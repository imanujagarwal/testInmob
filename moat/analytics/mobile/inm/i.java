package com.moat.analytics.mobile.inm;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class i
{
  private static final i a = new i();
  private final Map<j, String> b = new WeakHashMap();
  private final Map<b, String> c = new WeakHashMap();
  private final ScheduledExecutorService d = Executors.newScheduledThreadPool(1);
  private ScheduledFuture<?> e;
  private ScheduledFuture<?> f;
  
  static i a()
  {
    return a;
  }
  
  private i() {}
  
  void a(Context paramContext, j paramJ)
  {
    if ((b != null) && (paramJ != null))
    {
      b.put(paramJ, "");
      a(paramContext);
    }
  }
  
  void a(j paramJ)
  {
    if (paramJ != null)
    {
      p.a(3, "JSUpdateLooper", this, "removeSetupNeededBridge" + paramJ.hashCode());
      if (b != null) {
        b.remove(paramJ);
      }
    }
  }
  
  void a(Context paramContext, b paramB)
  {
    if (paramB != null)
    {
      p.a(3, "JSUpdateLooper", this, "addActiveTracker" + paramB.hashCode());
      if ((c != null) && (!c.containsKey(paramB)))
      {
        c.put(paramB, "");
        b(paramContext);
      }
    }
  }
  
  void a(b paramB)
  {
    if (paramB != null)
    {
      p.a(3, "JSUpdateLooper", this, "removeActiveTracker" + paramB.hashCode());
      if (c != null) {
        c.remove(paramB);
      }
    }
  }
  
  private void a(final Context paramContext)
  {
    if ((f == null) || (f.isDone()))
    {
      p.a(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
      paramContext = new Runnable()
      {
        public void run()
        {
          try
          {
            Intent localIntent = new Intent("UPDATE_METADATA");
            LocalBroadcastManager.getInstance(paramContext.getApplicationContext()).sendBroadcast(localIntent);
            if (i.a(i.this).isEmpty()) {
              i.b(i.this).cancel(true);
            }
            return;
          }
          catch (Exception localException)
          {
            m.a(localException;
          }
        }
      };
      f = d.scheduleWithFixedDelay(paramContext, 0L, 50L, TimeUnit.MILLISECONDS);
    }
  }
  
  private void b(final Context paramContext)
  {
    if ((e == null) || (e.isDone()))
    {
      p.a(3, "JSUpdateLooper", this, "Starting view update loop");
      paramContext = new Runnable()
      {
        public void run()
        {
          try
          {
            Intent localIntent = new Intent("UPDATE_VIEW_INFO");
            LocalBroadcastManager.getInstance(paramContext.getApplicationContext()).sendBroadcast(localIntent);
            if (i.c(i.this).isEmpty())
            {
              p.a(3, "JSUpdateLooper", i.this, "No more active trackers");
              i.d(i.this).cancel(true);
            }
            return;
          }
          catch (Exception localException)
          {
            m.a(localException;
          }
        }
      };
      e = d.scheduleWithFixedDelay(paramContext, 0L, ad, TimeUnit.MILLISECONDS);
    }
  }
}
