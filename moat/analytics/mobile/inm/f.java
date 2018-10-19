package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.a.b.a;
import java.lang.ref.WeakReference;

class f
{
  @Nullable
  private static WebAdTracker a;
  private static WeakReference<Activity> b = new WeakReference(null);
  
  f() {}
  
  static void a(Activity paramActivity)
  {
    try
    {
      if (aa == w.d.a) {
        return;
      }
      if (b(paramActivity))
      {
        if ((b.get() == null) || (b.get() != paramActivity))
        {
          Object localObject;
          if (((localObject = paramActivity.getWindow().getDecorView()) instanceof ViewGroup))
          {
            if ((localObject = ab.a((ViewGroup)localObject, true)).c())
            {
              b = new WeakReference(paramActivity);
              a((WebView)((a)localObject).b());
              return;
            }
            p.a(3, "GMAInterstitialHelper", paramActivity, "Sorry, no WebView in this activity");
          }
        }
      }
      else
      {
        a();
        b = new WeakReference(null);
      }
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  private static boolean b(Activity paramActivity)
  {
    String str = paramActivity.getClass().getName();
    p.a(3, "GMAInterstitialHelper", paramActivity, "Activity name: " + str);
    return str.contains("com.google.android.gms.ads.AdActivity");
  }
  
  private static void a(WebView paramWebView)
  {
    p.a(3, "GMAInterstitialHelper", b.get(), "Starting to track GMA interstitial");
    (f.a = MoatFactory.create().createWebAdTracker(paramWebView)).startTracking();
  }
  
  private static void a()
  {
    if (a != null)
    {
      p.a(3, "GMAInterstitialHelper", b.get(), "Stopping to track GMA interstitial");
      a.stopTracking();
      a = null;
    }
  }
}
