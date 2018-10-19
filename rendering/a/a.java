package com.inmobi.rendering.a;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  int a;
  public String b;
  public Map<String, String> c;
  long d;
  long e;
  int f;
  AtomicBoolean g;
  boolean h;
  boolean i;
  
  a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(new Random().nextInt() & 0x7FFFFFFF, paramString, new java.util.HashMap(), paramBoolean1, paramBoolean2, paramInt, System.currentTimeMillis(), 
      System.currentTimeMillis());
  }
  
  a(String paramString, Map<String, String> paramMap, boolean paramBoolean, int paramInt)
  {
    this(new Random().nextInt() & 0x7FFFFFFF, paramString, paramMap, paramBoolean, false, paramInt, System.currentTimeMillis(), 
      System.currentTimeMillis());
  }
  
  a(int paramInt1, String paramString, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, long paramLong1, long paramLong2)
  {
    a = paramInt1;
    b = paramString;
    c = paramMap;
    d = paramLong1;
    e = paramLong2;
    f = paramInt2;
    g = new AtomicBoolean(false);
    i = paramBoolean1;
    h = paramBoolean2;
  }
  






  public final boolean a(long paramLong)
  {
    return System.currentTimeMillis() - e > paramLong * 1000L;
  }
}
