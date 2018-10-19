package com.inmobi.rendering.mraid;

import org.json.JSONException;
import org.json.JSONObject;



public class g
{
  public boolean a;
  public String b;
  public String c;
  public String d;
  private static String e = g.class.getSimpleName();
  
  public g() {
    b = "none";
    c = "right";
    a = true;
    d = null;
  }
  
  public static g a(String paramString, g paramG) {
    g localG;
    gd = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      b = paramString.optString("forceOrientation", b);
      a = paramString.optBoolean("allowOrientationChange", a);
      c = paramString.optString("direction", c);
      
      if ((!b.equals("portrait")) && (!b.equals("landscape"))) {
        b = "none";
      }
      if ((!c.equals("left")) && (!c.equals("right"))) {
        c = "right";
      }
    }
    catch (JSONException localJSONException) {
      localG = null;
    }
    return localG;
  }
}
