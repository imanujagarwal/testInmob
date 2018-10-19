package com.integralads.avid.library.inmobi.session.internal;

import android.content.Context;
import android.webkit.WebView;
import com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext;

public abstract class InternalAvidHtmlAdSession
  extends InternalAvidAdSession<WebView>
{
  public InternalAvidHtmlAdSession(Context paramContext, String paramString, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext)
  {
    super(paramContext, paramString, paramExternalAvidAdSessionContext);
  }
  
  public WebView getWebView()
  {
    return (WebView)getView();
  }
  
  protected void onViewRegistered()
  {
    super.onViewRegistered();
    updateWebViewManager();
  }
  
  protected void onViewUnregistered()
  {
    super.onViewUnregistered();
    updateWebViewManager();
  }
}
