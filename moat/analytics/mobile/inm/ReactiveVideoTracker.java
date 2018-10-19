package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.view.View;
import java.util.Map;

public abstract interface ReactiveVideoTracker
{
  @Deprecated
  public abstract void setActivity(Activity paramActivity);
  
  public abstract void setListener(TrackerListener paramTrackerListener);
  
  public abstract void removeListener();
  
  public abstract void setVideoListener(VideoTrackerListener paramVideoTrackerListener);
  
  public abstract void removeVideoListener();
  
  public abstract boolean trackVideoAd(Map<String, String> paramMap, Integer paramInteger, View paramView);
  
  public abstract void setPlayerVolume(Double paramDouble);
  
  public abstract void dispatchEvent(MoatAdEvent paramMoatAdEvent);
  
  public abstract void changeTargetView(View paramView);
  
  public abstract void stopTracking();
}
