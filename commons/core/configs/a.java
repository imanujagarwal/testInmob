package com.inmobi.commons.core.configs;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;





public abstract class a
{
  public a p;
  
  public abstract String a();
  
  public abstract boolean c();
  
  public abstract a d();
  
  public a()
  {
    p = new a();
  }
  
  public void a(JSONObject paramJSONObject) throws JSONException {
    paramJSONObject = paramJSONObject.getJSONObject("includeIds");
    for (int i = 0; i < paramJSONObject.length(); i++) {
      
      






















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        p.a.put("O1", Boolean.valueOf(paramJSONObject.getBoolean("O1")));
      






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.put("UM5", Boolean.valueOf(paramJSONObject.getBoolean("UM5")));
      






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.put("GPID", Boolean.valueOf(paramJSONObject.getBoolean("GPID")));
      






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.put("SHA1_IMEI", Boolean.valueOf(paramJSONObject.optBoolean("SHA1_IMEI", false)));
      






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.put("MD5_IMEI", Boolean.valueOf(paramJSONObject.optBoolean("MD5_IMEI", false)));
    }
  }
  
  public JSONObject b() throws JSONException {
    JSONObject localJSONObject1 = new JSONObject();
    
    JSONObject localJSONObject2;
    (localJSONObject2 = new JSONObject()).put("O1", 
    


















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.get("O1"));localJSONObject2.put("UM5", 
    






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.get("UM5"));localJSONObject2.put("GPID", 
    






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.get("GPID"));localJSONObject2.put("SHA1_IMEI", 
    






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.get("SHA1_IMEI"));localJSONObject2.put("MD5_IMEI", 
    






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      p.a.get("MD5_IMEI"));localJSONObject1.put("includeIds", localJSONObject2);return localJSONObject1;
  }
  








  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool = false;
    }
    else if (a().equals(((a)paramObject).a())) {
      bool = true;
    }
    
    return bool;
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  






  public static final class a
  {
    public HashMap<String, Boolean> a = new HashMap();
    
    public a() {
      a.put("O1", Boolean.valueOf(true));
      a.put("UM5", Boolean.valueOf(true));
      a.put("GPID", Boolean.valueOf(true));
      a.put("SHA1_IMEI", Boolean.valueOf(false));
      a.put("MD5_IMEI", Boolean.valueOf(false));
    }
  }
}