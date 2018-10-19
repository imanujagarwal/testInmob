package com.moat.analytics.mobile.inm;

import android.graphics.Rect;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class t
  extends b
  implements NativeDisplayTracker
{
  private final Map<String, String> g;
  private final Set<NativeDisplayTracker.MoatUserInteractionType> h = new HashSet();
  
  t(View paramView, Map<String, String> paramMap)
  {
    super(paramView, true, false);
    p.a(3, "NativeDisplayTracker", this, "Initializing.");
    g = paramMap;
    if (paramView == null)
    {
      paramView = "Target view is null";
      paramMap = "NativeDisplayTracker initialization not successful, " + paramView;
      p.a("[ERROR] ", 3, "NativeDisplayTracker", this, paramMap);
      a = new m(paramView);
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      paramView = "AdIds is null or empty";
      paramMap = "NativeDisplayTracker initialization not successful, " + paramView;
      p.a("[ERROR] ", 3, "NativeDisplayTracker", this, paramMap);
      a = new m("AdIds is null or empty");
      return;
    }
    if ((paramView = getInstanced) == null)
    {
      paramMap = "prepareNativeDisplayTracking was not called successfully";
      paramView = "NativeDisplayTracker initialization not successful, " + paramMap;
      p.a("[ERROR] ", 3, "NativeDisplayTracker", this, paramView);
      a = new m(paramMap);
      return;
    }
    super.a(b);
    try
    {
      super.a(a);
      i();
      p.a("[SUCCESS] ", a() + " created for " + g() + ", with adIds:" + paramMap.toString());
      return;
    }
    catch (m paramMap)
    {
      a = paramMap;
    }
  }
  
  String a()
  {
    return "NativeDisplayTracker";
  }
  
  public void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType paramMoatUserInteractionType)
  {
    try
    {
      p.a(3, "NativeDisplayTracker", this, "reportUserInteractionEvent:" + paramMoatUserInteractionType.name());
      if (!h.contains(paramMoatUserInteractionType))
      {
        h.add(paramMoatUserInteractionType);
        JSONObject localJSONObject;
        (localJSONObject = new JSONObject()).accumulate("adKey", e);
        localJSONObject.accumulate("event", paramMoatUserInteractionType.name().toLowerCase());
        if (c != null) {
          c.b(localJSONObject.toString());
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      p.b(2, "NativeDisplayTracker", this, "Got JSON exception");
      m.a(localJSONException);
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  private void i()
  {
    if (c != null) {
      c.a(j());
    }
  }
  
  private String j()
  {
    String str1 = "";
    try
    {
      String str2 = a(g);
      p.a(3, "NativeDisplayTracker", this, "Parsed ad ids = " + str2);
      str1 = "{\"adIds\":" + str2 + ", \"adKey\":\"" + e + "\", \"adSize\":" + k() + "}";
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return str1;
  }
  
  private String k()
  {
    try
    {
      Rect localRect;
      int j = (localRect = z.a(super.f())).width();
      int i = localRect.height();
      HashMap localHashMap;
      (localHashMap = new HashMap()).put("width", Integer.toString(j));
      localHashMap.put("height", Integer.toString(i));
      return new JSONObject(localHashMap).toString();
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return null;
  }
  
  private static String a(Map<String, String> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    String str1;
    for (int i = 0; i < 8; i++)
    {
      str1 = "moatClientLevel" + i;
      if (paramMap.containsKey(str1)) {
        localLinkedHashMap.put(str1, paramMap.get(str1));
      }
    }
    for (i = 0; i < 8; i++)
    {
      str1 = "moatClientSlicer" + i;
      if (paramMap.containsKey(str1)) {
        localLinkedHashMap.put(str1, paramMap.get(str1));
      }
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str1 = (String)localIterator.next();
      if (!localLinkedHashMap.containsKey(str1))
      {
        String str2 = (String)paramMap.get(str1);
        localLinkedHashMap.put(str1, str2);
      }
    }
    return new JSONObject(localLinkedHashMap).toString();
  }
}
