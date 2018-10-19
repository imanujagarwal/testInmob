package com.integralads.avid.library.inmobi.session;

import com.integralads.avid.library.inmobi.session.internal.InternalAvidManagedAdSession;

public abstract class AbstractAvidManagedAdSession extends AbstractAvidAdSession<android.view.View>
{
  public AbstractAvidManagedAdSession() {}
  
  public void injectJavaScriptResource(String paramString)
  {
    InternalAvidManagedAdSession localInternalAvidManagedAdSession;
    if ((localInternalAvidManagedAdSession = (InternalAvidManagedAdSession)com.integralads.avid.library.inmobi.AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId())) != null) {
      localInternalAvidManagedAdSession.getJavaScriptResourceInjector().injectJavaScriptResource(paramString);
    }
  }
}
