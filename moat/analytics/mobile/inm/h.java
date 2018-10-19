package com.moat.analytics.mobile.inm;

import android.os.Handler;
import android.support.annotation.CallSuper;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

abstract class h
  extends c
{
  private a m = a.a;
  private int n = Integer.MIN_VALUE;
  private double o = NaN.0D;
  private int p = Integer.MIN_VALUE;
  int l = Integer.MIN_VALUE;
  private int q = 0;
  
  h(String paramString)
  {
    super(paramString);
  }
  
  abstract boolean n();
  
  public boolean a(Map<String, String> paramMap, View paramView)
  {
    try
    {
      if (((paramMap = super.a(paramMap, paramView))) && (p())) {
        t();
      }
    }
    catch (Exception paramMap)
    {
      p.a(3, "IntervalVideoTracker", this, "Problem with video loop");
      a("trackVideoAd", paramMap);
      paramMap = 0;
    }
    return paramMap;
  }
  
  public void stopTracking()
  {
    try
    {
      dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
      super.stopTracking();
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  public void setPlayerVolume(Double paramDouble)
  {
    super.setPlayerVolume(paramDouble);
    o = j().doubleValue();
  }
  
  JSONObject a(MoatAdEvent paramMoatAdEvent)
  {
    Integer localInteger;
    if (!b.equals(MoatAdEvent.a))
    {
      localInteger = b;
    }
    else
    {
      try
      {
        localInteger = o();
      }
      catch (Exception localException)
      {
        localInteger = Integer.valueOf(n);
      }
      b = localInteger;
    }
    if ((b.intValue() < 0) || ((b.intValue() == 0) && (d == MoatAdEventType.AD_EVT_COMPLETE) && (n > 0)))
    {
      localInteger = Integer.valueOf(n);
      b = localInteger;
    }
    if (d == MoatAdEventType.AD_EVT_COMPLETE) {
      if ((localInteger.intValue() == Integer.MIN_VALUE) || (l == Integer.MIN_VALUE) || (!a(localInteger, Integer.valueOf(l))))
      {
        m = a.d;
        d = MoatAdEventType.AD_EVT_STOPPED;
      }
      else
      {
        m = a.e;
      }
    }
    return super.a(paramMoatAdEvent);
  }
  
  abstract Integer o();
  
  protected boolean p()
  {
    return true;
  }
  
  abstract boolean q();
  
  abstract Integer r();
  
  private void t()
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        try
        {
          if ((n()) && (!m()))
          {
            if (Boolean.valueOf(s()).booleanValue())
            {
              i.postDelayed(this, 200L);
              return;
            }
            l();
            return;
          }
          l();
          return;
        }
        catch (Exception localException)
        {
          l();
          m.a(localException);
        }
      }
    };
    i.postDelayed(local1, 200L);
  }
  
  @CallSuper
  boolean s()
  {
    if ((!n()) || (m())) {
      return false;
    }
    try
    {
      int i = o().intValue();
      if ((n >= 0) && (i < 0)) {
        return false;
      }
      n = i;
      if (i == 0) {
        return true;
      }
      int j = r().intValue();
      boolean bool = q();
      double d1 = j / 4.0D;
      double d2 = j().doubleValue();
      MoatAdEventType localMoatAdEventType2 = null;
      if (i > p) {
        p = i;
      }
      if (l == Integer.MIN_VALUE) {
        l = j;
      }
      if (bool)
      {
        if (m == a.a)
        {
          localMoatAdEventType2 = MoatAdEventType.AD_EVT_START;
          m = a.c;
        }
        else if (m == a.b)
        {
          localMoatAdEventType2 = MoatAdEventType.AD_EVT_PLAYING;
          m = a.c;
        }
        else if (((j = (int)Math.floor(i / d1) - 1) >= 0) && (j < 3))
        {
          MoatAdEventType localMoatAdEventType1 = g[j];
          if (!h.containsKey(localMoatAdEventType1))
          {
            localMoatAdEventType2 = localMoatAdEventType1;
            h.put(localMoatAdEventType1, Integer.valueOf(1));
          }
        }
      }
      else if (m != a.b)
      {
        localMoatAdEventType2 = MoatAdEventType.AD_EVT_PAUSED;
        m = a.b;
      }
      int k;
      if (((k = localMoatAdEventType2 != null ? 1 : 0) == 0) && (!Double.isNaN(o)) && (Math.abs(o - d2) > 0.05D))
      {
        localMoatAdEventType2 = MoatAdEventType.AD_EVT_VOLUME_CHANGE;
        k = 1;
      }
      if (k != 0) {
        dispatchEvent(new MoatAdEvent(localMoatAdEventType2, Integer.valueOf(i), k()));
      }
      o = d2;
      q = 0;
      return true;
    }
    catch (Exception localException)
    {
      if (q++ < 5) {
        return true;
      }
    }
    return false;
  }
  
  static enum a
  {
    private a() {}
  }
}
