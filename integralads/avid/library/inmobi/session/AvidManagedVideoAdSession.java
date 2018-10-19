package com.integralads.avid.library.inmobi.session;

import com.integralads.avid.library.inmobi.session.internal.InternalAvidManagedVideoAdSession;

public class AvidManagedVideoAdSession extends AbstractAvidManagedAdSession
{
  public AvidManagedVideoAdSession() {}
  
  public com.integralads.avid.library.inmobi.video.AvidVideoPlaybackListener getAvidVideoPlaybackListener() {
    InternalAvidManagedVideoAdSession localInternalAvidManagedVideoAdSession;
    if ((localInternalAvidManagedVideoAdSession = (InternalAvidManagedVideoAdSession)com.integralads.avid.library.inmobi.AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId())) != null) return localInternalAvidManagedVideoAdSession.getAvidVideoPlaybackListener(); return null;
  }
}
