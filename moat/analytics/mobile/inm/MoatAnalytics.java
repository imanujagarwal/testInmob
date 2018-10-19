package com.moat.analytics.mobile.inm;

import android.app.Application;
import android.support.annotation.UiThread;

public abstract class MoatAnalytics
{
  private static MoatAnalytics a = null;
  
  public MoatAnalytics() {}
  
  public static synchronized MoatAnalytics getInstance()
  {
    if (a == null) {
      try
      {
        a = new k();
      }
      catch (Exception localException)
      {
        m.a(localException);
        a = new v.a();
      }
    }
    return a;
  }
  
  public abstract void start(MoatOptions paramMoatOptions, Application paramApplication);
  
  public abstract void start(Application paramApplication);
  
  @UiThread
  public abstract void prepareNativeDisplayTracking(String paramString);
}
