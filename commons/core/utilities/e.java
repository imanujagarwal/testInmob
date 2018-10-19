package com.inmobi.commons.core.utilities;

import android.content.Context;
import com.inmobi.commons.core.e.b;
import java.util.HashMap;
import java.util.Map;





















public final class e
{
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      return paramContext.checkCallingOrSelfPermission(paramString2) == 0;
    }
    catch (Exception paramContext)
    {
      try
      {
        (paramString2 = new HashMap()).put("type", "RuntimeException");
        paramString2.put("message", paramContext.getMessage());
        b.a();b.a(paramString1, "ExceptionCaught", paramString2);
      }
      catch (Exception localException) {
        new StringBuilder("Error in submitting telemetry event : (").append(paramContext.getMessage()).append(")");
      }
    }
    return false;
  }
}
