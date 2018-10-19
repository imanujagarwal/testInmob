package com.moat.analytics.mobile.inm;

import android.util.Log;
import android.view.View;

class p
{
  p() {}
  
  static void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (ab)
    {
      if (paramObject == null)
      {
        Log.println(paramInt, a(paramString1), String.format("message = %s", new Object[] { paramString2 }));
        return;
      }
      Log.println(paramInt, a(paramString1), String.format("id = %s, message = %s", new Object[] { Integer.valueOf(paramObject.hashCode()), paramString2 }));
    }
  }
  
  static void b(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (ac) {
      Log.println(paramInt, a(paramString1), String.format("id = %s, message = %s", new Object[] { paramObject == null ? "null" : Integer.valueOf(paramObject.hashCode()), paramString2 }));
    }
  }
  
  static void a(String paramString1, Object paramObject, String paramString2, Throwable paramThrowable)
  {
    if (ab) {
      Log.e(a(paramString1), String.format("id = %s, message = %s", new Object[] { Integer.valueOf(paramObject.hashCode()), paramString2 }), paramThrowable);
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    if ((!ab) && (getInstancea))
    {
      int i = 2;
      if (paramString1.equals("[ERROR] ")) {
        i = 6;
      }
      paramString2 = paramString1 + paramString2;
      Log.println(i, "MoatAnalytics", paramString2);
    }
  }
  
  static void a(String paramString1, int paramInt, String paramString2, Object paramObject, String paramString3)
  {
    a(paramInt, paramString2, paramObject, paramString3);
    a(paramString1, paramString3);
  }
  
  private static String a(String paramString)
  {
    return "Moat" + paramString;
  }
  
  static String a(View paramView)
  {
    if (paramView != null) {
      return paramView.getClass().getSimpleName() + "@" + paramView.hashCode();
    }
    return "null";
  }
}
