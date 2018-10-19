package com.integralads.avid.library.inmobi.session.internal.trackingwebview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AvidWebViewClient
  extends WebViewClient
{
  private AvidWebViewClientListener listener;
  
  public AvidWebViewClient() {}
  
  public AvidWebViewClientListener getListener()
  {
    return listener;
  }
  
  public void setListener(AvidWebViewClientListener paramAvidWebViewClientListener) {
    listener = paramAvidWebViewClientListener;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (listener != null) {
      listener.webViewDidLoadData();
    }
  }
  
  public static abstract interface AvidWebViewClientListener
  {
    public abstract void webViewDidLoadData();
  }
}
