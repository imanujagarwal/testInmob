package com.inmobi.rendering.mraid;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import com.google.android.gms.plus.PlusShare;
import com.inmobi.rendering.InMobiAdActivity.a;
import com.inmobi.rendering.RenderView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.json.JSONException;
import org.json.JSONObject;









public class i
{
  private static final String b = i.class.getSimpleName();
  

  public RenderView a;
  

  private a c;
  

  public i(RenderView paramRenderView)
  {
    a = paramRenderView;
    
    HandlerThread localHandlerThread;
    (localHandlerThread = new HandlerThread("SystemTasksHandlerThread")).start();
    c = new a(localHandlerThread.getLooper(), paramRenderView);
  }
  

































































































































  public static boolean a()
  {
    try
    {
      PlusShare.class.getName();
    } catch (NoClassDefFoundError localNoClassDefFoundError) {
      return false;
    }
    return true;
  }
  


















































  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str1 = paramString1 + " " + paramString2 + " " + paramString3;
    String str2 = null;
    try
    {
      switch (paramInt)
      {






      case 1: 
        str2 = "https://www.facebook.com/dialog/feed?app_id=181821551957328&link=" + URLEncoder.encode(paramString2, "UTF-8") + "&picture=" + URLEncoder.encode(paramString3, "UTF-8") + "&name=&description=" + URLEncoder.encode(paramString1, "UTF-8") + "&redirect_uri=" + URLEncoder.encode(paramString2, "UTF-8");
        break;
      
      case 2: 
        str2 = "https://m.google.com/app/plus/x/?v=compose&content=" + URLEncoder.encode(str1, "UTF-8");
        break;
      
      case 3: 
        str2 = "http://twitter.com/home?status=" + URLEncoder.encode(str1, "UTF-8");
      }
      
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return;
    }
    
    if (str2 != null)
    {
      (paramInt = new Intent("android.intent.action.VIEW")).setData(Uri.parse(str2));
      try {
        com.inmobi.commons.a.a.a(paramContext, paramInt); return;
      } catch (ActivityNotFoundException localActivityNotFoundException1) {
        
          localActivityNotFoundException1.getMessage();return;
      }
    }
    (paramInt = new Intent()).setType("text/plain");
    paramInt.putExtra("android.intent.extra.TEXT", str1);
    try {
      com.inmobi.commons.a.a.a(paramContext, paramInt); return;
    } catch (ActivityNotFoundException localActivityNotFoundException2) {
      
        localActivityNotFoundException2.getMessage();
    }
  }
  
  public final void a(Context paramContext)
  {
    if ((c != null) && (c.hasMessages(1))) {
      c.removeMessages(1);
      ((Vibrator)paramContext.getSystemService("vibrator"))
        .cancel();
    }
  }
  

  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (0 != paramString.length()) {
      try
      {
        String str1;
        if (((str1 = (paramString = new JSONObject(paramString)).optString("frequency")) != null) && (!"".equals(str1))) {
          if (("daily".equals(str1)) || ("weekly".equals(str1)) || ("monthly".equals(str1)) || ("yearly".equals(str1))) {
            localStringBuilder.append("freq=").append(str1).append(";");
          }
          else {
            return "";
          }
        }
        else {
          return "";
        }
        
        String str2;
        if (((str2 = paramString.optString("interval")) != null) && (!"".equals(str2))) {
          localStringBuilder.append("interval=").append(Integer.parseInt(str2)).append(";");
        }
        


        if ((str2 = a.a(paramString.optString("expires"))) != null) {
          localStringBuilder.append("until=").append(str2.replace("+", "Z+").replace("-", "Z-")).append(";");
        }
        
        if (str1.equals("weekly"))
        {

          if ((str2 = a.a(paramString.optJSONArray("daysInWeek"))) != null) {
            localStringBuilder.append("byday=").append(str2).append(";");
          }
        }
        
        if (str1.equals("monthly"))
        {

          if ((str2 = a.a(paramString.optJSONArray("daysInMonth"), -31, 31)) != null) {
            localStringBuilder.append("bymonthday=").append(str2).append(";");
          }
        }
        
        if (str1.equals("yearly"))
        {

          if ((str2 = a.a(paramString.optJSONArray("daysInYear"), 65170, 366)) != null) {
            localStringBuilder.append("byyearday=").append(str2).append(";");
          }
        }
        
        if (str1.equals("monthly"))
        {

          if ((str2 = a.a(paramString.optJSONArray("weeksInMonth"), -4, 4)) != null) {
            localStringBuilder.append("byweekno=").append(str2).append(";");
          }
        }
        
        if (str1.equals("yearly"))
        {

          if ((str2 = a.a(paramString.optJSONArray("monthsInYear"), 1, 12)) != null) {
            localStringBuilder.append("bymonth=").append(str2).append(";");
          }
        }
        
        return localStringBuilder.toString();
      } catch (JSONException paramString) {
        new StringBuilder("Error Parsing recurrence string").append(paramString.toString());
        return "";
      }
    }
    
    return "";
  }
  
  static final class a extends Handler {
    private static final String a = a.class.getSimpleName();
    private WeakReference<RenderView> b;
    
    public a(Looper paramLooper, RenderView paramRenderView) {
      super();
      b = new WeakReference(paramRenderView);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (what) {
      case 1: 
        paramMessage = (String)obj;
        
        RenderView localRenderView;
        if ((localRenderView = (RenderView)b.get()) != null) {
          localRenderView.a(paramMessage, "broadcastEvent('vibrateComplete');");
        }
        break;
      }
    }
  }
}
