package com.moat.analytics.mobile.inm;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

class y
  extends c
  implements ReactiveVideoTracker
{
  private Integer l;
  
  public y(String paramString)
  {
    super(paramString);
    p.a(3, "ReactiveVideoTracker", this, "Initializing.");
    p.a("[SUCCESS] ", a() + " created");
  }
  
  String a()
  {
    return "ReactiveVideoTracker";
  }
  
  Map<String, Object> i()
  {
    HashMap localHashMap = new HashMap();
    View localView = (View)k.get();
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    if (localView != null)
    {
      localInteger1 = Integer.valueOf(localView.getWidth());
      localInteger2 = Integer.valueOf(localView.getHeight());
    }
    localHashMap.put("duration", l);
    localHashMap.put("width", localInteger1);
    localHashMap.put("height", localInteger2);
    return localHashMap;
  }
  
  public boolean trackVideoAd(Map<String, String> paramMap, Integer paramInteger, View paramView)
  {
    try
    {
      c();
      d();
      l = paramInteger;
      return super.a(paramMap, paramView);
    }
    catch (Exception paramMap)
    {
      a("trackVideoAd", paramMap);
    }
    return false;
  }
  
  JSONObject a(MoatAdEvent paramMoatAdEvent)
  {
    if ((d == MoatAdEventType.AD_EVT_COMPLETE) && (!b.equals(MoatAdEvent.a)) && (!a(b, l))) {
      d = MoatAdEventType.AD_EVT_STOPPED;
    }
    return super.a(paramMoatAdEvent);
  }
  
  void a(List<String> paramList)
  {
    if (l.intValue() < 1000) {
      throw new m(String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[] { l }));
    }
    super.a(paramList);
  }
}
