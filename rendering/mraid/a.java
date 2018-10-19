package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract.Events;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;




public class a
{
  private static final SimpleDateFormat[] a = { new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US), new SimpleDateFormat("yyyy-MM", Locale.US), new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.US), new SimpleDateFormat("yyyyMMddHHmm", Locale.US), new SimpleDateFormat("yyyyMMdd", Locale.US), new SimpleDateFormat("yyyyMM", Locale.US), new SimpleDateFormat("yyyy", Locale.US) };
  





  public a() {}
  





  private static String b = a.class.getSimpleName();
  
  @TargetApi(14)
  public static int a(Context paramContext) {
    int i = 0;
    String[] arrayOfString = { "_id", "title" };
    



    if (((paramContext = paramContext.getContentResolver().query(CalendarContract.Events.CONTENT_URI, arrayOfString, null, null, null)) != null) && (paramContext.moveToLast())) {
      int j = paramContext.getColumnIndex("title");
      int k = paramContext.getColumnIndex("_id");
      
      String str1 = paramContext.getString(j);
      String str2 = paramContext.getString(k);
      if (str1 != null) {
        i = Integer.parseInt(str2);
      }
      
      paramContext.close();
    }
    
    return i;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static String a(String paramString) {
    if ((paramString != null) && (!"".equals(paramString))) {
      Date localDate = null;
      String str = null;
      for (SimpleDateFormat localSimpleDateFormat : a) {
        try {
          localDate = localSimpleDateFormat.parse(paramString);
        }
        catch (ParseException localParseException) {}
      }
      


      if (localDate != null)
      {





        DateFormat[] arrayOfDateFormat = { new SimpleDateFormat("yyyyMMdd'T'HHmmssZ", Locale.US), new SimpleDateFormat("yyyyMMdd'T'HHmm", Locale.US), new SimpleDateFormat("yyyyMMdd", Locale.US) }; for (int k = 0; k < 3; k++) { paramString = arrayOfDateFormat[k];
          try {
            str = paramString.format(Long.valueOf(localDate.getTime()));
          }
          catch (IllegalArgumentException localIllegalArgumentException) {}
        }
        

        return str;
      }
    }
    return null;
  }
  

  public static GregorianCalendar b(String paramString)
  {
    for (SimpleDateFormat localSimpleDateFormat : a) {
      try {
        Date localDate = localSimpleDateFormat.parse(paramString);
        GregorianCalendar localGregorianCalendar;
        (localGregorianCalendar = new GregorianCalendar()).setTime(localDate);
        new StringBuilder("Date format: ").append(localSimpleDateFormat.toPattern());
        return (GregorianCalendar)localGregorianCalendar;
      } catch (ParseException localParseException) {
        new StringBuilder("Skipping format: ").append(localSimpleDateFormat.toPattern());
      }
    }
    
    return null;
  }
  
  public static String a(JSONArray paramJSONArray, int paramInt1, int paramInt2) {
    if ((paramJSONArray != null) && (0 != paramJSONArray.length())) {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < paramJSONArray.length(); i++) {
        try {
          int j;
          if (((j = paramJSONArray.getInt(i)) < paramInt1) || (j > paramInt2) || (j != 0))
          {


            localStringBuilder.append(j).append(",");
          }
        } catch (JSONException localJSONException) {
          new StringBuilder("Could not parse day ").append(localJSONException.getMessage());
          return null;
        }
      }
      
      String str;
      int k;
      if ((k = (str = localStringBuilder.toString()).length()) == 0) {
        return null;
      }
      if (str.charAt(k - 1) == ',') {
        str = str.substring(0, k - 1);
      }
      return str;
    }
    return null;
  }
  
  public static String a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (0 != paramJSONArray.length())) {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < paramJSONArray.length(); i++) {
        try {
          Object localObject = paramJSONArray.get(i);
          localStringBuilder.append(localObject).append(",");
        } catch (JSONException localJSONException) {
          new StringBuilder("Could not parse day object ").append(localJSONException.toString());
          return null;
        }
      }
      
      String str;
      
      int j;
      if ((j = (str = localStringBuilder.toString()).length()) == 0) {
        return null;
      }
      if (str.charAt(j - 1) == ',') {
        str = str.substring(0, j - 1);
      }
      return str;
    }
    return null;
  }
}
