package com.integralads.avid.library.inmobi.session.internal;



public enum MediaType
{
  DISPLAY("display"), 
  VIDEO("video");
  
  private final String value;
  
  private MediaType(String paramString)
  {
    value = paramString;
  }
  
  public final String toString()
  {
    return value;
  }
}
