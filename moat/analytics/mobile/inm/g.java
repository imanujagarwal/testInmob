package com.moat.analytics.mobile.inm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

class g
{
  WebView a;
  j b;
  private final a d;
  private boolean e;
  final String c;
  private Handler f;
  private Runnable g;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  g(Context paramContext, a paramA)
  {
    d = paramA;
    e = false;
    c = String.format(Locale.ROOT, "_moatTracker%d", new Object[] { Integer.valueOf((int)(Math.random() * 1.0E8D)) });
    a = new WebView(paramContext);
    (paramContext = a.getSettings()).setJavaScriptEnabled(true);
    paramContext.setAllowContentAccess(false);
    paramContext.setAllowFileAccess(false);
    paramContext.setDatabaseEnabled(false);
    paramContext.setDomStorageEnabled(false);
    paramContext.setGeolocationEnabled(false);
    paramContext.setJavaScriptCanOpenWindowsAutomatically(false);
    paramContext.setSaveFormData(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext.setAllowFileAccessFromFileURLs(false);
      paramContext.setAllowUniversalAccessFromFileURLs(false);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      paramContext.setMixedContentMode(1);
    }
    paramContext = j.a.b;
    if (paramA == a.b) {
      paramContext = j.a.c;
    }
    try
    {
      b = new j(a, paramContext);
      return;
    }
    catch (m localM)
    {
      m.a(localM;
    }
  }
  
  void a(String paramString)
  {
    if (d == a.a)
    {
      a.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (!g.a(g.this)) {
            try
            {
              g.a(g.this, true);
              b.a();
              return;
            }
            catch (Exception localException)
            {
              m.a(localException;
            }
          }
        }
      });
      a.loadData(b(paramString), "text/html", "utf-8");
    }
  }
  
  void a(String paramString, Map<String, String> paramMap, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (d == a.b)
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        p.a(3, "GlobalWebView", this, "Starting off polling interval to check for Video API instance presence");
        f = new Handler();
        g = new Runnable()
        {
          public void run()
          {
            try
            {
              if ((a != null) && (Build.VERSION.SDK_INT >= 19)) {
                a.evaluateJavascript("typeof " + c + " !== 'undefined'", new ValueCallback()
                {
                  public void a(String paramAnonymous2String)
                  {
                    if ("true".equals(paramAnonymous2String))
                    {
                      p.a(3, "GlobalWebView", this, String.format("Video API instance %s detected. Flushing event queue", new Object[] { c }));
                      try
                      {
                        g.a(g.this, true);
                        b.a();
                        b.c(c);
                        return;
                      }
                      catch (Exception localException)
                      {
                        m.a(localException);
                        return;
                      }
                    }
                    g.c(g.this).postDelayed(g.b(g.this), 200L);
                  }
                });
              }
              return;
            }
            catch (Exception localException)
            {
              m.a(localException;
            }
          }
        };
        f.post(g);
      }
      else
      {
        p.a(3, "GlobalWebView", this, "Android API version is less than KitKat: " + Build.VERSION.SDK_INT);
        a.setWebViewClient(new WebViewClient()
        {
          public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            if (!g.a(g.this))
            {
              p.a(3, "GlobalWebView", this, "onPageFinished is called for the first time. Flushing event queue");
              try
              {
                g.a(g.this, true);
                b.a();
                b.c(c);
                return;
              }
              catch (Exception localException)
              {
                m.a(localException;
              }
            }
          }
        });
      }
      paramMap = new JSONObject(paramMap);
      a.loadData(a(c, paramString, paramInteger1, paramInteger2, paramMap, paramInteger3), "text/html", null);
    }
  }
  
  private static String b(String paramString)
  {
    return "<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/" + paramString + "/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>";
  }
  
  private static String a(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, JSONObject paramJSONObject, Integer paramInteger3)
  {
    return String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[] { "mianahwvc", paramInteger1, paramInteger2, "mianahwvc", Long.valueOf(System.currentTimeMillis()), paramString1, paramString2, paramJSONObject.toString(), paramInteger3 });
  }
  
  void a()
  {
    p.a(3, "GlobalWebView", this, "Cleaning up");
    b.b();
    b = null;
    a.destroy();
    a = null;
  }
  
  static enum a
  {
    private a() {}
  }
}
