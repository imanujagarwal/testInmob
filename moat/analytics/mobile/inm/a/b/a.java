package com.moat.analytics.mobile.inm.a.b;

import java.util.NoSuchElementException;

public final class a<T>
{
  private static final a<?> a = new a();
  private final T b;
  
  private a()
  {
    b = null;
  }
  
  public static <T> a<T> a()
  {
    return a;
  }
  
  private a(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("Optional of null value.");
    }
    b = paramT;
  }
  
  public static <T> a<T> a(T paramT)
  {
    return new a(paramT);
  }
  
  public static <T> a<T> b(T paramT)
  {
    if (paramT == null) {
      return a();
    }
    return a(paramT);
  }
  
  public final T b()
  {
    if (b == null) {
      throw new NoSuchElementException("No value present");
    }
    return b;
  }
  
  public final boolean c()
  {
    return b != null;
  }
  
  public final T c(T paramT)
  {
    if (b != null) {
      return b;
    }
    return paramT;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return (b == b) || ((b != null) && (b != null) && (b.equals(b)));
  }
  
  public final int hashCode()
  {
    if (b == null) {
      return 0;
    }
    return b.hashCode();
  }
  
  public final String toString()
  {
    if (b != null) {
      return String.format("Optional[%s]", new Object[] { b });
    }
    return "Optional.empty";
  }
}
