package com.integralads.avid.library.inmobi.session.internal;

import android.content.Context;
import com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext;



public class InternalAvidDisplayAdSession
  extends InternalAvidHtmlAdSession
{
  public InternalAvidDisplayAdSession(Context paramContext, String paramString, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext)
  {
    super(paramContext, paramString, paramExternalAvidAdSessionContext);
  }
  
  public SessionType getSessionType()
  {
    return SessionType.DISPLAY;
  }
  
  public MediaType getMediaType()
  {
    return MediaType.DISPLAY;
  }
}
