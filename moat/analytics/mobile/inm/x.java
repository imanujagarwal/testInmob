package com.moat.analytics.mobile.inm;

import android.support.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class x<T>
  implements InvocationHandler
{
  private static final Object[] a = new Object[0];
  private final a<T> b;
  private final Class<T> c;
  private final LinkedList<x<T>.b> d;
  private boolean e;
  private T f;
  
  @VisibleForTesting
  x(a<T> paramA, Class<T> paramClass)
  {
    com.moat.analytics.mobile.inm.a.a.a.a(paramA);
    com.moat.analytics.mobile.inm.a.a.a.a(paramClass);
    b = paramA;
    c = paramClass;
    d = new LinkedList();
    w.a().a(new w.b()
    {
      public void c()
      {
        x.a(x.this);
      }
      
      public void d() {}
    });
  }
  
  static <T> T a(a<T> paramA, Class<T> paramClass)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramA = new x(paramA, paramClass);
    return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, paramA);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      return a(paramMethod, paramArrayOfObject);
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return a(paramMethod);
  }
  
  private Object a(Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject = paramMethod.getDeclaringClass();
    w localW = w.a();
    if (Object.class.equals(localObject))
    {
      localObject = paramMethod.getName();
      if ("getClass".equals(localObject)) {
        return c;
      }
      if ("toString".equals(localObject))
      {
        paramMethod = paramMethod.invoke(this, paramArrayOfObject);
        paramArrayOfObject = x.class.getName();
        localObject = c.getName();
        return String.valueOf(paramMethod).replace(paramArrayOfObject, (CharSequence)localObject);
      }
      return paramMethod.invoke(this, paramArrayOfObject);
    }
    if ((e) && (f == null))
    {
      d.clear();
      return a(paramMethod);
    }
    if (a == w.d.b)
    {
      c();
      if (f != null) {
        return paramMethod.invoke(f, paramArrayOfObject);
      }
    }
    if ((a == w.d.a) && ((!e) || (f != null))) {
      b(paramMethod, paramArrayOfObject);
    }
    return a(paramMethod);
  }
  
  private void b()
  {
    if (!e)
    {
      try
      {
        com.moat.analytics.mobile.inm.a.b.a localA = b.a();
        f = localA.c(null);
      }
      catch (Exception localException)
      {
        p.a("OnOffTrackerProxy", this, "Could not create instance", localException);
        m.a(localException);
      }
      e = true;
    }
  }
  
  private void c()
  {
    b();
    if (f == null) {
      return;
    }
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      b localB = (b)localIterator.next();
      try
      {
        Object[] arrayOfObject = new Object[b.a(localB).length];
        int i = 0;
        for (WeakReference localWeakReference : b.a(localB)) {
          arrayOfObject[(i++)] = localWeakReference.get();
        }
        b.b(localB).invoke(f, arrayOfObject);
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
    d.clear();
  }
  
  private void b(Method paramMethod, Object[] paramArrayOfObject)
  {
    if (d.size() >= 15) {
      d.remove(5);
    }
    d.add(new b(paramMethod, paramArrayOfObject, null));
  }
  
  private Object a(Method paramMethod)
  {
    try
    {
      if (Boolean.TYPE.equals(paramMethod.getReturnType())) {
        return Boolean.valueOf(true);
      }
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return null;
  }
  
  private class b
  {
    private final WeakReference[] b;
    private final LinkedList<Object> c = new LinkedList();
    private final Method d;
    
    private b(Method paramMethod, Object... paramVarArgs)
    {
      if (paramVarArgs == null) {
        paramVarArgs = x.a();
      }
      this$1 = new WeakReference[paramVarArgs.length];
      int i = 0;
      int j = (paramVarArgs = paramVarArgs).length;
      for (int k = 0; k < j; k++)
      {
        Object localObject;
        if ((((localObject = paramVarArgs[k]) instanceof Map)) || ((localObject instanceof Integer)) || ((localObject instanceof Double))) {
          c.add(localObject);
        }
        x.this[(i++)] = new WeakReference(localObject);
      }
      b = x.this;
      d = paramMethod;
    }
  }
  
  static abstract interface a<T>
  {
    public abstract com.moat.analytics.mobile.inm.a.b.a<T> a();
  }
}
