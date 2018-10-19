package com.inmobi.commons.core.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.a.a;
import java.util.HashMap;



public final class c
{
  private static HashMap<String, c> b = new HashMap();
  private static final Object c = new Object();
  public SharedPreferences a;
  
  private c(Context paramContext, String paramString)
  {
    a = paramContext.getSharedPreferences(paramString, 0);
  }
  
  public static String a(String paramString) {
    return "com.im.keyValueStore." + paramString;
  }
  
  public static c a(Context paramContext, String paramString) {
    paramString = a(paramString);
    c localC;
    if ((localC = (c)b.get(paramString)) != null) {
      return localC;
    }
    synchronized (c)
    {
      if ((localC = (c)b.get(paramString)) != null) {
        return localC;
      }
      
      localC = new c(paramContext, paramString);
      b.put(paramString, localC);
      return localC;
    }
  }
  
  public static c b(String paramString)
  {
    return a(a.b(), paramString);
  }
  
  public final void a(String paramString1, String paramString2) {
    SharedPreferences.Editor localEditor;
    (localEditor = a.edit()).putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  public final String c(String paramString) {
    return a.getString(paramString, null);
  }
  
  public final void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor;
    (localEditor = a.edit()).putInt(paramString, paramInt);
    localEditor.apply();
  }
  
  public final int d(String paramString) {
    return a.getInt(paramString, Integer.MIN_VALUE);
  }
  





  public final void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor;
    



    (localEditor = a.edit()).putLong(paramString, paramLong);
    localEditor.apply();
  }
  
  public final long b(String paramString, long paramLong) {
    return a.getLong(paramString, paramLong);
  }
  
  public final void a(String paramString, boolean paramBoolean) {
    SharedPreferences.Editor localEditor;
    (localEditor = a.edit()).putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  public final boolean b(String paramString, boolean paramBoolean) {
    return a.getBoolean(paramString, paramBoolean);
  }
}
