package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.Map;

abstract class v
{
  v() {}
  
  public static class b
    extends MoatFactory
  {
    public b() {}
    
    public WebAdTracker createWebAdTracker(@NonNull WebView paramWebView)
    {
      return new v.e();
    }
    
    public WebAdTracker createWebAdTracker(@NonNull ViewGroup paramViewGroup)
    {
      return new v.e();
    }
    
    public NativeDisplayTracker createNativeDisplayTracker(@NonNull View paramView, @NonNull Map<String, String> paramMap)
    {
      return new v.c();
    }
    
    public NativeVideoTracker createNativeVideoTracker(@NonNull String paramString)
    {
      return new v.d();
    }
    
    public <T> T createCustomTracker(MoatPlugin<T> paramMoatPlugin)
    {
      return paramMoatPlugin.b();
    }
  }
  
  public static class a
    extends MoatAnalytics
  {
    public a() {}
    
    public void start(MoatOptions paramMoatOptions, Application paramApplication) {}
    
    public void start(Application paramApplication) {}
    
    public void prepareNativeDisplayTracking(String paramString) {}
  }
  
  static class d
    implements NativeVideoTracker
  {
    d() {}
    
    public void setActivity(Activity paramActivity) {}
    
    public void setListener(TrackerListener paramTrackerListener) {}
    
    public void removeListener() {}
    
    public void setVideoListener(VideoTrackerListener paramVideoTrackerListener) {}
    
    public void removeVideoListener() {}
    
    public void dispatchEvent(MoatAdEvent paramMoatAdEvent) {}
    
    public boolean trackVideoAd(Map<String, String> paramMap, MediaPlayer paramMediaPlayer, View paramView)
    {
      return false;
    }
    
    public void setPlayerVolume(Double paramDouble) {}
    
    public void changeTargetView(View paramView) {}
    
    public void stopTracking() {}
  }
  
  static class c
    implements NativeDisplayTracker
  {
    c() {}
    
    public void startTracking() {}
    
    public void setListener(TrackerListener paramTrackerListener) {}
    
    public void removeListener() {}
    
    public void setActivity(Activity paramActivity) {}
    
    public void stopTracking() {}
    
    public void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType paramMoatUserInteractionType) {}
  }
  
  static class e
    implements WebAdTracker
  {
    e() {}
    
    public void startTracking() {}
    
    public void setListener(TrackerListener paramTrackerListener) {}
    
    public void removeListener() {}
    
    public void setActivity(Activity paramActivity) {}
    
    public void stopTracking() {}
  }
}
