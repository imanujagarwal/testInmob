package com.inmobi.commons.core.utilities.b;

import org.json.JSONException;
import org.json.JSONObject;





public class h
{
  private static final String e = h.class.getSimpleName();
  private static h f;
  private static final Object g = new Object();
  public String a;
  public long b;
  public long c;
  boolean d;
  
  public static h a()
  {
    h localH1;
    if ((localH1 = f) == null) {
      synchronized (g)
      {
        if ((localH1 = f) == null)
        {
          localH1 = h.f = new h();
        }
      }
    }
    return localH2;
  }
  






  private h() {}
  






  public final JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sid", a);
      localJSONObject.put("s-ts", b);
      localJSONObject.put("e-ts", c);
    }
    catch (JSONException localJSONException) {}
    
    return localJSONObject;
  }
  
  public final void a(boolean paramBoolean) {
    d = paramBoolean;
    
    if (!d)
    {












































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      paramBoolean = this;a = null;
      b = 0L;
      c = 0L;
    }
  }
}
