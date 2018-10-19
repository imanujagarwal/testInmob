package com.integralads.avid.library.inmobi.utils;

import org.json.JSONObject;

public class AvidCommand {
  public AvidCommand() {}
  
  public static String setNativeViewState(String paramString) { return callAvidbridge("setNativeViewState(" + paramString + ")"); }
  
  public static String setAppState(String paramString)
  {
    return callAvidbridge("setAppState(" + JSONObject.quote(paramString) + ")");
  }
  
  public static String publishReadyEventForDeferredAdSession() {
    return callAvidbridge("publishReadyEventForDeferredAdSession()");
  }
  
  public static String publishVideoEvent(String paramString) {
    return callAvidbridge("publishVideoEvent(" + JSONObject.quote(paramString) + ")");
  }
  
  public static String publishVideoEvent(String paramString1, String paramString2) {
    return callAvidbridge("publishVideoEvent(" + JSONObject.quote(paramString1) + "," + paramString2 + ")");
  }
  
  public static String setAvidAdSessionContext(String paramString) {
    return callAvidbridge("setAvidAdSessionContext(" + paramString + ")");
  }
  
  public static String callAvidbridge(String paramString) {
    return "javascript: if(window.avidbridge!==undefined){avidbridge." + paramString + "}";
  }
  
  public static String formatJavaScript(String paramString) {
    return "javascript: " + paramString;
  }
}
