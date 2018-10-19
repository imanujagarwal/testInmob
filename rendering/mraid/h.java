package com.inmobi.rendering.mraid;

import org.json.JSONException;
import org.json.JSONObject;



public class h
{
  private static final String g = h.class.getSimpleName();
  String a;
  int b;
  int c;
  
  public h()
  {
    d = 0;
    e = 0;
    a = "top-right";
    f = true; }
  
  int d;
  
  public static h a(String paramString, h paramH) { h localH = new h();
    try {
      paramString = new JSONObject(paramString);
      
      b = paramString.getInt("width");
      c = paramString.getInt("height");
      d = paramString.getInt("offsetX");
      e = paramString.getInt("offsetY");
      
      if (paramH != null) {
        a = paramString.optString("customClosePosition", a);
        f = paramString.optBoolean("allowOffscreen", f);
      }
    }
    catch (JSONException localJSONException) {
      localH = null;
    }
    
    return localH; }
  
  int e;
  boolean f;
  public final String a() { String str = "";
    try {
      JSONObject localJSONObject;
      (localJSONObject = new JSONObject()).put("width", b);
      localJSONObject.put("height", c);
      localJSONObject.put("customClosePosition", a);
      localJSONObject.put("offsetX", d);
      localJSONObject.put("offsetY", e);
      localJSONObject.put("allowOffscreen", f);
      str = localJSONObject.toString();
    }
    catch (JSONException localJSONException) {}
    

    return str;
  }
}
