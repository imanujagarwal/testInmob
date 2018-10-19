package com.moat.analytics.mobile.inm;

import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Locale;

class m
  extends Exception
{
  private static final Long a = Long.valueOf(60000L);
  private static Long b;
  private static Exception c = null;
  
  m(String paramString)
  {
    super(paramString);
  }
  
  static String a(String paramString, Exception paramException)
  {
    if ((paramException instanceof m)) {
      return paramString + " failed: " + paramException.getMessage();
    }
    return paramString + " failed unexpectedly";
  }
  
  static void a(Exception paramException)
  {
    if (ab)
    {
      Log.e("MoatException", Log.getStackTraceString(paramException));
      return;
    }
    b(paramException);
  }
  
  private static void b(Exception paramException)
  {
    try
    {
      if (aa == w.d.b)
      {
        int i;
        if ((i = ae) == 0) {
          return;
        }
        if ((i < 100) && (i / 100.0D < Math.random())) {
          return;
        }
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        Object localObject = "https://px.moatads.com/pixel.gif?e=0&i=MOATSDK1&ac=1";
        (localObject = new StringBuilder((String)localObject)).append("&zt=" + ((paramException instanceof m) ? 1 : 0));
        ((StringBuilder)localObject).append("&zr=" + i);
        try
        {
          ((StringBuilder)localObject).append("&zm=" + (paramException.getMessage() == null ? "null" : URLEncoder.encode(Base64.encodeToString(paramException.getMessage().getBytes("UTF-8"), 0), "UTF-8")));
          ((StringBuilder)localObject).append("&k=" + URLEncoder.encode(Base64.encodeToString(Log.getStackTraceString(paramException).getBytes("UTF-8"), 0), "UTF-8"));
        }
        catch (Exception localException1) {}
        try
        {
          str1 = "INM";
          ((StringBuilder)localObject).append("&zMoatMMAKv=c334ae83accfebb8da23104450c896463c9cfab7");
          str3 = "2.5.0";
          paramException = s.d();
          ((StringBuilder)localObject).append("&zMoatMMAKan=" + paramException.a());
          str2 = paramException.b();
          str4 = Integer.toString(Build.VERSION.SDK_INT);
        }
        catch (Exception localException2) {}
        ((StringBuilder)localObject).append("&d=Android:" + str1 + ":" + str2 + ":-");
        ((StringBuilder)localObject).append("&bo=" + str3);
        ((StringBuilder)localObject).append("&bd=" + str4);
        paramException = Long.valueOf(System.currentTimeMillis());
        ((StringBuilder)localObject).append("&t=" + paramException);
        ((StringBuilder)localObject).append("&de=" + String.format(Locale.ROOT, "%.0f", new Object[] { Double.valueOf(Math.floor(Math.random() * Math.pow(10.0D, 12.0D))) }));
        ((StringBuilder)localObject).append("&cs=0");
        if ((b == null) || (paramException.longValue() - b.longValue() > a.longValue()))
        {
          q.b(((StringBuilder)localObject).toString());
          b = paramException;
        }
        return;
      }
      c = paramException;
      return;
    }
    catch (Exception localException3) {}
  }
  
  static void a()
  {
    if (c != null)
    {
      b(c);
      c = null;
    }
  }
}
