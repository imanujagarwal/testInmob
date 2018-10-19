package com.moat.analytics.mobile.inm;

import android.os.Handler;
import android.os.Looper;
import com.moat.analytics.mobile.inm.a.b.a;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class w
{
  private long f = 1800000L;
  private long g = 60000L;
  private static w h;
  private static final Queue<c> i = new ConcurrentLinkedQueue();
  private Handler j;
  volatile d a = d.a;
  volatile boolean b = false;
  volatile boolean c = false;
  volatile int d = 200;
  volatile int e = 10;
  private final AtomicBoolean k = new AtomicBoolean(false);
  private volatile long l = 0L;
  private final AtomicInteger m = new AtomicInteger(0);
  private final AtomicBoolean n = new AtomicBoolean(false);
  
  static synchronized w a()
  {
    if (h == null) {
      h = new w();
    }
    return h;
  }
  
  private w()
  {
    try
    {
      j = new Handler(Looper.getMainLooper());
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  void b()
  {
    if (System.currentTimeMillis() - l > f) {
      a(0L);
    }
  }
  
  private void a(final long paramLong)
  {
    if (!n.compareAndSet(false, true)) {
      return;
    }
    p.a(3, "OnOff", this, "Performing status check.");
    new Thread()
    {
      public void run()
      {
        Looper.prepare();
        Handler localHandler = new Handler();
        w.a localA = new w.a(w.this, "INM", localHandler, new w.e()
        {
          public void a(l paramAnonymous2L)
          {
            synchronized ()
            {
              boolean bool = getInstancea;
              if ((a != paramAnonymous2L.e()) || ((a == w.d.a) && (bool)))
              {
                a = paramAnonymous2L.e();
                if ((a == w.d.a) && (bool)) {
                  a = w.d.b;
                }
                if (a == w.d.b) {
                  p.a(3, "OnOff", this, "Moat enabled - Version 2.5.0");
                }
                paramAnonymous2L = w.c().iterator();
                while (paramAnonymous2L.hasNext())
                {
                  w.c localC = (w.c)paramAnonymous2L.next();
                  if (a == w.d.b) {
                    b.c();
                  } else {
                    b.d();
                  }
                }
              }
              while (!w.c().isEmpty()) {
                w.c().remove();
              }
              return;
            }
          }
        }, null);
        localHandler.postDelayed(localA, paramLong);
        Looper.loop();
      }
    }.start();
  }
  
  void a(b paramB)
  {
    if (a == d.b)
    {
      paramB.c();
      return;
    }
    d();
    i.add(new c(Long.valueOf(System.currentTimeMillis()), paramB));
    e();
  }
  
  private void d()
  {
    synchronized (i)
    {
      long l1 = System.currentTimeMillis();
      Iterator localIterator = i.iterator();
      while (localIterator.hasNext())
      {
        c localC = (c)localIterator.next();
        if (l1 - a.longValue() >= 60000L) {
          localIterator.remove();
        }
      }
      if (i.size() >= 15) {
        for (int i1 = 0; i1 < 5; i1++) {
          i.remove();
        }
      }
      return;
    }
  }
  
  private void e()
  {
    if (!k.compareAndSet(false, true)) {
      return;
    }
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        try
        {
          if (w.c().size() > 0)
          {
            w.a(w.this);
            w.b(w.this).postDelayed(this, 60000L);
            return;
          }
          w.c(w.this).compareAndSet(true, false);
          w.b(w.this).removeCallbacks(this);
          return;
        }
        catch (Exception localException)
        {
          m.a(localException;
        }
      }
    };
    j.postDelayed(local2, 60000L);
  }
  
  static abstract interface b
  {
    public abstract void c();
    
    public abstract void d();
  }
  
  static abstract interface e
  {
    public abstract void a(l paramL);
  }
  
  private class c
  {
    final Long a;
    final w.b b;
    
    c(Long paramLong, w.b paramB)
    {
      a = paramLong;
      b = paramB;
    }
  }
  
  private class a
    implements Runnable
  {
    private final Handler b;
    private final String c;
    private final w.e d;
    
    private a(String paramString, Handler paramHandler, w.e paramE)
    {
      d = paramE;
      b = paramHandler;
      c = ("https://z.moatads.com/" + paramString + "/android/" + "c334ae83accfebb8da23104450c896463c9cfab7".substring(0, 7) + "/status.json");
    }
    
    public void run()
    {
      try
      {
        a();
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
      b.removeCallbacks(this);
      Looper localLooper;
      if ((localLooper = Looper.myLooper()) != null) {
        localLooper.quit();
      }
    }
    
    private void a()
    {
      String str = b();
      final l localL = new l(str);
      b = localL.a();
      c = localL.b();
      d = localL.c();
      e = localL.d();
      Looper localLooper = Looper.getMainLooper();
      new Handler(localLooper).post(new Runnable()
      {
        public void run()
        {
          try
          {
            w.a.a(w.a.this).a(localL);
            return;
          }
          catch (Exception localException)
          {
            m.a(localException;
          }
        }
      });
      w.a(w.this, System.currentTimeMillis());
      w.d(w.this).compareAndSet(true, false);
      if (str == null)
      {
        if (w.e(w.this).incrementAndGet() < 10) {
          w.b(w.this, w.f(w.this));
        }
      }
      else {
        w.e(w.this).set(0);
      }
    }
    
    private String b()
    {
      Object localObject = q.a(c + "?ts=" + System.currentTimeMillis() + "&v=2.5.0");
      try
      {
        localObject = (String)((a)localObject).b();
      }
      catch (Exception localException)
      {
        localObject = null;
      }
      return localObject;
    }
  }
  
  static enum d
  {
    private d() {}
  }
}
