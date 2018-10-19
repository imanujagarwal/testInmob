package com.integralads.avid.library.inmobi.walking;

import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.inmobi.session.internal.ObstructionsWhiteList;
import com.integralads.avid.library.inmobi.utils.AvidViewUtil;
import com.integralads.avid.library.inmobi.weakreference.AvidView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;



public class AvidAdViewCache
{
  private final AvidAdSessionRegistry adSessionRegistry;
  private final HashMap<View, String> adViews = new HashMap();
  private final HashMap<View, ArrayList<String>> friendlyObstructions = new HashMap();
  private final HashSet<View> rootViews = new HashSet();
  private final HashSet<String> visibleSessionIds = new HashSet();
  private final HashSet<String> hiddenSessionIds = new HashSet();
  private boolean isAdViewProcessed;
  
  public AvidAdViewCache(AvidAdSessionRegistry paramAvidAdSessionRegistry)
  {
    adSessionRegistry = paramAvidAdSessionRegistry;
  }
  
  public HashSet<String> getVisibleSessionIds() {
    return visibleSessionIds;
  }
  
  public HashSet<String> getHiddenSessionIds() {
    return hiddenSessionIds;
  }
  
  public void prepare() {
    for (Iterator localIterator = adSessionRegistry.getInternalAvidAdSessions().iterator(); localIterator.hasNext();) { InternalAvidAdSession localInternalAvidAdSession;
      View localView = (localInternalAvidAdSession = (InternalAvidAdSession)localIterator.next()).getView();
      if ((localInternalAvidAdSession.isActive()) && (localView != null)) {
        if (buildRootViews(localView)) {
          visibleSessionIds.add(localInternalAvidAdSession.getAvidAdSessionId());
          adViews.put(localView, localInternalAvidAdSession.getAvidAdSessionId());
          prepareFriendlyObstructions(localInternalAvidAdSession);
        } else {
          hiddenSessionIds.add(localInternalAvidAdSession.getAvidAdSessionId());
        }
      }
    }
  }
  
  private boolean buildRootViews(View paramView) {
    if (!paramView.hasWindowFocus()) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    
    while (paramView != null) {
      if (AvidViewUtil.isViewVisible(paramView)) {
        localHashSet.add(paramView);
      } else {
        return false;
      }
      
      paramView = ((paramView = paramView.getParent()) instanceof View) ? (View)paramView : null;
    }
    rootViews.addAll(localHashSet);
    return true;
  }
  
  private void prepareFriendlyObstructions(InternalAvidAdSession paramInternalAvidAdSession) {
    for (Iterator localIterator = paramInternalAvidAdSession.getObstructionsWhiteList().getWhiteList().iterator(); localIterator.hasNext();) { AvidView localAvidView;
      if (!(localAvidView = (AvidView)localIterator.next()).isEmpty()) {
        addFriendlyObstruction((View)localAvidView.get(), paramInternalAvidAdSession);
      }
    }
  }
  
  private void addFriendlyObstruction(View paramView, InternalAvidAdSession paramInternalAvidAdSession) {
    ArrayList localArrayList;
    if ((localArrayList = (ArrayList)friendlyObstructions.get(paramView)) == null) {
      localArrayList = new ArrayList();
      friendlyObstructions.put(paramView, localArrayList);
    }
    localArrayList.add(paramInternalAvidAdSession.getAvidAdSessionId());
  }
  
  public void cleanup() {
    adViews.clear();
    friendlyObstructions.clear();
    rootViews.clear();
    visibleSessionIds.clear();
    hiddenSessionIds.clear();
    isAdViewProcessed = false;
  }
  
  public void onAdViewProcessed() {
    isAdViewProcessed = true;
  }
  
  public String getSessionId(View paramView) {
    if (adViews.size() == 0) {
      return null;
    }
    String str;
    if ((str = (String)adViews.get(paramView)) != null) {
      adViews.remove(paramView);
    }
    return str;
  }
  
  public ArrayList<String> getFriendlySessionIds(View paramView) {
    if (friendlyObstructions.size() == 0) {
      return null;
    }
    ArrayList localArrayList;
    if ((localArrayList = (ArrayList)friendlyObstructions.get(paramView)) != null) {
      friendlyObstructions.remove(paramView);
      Collections.sort(localArrayList);
    }
    return localArrayList;
  }
  
  public ViewType getViewType(View paramView) {
    if (rootViews.contains(paramView)) {
      return ViewType.ROOT_VIEW;
    }
    if (isAdViewProcessed) return ViewType.OBSTRUCTION_VIEW; return ViewType.UNDERLYING_VIEW;
  }
  
  @VisibleForTesting
  HashMap<View, String> getAdViews() {
    return adViews;
  }
  
  @VisibleForTesting
  HashMap<View, ArrayList<String>> getFriendlyObstructions() {
    return friendlyObstructions;
  }
  
  @VisibleForTesting
  HashSet<View> getRootViews() {
    return rootViews;
  }
}
