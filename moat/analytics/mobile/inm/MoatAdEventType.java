package com.moat.analytics.mobile.inm;

public enum MoatAdEventType
{
  private final String a;
  
  private MoatAdEventType(String paramString)
  {
    a = paramString;
  }
  
  public final String toString()
  {
    return a;
  }
  
  public static MoatAdEventType fromString(String paramString)
  {
    if (paramString != null) {
      for (MoatAdEventType localMoatAdEventType : values()) {
        if (paramString.equalsIgnoreCase(localMoatAdEventType.toString())) {
          return localMoatAdEventType;
        }
      }
    }
    return null;
  }
}
