package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.support.annotation.UiThread;

@UiThread
public abstract interface NativeDisplayTracker
{
  public abstract void setListener(TrackerListener paramTrackerListener);
  
  public abstract void removeListener();
  
  @Deprecated
  public abstract void setActivity(Activity paramActivity);
  
  public abstract void startTracking();
  
  public abstract void stopTracking();
  
  public abstract void reportUserInteractionEvent(MoatUserInteractionType paramMoatUserInteractionType);
  
  public static enum MoatUserInteractionType
  {
    TOUCH,  CLICK;
    
    private MoatUserInteractionType() {}
  }
}
