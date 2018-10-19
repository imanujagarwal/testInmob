package com.integralads.avid.library.inmobi.weakreference;

import java.lang.ref.WeakReference;

public class ObjectWrapper<T>
{
  private WeakReference<T> weakReference;
  
  public ObjectWrapper(T paramT) {
    weakReference = new WeakReference(paramT);
  }
  
  public T get() {
    return weakReference.get();
  }
  
  public void set(T paramT) {
    weakReference = new WeakReference(paramT);
  }
  
  public boolean isEmpty() {
    return get() == null;
  }
  
  public boolean contains(Object paramObject) {
    Object localObject;
    return ((localObject = get()) != null) && (paramObject != null) && (localObject.equals(paramObject));
  }
}
