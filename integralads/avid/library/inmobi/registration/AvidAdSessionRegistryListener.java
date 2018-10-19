package com.integralads.avid.library.inmobi.registration;

public abstract interface AvidAdSessionRegistryListener
{
  public abstract void registryHasSessionsChanged(AvidAdSessionRegistry paramAvidAdSessionRegistry);
  
  public abstract void registryHasActiveSessionsChanged(AvidAdSessionRegistry paramAvidAdSessionRegistry);
}
