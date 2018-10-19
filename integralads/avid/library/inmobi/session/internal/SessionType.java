package com.integralads.avid.library.inmobi.session.internal;



public enum SessionType
{
  DISPLAY("display"), 
  VIDEO("video"), 
  MANAGED_DISPLAY("managedDisplay"), 
  MANAGED_VIDEO("managedVideo");
  
  private final String value;
  
  private SessionType(String paramString)
  {
    value = paramString;
  }
  
  public final String toString()
  {
    return value;
  }
}
