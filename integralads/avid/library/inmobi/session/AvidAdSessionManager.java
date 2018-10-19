package com.integralads.avid.library.inmobi.session;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.integralads.avid.library.inmobi.AvidContext;
import com.integralads.avid.library.inmobi.AvidManager;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidDisplayAdSession;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidManagedVideoAdSession;

public class AvidAdSessionManager
{
  public AvidAdSessionManager() {}
  
  public static String getVersion()
  {
    return AvidContext.getInstance().getAvidVersion();
  }
  
  public static String getReleaseDate() {
    return AvidContext.getInstance().getAvidReleaseDate();
  }
  
  public static AvidDisplayAdSession startAvidDisplayAdSession(Context paramContext, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext) {
    AvidManager.getInstance().init(paramContext);
    AvidDisplayAdSession localAvidDisplayAdSession = new AvidDisplayAdSession();
    (
      paramContext = new InternalAvidDisplayAdSession(paramContext, localAvidDisplayAdSession.getAvidAdSessionId(), paramExternalAvidAdSessionContext)).onStart();
    AvidManager.getInstance().registerAvidAdSession(localAvidDisplayAdSession, paramContext);
    return localAvidDisplayAdSession;
  }
  
  public static AvidVideoAdSession startAvidVideoAdSession(Context paramContext, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext) {
    AvidManager.getInstance().init(paramContext);
    AvidVideoAdSession localAvidVideoAdSession = new AvidVideoAdSession();
    (
      paramContext = new com.integralads.avid.library.inmobi.session.internal.InternalAvidVideoAdSession(paramContext, localAvidVideoAdSession.getAvidAdSessionId(), paramExternalAvidAdSessionContext)).onStart();
    AvidManager.getInstance().registerAvidAdSession(localAvidVideoAdSession, paramContext);
    return localAvidVideoAdSession;
  }
  
  public static AvidManagedVideoAdSession startAvidManagedVideoAdSession(Context paramContext, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext) {
    AvidManager.getInstance().init(paramContext);
    AvidManagedVideoAdSession localAvidManagedVideoAdSession = new AvidManagedVideoAdSession();
    (
      paramContext = new InternalAvidManagedVideoAdSession(paramContext, localAvidManagedVideoAdSession.getAvidAdSessionId(), paramExternalAvidAdSessionContext)).onStart();
    AvidManager.getInstance().registerAvidAdSession(localAvidManagedVideoAdSession, paramContext);
    return localAvidManagedVideoAdSession;
  }
  
  public static AvidManagedDisplayAdSession startAvidManagedDisplayAdSession(Context paramContext, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext) {
    AvidManager.getInstance().init(paramContext);
    AvidManagedDisplayAdSession localAvidManagedDisplayAdSession = new AvidManagedDisplayAdSession();
    (
      paramContext = new com.integralads.avid.library.inmobi.session.internal.InternalAvidManagedDisplayAdSession(paramContext, localAvidManagedDisplayAdSession.getAvidAdSessionId(), paramExternalAvidAdSessionContext)).onStart();
    AvidManager.getInstance().registerAvidAdSession(localAvidManagedDisplayAdSession, paramContext);
    return localAvidManagedDisplayAdSession;
  }
  
  public static <T extends AbstractAvidAdSession> T findAvidAdSessionById(String paramString) {
    return AvidManager.getInstance().findAvidAdSessionById(paramString);
  }
  
  public static WebView webViewForView(View paramView) {
    WebView localWebView;
    if ((localWebView = findWebView(paramView)) != null) {
      return localWebView;
    }
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    paramView = (ViewGroup)paramView;
    for (int i = 0; i < paramView.getChildCount(); i++)
    {

      if ((localWebView = webViewForView(paramView.getChildAt(i))) != null) {
        break;
      }
    }
    return localWebView;
  }
  
  public static WebView webViewForSessionId(String paramString)
  {
    if ((paramString = AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionById(paramString)) != null) return paramString.getWebView(); return null;
  }
  
  private static WebView findWebView(View paramView)
  {
    if ((paramView = AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionByView(paramView)) != null) return paramView.getWebView(); return null;
  }
}
