package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.inm.a.b.a;
import java.util.Map;

public class ReactiveVideoTrackerPlugin
  implements MoatPlugin<ReactiveVideoTracker>
{
  private final String a;
  
  public ReactiveVideoTrackerPlugin(String paramString)
  {
    a = paramString;
  }
  
  public ReactiveVideoTracker c()
  {
    (ReactiveVideoTracker)x.a(new x.a()
    {
      public a<ReactiveVideoTracker> a()
      {
        p.a("[INFO] ", "Attempting to create ReactiveVideoTracker");
        return a.a(new y(ReactiveVideoTrackerPlugin.a(ReactiveVideoTrackerPlugin.this)));
      }
    }, ReactiveVideoTracker.class);
  }
  
  public ReactiveVideoTracker d()
  {
    return new a();
  }
  
  static class a
    implements ReactiveVideoTracker
  {
    a() {}
    
    public void setActivity(Activity paramActivity) {}
    
    public void setListener(TrackerListener paramTrackerListener) {}
    
    public void removeListener() {}
    
    public void setVideoListener(VideoTrackerListener paramVideoTrackerListener) {}
    
    public void removeVideoListener() {}
    
    public boolean trackVideoAd(Map<String, String> paramMap, Integer paramInteger, View paramView)
    {
      return false;
    }
    
    public void setPlayerVolume(Double paramDouble) {}
    
    public void changeTargetView(View paramView) {}
    
    public void dispatchEvent(MoatAdEvent paramMoatAdEvent) {}
    
    public void stopTracking() {}
  }
}
