package com.inmobi.commons.core.network;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;



public class d
{
  private static final String e = d.class.getSimpleName();
  private String f;
  public byte[] a;
  
  public d() {}
  
  public final boolean a()
  {
    return b != null;
  }
  
  public final String b() {
    if (f == null) f = a(a);
    return f;
  }
  
  public static String a(byte[] paramArrayOfByte) {
    if ((paramArrayOfByte == null) || (0 == paramArrayOfByte.length)) {
      return "";
    }
    try {
      return new String(paramArrayOfByte, "UTF-8");
    } catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return "";
  }
  










  public final void b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (0 == paramArrayOfByte.length)) {
      a = new byte[0];
      return;
    }
    a = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, a, 0, paramArrayOfByte.length);
  }
  



  public NetworkError b;
  


  public int c;
  


  public Map<String, List<String>> d;
  


  public final long c()
  {
    long l = 0L;
    try
    {
      if (f != null) {
        l = 0L + f.length();
      }
    }
    catch (Exception localException)
    {
      new StringBuilder("SDK encountered unexpected error in computing response size; ").append(localException.getMessage());
    }
    return l;
  }
}
