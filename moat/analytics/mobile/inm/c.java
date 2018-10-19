package com.moat.analytics.mobile.inm;

import android.os.Handler;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

abstract class c
  extends b
{
  static final MoatAdEventType[] g = { MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE };
  final Map<MoatAdEventType, Integer> h;
  private final Set<MoatAdEventType> l;
  private VideoTrackerListener m;
  private boolean n;
  private Double o;
  final Handler i;
  Map<String, String> j;
  WeakReference<View> k;
  private final g p;
  private final String q;
  
  c(String paramString)
  {
    super(null, false, true);
    p.a(3, "BaseVideoTracker", this, "Initializing.");
    q = paramString;
    p = new g(a.a(), g.a.b);
    super.a(p.b);
    try
    {
      super.a(p.a);
    }
    catch (m paramString)
    {
      a = paramString;
    }
    h = new HashMap();
    l = new HashSet();
    i = new Handler();
    n = false;
    o = Double.valueOf(1.0D);
  }
  
  public void setVideoListener(VideoTrackerListener paramVideoTrackerListener)
  {
    m = paramVideoTrackerListener;
  }
  
  public void removeVideoListener()
  {
    m = null;
  }
  
  @CallSuper
  public boolean a(Map<String, String> paramMap, View paramView)
  {
    try
    {
      c();
      d();
      if (paramView == null) {
        p.a(3, "BaseVideoTracker", this, "trackVideoAd received null video view instance");
      }
      j = paramMap;
      k = new WeakReference(paramView);
      b();
      paramMap = String.format("trackVideoAd tracking ids: %s | view: %s", new Object[] { new JSONObject(paramMap).toString(), p.a(paramView) });
      p.a(3, "BaseVideoTracker", this, paramMap);
      p.a("[SUCCESS] ", a() + " " + paramMap);
      if (d != null) {
        d.onTrackingStarted(g());
      }
      return true;
    }
    catch (Exception paramMap)
    {
      a("trackVideoAd", paramMap);
    }
    return false;
  }
  
  public void setPlayerVolume(Double paramDouble)
  {
    Double localDouble = j();
    if (!paramDouble.equals(o))
    {
      p.a(3, "BaseVideoTracker", this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[] { paramDouble }));
      o = paramDouble;
      if (!localDouble.equals(j())) {
        dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.a, o));
      }
    }
  }
  
  public void changeTargetView(View paramView)
  {
    p.a(3, "BaseVideoTracker", this, "changing view to " + p.a(paramView));
    k = new WeakReference(paramView);
    try
    {
      super.changeTargetView(paramView);
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  void a(List<String> paramList)
  {
    if (j == null) {
      paramList.add("Null adIds object");
    }
    if (!paramList.isEmpty())
    {
      paramList = TextUtils.join(" and ", paramList);
      throw new m(paramList);
    }
    super.a(paramList);
  }
  
  public void stopTracking()
  {
    try
    {
      super.stopTracking();
      l();
      if (m != null) {
        m = null;
      }
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  public void dispatchEvent(MoatAdEvent paramMoatAdEvent)
  {
    try
    {
      b(paramMoatAdEvent);
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  abstract Map<String, Object> i();
  
  Double j()
  {
    return Double.valueOf(k().doubleValue() * s.a());
  }
  
  Double k()
  {
    return o;
  }
  
  void b()
  {
    super.changeTargetView((View)k.get());
    super.b();
    Integer localInteger1 = (Integer)(localObject = i()).get("width");
    Integer localInteger2 = (Integer)((Map)localObject).get("height");
    Object localObject = (Integer)((Map)localObject).get("duration");
    p.a(3, "BaseVideoTracker", this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[] { localInteger2, localInteger1, localObject }));
    p.a(q, j, localInteger1, localInteger2, (Integer)localObject);
  }
  
  JSONObject a(MoatAdEvent paramMoatAdEvent)
  {
    if (Double.isNaN(c.doubleValue())) {
      c = o;
    }
    return new JSONObject(paramMoatAdEvent.a());
  }
  
  private void b(MoatAdEvent paramMoatAdEvent)
  {
    JSONObject localJSONObject = a(paramMoatAdEvent);
    p.a(3, "BaseVideoTracker", this, String.format("Received event: %s", new Object[] { localJSONObject.toString() }));
    p.a("[SUCCESS] ", a() + String.format(" Received event: %s", new Object[] { localJSONObject.toString() }));
    if ((e()) && (c != null))
    {
      c.a(p.c, localJSONObject);
      if (!l.contains(d))
      {
        l.add(d);
        if (m != null) {
          m.onVideoEventReported(d);
        }
      }
    }
    if (a(paramMoatAdEvent = d))
    {
      h.put(paramMoatAdEvent, Integer.valueOf(1));
      if (c != null) {
        c.c(this);
      }
      l();
    }
  }
  
  void l()
  {
    if (!n)
    {
      n = true;
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          try
          {
            p.a(3, "BaseVideoTracker", this, "Shutting down.");
            c.a(c.this).a();
            c.a(c.this, null);
            return;
          }
          catch (Exception localException)
          {
            m.a(localException;
          }
        }
      };
      i.postDelayed(local1, 500L);
    }
  }
  
  private static boolean a(MoatAdEventType paramMoatAdEventType)
  {
    return (paramMoatAdEventType == MoatAdEventType.AD_EVT_COMPLETE) || (paramMoatAdEventType == MoatAdEventType.AD_EVT_STOPPED) || (paramMoatAdEventType == MoatAdEventType.AD_EVT_SKIPPED);
  }
  
  boolean m()
  {
    return (h.containsKey(MoatAdEventType.AD_EVT_COMPLETE)) || (h.containsKey(MoatAdEventType.AD_EVT_STOPPED)) || (h.containsKey(MoatAdEventType.AD_EVT_SKIPPED));
  }
  
  boolean a(Integer paramInteger1, Integer paramInteger2)
  {
    paramInteger1 = Math.abs(paramInteger2.intValue() - paramInteger1.intValue());
    double d = Math.min(750.0D, paramInteger2.intValue() * 0.05D);
    return paramInteger1 <= d;
  }
}
