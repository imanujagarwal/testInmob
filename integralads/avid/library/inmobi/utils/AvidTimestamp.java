package com.integralads.avid.library.inmobi.utils;

public class AvidTimestamp {
  public AvidTimestamp() {}
  
  private static double NANOSEC_PER_MILLISEC = 1000000.0D;
  
  public static double getCurrentTime() {
    return System.nanoTime() / NANOSEC_PER_MILLISEC;
  }
}
