package com.inmobi.commons.core.a;

import android.content.ContentValues;
import android.util.Log;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;











public class d
{
  private static final String g = d.class.getSimpleName();
  int a;
  String b;
  String c;
  String d;
  long e;
  public String f;
  
  public d(Thread paramThread, Throwable paramThrowable)
  {
    this("crashReporting", "CrashEvent");
    JSONObject localJSONObject = new JSONObject();
    try {
      localJSONObject.put("name", paramThrowable.getClass().getSimpleName());
      localJSONObject.put("message", paramThrowable.getMessage());
      localJSONObject.put("stack", Log.getStackTraceString(paramThrowable));
      localJSONObject.put("thread", paramThread.getName());
      






















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      f = localJSONObject.toString();
    }
    catch (JSONException paramThread)
    {
      new StringBuilder("JSONException: ").append(paramThread);
    }
  }
  
  public d(String paramString1, String paramString2) {
    b = UUID.randomUUID().toString();
    d = paramString1;
    c = paramString2;
    f = null;
    e = System.currentTimeMillis();
  }
  
  private d(String paramString1, String paramString2, String paramString3, String paramString4) {
    b = paramString1;
    d = paramString2;
    c = paramString3;
    f = paramString4;
    e = System.currentTimeMillis();
  }
  















  public final String a()
  {
    if (f == null) return ""; return f;
  }
  








  public String toString()
  {
    return 
    





























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      c + "@" + 
      


































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      d + " ";
  }
  
  public static d a(ContentValues paramContentValues) {
    Object localObject = paramContentValues.getAsString("eventId");
    String str1 = paramContentValues.getAsString("eventType");
    String str2 = paramContentValues.getAsString("componentType");
    String str3 = paramContentValues.getAsString("payload");
    long l = Long.valueOf(paramContentValues.getAsString("ts")).longValue();
    
    de = l;
    a = paramContentValues.getAsInteger("id").intValue();
    return localObject;
  }
}