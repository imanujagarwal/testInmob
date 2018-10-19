package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.utilities.uid.d;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;







final class f
  extends com.inmobi.commons.core.network.c
{
  private static final String d = f.class.getSimpleName();
  
  int a;
  
  int b;
  
  Map<String, a> c;
  
  f(Map<String, a> paramMap, d paramD, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramMap, paramD, paramString, paramInt1, paramInt2, false, paramInt3);
  }
  
  f(Map<String, a> paramMap, d paramD, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
    super("POST", (paramString == null) || (paramString.trim().length() == 0) ? "https://config.inmobi.com/config-server/v1/config/secure.cfg" : paramBoolean ? "https://config.inmobi.cn/config-server/v1/config/secure.cfg" : paramString, paramD, paramInt3);
    c = paramMap;
    a = paramInt1;
    b = paramInt2;
  }
  

  public final void a()
  {
    super.a();
    o.put("p", c());
    o.put("im-accid", com.inmobi.commons.a.a.e());
  }
  
  private String c() {
    c localC = new c();
    String str = "";
    try
    {
      JSONArray localJSONArray = new JSONArray();
      for (Map.Entry localEntry : c.entrySet()) {
        JSONObject localJSONObject;
        (localJSONObject = new JSONObject()).put("n", localEntry.getKey());
        localJSONObject.put("t", localC.b((String)localEntry.getKey()));
        localJSONArray.put(localJSONObject);
      }
      
      str = localJSONArray.toString();
    }
    catch (JSONException localJSONException) {}
    
    return str;
  }
}
