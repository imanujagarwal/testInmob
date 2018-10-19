package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class z
{
  private c b = new c();
  private JSONObject c;
  private Rect d;
  private Rect e;
  private JSONObject f;
  private JSONObject g;
  private Location h;
  private Map<String, Object> i = new HashMap();
  String a = "{}";
  
  z() {}
  
  void a(String paramString, View paramView)
  {
    HashMap localHashMap = new HashMap();
    String str = "{}";
    int j = 0;
    try
    {
      if (paramView != null)
      {
        DisplayMetrics localDisplayMetrics = l(paramView);
        boolean bool1 = c(paramView);
        boolean bool2 = d(paramView);
        boolean bool3 = e(paramView);
        float f1 = f(paramView);
        localHashMap.put("dr", Float.valueOf(density));
        localHashMap.put("dv", Double.valueOf(s.a()));
        localHashMap.put("adKey", paramString);
        localHashMap.put("isAttached", Integer.valueOf(bool1 ? 1 : 0));
        localHashMap.put("inFocus", Integer.valueOf(bool2 ? 1 : 0));
        localHashMap.put("isHidden", Integer.valueOf(bool3 ? 1 : 0));
        localHashMap.put("opacity", Float.valueOf(f1));
        paramString = a(localDisplayMetrics);
        Rect localRect = a(paramView);
        paramView = a(paramView, localRect, bool1, bool2, bool3);
        if ((c == null) || (b != b.b) || (!a.equals(b.a)) || (c != b.c))
        {
          b = paramView;
          c = new JSONObject(a(b.a, localDisplayMetrics));
          j = 1;
        }
        localHashMap.put("coveredPercent", Double.valueOf(c));
        if ((g == null) || (!paramString.equals(e)))
        {
          e = paramString;
          g = new JSONObject(a(paramString, localDisplayMetrics));
          j = 1;
        }
        if ((f == null) || (!localRect.equals(d)))
        {
          d = localRect;
          f = new JSONObject(a(localRect, localDisplayMetrics));
          j = 1;
        }
        if ((i == null) || (!localHashMap.equals(i)))
        {
          i = localHashMap;
          j = 1;
        }
        if (!o.a(paramString = o.a().b(), h))
        {
          j = 1;
          h = paramString;
        }
        if (j != 0)
        {
          (paramView = new JSONObject(i)).accumulate("screen", g);
          paramView.accumulate("view", f);
          paramView.accumulate("visible", c);
          paramView.accumulate("maybe", c);
          paramView.accumulate("visiblePercent", Double.valueOf(b.b));
          if (paramString != null) {
            paramView.accumulate("location", a(paramString));
          }
          str = paramView.toString();
          a = str;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      m.a(localException);
      a = str;
    }
  }
  
  private static boolean c(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return (paramView != null) && (paramView.isAttachedToWindow());
    }
    return (paramView != null) && (paramView.getWindowToken() != null);
  }
  
  private static boolean d(View paramView)
  {
    return (paramView != null) && (paramView.hasWindowFocus());
  }
  
  private static boolean e(View paramView)
  {
    return (paramView == null) || (!paramView.isShown());
  }
  
  private static float f(View paramView)
  {
    if (paramView == null) {
      return 0.0F;
    }
    return g(paramView);
  }
  
  private static float g(View paramView)
  {
    float f1 = paramView.getAlpha();
    while ((paramView != null) && (paramView.getParent() != null) && (f1 != 0.0D) && ((paramView.getParent() instanceof View)))
    {
      f1 *= ((View)paramView.getParent()).getAlpha();
      paramView = (View)paramView.getParent();
    }
    return f1;
  }
  
  private static Rect a(DisplayMetrics paramDisplayMetrics)
  {
    int j = widthPixels;
    paramDisplayMetrics = heightPixels;
    return new Rect(0, 0, j, paramDisplayMetrics);
  }
  
  static Rect a(View paramView)
  {
    if (paramView != null) {
      return k(paramView);
    }
    return new Rect(0, 0, 0, 0);
  }
  
  private static c a(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    c localC = new c();
    paramRect = b(paramRect);
    if ((paramView != null) && (paramBoolean1) && (paramBoolean2) && (!paramBoolean3) && (paramRect > 0))
    {
      paramBoolean1 = new Rect(0, 0, 0, 0);
      if (a(paramView, paramBoolean1))
      {
        if ((paramBoolean2 = b(paramBoolean1)) < paramRect) {
          p.b(2, "VisibilityInfo", null, "Ad is clipped");
        }
        if ((paramView.getRootView() instanceof ViewGroup))
        {
          a = paramBoolean1;
          if (ac)
          {
            c = 1.0D;
          }
          else
          {
            if ((paramView = a(paramBoolean1, b)) > 0) {
              c = (paramView / (paramBoolean2 * 1.0D));
            }
            paramView = paramBoolean2 - paramView;
            b = (paramView / (paramRect * 1.0D));
          }
        }
      }
    }
    return localC;
  }
  
  private static boolean h(View paramView)
  {
    return (paramView.isShown()) && (paramView.getAlpha() > 0.0D);
  }
  
  private static ArrayDeque<View> i(@NonNull View paramView)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    View localView = paramView;
    int j = 0;
    while ((localView.getParent() != null) || (localView == paramView.getRootView()))
    {
      j++;
      if (j > 50)
      {
        p.a(3, "VisibilityInfo", null, "Short-circuiting chain retrieval, reached max");
        break;
      }
      localArrayDeque.add(localView);
      if (!(localView.getParent() instanceof View)) {
        break;
      }
      localView = (View)localView.getParent();
    }
    return localArrayDeque;
  }
  
  private static boolean a(View paramView1, View paramView2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (Build.VERSION.SDK_INT < 21) || (paramView1.getZ() >= paramView2.getZ());
    }
    return (Build.VERSION.SDK_INT >= 21) && (paramView1.getZ() > paramView2.getZ());
  }
  
  private static boolean j(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return (paramView.getBackground() == null) || (paramView.getBackground().getAlpha() == 0);
    }
    return true;
  }
  
  private static void a(b paramB, Rect paramRect, a paramA)
  {
    Rect localRect1;
    if ((localRect1 = b).setIntersect(paramRect, localRect1))
    {
      if (Build.VERSION.SDK_INT >= 22)
      {
        Rect localRect2 = new Rect(0, 0, 0, 0);
        if (a(a, localRect2))
        {
          if ((localRect1 = b).setIntersect(localRect2, localRect1)) {}
        }
        else {
          return;
        }
      }
      if (ac) {
        p.b(2, "VisibilityInfo", a, String.format(Locale.ROOT, "Covered by %s-%s alpha=%f", new Object[] { a.getClass().getName(), localRect1.toString(), Float.valueOf(a.getAlpha()) }));
      }
      b.add(localRect1);
      if (localRect1.contains(paramRect)) {
        c = true;
      }
    }
  }
  
  private static void b(b paramB, Rect paramRect, a paramA)
  {
    if (!h(a)) {
      return;
    }
    int j = 1;
    if ((a instanceof ViewGroup))
    {
      boolean bool1 = ViewGroup.class.equals(a.getClass().getSuperclass());
      boolean bool2 = j(a);
      if ((bool1) && (bool2)) {
        j = 0;
      }
      ViewGroup localViewGroup;
      int k = (localViewGroup = (ViewGroup)a).getChildCount();
      for (int m = 0; m < k; m++)
      {
        if (++a > 500) {
          return;
        }
        b(new b(localViewGroup.getChildAt(m), paramB), paramRect, paramA);
        if (c) {
          return;
        }
      }
    }
    if (j != 0) {
      a(paramB, paramRect, paramA);
    }
  }
  
  @VisibleForTesting
  static a a(Rect paramRect, @NonNull View paramView)
  {
    a localA = new a();
    try
    {
      ArrayDeque localArrayDeque;
      if (((localArrayDeque = i(paramView)) == null) || (localArrayDeque.isEmpty())) {
        return localA;
      }
      p.b(2, "VisibilityInfo", paramView, "starting covering rect search");
      b localB = null;
      while (!localArrayDeque.isEmpty())
      {
        View localView1 = (View)localArrayDeque.pollLast();
        paramView = localB;
        localB = new b(localView1, paramView);
        if (localView1.getParent() != null) {
          if ((localView1.getParent() instanceof ViewGroup))
          {
            ViewGroup localViewGroup;
            int j = (localViewGroup = (ViewGroup)localView1.getParent()).getChildCount();
            boolean bool = false;
            for (int k = 0; k < j; k++)
            {
              if (a >= 500)
              {
                p.a(3, "VisibilityInfo", null, "Short-circuiting cover retrieval, reached max");
                return localA;
              }
              View localView2;
              if ((localView2 = localViewGroup.getChildAt(k)) == localView1)
              {
                bool = true;
              }
              else
              {
                a += 1;
                if (a(localView2, localView1, bool))
                {
                  b(new b(localView2, paramView), paramRect, localA);
                  if (c) {
                    return localA;
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return localA;
  }
  
  @VisibleForTesting
  static int a(Rect paramRect, Set<Rect> paramSet)
  {
    int j = 0;
    if (!paramSet.isEmpty())
    {
      ArrayList localArrayList;
      (localArrayList = new ArrayList()).addAll(paramSet);
      Collections.sort(localArrayList, new Comparator()
      {
        public final int a(Rect paramAnonymousRect1, Rect paramAnonymousRect2)
        {
          return Integer.valueOf(top).compareTo(Integer.valueOf(top));
        }
      });
      paramSet = new ArrayList();
      Iterator localIterator1 = localArrayList.iterator();
      Rect localRect1;
      while (localIterator1.hasNext())
      {
        localRect1 = (Rect)localIterator1.next();
        paramSet.add(Integer.valueOf(left));
        paramSet.add(Integer.valueOf(right));
      }
      Collections.sort(paramSet);
      label306:
      for (int k = 0; k < paramSet.size() - 1; k++) {
        if (!((Integer)paramSet.get(k)).equals(paramSet.get(k + 1)))
        {
          localRect1 = new Rect(((Integer)paramSet.get(k)).intValue(), top, ((Integer)paramSet.get(k + 1)).intValue(), bottom);
          int m = top;
          Iterator localIterator2 = localArrayList.iterator();
          Rect localRect2;
          do
          {
            if (!localIterator2.hasNext()) {
              break label306;
            }
            if (!Rect.intersects(localRect2 = (Rect)localIterator2.next(), localRect1)) {
              break;
            }
            if (bottom > m)
            {
              j += localRect1.width() * (bottom - Math.max(m, top));
              m = bottom;
            }
          } while (bottom != bottom);
        }
      }
    }
    return j;
  }
  
  private static Map<String, String> a(Rect paramRect, DisplayMetrics paramDisplayMetrics)
  {
    return a(b(paramRect, paramDisplayMetrics));
  }
  
  private static Map<String, String> a(Rect paramRect)
  {
    HashMap localHashMap;
    (localHashMap = new HashMap()).put("x", String.valueOf(left));
    localHashMap.put("y", String.valueOf(top));
    localHashMap.put("w", String.valueOf(right - left));
    localHashMap.put("h", String.valueOf(bottom - top));
    return localHashMap;
  }
  
  private static Rect b(Rect paramRect, DisplayMetrics paramDisplayMetrics)
  {
    if ((paramDisplayMetrics = density) == 0.0F) {
      return paramRect;
    }
    int j = Math.round(left / paramDisplayMetrics);
    int k = Math.round(right / paramDisplayMetrics);
    int m = Math.round(top / paramDisplayMetrics);
    paramRect = Math.round(bottom / paramDisplayMetrics);
    return new Rect(j, m, k, paramRect);
  }
  
  private static JSONObject a(Location paramLocation)
  {
    if ((paramLocation = b(paramLocation)) == null) {
      return null;
    }
    return new JSONObject(paramLocation);
  }
  
  private static Map<String, String> b(Location paramLocation)
  {
    if (paramLocation == null) {
      return null;
    }
    HashMap localHashMap;
    (localHashMap = new HashMap()).put("latitude", Double.toString(paramLocation.getLatitude()));
    localHashMap.put("longitude", Double.toString(paramLocation.getLongitude()));
    localHashMap.put("timestamp", Long.toString(paramLocation.getTime()));
    localHashMap.put("horizontalAccuracy", Float.toString(paramLocation.getAccuracy()));
    return localHashMap;
  }
  
  private static int b(Rect paramRect)
  {
    return paramRect.width() * paramRect.height();
  }
  
  private static boolean a(View paramView, Rect paramRect)
  {
    if (paramView.getGlobalVisibleRect(paramRect))
    {
      int[] arrayOfInt1 = { Integer.MIN_VALUE, Integer.MIN_VALUE };
      paramView.getLocationInWindow(arrayOfInt1);
      int[] arrayOfInt2 = { Integer.MIN_VALUE, Integer.MIN_VALUE };
      paramView.getLocationOnScreen(arrayOfInt2);
      paramView = arrayOfInt2[0] - arrayOfInt1[0];
      int j = arrayOfInt2[1] - arrayOfInt1[1];
      paramRect.offset(paramView, j);
      return true;
    }
    return false;
  }
  
  private static Rect k(View paramView)
  {
    int[] arrayOfInt = { Integer.MIN_VALUE, Integer.MIN_VALUE };
    paramView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[0];
    int j = arrayOfInt[1];
    return new Rect(k, j, k + paramView.getWidth(), j + paramView.getHeight());
  }
  
  private static Rect b(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 += paramView.getLeft();
    paramInt2 += paramView.getTop();
    return new Rect(paramInt1, paramInt2, paramInt1 + paramView.getWidth(), paramInt2 + paramView.getHeight());
  }
  
  private static DisplayMetrics l(View paramView)
  {
    Activity localActivity;
    if ((Build.VERSION.SDK_INT >= 17) && (a.a != null) && ((localActivity = (Activity)a.a.get()) != null))
    {
      paramView = new DisplayMetrics();
      localActivity.getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      return paramView;
    }
    return paramView.getContext().getResources().getDisplayMetrics();
  }
  
  static class a
  {
    int a = 0;
    final Set<Rect> b = new HashSet();
    boolean c = false;
    
    a() {}
  }
  
  private static class b
  {
    final View a;
    final Rect b;
    
    b(View paramView, b paramB)
    {
      a = paramView;
      if (paramB != null)
      {
        b = z.a(paramView, b.left, b.top);
        return;
      }
      b = z.b(paramView);
    }
  }
  
  private static class c
  {
    Rect a = new Rect(0, 0, 0, 0);
    double b = 0.0D;
    double c = 0.0D;
    
    c() {}
  }
}
