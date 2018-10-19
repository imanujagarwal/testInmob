package com.moat.analytics.mobile.inm;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.a.b.a;
import java.lang.ref.WeakReference;
import java.util.Map;

class n
  extends MoatFactory
{
  n()
  {
    if (!a())
    {
      String str1 = "Failed to initialize MoatFactory";
      String str2 = str1 + ", SDK was not started";
      p.a("[ERROR] ", 3, "Factory", this, str2);
      throw new m(str1);
    }
  }
  
  public WebAdTracker createWebAdTracker(@NonNull WebView paramWebView)
  {
    try
    {
      return a(paramWebView);
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return new v.e();
  }
  
  public WebAdTracker createWebAdTracker(@NonNull ViewGroup paramViewGroup)
  {
    try
    {
      return a(paramViewGroup);
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return new v.e();
  }
  
  public NativeDisplayTracker createNativeDisplayTracker(@NonNull View paramView, @NonNull Map<String, String> paramMap)
  {
    try
    {
      return a(paramView, paramMap);
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return new v.c();
  }
  
  public NativeVideoTracker createNativeVideoTracker(String paramString)
  {
    try
    {
      return a(paramString);
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return new v.d();
  }
  
  public <T> T createCustomTracker(MoatPlugin<T> paramMoatPlugin)
  {
    try
    {
      return a(paramMoatPlugin);
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return paramMoatPlugin.b();
  }
  
  private WebAdTracker a(final WebView paramWebView)
  {
    paramWebView = new WeakReference(paramWebView);
    (WebAdTracker)x.a(new x.a()
    {
      public a<WebAdTracker> a()
      {
        WebView localWebView = (WebView)paramWebView.get();
        String str = "Attempting to create WebAdTracker for " + p.a(localWebView);
        p.a("[INFO] ", 3, "Factory", this, str);
        return a.a(new aa(localWebView));
      }
    }, WebAdTracker.class);
  }
  
  private WebAdTracker a(final ViewGroup paramViewGroup)
  {
    paramViewGroup = new WeakReference(paramViewGroup);
    (WebAdTracker)x.a(new x.a()
    {
      public a<WebAdTracker> a()
      {
        ViewGroup localViewGroup = (ViewGroup)paramViewGroup.get();
        String str = "Attempting to create WebAdTracker for adContainer " + p.a(localViewGroup);
        p.a("[INFO] ", 3, "Factory", this, str);
        return a.a(new aa(localViewGroup));
      }
    }, WebAdTracker.class);
  }
  
  private NativeDisplayTracker a(final View paramView, final Map<String, String> paramMap)
  {
    paramView = new WeakReference(paramView);
    (NativeDisplayTracker)x.a(new x.a()
    {
      public a<NativeDisplayTracker> a()
      {
        View localView = (View)paramView.get();
        String str = "Attempting to create NativeDisplayTracker for " + p.a(localView);
        p.a("[INFO] ", 3, "Factory", this, str);
        return a.a(new t(localView, paramMap));
      }
    }, NativeDisplayTracker.class);
  }
  
  private NativeVideoTracker a(final String paramString)
  {
    (NativeVideoTracker)x.a(new x.a()
    {
      public a<NativeVideoTracker> a()
      {
        String str = "Attempting to create NativeVideoTracker";
        p.a("[INFO] ", 3, "Factory", this, str);
        return a.a(new u(paramString));
      }
    }, NativeVideoTracker.class);
  }
  
  private <T> T a(MoatPlugin<T> paramMoatPlugin)
  {
    return paramMoatPlugin.a();
  }
  
  private boolean a()
  {
    return ((k)k.getInstance()).a();
  }
}
