package com.integralads.avid.library.inmobi.deferred;

import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.inmobi.session.internal.jsbridge.AvidBridgeManager;

public class AvidDeferredAdSessionListenerImpl extends com.integralads.avid.library.inmobi.base.AvidBaseListenerImpl implements AvidDeferredAdSessionListener
{
  public AvidDeferredAdSessionListenerImpl(InternalAvidAdSession paramInternalAvidAdSession, AvidBridgeManager paramAvidBridgeManager)
  {
    super(paramInternalAvidAdSession, paramAvidBridgeManager);
  }
  
  public void recordReadyEvent()
  {
    assertSessionIsNotEnded();
    if (getAvidAdSession().isReady()) {
      throw new IllegalStateException("The AVID ad session is already ready. Please ensure you are only calling recordReadyEvent once for the deferred AVID ad session.");
    }
    

    getAvidBridgeManager().publishReadyEventForDeferredAdSession();
    getAvidAdSession().onReady();
  }
}
