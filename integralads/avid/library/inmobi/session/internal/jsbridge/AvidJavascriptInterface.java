package com.integralads.avid.library.inmobi.session.internal.jsbridge;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSessionContext;
import org.json.JSONObject;







public class AvidJavascriptInterface
{
  public static final String AVID_OBJECT = "avid";
  private final InternalAvidAdSessionContext avidAdSessionContext;
  private final Handler handler = new Handler();
  private AvidJavascriptInterfaceCallback callback;
  
  public AvidJavascriptInterface(InternalAvidAdSessionContext paramInternalAvidAdSessionContext) {
    avidAdSessionContext = paramInternalAvidAdSessionContext;
  }
  
  public AvidJavascriptInterfaceCallback getCallback() {
    return callback;
  }
  
  public void setCallback(AvidJavascriptInterfaceCallback paramAvidJavascriptInterfaceCallback) {
    callback = paramAvidJavascriptInterfaceCallback;
  }
  
  @JavascriptInterface
  public String getAvidAdSessionContext() {
    handler.post(new CallbackRunnable());
    
    return avidAdSessionContext.getStubContext().toString();
  }
  
  class CallbackRunnable implements Runnable {
    CallbackRunnable() {}
    
    public void run() {
      if (callback != null) {
        callback.onAvidAdSessionContextInvoked();
        callback = null;
      }
    }
  }
  
  public static abstract interface AvidJavascriptInterfaceCallback
  {
    public abstract void onAvidAdSessionContextInvoked();
  }
}
