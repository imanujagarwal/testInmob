package com.integralads.avid.library.inmobi.session;

import android.app.Activity;
import android.view.View;
import com.integralads.avid.library.inmobi.AvidManager;
import com.integralads.avid.library.inmobi.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.inmobi.session.internal.ObstructionsWhiteList;
import java.util.UUID;

public abstract class AbstractAvidAdSession<T extends View>
{
  private String avidAdSessionId;
  
  public AbstractAvidAdSession()
  {
    avidAdSessionId = UUID.randomUUID().toString();
  }
  
  public String getAvidAdSessionId() {
    return avidAdSessionId;
  }
  
  public void registerAdView(T paramT, Activity paramActivity) {
    InternalAvidAdSession localInternalAvidAdSession;
    if ((localInternalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(avidAdSessionId)) != null) {
      localInternalAvidAdSession.registerAdView(paramT);
    }
    AvidManager.getInstance().registerActivity(paramActivity);
  }
  
  public void unregisterAdView(T paramT) {
    InternalAvidAdSession localInternalAvidAdSession;
    if ((localInternalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(avidAdSessionId)) != null) {
      localInternalAvidAdSession.unregisterAdView(paramT);
    }
  }
  
  public void endSession() {
    InternalAvidAdSession localInternalAvidAdSession;
    if ((localInternalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId())) != null) {
      localInternalAvidAdSession.onEnd();
    }
  }
  
  public AvidDeferredAdSessionListener getAvidDeferredAdSessionListener()
  {
    InternalAvidAdSession localInternalAvidAdSession;
    if ((localInternalAvidAdSession = (localInternalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId())) != null ? localInternalAvidAdSession.getAvidDeferredAdSessionListener() : null) == null) {
      throw new IllegalStateException("The AVID ad session is not deferred. Please ensure you are only using AvidDeferredAdSessionListener for deferred AVID ad session.");
    }
    

    return localInternalAvidAdSession;
  }
  
  public void registerFriendlyObstruction(View paramView) {
    InternalAvidAdSession localInternalAvidAdSession;
    if ((localInternalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId())) != null) {
      localInternalAvidAdSession.getObstructionsWhiteList().add(paramView);
    }
  }
}
