package com.integralads.avid.library.inmobi.utils;

import android.util.Log;

public class AvidLogs
{
  private static final boolean DEBUG = true;
  private static final String TAG = "AVID";
  
  public AvidLogs() {}
  
  public static void d(String paramString) {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      Log.d("AVID", paramString);
    }
  }
  
  public static void w(String paramString) {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      Log.w("AVID", paramString);
    }
  }
  
  public static void i(String paramString) {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      Log.i("AVID", paramString);
    }
  }
  
  public static void e(String paramString) {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      Log.e("AVID", paramString);
    }
  }
  
  public static void e(String paramString, Exception paramException) {
    if ((!android.text.TextUtils.isEmpty(paramString)) || (paramException != null)) {
      Log.e("AVID", paramString, paramException);
    }
  }
}
