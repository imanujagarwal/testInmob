package com.integralads.avid.library.inmobi;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.VisibleForTesting;
import com.integralads.avid.library.inmobi.activity.AvidActivityStack;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistryListener;
import com.integralads.avid.library.inmobi.session.AbstractAvidAdSession;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.inmobi.utils.AvidJSONUtil;
import java.util.Iterator;

public class AvidManager implements AvidLoader.AvidLoaderListener, AvidStateWatcher.AvidStateWatcherListener, AvidAdSessionRegistryListener
{
  private static AvidManager avidManagerInstance = new AvidManager();
  private static Context context;
  
  public AvidManager() {}
  
  public static AvidManager getInstance() { return avidManagerInstance; }
  
  public void init(Context paramContext)
  {
    if (context == null) {
      context = paramContext.getApplicationContext();
      AvidStateWatcher.getInstance().init(context);
      AvidAdSessionRegistry.getInstance().setListener(this);
      AvidJSONUtil.init(context);
    }
  }
  
  public void registerAvidAdSession(AbstractAvidAdSession paramAbstractAvidAdSession, InternalAvidAdSession paramInternalAvidAdSession) {
    AvidAdSessionRegistry.getInstance().registerAvidAdSession(paramAbstractAvidAdSession, paramInternalAvidAdSession);
  }
  
  public AbstractAvidAdSession findAvidAdSessionById(String paramString) {
    return AvidAdSessionRegistry.getInstance().findAvidAdSessionById(paramString);
  }
  
  public InternalAvidAdSession findInternalAvidAdSessionById(String paramString) {
    return AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionById(paramString);
  }
  
  public void registerActivity(Activity paramActivity) {
    AvidActivityStack.getInstance().addActivity(paramActivity);
  }
  
  private void start()
  {
    AvidStateWatcher.getInstance().setStateWatcherListener(this);
    AvidStateWatcher.getInstance().start();
    if (AvidStateWatcher.getInstance().isActive()) {
      AvidTreeWalker.getInstance().start();
    }
  }
  
  private void stop()
  {
    AvidActivityStack.getInstance().cleanup();
    AvidTreeWalker.getInstance().stop();
    AvidStateWatcher.getInstance().stop();
    AvidLoader.getInstance().unregisterAvidLoader();
    context = null;
  }
  
  private boolean isActive() {
    return !AvidAdSessionRegistry.getInstance().isEmpty();
  }
  
  private void notifyAvidReady() {
    AvidAdSessionRegistry.getInstance().setListener(null);
    for (Iterator localIterator = AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions().iterator(); localIterator.hasNext();) {
      ((InternalAvidAdSession)localIterator.next()).getAvidBridgeManager().onAvidJsReady();
    }
    AvidAdSessionRegistry.getInstance().setListener(this);
  }
  
  public void onAvidLoaded()
  {
    if (isActive()) {
      notifyAvidReady();
      if (AvidAdSessionRegistry.getInstance().hasActiveSessions()) {
        start();
      }
    }
  }
  
  public void onAppStateChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      AvidTreeWalker.getInstance().start();return;
    }
    AvidTreeWalker.getInstance().pause();
  }
  

  public void registryHasSessionsChanged(AvidAdSessionRegistry paramAvidAdSessionRegistry)
  {
    if (paramAvidAdSessionRegistry.isEmpty()) {
      return;
    }
    
    if (!AvidBridge.isAvidJsReady()) {
      AvidLoader.getInstance().setListener(this);
      AvidLoader.getInstance().registerAvidLoader(context);
    }
  }
  
  public void registryHasActiveSessionsChanged(AvidAdSessionRegistry paramAvidAdSessionRegistry)
  {
    if ((paramAvidAdSessionRegistry.hasActiveSessions()) && (AvidBridge.isAvidJsReady())) {
      start();return;
    }
    stop();
  }
  
  @VisibleForTesting
  static void setAvidManagerInstance(AvidManager paramAvidManager)
  {
    avidManagerInstance = paramAvidManager;
  }
}
