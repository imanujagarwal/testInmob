package com.moat.analytics.mobile.inm;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.content.LocalBroadcastManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class j
{
  private int a = 0;
  private boolean b = false;
  private boolean c = false;
  private final AtomicBoolean d = new AtomicBoolean(false);
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  @NonNull
  private final WeakReference<WebView> h;
  private final Map<b, String> i;
  private final LinkedList<String> j;
  private final long k;
  private final String l;
  private final List<String> m;
  private final a n;
  private final BroadcastReceiver o = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      try
      {
        j.e(j.this);
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
      if (System.currentTimeMillis() - j.f(j.this) > 30000L) {
        j.g(j.this);
      }
    }
  };
  private final BroadcastReceiver p = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      try
      {
        j.h(j.this);
        return;
      }
      catch (Exception localException)
      {
        m.a(localException;
      }
    }
  };
  
  j(WebView paramWebView, a paramA)
  {
    h = new WeakReference(paramWebView);
    n = paramA;
    j = new LinkedList();
    m = new ArrayList();
    i = new WeakHashMap();
    k = System.currentTimeMillis();
    paramWebView = h();
    l = String.format("javascript:(function(d,k){function l(){function d(a,b){var c=ipkn[b]||ipkn[kuea];if(c){var h=function(b){var c=b.b;c.ts=b.i;c.ticks=b.g;c.buffered=!0;a(c)};h(c.first);c.a.forEach(function(a){h(a)})}}function e(a){var b=a.a,c=a.c,h=a.b;a=a.f;var d=[];if(c)b[c]&&d.push(b[c].fn[0]);else for(key in b)if(b[key])for(var g=0,e=b[key].fn.length;g<e;g++)d.push(b[key].fn[g]);g=0;for(e=d.length;g<e;g++){var f=d[g];if('function'===typeof f)try{h?f(h):f()}catch(k){}a&&delete b[c]}}function f(a,b,c){'function'===typeof a&& (b===kuea&&c[b]?c[b].fn.push(a):c[b]={ts:+new Date,fn:[a]},c===yhgt&&d(a,b))}kuea=+new Date;iymv={};briz=!1;ewat=+new Date;bnkr=[];bjmk={};dptk={};uqaj={};ryup={};yhgt={};ipkn={};csif={};this.h=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash;this.aqzx=a.aqzx;this.appId=a.appId;this.metadata=a};this.nvsj=function(a){briz||(f(a,ewat,iymv),briz=!0)};this.bpsy=function(a,b){var c=b||kuea; c!==kuea&&bjmk[c]||f(a,c,bjmk)};this.qmrv=function(a,b){var c=b||kuea;c!==kuea&&uqaj[c]||f(a,c,uqaj)};this.lgpr=function(a,b){f(a,b||kuea,yhgt)};this.hgen=function(a,b){f(a,b||kuea,csif)};this.xrnk=function(a){delete yhgt[a||kuea]};this.vgft=function(a){return dptk[a||kuea]||!1};this.lkpu=function(a){return ryup[a||kuea]||!1};this.crts=function(a){var b={a:iymv,b:a,c:ewat};briz?e(b):bnkr.push(a)};this.mqjh=function(a){var b=a||kuea;dptk[b]=!0;var c={a:bjmk,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.egpw= function(a){var b=a||kuea;ryup[b]=!0;var c={a:uqaj,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.sglu=function(a){var b=a.adKey||kuea,c={a:yhgt,b:a.event||a,g:1,i:+new Date,f:!1};b!==kuea&&(c.c=a.adKey);a=0<Object.keys(yhgt).length;if(!a||!this.isNative)if(ipkn[b]){var d=ipkn[b].a.slice(-1)[0]||ipkn[b].first;JSON.stringify(c.b)==JSON.stringify(d.b)?d.g+=1:(5<=ipkn[b].a.length&&ipkn[b].a.shift(),ipkn[b].a.push(c))}else ipkn[b]={first:c,a:[]};a&&e(c);return a};this.ucbx=function(a){e({c:a.adKey||kuea,a:csif, b:a.event,f:!1})}}'undefined'===typeof d.MoatMAK&&(d.MoatMAK=new l,d.MoatMAK.h(k),d.__zMoatInit__=!0)})(window,%s);", new Object[] { paramWebView });
    if (d("Initialize"))
    {
      paramWebView = new IntentFilter("UPDATE_METADATA");
      paramA = new IntentFilter("UPDATE_VIEW_INFO");
      LocalBroadcastManager.getInstance(s.c()).registerReceiver(o, paramWebView);
      LocalBroadcastManager.getInstance(s.c()).registerReceiver(p, paramA);
      d();
      i.a().a(s.c(), this);
      p.a(3, "JavaScriptBridge", this, "bridge initialization succeeded");
    }
  }
  
  void a(b paramB)
  {
    if (paramB != null)
    {
      p.a(3, "JavaScriptBridge", this, "adding tracker" + e);
      i.put(paramB, "");
    }
  }
  
  void a(String paramString)
  {
    paramString = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.crts(%s);}", new Object[] { paramString });
    f(paramString);
  }
  
  void b(String paramString)
  {
    p.a(3, "JavaScriptBridge", this, "markUserInteractionEvent:" + paramString);
    paramString = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.ucbx(%s);}", new Object[] { paramString });
    f(paramString);
  }
  
  void a()
  {
    p.a(3, "JavaScriptBridge", this, "webViewReady");
    if (d.compareAndSet(false, true))
    {
      p.a(3, "JavaScriptBridge", this, "webViewReady first time");
      i();
      Iterator localIterator = m.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        g(str);
      }
      m.clear();
    }
    c();
  }
  
  private void c()
  {
    Iterator localIterator = i.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject;
      if ((localObject = (b)((Map.Entry)localIterator.next()).getKey()).e())
      {
        localObject = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[] { e });
        g((String)localObject);
      }
    }
  }
  
  void b(b paramB)
  {
    if (d("startTracking"))
    {
      p.a(3, "JavaScriptBridge", this, "Starting tracking on tracker" + e);
      String str = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[] { e });
      g(str);
      i.a().a(s.c(), paramB);
    }
  }
  
  void c(b paramB)
  {
    Object localObject = null;
    if (!g)
    {
      try
      {
        if (d("stopTracking")) {
          try
          {
            p.a(3, "JavaScriptBridge", this, "Ending tracking on tracker" + e);
            String str = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.egpw(\"%s\");}", new Object[] { e });
            g(str);
          }
          catch (Exception localException)
          {
            p.a("JavaScriptBridge", this, "Failed to end impression.", localException);
          }
        }
      }
      catch (m localM) {}
      if (n == a.b) {
        d(paramB);
      } else {
        b();
      }
      i.remove(paramB);
    }
    if (localM != null) {
      throw localM;
    }
  }
  
  private void d()
  {
    w localW = w.a();
    try
    {
      if (a == w.d.a) {
        return;
      }
      if (!c)
      {
        p.a(3, "JavaScriptBridge", this, "Attempting to establish communication (setting environment variables).");
        c = true;
      }
      g(l);
      return;
    }
    catch (Exception localException)
    {
      p.a("JavaScriptBridge", this, "Attempt failed to establish communication (did not set environment variables).", localException);
    }
  }
  
  @TargetApi(19)
  private void e()
  {
    try
    {
      if (aa == w.d.a) {
        return;
      }
      if (g)
      {
        p.a(3, "JavaScriptBridge", this, "Can't send info, already cleaned up");
        return;
      }
      if ((!f()) || ((b) && (g().getUrl() == null)))
      {
        p.a(3, "JavaScriptBridge", this, "WebView became null" + (g() == null ? "" : "based on null url") + ", stopping tracking loop");
        b();
        return;
      }
      if (g().getUrl() != null) {
        b = true;
      }
      Iterator localIterator = i.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject;
        if (((localObject = (b)((Map.Entry)localIterator.next()).getKey()) == null) || (((b)localObject).f() == null))
        {
          p.a(3, "JavaScriptBridge", this, "Tracker has no subject");
          if ((localObject == null) || (!f))
          {
            c((b)localObject);
            continue;
          }
        }
        if (((b)localObject).e())
        {
          if (!d.get())
          {
            str = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[] { e });
            g(str);
          }
          String str = ((b)localObject).h();
          localObject = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.sglu(%s);}", new Object[] { str });
          if (Build.VERSION.SDK_INT >= 19) {
            g().evaluateJavascript((String)localObject, new ValueCallback()
            {
              public void a(String paramAnonymousString)
              {
                if ((paramAnonymousString == null) || (paramAnonymousString.equalsIgnoreCase("null")) || (paramAnonymousString.equalsIgnoreCase("false")))
                {
                  p.a(3, "JavaScriptBridge", j.this, "Received value is:" + (paramAnonymousString == null ? "null" : new StringBuilder("(String)").append(paramAnonymousString).toString()));
                  if (j.a(j.this) >= 150)
                  {
                    p.a(3, "JavaScriptBridge", j.this, "Giving up on finding ad");
                    b();
                  }
                  j.b(j.this);
                  if ((paramAnonymousString != null) && (paramAnonymousString.equalsIgnoreCase("false")) && (!j.c(j.this)))
                  {
                    j.a(j.this, true);
                    p.a(3, "JavaScriptBridge", j.this, "Bridge connection established");
                  }
                }
                else
                {
                  if (paramAnonymousString.equalsIgnoreCase("true"))
                  {
                    if (!j.d(j.this))
                    {
                      j.b(j.this, true);
                      p.a(3, "JavaScriptBridge", j.this, "Javascript has found ad");
                      a();
                    }
                    j.a(j.this, 0);
                    return;
                  }
                  p.a(3, "JavaScriptBridge", j.this, "Received unusual value from Javascript:" + paramAnonymousString);
                }
              }
            });
          } else {
            g().loadUrl((String)localObject);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      m.a(localException);
      b();
    }
  }
  
  private boolean d(String paramString)
  {
    WebView localWebView;
    if ((localWebView = g()) == null)
    {
      p.a(6, "JavaScriptBridge", this, "WebView is null. Can't " + paramString);
      throw new m("WebView is null");
    }
    if (!a(localWebView))
    {
      p.a(6, "JavaScriptBridge", this, "JavaScript is not enabled in the given WebView. Can't " + paramString);
      throw new m("JavaScript is not enabled in the WebView");
    }
    return true;
  }
  
  private boolean a(WebView paramWebView)
  {
    return paramWebView.getSettings().getJavaScriptEnabled();
  }
  
  private boolean f()
  {
    return g() != null;
  }
  
  private WebView g()
  {
    return (WebView)h.get();
  }
  
  private String h()
  {
    try
    {
      Object localObject = s.d();
      s.b localB = s.e();
      HashMap localHashMap = new HashMap();
      String str1 = ((s.a)localObject).a();
      String str2 = ((s.a)localObject).b();
      localObject = ((s.a)localObject).c();
      String str3 = Integer.toString(Build.VERSION.SDK_INT);
      String str4 = s.b();
      String str5 = n == a.a ? "0" : "1";
      String str6 = e ? "1" : "0";
      String str7 = d ? "1" : "0";
      String str8 = ((k)MoatAnalytics.getInstance()).b() ? "0" : "1";
      localHashMap.put("versionHash", "c334ae83accfebb8da23104450c896463c9cfab7");
      localHashMap.put("appName", str1);
      localHashMap.put("namespace", "INM");
      localHashMap.put("version", "2.5.0");
      localHashMap.put("deviceOS", str3);
      localHashMap.put("isNative", str5);
      localHashMap.put("appId", str2);
      localHashMap.put("source", localObject);
      localHashMap.put("carrier", b);
      localHashMap.put("sim", a);
      localHashMap.put("phone", String.valueOf(c));
      localHashMap.put("buildFp", Build.FINGERPRINT);
      localHashMap.put("buildModel", Build.MODEL);
      localHashMap.put("buildMfg", Build.MANUFACTURER);
      localHashMap.put("buildBrand", Build.BRAND);
      localHashMap.put("buildProduct", Build.PRODUCT);
      localHashMap.put("buildTags", Build.TAGS);
      localHashMap.put("f1", str7);
      localHashMap.put("f2", str6);
      localHashMap.put("locationEnabled", str8);
      if (str4 != null) {
        localHashMap.put("aqzx", str4);
      }
      return new JSONObject(localHashMap).toString();
    }
    catch (Exception localException) {}
    return "{}";
  }
  
  void c(String paramString)
  {
    p.a(3, "JavaScriptBridge", this, "flushDispatchQueue");
    Object localObject;
    String str3;
    if (j.size() >= 200)
    {
      LinkedList localLinkedList = new LinkedList();
      for (int i2 = 0; i2 < 10; i2++)
      {
        String str2 = (String)j.removeFirst();
        localLinkedList.addFirst(str2);
      }
      i2 = Math.min(j.size() / 200, 10);
      int i3 = Math.min(200 + i2, j.size());
      for (int i4 = 0; i4 < i3; i4++) {
        j.removeFirst();
      }
      localObject = localLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        str3 = (String)((Iterator)localObject).next();
        j.addFirst(str3);
      }
    }
    if (!j.isEmpty())
    {
      int i1 = 1;
      String str1 = "javascript:%s.dispatchMany([%s])";
      StringBuilder localStringBuilder = new StringBuilder();
      for (localObject = ""; (!j.isEmpty()) && (i1 < 200); localObject = ",")
      {
        i1++;
        str3 = (String)j.removeFirst();
        if (localStringBuilder.length() + str3.length() > 2000) {
          break;
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(str3);
      }
      str1 = String.format(str1, new Object[] { paramString, localStringBuilder.toString() });
      g(str1);
    }
    j.clear();
  }
  
  @UiThread
  void a(String paramString, JSONObject paramJSONObject)
  {
    if (g)
    {
      p.a(3, "JavaScriptBridge", this, "Can't dispatch, already cleaned up");
      return;
    }
    paramJSONObject = paramJSONObject.toString();
    if ((d.get()) && (f()))
    {
      paramString = String.format("javascript:%s.dispatchEvent(%s);", new Object[] { paramString, paramJSONObject });
      g(paramString);
      return;
    }
    j.add(paramJSONObject);
  }
  
  private void e(String paramString)
  {
    if (m.size() >= 50) {
      m.subList(0, 25).clear();
    }
    m.add(paramString);
  }
  
  private void f(String paramString)
  {
    if (d.get())
    {
      g(paramString);
      return;
    }
    e(paramString);
  }
  
  @UiThread
  private void g(String paramString)
  {
    if (g)
    {
      p.a(3, "JavaScriptBridge", this, "Can't send, already cleaned up");
      return;
    }
    if (f())
    {
      p.b(2, "JavaScriptBridge", this, paramString);
      if (Build.VERSION.SDK_INT >= 19)
      {
        g().evaluateJavascript(paramString, null);
        return;
      }
      g().loadUrl(paramString);
    }
  }
  
  private void i()
  {
    p.a(3, "JavaScriptBridge", this, "Stopping metadata reporting loop");
    i.a().a(this);
    LocalBroadcastManager.getInstance(s.c()).unregisterReceiver(o);
  }
  
  private void d(b paramB)
  {
    p.a(3, "JavaScriptBridge", this, "Stopping view update loop");
    if (paramB != null) {
      i.a().a(paramB);
    }
  }
  
  void b()
  {
    p.a(3, "JavaScriptBridge", this, "Cleaning up");
    g = true;
    i();
    Iterator localIterator = i.entrySet().iterator();
    while (localIterator.hasNext())
    {
      b localB = (b)((Map.Entry)localIterator.next()).getKey();
      d(localB);
    }
    i.clear();
    LocalBroadcastManager.getInstance(s.c()).unregisterReceiver(p);
  }
  
  protected void finalize()
  {
    try
    {
      super.finalize();
      p.a(3, "JavaScriptBridge", this, "finalize");
      b();
      return;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
  }
  
  static enum a
  {
    private a() {}
  }
}
