package com.integralads.avid.library.inmobi.session.internal.jsbridge;

import android.support.annotation.VisibleForTesting;
import android.webkit.WebView;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.inmobi.weakreference.AvidWebView;


public class AvidWebViewManager
  implements AvidJavascriptInterface.AvidJavascriptInterfaceCallback
{
  private final InternalAvidAdSessionContext avidAdSessionContext;
  private final AvidWebView avidWebView = new AvidWebView(null);
  private final AvidBridgeManager avidBridgeManager;
  private AvidJavascriptInterface javascriptInterface;
  
  public AvidWebViewManager(InternalAvidAdSessionContext paramInternalAvidAdSessionContext, AvidBridgeManager paramAvidBridgeManager) {
    avidAdSessionContext = paramInternalAvidAdSessionContext;
    avidBridgeManager = paramAvidBridgeManager;
  }
  
  public void setWebView(WebView paramWebView) {
    if (avidWebView.get() == paramWebView) {
      return;
    }
    avidBridgeManager.setWebView(null);
    clearJavascriptInterface();
    avidWebView.set(paramWebView);
    if (paramWebView != null) {
      javascriptInterface = new AvidJavascriptInterface(avidAdSessionContext);
      javascriptInterface.setCallback(this);
      paramWebView.addJavascriptInterface(javascriptInterface, "avid");
    }
  }
  
  public void destroy() {
    setWebView(null);
  }
  
  private void clearJavascriptInterface() {
    if (javascriptInterface != null) {
      javascriptInterface.setCallback(null);
      javascriptInterface = null;
    }
  }
  
  public void onAvidAdSessionContextInvoked()
  {
    avidBridgeManager.setWebView((WebView)avidWebView.get());
  }
  
  @VisibleForTesting
  AvidJavascriptInterface getJavascriptInterface() {
    return javascriptInterface;
  }
}
