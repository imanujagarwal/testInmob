package com.integralads.avid.library.inmobi.session.internal;

import android.content.Context;
import com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.inmobi.video.AvidVideoPlaybackListenerImpl;

public class InternalAvidManagedVideoAdSession extends InternalAvidManagedAdSession
{
  private AvidVideoPlaybackListenerImpl avidVideoPlaybackListener;
  
  public InternalAvidManagedVideoAdSession(Context paramContext, String paramString, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext)
  {
    super(paramContext, paramString, paramExternalAvidAdSessionContext);
    avidVideoPlaybackListener = new AvidVideoPlaybackListenerImpl(this, getAvidBridgeManager());
  }
  
  public AvidVideoPlaybackListenerImpl getAvidVideoPlaybackListener() {
    return avidVideoPlaybackListener;
  }
  
  public SessionType getSessionType()
  {
    return SessionType.MANAGED_VIDEO;
  }
  
  public MediaType getMediaType()
  {
    return MediaType.VIDEO;
  }
  
  public void onEnd()
  {
    avidVideoPlaybackListener.destroy();
    super.onEnd();
  }
}
