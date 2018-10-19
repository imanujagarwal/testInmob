package com.moat.analytics.mobile.inm;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.a.b.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

class ab
{
  private static final LinkedHashSet<String> a = new LinkedHashSet();
  
  ab() {}
  
  @NonNull
  static a<WebView> a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    try
    {
      if (paramViewGroup == null) {
        return a.a();
      }
      if ((paramViewGroup instanceof WebView)) {
        return a.a((WebView)paramViewGroup);
      }
      LinkedList localLinkedList;
      (localLinkedList = new LinkedList()).add(paramViewGroup);
      paramViewGroup = null;
      int i = 0;
      label193:
      while ((!localLinkedList.isEmpty()) && (i < 100))
      {
        i++;
        ViewGroup localViewGroup;
        int j = (localViewGroup = (ViewGroup)localLinkedList.poll()).getChildCount();
        for (int k = 0;; k++)
        {
          if (k >= j) {
            break label193;
          }
          View localView;
          if (((localView = localViewGroup.getChildAt(k)) instanceof WebView))
          {
            p.a(3, "WebViewHound", localView, "Found WebView");
            if ((paramBoolean) || (a(String.valueOf(localView.hashCode())))) {
              if (paramViewGroup == null)
              {
                paramViewGroup = (WebView)localView;
              }
              else
              {
                p.a(3, "WebViewHound", localView, "Ambiguous ad container: multiple WebViews reside within it.");
                p.a("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                paramViewGroup = null;
                break;
              }
            }
          }
          if ((localView instanceof ViewGroup)) {
            localLinkedList.add((ViewGroup)localView);
          }
        }
      }
      return a.b(paramViewGroup);
    }
    catch (Exception localException) {}
    return a.a();
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      paramString = a.add(paramString);
      if (a.size() > 50)
      {
        Iterator localIterator = a.iterator();
        for (int i = 0; (i < 25) && (localIterator.hasNext()); i++)
        {
          localIterator.next();
          localIterator.remove();
        }
      }
      p.a(3, "WebViewHound", null, paramString != 0 ? "Newly Found WebView" : "Already Found WebView");
      return paramString;
    }
    catch (Exception localException)
    {
      m.a(localException;
    }
    return false;
  }
}
