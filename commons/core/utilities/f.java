package com.inmobi.commons.core.utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.inmobi.commons.a.a;







public final class f
{
  private static final String a = f.class.getSimpleName();
  
  public f() {}
  
  public static boolean a(@NonNull String paramString) { Context localContext; if ((localContext = a.b()) == null) return false;
    try
    {
      return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(localContext) == 0;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}catch (Exception localException)
    {
      new StringBuilder("Error in connecting to GooglePlayServices API for component ").append(paramString).append(" : (").append(localException.getMessage()).append(")");
    }
    return false;
  }
}
