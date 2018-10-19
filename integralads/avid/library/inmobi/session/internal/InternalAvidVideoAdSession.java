package com.integralads.avid.library.inmobi.session.internal;

import android.content.Context;
import com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext;

public class InternalAvidVideoAdSession extends InternalAvidHtmlAdSession
{
  public InternalAvidVideoAdSession(Context paramContext, String paramString, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext)
  {
    super(paramContext, paramString, paramExternalAvidAdSessionContext);
  }
  
  public SessionType getSessionType()
  {
    return SessionType.VIDEO;
  }
  
  public MediaType getMediaType()
  {
    return MediaType.VIDEO;
  }
}
