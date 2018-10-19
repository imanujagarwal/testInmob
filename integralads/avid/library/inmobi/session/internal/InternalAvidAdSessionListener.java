package com.integralads.avid.library.inmobi.session.internal;

public abstract interface InternalAvidAdSessionListener
{
  public abstract void sessionDidEnd(InternalAvidAdSession paramInternalAvidAdSession);
  
  public abstract void sessionHasBecomeActive(InternalAvidAdSession paramInternalAvidAdSession);
  
  public abstract void sessionHasResignedActive(InternalAvidAdSession paramInternalAvidAdSession);
}
