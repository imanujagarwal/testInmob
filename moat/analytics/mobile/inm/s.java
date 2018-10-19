package com.moat.analytics.mobile.inm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.support.annotation.FloatRange;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

class s
{
  private static String a;
  private static a b = null;
  private static b c = null;
  
  s() {}
  
  @FloatRange(from=0.0D, to=1.0D)
  static double a()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)a.a().getSystemService("audio");
      int j = h();
      int i = localAudioManager.getStreamMaxVolume(3);
      return j / i;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return 0.0D;
  }
  
  private static int h()
  {
    try
    {
      return ((AudioManager)a.a().getSystemService("audio")).getStreamVolume(3);
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return 0;
  }
  
  static void a(Context paramContext)
  {
    try
    {
      AsyncTask.execute(new Runnable()
      {
        public final void run()
        {
          try
          {
            Object localObject = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Class localClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            localObject = ((Class)localObject).getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { a });
            if (!((Boolean)localClass.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(localObject, new Object[0])).booleanValue())
            {
              s.a((String)localClass.getMethod("getId", new Class[0]).invoke(localObject, new Object[0]));
              p.a(3, "Util", this, "Retrieved Advertising ID = " + s.f());
              return;
            }
            p.a(3, "Util", this, "User has limited ad tracking");
            return;
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            p.a("Util", this, "ClassNotFoundException while retrieving Advertising ID", localClassNotFoundException);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            p.a("Util", this, "NoSuchMethodException while retrieving Advertising ID", localNoSuchMethodException);
            return;
          }
          catch (Exception localException)
          {
            m.a(localException;
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  static String b()
  {
    return a;
  }
  
  static Context c()
  {
    WeakReference localWeakReference;
    if ((localWeakReference = getInstancee) != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  static a d()
  {
    if ((b == null) || (!a.a(b))) {
      b = new a(null);
    }
    return b;
  }
  
  static b e()
  {
    if ((c == null) || (!cf)) {
      c = new b(null);
    }
    return c;
  }
  
  private static boolean i()
  {
    Context localContext = c();
    int i = 0;
    if (localContext != null) {
      if (Build.VERSION.SDK_INT >= 17) {
        i = Settings.Global.getInt(localContext.getContentResolver(), "adb_enabled", 0);
      } else {
        i = Settings.Secure.getInt(localContext.getContentResolver(), "adb_enabled", 0);
      }
    }
    return i == 1;
  }
  
  static boolean b(Context paramContext)
  {
    return (getApplicationInfoflags & 0x2) != 0;
  }
  
  static class b
  {
    String a = "_unknown_";
    String b = "_unknown_";
    Integer c = Integer.valueOf(-1);
    boolean d = false;
    boolean e = false;
    boolean f = false;
    
    private b()
    {
      try
      {
        Context localContext;
        if ((localContext = s.c()) != null)
        {
          f = true;
          TelephonyManager localTelephonyManager = (TelephonyManager)localContext.getSystemService("phone");
          a = localTelephonyManager.getSimOperatorName();
          b = localTelephonyManager.getNetworkOperatorName();
          c = Integer.valueOf(localTelephonyManager.getPhoneType());
          d = s.g();
          e = s.b(localContext);
        }
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
  }
  
  static class a
  {
    private boolean a = false;
    private String b = "_unknown_";
    private String c = "_unknown_";
    private String d = "_unknown_";
    
    private a()
    {
      try
      {
        Object localObject;
        if ((localObject = s.c()) != null)
        {
          a = true;
          PackageManager localPackageManager = ((Context)localObject).getPackageManager();
          c = ((Context)localObject).getPackageName();
          localObject = ((Context)localObject).getApplicationInfo();
          localObject = localPackageManager.getApplicationLabel((ApplicationInfo)localObject);
          b = ((CharSequence)localObject).toString();
          d = localPackageManager.getInstallerPackageName(c);
          return;
        }
        p.a(3, "Util", this, "Can't get app name, appContext is null.");
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
    
    String a()
    {
      return b;
    }
    
    String b()
    {
      return c;
    }
    
    String c()
    {
      if (d != null) {
        return d;
      }
      return "_unknown_";
    }
  }
}
