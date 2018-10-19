package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

abstract class b
{
  m a = null;
  private WeakReference<View> g;
  WeakReference<WebView> b;
  j c;
  TrackerListener d;
  final String e;
  private final z h;
  private final boolean i;
  final boolean f;
  private boolean j;
  private boolean k;
  
  b(@Nullable View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    p.a(3, "BaseTracker", this, "Initializing.");
    e = (paramBoolean1 ? "m" + hashCode() : "");
    g = new WeakReference(paramView);
    i = paramBoolean1;
    f = paramBoolean2;
    j = false;
    k = false;
    h = new z();
  }
  
  abstract String a();
  
  public void setListener(TrackerListener paramTrackerListener)
  {
    d = paramTrackerListener;
  }
  
  public void removeListener()
  {
    d = null;
  }
  
  public void startTracking()
  {
    try
    {
      p.a(3, "BaseTracker", this, "In startTracking method.");
      b();
      if (d != null) {
        d.onTrackingStarted("Tracking started on " + g());
      }
      String str = "startTracking succeeded for " + g();
      p.a(3, "BaseTracker", this, str);
      p.a("[SUCCESS] ", a() + " " + str);
      return;
    }
    catch (Exception localException)
    {
      a("startTracking", localException);
    }
  }
  
  @CallSuper
  public void stopTracking()
  {
    int m = 0;
    try
    {
      p.a(3, "BaseTracker", this, "In stopTracking method.");
      k = true;
      if (c != null)
      {
        c.c(this);
        m = 1;
      }
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    p.a(3, "BaseTracker", this, "Attempt to stop tracking ad impression was " + (m != 0 ? "" : "un") + "successful.");
    p.a(m != 0 ? "[SUCCESS] " : "[ERROR] ", a() + " stopTracking " + (m != 0 ? "succeeded" : "failed") + " for " + g());
    if (d != null)
    {
      d.onTrackingStopped("");
      d = null;
    }
  }
  
  @CallSuper
  public void changeTargetView(View paramView)
  {
    p.a(3, "BaseTracker", this, "changing view to " + p.a(paramView));
    g = new WeakReference(paramView);
  }
  
  @Deprecated
  public void setActivity(Activity paramActivity) {}
  
  @CallSuper
  void b()
  {
    p.a(3, "BaseTracker", this, "Attempting to start impression.");
    c();
    d();
    a(new ArrayList());
    if (c != null)
    {
      c.b(this);
      j = true;
      p.a(3, "BaseTracker", this, "Impression started.");
      return;
    }
    p.a(3, "BaseTracker", this, "Bridge is null, won't start tracking");
    throw new m("Bridge is null");
  }
  
  void a(j paramJ)
  {
    c = paramJ;
  }
  
  void a(WebView paramWebView)
  {
    if (paramWebView != null)
    {
      b = new WeakReference(paramWebView);
      if ((c == null) && (!l())) {
        i();
      }
      if (c != null) {
        c.a(this);
      }
    }
  }
  
  private void i()
  {
    p.a(3, "BaseTracker", this, "Attempting bridge installation.");
    if (b.get() != null)
    {
      c = new j((WebView)b.get(), j.a.a);
      p.a(3, "BaseTracker", this, "Bridge installed.");
      return;
    }
    c = null;
    p.a(3, "BaseTracker", this, "Bridge not installed, WebView is null.");
  }
  
  void c()
  {
    if (a != null) {
      throw new m("Tracker initialization failed: " + a.getMessage());
    }
  }
  
  void d()
  {
    j();
    k();
  }
  
  private void j()
  {
    if (j) {
      throw new m("Tracker already started");
    }
  }
  
  private void k()
  {
    if (k) {
      throw new m("Tracker already stopped");
    }
  }
  
  @CallSuper
  void a(List<String> paramList)
  {
    if ((f() == null) && (!f)) {
      paramList.add("Tracker's target view is null");
    }
    if (!paramList.isEmpty())
    {
      paramList = TextUtils.join(" and ", paramList);
      throw new m(paramList);
    }
  }
  
  boolean e()
  {
    return (j) && (!k);
  }
  
  private boolean l()
  {
    return (i) || (f);
  }
  
  View f()
  {
    return (View)g.get();
  }
  
  String g()
  {
    return p.a(f());
  }
  
  String h()
  {
    h.a(e, f());
    return h.a;
  }
  
  void a(String paramString, Exception paramException)
  {
    try
    {
      m.a(paramException);
      paramString = m.a(paramString, paramException);
      if (d != null) {
        d.onTrackingFailedToStart(paramString);
      }
      p.a(3, "BaseTracker", this, paramString);
      p.a("[ERROR] ", a() + " " + paramString);
      return;
    }
    catch (Exception localException) {}
  }
}
