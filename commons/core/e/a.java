package com.inmobi.commons.core.e;

import android.util.Log;
import com.inmobi.commons.core.a.d;
import org.json.JSONException;
import org.json.JSONObject;






public final class a
  extends d
{
  private static final String g = f.class.getSimpleName();
  
  public a(Throwable paramThrowable) {
    super("crashReporting", "catchEvent");
    JSONObject localJSONObject = new JSONObject();
    try {
      localJSONObject.put("name", paramThrowable.getClass().getSimpleName());
      localJSONObject.put("message", paramThrowable.getMessage());
      localJSONObject.put("stack", Log.getStackTraceString(paramThrowable));
      localJSONObject.put("thread", Thread.currentThread().getName());
      


































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      f = localJSONObject.toString();
    }
    catch (JSONException paramThrowable)
    {
      new StringBuilder("JSONException: ").append(paramThrowable);
    }
  }
}
