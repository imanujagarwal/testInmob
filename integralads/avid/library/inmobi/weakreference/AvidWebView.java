package com.integralads.avid.library.inmobi.weakreference;

import android.webkit.WebView;
import com.integralads.avid.library.inmobi.utils.AvidCommand;


public class AvidWebView
  extends AvidView<WebView>
{
  public AvidWebView(WebView paramWebView)
  {
    super(paramWebView);
  }
  
  public void injectJavaScript(String paramString) {
    injectFormattedJavaScript(AvidCommand.formatJavaScript(paramString));
  }
  
  public void injectFormattedJavaScript(String paramString) {
    WebView localWebView;
    if ((localWebView = (WebView)get()) != null) {
      localWebView.loadUrl(paramString);
    }
  }
}
