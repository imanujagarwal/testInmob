package com.integralads.avid.library.inmobi;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.integralads.avid.library.inmobi.processing.AvidProcessorFactory;
import com.integralads.avid.library.inmobi.processing.IAvidNodeProcessor;
import com.integralads.avid.library.inmobi.processing.IAvidNodeProcessor.IAvidViewWalker;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.utils.AvidJSONUtil;
import com.integralads.avid.library.inmobi.utils.AvidTimestamp;
import com.integralads.avid.library.inmobi.utils.AvidViewUtil;
import com.integralads.avid.library.inmobi.walking.AvidAdViewCache;
import com.integralads.avid.library.inmobi.walking.AvidStatePublisher;
import com.integralads.avid.library.inmobi.walking.ViewType;
import com.integralads.avid.library.inmobi.walking.async.AvidAsyncTaskQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AvidTreeWalker
  implements IAvidNodeProcessor.IAvidViewWalker
{
  private static final int UPDATE_TREE_BY_SCHEDULE_PERIOD = 200;
  private static AvidTreeWalker avidTreeWalker = new AvidTreeWalker();
  
  private static TreeWalkerHandler handler;
  private List<AvidTreeWalkerTimeLogger> timeLoggers = new ArrayList();
  private int objectsCount;
  private AvidProcessorFactory processorFactory;
  private AvidAdViewCache adViewCache;
  private AvidStatePublisher statePublisher;
  private double startTime;
  private double endTime;
  
  public AvidTreeWalker()
  {
    adViewCache = new AvidAdViewCache(AvidAdSessionRegistry.getInstance());
    processorFactory = new AvidProcessorFactory();
    statePublisher = new AvidStatePublisher(AvidAdSessionRegistry.getInstance(), new AvidAsyncTaskQueue());
  }
  



  public static AvidTreeWalker getInstance()
  {
    return avidTreeWalker;
  }
  
  public void addTimeLogger(AvidTreeWalkerTimeLogger paramAvidTreeWalkerTimeLogger) {
    if (!timeLoggers.contains(paramAvidTreeWalkerTimeLogger)) {
      timeLoggers.add(paramAvidTreeWalkerTimeLogger);
    }
  }
  
  public void removeTimeLogger(AvidTreeWalkerTimeLogger paramAvidTreeWalkerTimeLogger) {
    if (timeLoggers.contains(paramAvidTreeWalkerTimeLogger)) {
      timeLoggers.remove(paramAvidTreeWalkerTimeLogger);
    }
  }
  
  public void start() {
    startTreeWalkerUpdater();
    updateTreeState();
  }
  
  public void stop() {
    pause();
    timeLoggers.clear();
    statePublisher.cleanupCache();
  }
  
  public void pause() {
    stopTreeWalkerUpdater();
  }
  
  private void updateTreeState() {
    beforeWalk();
    doWalk();
    afterWalk();
  }
  
  private void beforeWalk() {
    objectsCount = 0;
    startTime = AvidTimestamp.getCurrentTime();
  }
  
  private void afterWalk() {
    endTime = AvidTimestamp.getCurrentTime();
    notifyTimeLogger((endTime - startTime));
  }
  
  @VisibleForTesting
  void doWalk() {
    adViewCache.prepare();
    double d = AvidTimestamp.getCurrentTime();
    IAvidNodeProcessor localIAvidNodeProcessor = processorFactory.getRootProcessor();
    JSONObject localJSONObject; if (adViewCache.getHiddenSessionIds().size() > 0) {
      localJSONObject = localIAvidNodeProcessor.getState(null);
      statePublisher.publishEmptyState(localJSONObject, adViewCache.getHiddenSessionIds(), d);
    }
    if (adViewCache.getVisibleSessionIds().size() > 0) {
      localJSONObject = localIAvidNodeProcessor.getState(null);
      walkViewChildren(null, localIAvidNodeProcessor, localJSONObject, ViewType.ROOT_VIEW);
      AvidJSONUtil.fixStateFrame(localJSONObject);
      statePublisher.publishState(localJSONObject, adViewCache.getVisibleSessionIds(), d);
    } else {
      statePublisher.cleanupCache();
    }
    adViewCache.cleanup();
  }
  
  public void walkView(View paramView, IAvidNodeProcessor paramIAvidNodeProcessor, JSONObject paramJSONObject)
  {
    if (!AvidViewUtil.isViewVisible(paramView)) {
      return;
    }
    ViewType localViewType;
    if ((localViewType = adViewCache.getViewType(paramView)) == ViewType.UNDERLYING_VIEW) {
      return;
    }
    JSONObject localJSONObject = paramIAvidNodeProcessor.getState(paramView);
    AvidJSONUtil.addChildState(paramJSONObject, localJSONObject);
    
    if (!handleAdView(paramView, localJSONObject)) {
      checkFriendlyObstruction(paramView, localJSONObject);
      walkViewChildren(paramView, paramIAvidNodeProcessor, localJSONObject, localViewType);
    }
    objectsCount += 1;
  }
  
  private void walkViewChildren(View paramView, IAvidNodeProcessor paramIAvidNodeProcessor, JSONObject paramJSONObject, ViewType paramViewType) {
    paramIAvidNodeProcessor.iterateChildren(paramView, paramJSONObject, this, paramViewType == ViewType.ROOT_VIEW);
  }
  
  private boolean handleAdView(View paramView, JSONObject paramJSONObject)
  {
    if ((paramView = adViewCache.getSessionId(paramView)) != null) {
      AvidJSONUtil.addAvidId(paramJSONObject, paramView);
      adViewCache.onAdViewProcessed();
      return true;
    }
    return false;
  }
  
  private void checkFriendlyObstruction(View paramView, JSONObject paramJSONObject)
  {
    if ((paramView = adViewCache.getFriendlySessionIds(paramView)) != null)
      AvidJSONUtil.addFriendlyObstruction(paramJSONObject, paramView);
  }
  
  private void notifyTimeLogger(long paramLong) {
    Iterator localIterator;
    if (timeLoggers.size() > 0) {
      for (localIterator = timeLoggers.iterator(); localIterator.hasNext();) {
        ((AvidTreeWalkerTimeLogger)localIterator.next()).onTreeProcessed(objectsCount, paramLong);
      }
    }
  }
  
  private void startTreeWalkerUpdater() {
    if (handler == null)
    {
      (AvidTreeWalker.handler = new TreeWalkerHandler(null)).postDelayed(viewTreeUpdaterRunnable, 200L);
    }
  }
  
  private void stopTreeWalkerUpdater() {
    if (handler != null) {
      handler.removeCallbacks(viewTreeUpdaterRunnable);
      handler = null;
    }
  }
  
  @VisibleForTesting
  void setAdViewCache(AvidAdViewCache paramAvidAdViewCache) {
    adViewCache = paramAvidAdViewCache;
  }
  
  @VisibleForTesting
  void setStatePublisher(AvidStatePublisher paramAvidStatePublisher) {
    statePublisher = paramAvidStatePublisher;
  }
  
  @VisibleForTesting
  void setProcessorFactory(AvidProcessorFactory paramAvidProcessorFactory) {
    processorFactory = paramAvidProcessorFactory;
  }
  
  private static final Runnable viewTreeUpdaterRunnable = new Runnable()
  {
    public final void run() {
      if (AvidTreeWalker.handler != null) {
        AvidTreeWalker.handler.sendEmptyMessage(0);
        AvidTreeWalker.handler.postDelayed(AvidTreeWalker.viewTreeUpdaterRunnable, 200L);
      }
    }
  };
  
  private static class TreeWalkerHandler extends Handler {
    private TreeWalkerHandler() {}
    
    public void handleMessage(Message paramMessage) {
      super.handleMessage(paramMessage);
      AvidTreeWalker.getInstance().updateTreeState();
    }
  }
  
  public static abstract interface AvidTreeWalkerTimeLogger
  {
    public abstract void onTreeProcessed(int paramInt, long paramLong);
  }
}
