package com.integralads.avid.library.inmobi;

import android.support.annotation.NonNull;

public class AvidBridge
{
  public static final String APP_STATE_ACTIVE = "active";
  public static final String APP_STATE_INACTIVE = "inactive";
  private static String avidJS;
  
  public AvidBridge() {}
  
  public static void setAvidJs(@NonNull String paramString) {
    avidJS = paramString;
  }
  
  public static boolean isAvidJsReady() {
    return !android.text.TextUtils.isEmpty(avidJS);
  }
  
  public static String getAvidJs() {
    return avidJS;
  }
  
  public static void cleanUpAvidJS() {
    avidJS = null;
  }
}
