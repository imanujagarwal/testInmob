package com.moat.analytics.mobile.inm;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import java.lang.ref.WeakReference;

class k
  extends MoatAnalytics
  implements w.b
{
  boolean a = false;
  boolean b = false;
  boolean c = false;
  private boolean f = false;
  private String g;
  @Nullable
  g d;
  WeakReference<Context> e;
  private MoatOptions h;
  
  k() {}
  
  public void start(MoatOptions paramMoatOptions, Application paramApplication)
  {
    try
    {
      a(paramMoatOptions, paramApplication);
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  public void start(Application paramApplication)
  {
    start(new MoatOptions(), paramApplication);
  }
  
  @UiThread
  public void prepareNativeDisplayTracking(String paramString)
  {
    g = paramString;
    if (aa == w.d.a) {
      return;
    }
    try
    {
      e();
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  private void a(MoatOptions paramMoatOptions, Application paramApplication)
  {
    if (f)
    {
      p.a(3, "Analytics", this, "Moat SDK has already been started.");
      return;
    }
    h = paramMoatOptions;
    w.a().b();
    c = disableLocationServices;
    if (paramApplication == null) {
      throw new m("Moat Analytics SDK didn't start, application was null");
    }
    if ((loggingEnabled) && (s.b(paramApplication.getApplicationContext()))) {
      a = true;
    }
    e = new WeakReference(paramApplication.getApplicationContext());
    f = true;
    b = autoTrackGMAInterstitials;
    a.a(paramApplication);
    w.a().a(this);
    if (!disableAdIdCollection) {
      s.a(paramApplication);
    }
    p.a("[SUCCESS] ", "Moat Analytics SDK Version 2.5.0 started");
  }
  
  @UiThread
  private void e()
  {
    if (d == null)
    {
      d = new g(a.a(), g.a.a);
      d.a(g);
      p.a(3, "Analytics", this, "Preparing native display tracking with partner code " + g);
      p.a("[SUCCESS] ", "Prepared for native display tracking with partner code " + g);
    }
  }
  
  boolean a()
  {
    return f;
  }
  
  boolean b()
  {
    return (h != null) && (h.disableLocationServices);
  }
  
  public void c()
  {
    m.a();
    o.a();
    if (g != null) {
      try
      {
        e();
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
  }
  
  public void d() {}
}
