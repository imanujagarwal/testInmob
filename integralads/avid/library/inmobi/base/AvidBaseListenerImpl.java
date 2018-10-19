package com.integralads.avid.library.inmobi.base;

import com.integralads.avid.library.inmobi.session.internal.jsbridge.AvidBridgeManager;

public abstract class AvidBaseListenerImpl
{
  private com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession avidAdSession;
  private AvidBridgeManager avidBridgeManager;
  
  public AvidBaseListenerImpl(com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession paramInternalAvidAdSession, AvidBridgeManager paramAvidBridgeManager)
  {
    avidAdSession = paramInternalAvidAdSession;
    avidBridgeManager = paramAvidBridgeManager;
  }
  
  public void destroy() {
    avidAdSession = null;
    avidBridgeManager = null;
  }
  
  public com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession getAvidAdSession() {
    return avidAdSession;
  }
  
  public AvidBridgeManager getAvidBridgeManager() {
    return avidBridgeManager;
  }
  
  public void assertSessionIsNotEnded() {
    if (avidAdSession == null) {
      throw new IllegalStateException("The AVID ad session is ended. Please ensure you are not recording events after the session has ended.");
    }
  }
}
