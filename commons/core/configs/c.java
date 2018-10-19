package com.inmobi.commons.core.configs;

import org.json.JSONException;
import org.json.JSONObject;













public final class c
{
  com.inmobi.commons.core.d.c a;
  
  public c()
  {
    a = com.inmobi.commons.core.d.c.b("config_store");
  }
  





  public final void a(a paramA)
  {
    String str;
    



    if ((str = a.c(paramA.a() + "_config")) == null) {
      return;
    }
    try
    {
      paramA.a(new JSONObject(str));
      

      return;
    } catch (JSONException localJSONException) {}
  }
  
  public final boolean a(String paramString) { return a.c(paramString + "_config") != null; }
  
  public final long b(String paramString)
  {
    return a.b(paramString + "_config_update_ts", 0L);
  }
  
  public final void a(String paramString, long paramLong) {
    a.a(paramString + "_config_update_ts", paramLong);
  }
}
