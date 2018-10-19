package com.inmobi.commons.core.network;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;






public class WebViewNetworkTask
{
  private static final String d = WebViewNetworkTask.class.getSimpleName();
  public c a;
  public WebViewClient b;
  public NetworkTaskWebView c;
  
  public WebViewNetworkTask(c paramC, WebViewClient paramWebViewClient) {
    b = paramWebViewClient;
    a = paramC;
  }
  








  public class NetworkTaskWebView
    extends WebView
  {
    public boolean a;
    








    public NetworkTaskWebView(Context paramContext)
    {
      super();
    }
    
    public void destroy()
    {
      a = true;
      super.destroy();
    }
  }
}
