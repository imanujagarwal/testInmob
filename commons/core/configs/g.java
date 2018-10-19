package com.inmobi.commons.core.configs;

import org.json.JSONException;
import org.json.JSONObject;










public final class g
  extends a
{
  public String a = "010001";
  public String b = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";
  private String d = "rsa";
  public String c = "1";
  
  public g() {}
  
  public final String a() { return "pk"; }
  
  public final void a(JSONObject paramJSONObject)
    throws JSONException
  {
    super.a(paramJSONObject);
    
    a = paramJSONObject.getString("e");
    b = paramJSONObject.getString("m");
    d = paramJSONObject.getString("alg");
    c = paramJSONObject.getString("ver");
  }
  
  public final JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject;
    (localJSONObject = super.b()).put("e", a);
    localJSONObject.put("m", b);
    localJSONObject.put("alg", d);
    localJSONObject.put("ver", c);
    return localJSONObject;
  }
  

  public final boolean c()
  {
    return (a.trim().length() != 0) && (b.trim().length() != 0) && (d.trim().length() != 0) && (c.trim().length() != 0);
  }
  
  public final a d()
  {
    return new g();
  }
}
