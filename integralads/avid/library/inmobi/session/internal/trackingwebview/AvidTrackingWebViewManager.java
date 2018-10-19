package com.integralads.avid.library.inmobi.session.internal.trackingwebview;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.integralads.avid.library.inmobi.weakreference.AvidWebView;
import java.util.ArrayList;









public class AvidTrackingWebViewManager
  implements AvidJavaScriptResourceInjector, AvidWebViewClient.AvidWebViewClientListener
{
  private static final String HTML_DATA = "<html><body></body></html>";
  private static final String HTML_ENCODING = "text/html";
  private static final String JAVASCRIPT_RESOURCE = "(function () {\nvar script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);\n})();";
  private static final String SCRIPT_SRC_PLACEHOLDER = "%SCRIPT_SRC%";
  static final int STATE_IDLE = 0;
  static final int STATE_LOADING = 1;
  static final int STATE_READY = 2;
  private final AvidWebView avidWebView;
  private final AvidWebViewClient webViewClient;
  private int state = 0;
  private final ArrayList<String> pendingJavaScriptResources = new ArrayList();
  
  public AvidTrackingWebViewManager(WebView paramWebView) {
    avidWebView = new AvidWebView(paramWebView);
    paramWebView.getSettings().setJavaScriptEnabled(true);
    webViewClient = new AvidWebViewClient();
    webViewClient.setListener(this);
    paramWebView.setWebViewClient(webViewClient);
  }
  
  public void loadHTML() {
    WebView localWebView;
    if (((localWebView = (WebView)avidWebView.get()) != null) && (state == 0)) {
      state = 1;
      localWebView.loadData("<html><body></body></html>", "text/html", null);
    }
  }
  
  public void injectJavaScriptResource(String paramString)
  {
    if (state == 2) {
      doInjectJavaScriptResource(paramString);return;
    }
    pendingJavaScriptResources.add(paramString);
  }
  

  public void webViewDidLoadData()
  {
    state = 2;
    for (String str : pendingJavaScriptResources) {
      doInjectJavaScriptResource(str);
    }
    pendingJavaScriptResources.clear();
  }
  
  private void doInjectJavaScriptResource(String paramString) {
    paramString = "(function () {\nvar script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);\n})();".replace("%SCRIPT_SRC%", paramString);
    avidWebView.injectJavaScript(paramString);
  }
}
