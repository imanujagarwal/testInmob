package com.inmobi.rendering.a;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;








public class b
{
  private static final String b = b.class.getSimpleName();
  





















  static final String[] a = { "id", "pending_attempts", "url", "ping_in_webview", "follow_redirect", "ts", "created_ts", "track_extras" };
  
  b() {
    com.inmobi.commons.core.d.b localB;
    (localB = com.inmobi.commons.core.d.b.a()).a("click", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL, track_extras TEXT, created_ts TEXT NOT NULL )");
    localB.b();
  }
  
  public static boolean a() {
    com.inmobi.commons.core.d.b localB = com.inmobi.commons.core.d.b.a();
    return 0 == localB.a("click");
  }
  
  public final synchronized boolean a(a paramA, int paramInt) {
    ContentValues localContentValues = b(paramA);
    
    com.inmobi.commons.core.d.b localB;
    if ((localB = com.inmobi.commons.core.d.b.a()).a("click") >= paramInt)
    {
      try
      {
        (paramInt = new HashMap()).put("pingUrl", b);
        paramInt.put("errorCode", "MaxDbLimitBreach");
        com.inmobi.commons.core.e.b.a();com.inmobi.commons.core.e.b.a("ads", "PingDiscarded", paramInt);
      }
      catch (Exception paramInt) {
        new StringBuilder("Error in submitting telemetry event : (").append(paramInt.getMessage()).append(")");
      }
      


      paramA = a((ContentValues)localB.a("click", a, "ts= (SELECT MIN(ts) FROM click LIMIT 1)", null, null, null, null, null).get(0));
      new StringBuilder("Deleting click (").append(a).append(")");
      a(paramA);
    }
    
    localB.a("click", localContentValues);
    localB.b();
    return true;
  }
  























  public static void a(a paramA)
  {
    com.inmobi.commons.core.d.b localB = com.inmobi.commons.core.d.b.a();
    paramA = new String[] { String.valueOf(a) };
    localB.a("click", "id = ?", paramA);
    localB.b();
  }
  
  static a a(ContentValues paramContentValues) {
    int i = paramContentValues.getAsInteger("id").intValue();
    int j = paramContentValues.getAsInteger("pending_attempts").intValue();
    String str = paramContentValues.getAsString("url");
    long l1 = Long.valueOf(paramContentValues.getAsString("ts")).longValue();
    long l2 = Long.valueOf(paramContentValues.getAsString("created_ts")).longValue();
    boolean bool1 = Boolean.valueOf(paramContentValues.getAsString("follow_redirect")).booleanValue();
    boolean bool2 = Boolean.valueOf(paramContentValues.getAsString("ping_in_webview")).booleanValue();
    paramContentValues = paramContentValues.getAsString("track_extras");
    HashMap localHashMap = new HashMap();
    if (paramContentValues != null) {
      try {
        paramContentValues = new JSONObject(paramContentValues);
        localHashMap.putAll(a(paramContentValues));
      }
      catch (JSONException paramContentValues) {
        new StringBuilder("JSONException in parsing extras (").append(paramContentValues.getMessage()).append(")");
      }
      catch (Exception paramContentValues) {
        new StringBuilder("Exception in parsing extras (").append(paramContentValues.getMessage()).append(")");
      }
    }
    return new a(i, str, localHashMap, bool1, bool2, j, l1, l2);
  }
  
  static ContentValues b(a paramA) {
    ContentValues localContentValues;
    (localContentValues = new ContentValues()).put("id", Integer.valueOf(a));
    localContentValues.put("url", b);
    localContentValues.put("pending_attempts", Integer.valueOf(f));
    localContentValues.put("ts", Long.toString(d));
    localContentValues.put("created_ts", Long.toString(e));
    localContentValues.put("follow_redirect", Boolean.toString(i));
    localContentValues.put("ping_in_webview", Boolean.toString(h));
    if ((c != null) && (c.size() > 0)) {
      paramA = new JSONObject(c);
      localContentValues.put("track_extras", paramA.toString());
    }
    return localContentValues;
  }
  
  private static Map<String, String> a(JSONObject paramJSONObject) throws JSONException {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext()) {
      String str = (String)localIterator.next();
      localHashMap.put(str, (String)paramJSONObject.get(str));
    }
    return localHashMap;
  }
}
