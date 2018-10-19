package com.moat.analytics.mobile.inm;

import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONObject;

class l
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private int d = 200;
  private int e = 10;
  
  l(String paramString)
  {
    a(paramString);
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      String str;
      boolean bool1 = (str = (paramString = new JSONObject(paramString)).getString("sa")).equals("c334ae83accfebb8da23104450c896463c9cfab7");
      boolean bool2 = str.equals("8f1d08a2d6496191a5ebae8f0590f513e2619489");
      if (((str.equals("on")) || (bool1) || (bool2)) && (!a(paramString)) && (!b(paramString)))
      {
        a = true;
        b = bool1;
        c = bool2;
        if (c) {
          b = true;
        }
      }
      int i;
      if ((paramString.has("in")) && ((i = paramString.getInt("in")) >= 100) && (i <= 1000)) {
        d = i;
      }
      if (paramString.has("es")) {
        e = paramString.getInt("es");
      }
      if (c(paramString)) {
        getInstancec = true;
      }
      return;
    }
    catch (Exception paramString)
    {
      a = false;
      b = false;
      d = 200;
      m.a(paramString);
    }
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    try
    {
      if (16 > Build.VERSION.SDK_INT) {
        return true;
      }
      if (paramJSONObject.has("ob"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("ob");
        int i = 0;
        int j = paramJSONObject.length();
        while (i < j)
        {
          if (paramJSONObject.getInt(i) == Build.VERSION.SDK_INT) {
            return true;
          }
          i++;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return true;
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("ap"))
      {
        String str = s.d().b();
        paramJSONObject = paramJSONObject.getJSONArray("ap");
        int i = 0;
        int j = paramJSONObject.length();
        while (i < j)
        {
          if (paramJSONObject.getString(i).contentEquals(str)) {
            return true;
          }
          i++;
        }
      }
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return false;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("al"))
      {
        String str = s.d().b();
        paramJSONObject = paramJSONObject.getJSONArray("al");
        int i = 0;
        int j = paramJSONObject.length();
        while (i < j)
        {
          if (paramJSONObject.getString(i).contentEquals(str)) {
            return true;
          }
          i++;
        }
      }
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return false;
  }
  
  boolean a()
  {
    return b;
  }
  
  boolean b()
  {
    return c;
  }
  
  int c()
  {
    return d;
  }
  
  int d()
  {
    return e;
  }
  
  w.d e()
  {
    if (a) {
      return w.d.b;
    }
    return w.d.a;
  }
}
