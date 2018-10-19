package com.moat.analytics.mobile.inm;

import android.app.Application;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class o
  implements LocationListener
{
  private static o a = null;
  private ScheduledExecutorService b;
  private ScheduledFuture<?> c;
  private ScheduledFuture<?> d;
  private LocationManager e;
  private boolean f;
  private Location g;
  private boolean h;
  
  static o a()
  {
    if (a == null) {
      a = new o();
    }
    return a;
  }
  
  private o()
  {
    try
    {
      f = getInstancec;
      if (f)
      {
        p.a(3, "LocationManager", this, "Moat location services disabled");
        return;
      }
      b = Executors.newScheduledThreadPool(1);
      Application localApplication = a.a();
      e = ((LocationManager)localApplication.getSystemService("location"));
      if (e.getAllProviders().size() == 0)
      {
        p.a(3, "LocationManager", this, "Device has no location providers");
        return;
      }
      e();
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  @Nullable
  Location b()
  {
    if ((f) || (e == null)) {
      return null;
    }
    return g;
  }
  
  void c()
  {
    e();
  }
  
  void d()
  {
    a(false);
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    try
    {
      p.a(3, "LocationManager", this, "Received an updated location = " + paramLocation.toString());
      float f1 = b(paramLocation);
      if ((paramLocation.hasAccuracy()) && (paramLocation.getAccuracy() <= 100.0F) && (f1 < 600.0F))
      {
        g = b(g, paramLocation);
        p.a(3, "LocationManager", this, "fetchCompleted");
        a(true);
      }
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onProviderDisabled(String paramString) {}
  
  private void e()
  {
    try
    {
      if ((f) || (e == null)) {
        return;
      }
      if (h) {
        p.a(3, "LocationManager", this, "already updating location");
      }
      p.a(3, "LocationManager", this, "starting location fetch");
      g = b(g, f());
      if (g != null)
      {
        p.a(3, "LocationManager", this, "Have a valid location, won't fetch = " + g.toString());
        k();
        return;
      }
      g();
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      p.a(3, "LocationManager", this, "stopping location fetch");
      h();
      i();
      if (paramBoolean)
      {
        k();
        return;
      }
      j();
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  private Location f()
  {
    Location localLocation = null;
    try
    {
      boolean bool1 = l();
      boolean bool2 = m();
      if ((bool1) && (bool2)) {
        localLocation = b(e.getLastKnownLocation("gps"), e.getLastKnownLocation("network"));
      } else if (bool1) {
        localLocation = e.getLastKnownLocation("gps");
      } else if (bool2) {
        localLocation = e.getLastKnownLocation("network");
      }
    }
    catch (SecurityException localSecurityException)
    {
      m.a(localSecurityException;
    }
    return localLocation;
  }
  
  private void g()
  {
    try
    {
      if (!h)
      {
        p.a(3, "LocationManager", this, "Attempting to start update");
        if (l())
        {
          p.a(3, "LocationManager", this, "start updating gps location");
          e.requestLocationUpdates("gps", 0L, 0.0F, this, Looper.getMainLooper());
          h = true;
        }
        if (m())
        {
          p.a(3, "LocationManager", this, "start updating network location");
          e.requestLocationUpdates("network", 0L, 0.0F, this, Looper.getMainLooper());
          h = true;
        }
        if (h)
        {
          i();
          d = b.schedule(new Runnable()
          {
            public void run()
            {
              try
              {
                p.a(3, "LocationManager", this, "fetchTimedOut");
                o.a(o.this, true);
                return;
              }
              catch (Exception localException)
              {
                m.a(localException;
              }
            }
          }, 60L, TimeUnit.SECONDS);
        }
      }
      return;
    }
    catch (SecurityException localSecurityException)
    {
      m.a(localSecurityException;
    }
  }
  
  private void h()
  {
    try
    {
      p.a(3, "LocationManager", this, "Stopping to update location");
      if ((n()) && (e != null))
      {
        e.removeUpdates(this);
        h = false;
      }
      return;
    }
    catch (SecurityException localSecurityException)
    {
      m.a(localSecurityException;
    }
  }
  
  private void i()
  {
    if ((d != null) && (!d.isCancelled()))
    {
      d.cancel(true);
      d = null;
    }
  }
  
  private void j()
  {
    if ((c != null) && (!c.isCancelled()))
    {
      c.cancel(true);
      c = null;
    }
  }
  
  private void k()
  {
    p.a(3, "LocationManager", this, "Resetting fetch timer");
    j();
    float f1 = 600.0F;
    if (g != null)
    {
      float f2 = b(g);
      f1 = Math.max(600.0F - f2, 0.0F);
    }
    long l = f1;
    c = b.schedule(new Runnable()
    {
      public void run()
      {
        try
        {
          p.a(3, "LocationManager", this, "fetchTimerCompleted");
          o.a(o.this);
          return;
        }
        catch (Exception localException)
        {
          m.a(localException;
        }
      }
    }, l, TimeUnit.SECONDS);
  }
  
  private boolean l()
  {
    return (a("android.permission.ACCESS_FINE_LOCATION")) && (e.getProvider("gps") != null) && (e.isProviderEnabled("gps"));
  }
  
  private boolean m()
  {
    return (n()) && (e.getProvider("network") != null) && (e.isProviderEnabled("network"));
  }
  
  private static boolean a(String paramString)
  {
    return ContextCompat.checkSelfPermission(a.a().getApplicationContext(), paramString) == 0;
  }
  
  private static boolean n()
  {
    return (a("android.permission.ACCESS_FINE_LOCATION")) || (a("android.permission.ACCESS_COARSE_LOCATION"));
  }
  
  private static Location b(Location paramLocation1, Location paramLocation2)
  {
    boolean bool1 = a(paramLocation1);
    boolean bool2 = a(paramLocation2);
    if (!bool1)
    {
      if (!bool2) {
        return null;
      }
      return paramLocation2;
    }
    if (!bool2) {
      return paramLocation1;
    }
    if (paramLocation1.getAccuracy() < paramLocation1.getAccuracy()) {
      return paramLocation1;
    }
    return paramLocation2;
  }
  
  private static boolean a(Location paramLocation)
  {
    boolean bool = true;
    if (paramLocation == null) {
      bool = false;
    } else if ((paramLocation.getLatitude() == 0.0D) && (paramLocation.getLongitude() == 0.0D)) {
      bool = false;
    } else if (paramLocation.getAccuracy() < 0.0F) {
      bool = false;
    } else if (b(paramLocation) >= 600.0F) {
      bool = false;
    }
    return bool;
  }
  
  private static float b(Location paramLocation)
  {
    return (float)((System.currentTimeMillis() - paramLocation.getTime()) / 1000L);
  }
  
  static boolean a(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation1 == paramLocation2) {
      return true;
    }
    return (paramLocation1 != null) && (paramLocation2 != null) && (paramLocation1.getTime() == paramLocation2.getTime());
  }
}
