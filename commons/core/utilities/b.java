package com.inmobi.commons.core.utilities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.net.URISyntaxException;
import java.net.URLDecoder;







public class b
{
  private static final String a = b.class.getSimpleName();
  


  public b() {}
  

  public static boolean a(Context paramContext, String paramString)
  {
    if (paramString == null)
      return false;
    if (paramContext != null) {
      try
      {
        return new Intent("android.intent.action.VIEW", Uri.parse(paramString)).resolveActivity(paramContext.getPackageManager()) != null;
      } catch (Exception localException) {
        return false;
      }
    }
    return a(Uri.parse(paramString));
  }
  


  public static void b(Context paramContext, @NonNull String paramString)
    throws URISyntaxException, ActivityNotFoundException
  {
    Uri localUri;
    

    do
    {
      if (paramContext == null) return;
      try
      {
        Intent localIntent;
        (localIntent = Intent.parseUri(paramString, 0)).setFlags(268435456);
        paramContext.startActivity(localIntent); return;
      } catch (ActivityNotFoundException localActivityNotFoundException) {
        localUri = Uri.parse(paramString);
      }
    } while (("intent".equals(localUri.getScheme())) && 
      (!TextUtils.isEmpty(paramString = b(paramString))));
    

    throw localActivityNotFoundException;
  }
  










  @Nullable
  public static String a(Context paramContext, @NonNull String paramString1, @Nullable String paramString2)
  {
    if (paramContext == null) return null;
    try {
      Intent localIntent;
      if ((localIntent = Intent.parseUri(paramString1, 0)).resolveActivity(paramContext.getPackageManager()) != null) {
        localIntent.setFlags(268435456);
        paramContext.startActivity(localIntent);
        return paramString1;
      }
      new StringBuilder("No app can handle the:").append(paramString1).append(", trying with fallback URL if any");
      if (!TextUtils.isEmpty(paramString2)) {
        return a(paramContext, paramString2, null);
      }
      paramString2 = Uri.parse(paramString1);
      
      if (("intent".equals(paramString2.getScheme())) && 
        (!TextUtils.isEmpty(paramString2 = b(paramString1)))) {
        return a(paramContext, 
          URLDecoder.decode(paramString2, "UTF-8"), null);
      }
    }
    catch (Exception localException)
    {
      new StringBuilder("No app can handle the url:").append(paramString1).append(", Log : ").append(localException.getMessage());
    }
    return null;
  }
  




  @Nullable
  private static String b(String paramString)
  {
    String str = null;
    try
    {
      str = Intent.parseUri(paramString, 1).getStringExtra("browser_fallback_url");
    } catch (URISyntaxException paramString) {
      new StringBuilder("Exception while getting Fallback Url :").append(paramString.getMessage());
    }
    return str;
  }
  





  private static boolean a(Uri paramUri)
  {
    return ("http".equals(paramUri.getScheme())) || ("https".equals(paramUri.getScheme()));
  }
  






  public static boolean a(@NonNull String paramString)
  {
    return (a(paramString = Uri.parse(paramString))) && (!"play.google.com".equals(paramString.getHost())) && (!"market.android.com".equals(paramString.getHost())) && (!"market".equals(paramString.getScheme()));
  }
}
