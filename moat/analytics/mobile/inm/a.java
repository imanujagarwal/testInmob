package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

class a
{
  private static boolean b = false;
  static WeakReference<Activity> a;
  private static Application c;
  private static int d = 0;
  private static boolean e = false;
  
  a() {}
  
  static void a(Application paramApplication)
  {
    c = paramApplication;
    if (!b)
    {
      b = true;
      c.registerActivityLifecycleCallbacks(new a());
    }
  }
  
  static Application a()
  {
    return c;
  }
  
  private static boolean b(Activity paramActivity)
  {
    return (a != null) && (a.get() == paramActivity);
  }
  
  private static class a
    implements Application.ActivityLifecycleCallbacks
  {
    a() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      a.a(1);
    }
    
    public void onActivityStarted(Activity paramActivity)
    {
      try
      {
        a.a = new WeakReference(paramActivity);
        a.a(2);
        if (!a.b()) {
          a(true);
        }
        a.a(true);
        p.a(3, "ActivityState", this, "Activity started: " + paramActivity.getClass() + "@" + paramActivity.hashCode());
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
      try
      {
        a.a = new WeakReference(paramActivity);
        a.a(3);
        w.a().b();
        p.a(3, "ActivityState", this, "Activity resumed: " + paramActivity.getClass() + "@" + paramActivity.hashCode());
        if (getInstanceb) {
          f.a(paramActivity);
        }
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
    
    public void onActivityPaused(Activity paramActivity)
    {
      try
      {
        a.a(4);
        if (a.a(paramActivity)) {
          a.a = new WeakReference(null);
        }
        p.a(3, "ActivityState", this, "Activity paused: " + paramActivity.getClass() + "@" + paramActivity.hashCode());
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      try
      {
        if (a.c() != 3)
        {
          a.a(false);
          a(false);
        }
        a.a(5);
        if (a.a(paramActivity)) {
          a.a = new WeakReference(null);
        }
        p.a(3, "ActivityState", this, "Activity stopped: " + paramActivity.getClass() + "@" + paramActivity.hashCode());
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity)
    {
      try
      {
        if ((a.c() != 3) && (a.c() != 5))
        {
          if (a.b()) {
            a(false);
          }
          a.a(false);
        }
        a.a(6);
        p.a(3, "ActivityState", this, "Activity destroyed: " + paramActivity.getClass() + "@" + paramActivity.hashCode());
        if (a.a(paramActivity)) {
          a.a = new WeakReference(null);
        }
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
    
    private static void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        p.a(3, "ActivityState", null, "App became visible");
        if ((aa == w.d.b) && (!getInstancec)) {
          o.a().c();
        }
      }
      else
      {
        p.a(3, "ActivityState", null, "App became invisible");
        if ((aa == w.d.b) && (!getInstancec)) {
          o.a().d();
        }
      }
    }
  }
}
