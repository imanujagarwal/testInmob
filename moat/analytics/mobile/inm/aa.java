package com.moat.analytics.mobile.inm;

import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.a.b.a;

class aa
  extends b
  implements WebAdTracker
{
  aa(@Nullable ViewGroup paramViewGroup)
  {
    this((WebView)ab.a(paramViewGroup, false).c(null));
    String str;
    if (paramViewGroup == null)
    {
      paramViewGroup = "Target ViewGroup is null";
      str = "WebAdTracker initialization not successful, " + paramViewGroup;
      p.a("[ERROR] ", 3, "WebAdTracker", this, str);
      a = new m(paramViewGroup);
    }
    if (b == null)
    {
      paramViewGroup = "No WebView to track inside of ad container";
      str = "WebAdTracker initialization not successful, " + paramViewGroup;
      p.a("[ERROR] ", 3, "WebAdTracker", this, str);
      a = new m(paramViewGroup);
    }
  }
  
  aa(@Nullable WebView paramWebView)
  {
    super(paramWebView, false, false);
    p.a(3, "WebAdTracker", this, "Initializing.");
    if (paramWebView == null)
    {
      paramWebView = "WebView is null";
      String str = "WebAdTracker initialization not successful, " + paramWebView;
      p.a("[ERROR] ", 3, "WebAdTracker", this, str);
      a = new m(paramWebView);
      return;
    }
    try
    {
      super.a(paramWebView);
      p.a("[SUCCESS] ", a() + " created for " + g());
      return;
    }
    catch (m paramWebView)
    {
      a = paramWebView;
    }
  }
  
  String a()
  {
    return "WebAdTracker";
  }
}
