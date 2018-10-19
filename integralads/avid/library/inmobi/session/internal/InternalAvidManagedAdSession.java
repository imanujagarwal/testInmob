package com.integralads.avid.library.inmobi.session.internal;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.inmobi.session.internal.trackingwebview.AvidJavaScriptResourceInjector;
import com.integralads.avid.library.inmobi.session.internal.trackingwebview.AvidTrackingWebViewManager;

public abstract class InternalAvidManagedAdSession extends InternalAvidAdSession<View>
{
  private AvidTrackingWebViewManager trackingWebViewManager;
  private final WebView webView;
  
  public InternalAvidManagedAdSession(Context paramContext, String paramString, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext)
  {
    super(paramContext, paramString, paramExternalAvidAdSessionContext);
    webView = new WebView(paramContext.getApplicationContext());
    trackingWebViewManager = new AvidTrackingWebViewManager(webView);
  }
  
  public WebView getWebView()
  {
    return webView;
  }
  
  public AvidJavaScriptResourceInjector getJavaScriptResourceInjector() {
    return trackingWebViewManager;
  }
  
  public void onStart()
  {
    super.onStart();
    updateWebViewManager();
    trackingWebViewManager.loadHTML();
  }
  
  @VisibleForTesting
  void setTrackingWebViewManager(AvidTrackingWebViewManager paramAvidTrackingWebViewManager) {
    trackingWebViewManager = paramAvidTrackingWebViewManager;
  }
}
