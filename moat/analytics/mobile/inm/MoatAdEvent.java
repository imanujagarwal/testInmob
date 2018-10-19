package com.moat.analytics.mobile.inm;

import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent
{
  static final Integer a = Integer.valueOf(Integer.MIN_VALUE);
  private static final Double e = Double.valueOf(NaN.0D);
  public static final Double VOLUME_MUTED = Double.valueOf(0.0D);
  public static final Double VOLUME_UNMUTED = Double.valueOf(1.0D);
  Integer b;
  Double c;
  private final Double f;
  private final Long g = Long.valueOf(System.currentTimeMillis());
  MoatAdEventType d;
  
  public MoatAdEvent(MoatAdEventType paramMoatAdEventType, Integer paramInteger, Double paramDouble)
  {
    d = paramMoatAdEventType;
    c = paramDouble;
    b = paramInteger;
    f = Double.valueOf(s.a());
  }
  
  public MoatAdEvent(MoatAdEventType paramMoatAdEventType, Integer paramInteger)
  {
    this(paramMoatAdEventType, paramInteger, e);
  }
  
  public MoatAdEvent(MoatAdEventType paramMoatAdEventType)
  {
    this(paramMoatAdEventType, a, e);
  }
  
  Map<String, Object> a()
  {
    HashMap localHashMap;
    (localHashMap = new HashMap()).put("adVolume", c);
    localHashMap.put("playhead", b);
    localHashMap.put("aTimeStamp", g);
    localHashMap.put("type", d.toString());
    localHashMap.put("deviceVolume", f);
    return localHashMap;
  }
}
