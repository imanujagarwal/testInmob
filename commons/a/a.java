package com.inmobi.commons.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.core.utilities.c;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;












public final class a
{
  private static final String a = a.class.getSimpleName();
  




  static { "row".contains("staging"); } private static final boolean b = false;
  

  private static Context c;
  
  private static String d = "";
  private static String e = "";
  private static AtomicBoolean f = new AtomicBoolean();
  private static boolean g = false;
  
  public static void a(Context paramContext, String paramString) {
    if (!a())
    {

























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      c = paramContext.getApplicationContext();e = paramString;f.set(true);
      



























































































































      if (Build.VERSION.SDK_INT < 17) {
        try
        {
          d = new WebView(paramContext).getSettings().getUserAgentString();


















































































































































































































































































































































































































































        }
        catch (Exception paramContext)
        {


















































































































































































































































































































































































































































          c = null;new StringBuilder("SDK encountered an unexpected error in SdkContext.fetchWebviewUserAgent().handler() method; ").append(paramContext.getMessage());
        }
      }
      h();
    }
  }
  
  public static boolean a() {
    return c != null;
  }
  
  @Nullable
  public static Context b() {
    return c;
  }
  
  public static void c() {
    c = null;
  }
  
  public static void a(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static boolean d() {
    return g;
  }
  
  public static String e() {
    return e;
  }
  
  public static String f() {
    if ((TextUtils.isEmpty(d)) && (Build.VERSION.SDK_INT >= 17))
    {
      d = c(c);
    }
    return d;
  }
  
  public static boolean g() {
    return f.get();
  }
  
  public static void b(boolean paramBoolean) {
    f.set(paramBoolean);
  }
  




  public static File a(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "im_cached_content");
  }
  

















  public static void a(File paramFile)
  {
    c.a(paramFile);
  }
  

  public static void b(@NonNull Context paramContext)
  {
    try
    {
      if ((paramContext = 
      























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        new File(paramContext.getCacheDir(), "im_cached_content")).exists()) {
        c.a(paramContext);
      }
      return;
    } catch (Exception paramContext) {
      new StringBuilder("SDK encountered unexpected error in clearOldMediaCacheDirectory; ").append(paramContext.getMessage());
    }
  }
  
  private static void h() {
    File localFile;
    if (!(localFile = a(
    



































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      c)).mkdir()) { localFile.isDirectory();
    }
  }
  
  @TargetApi(17)
  private static String c(Context paramContext)
  {
    String str = "";
    
















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    try
    {
      if (b) {
        throw new Exception("android.util.AndroidRuntimeException: android.content.pm.PackageManager$NameNotFoundException: com.google.android.webview");
      }
      return 
      





















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        WebSettings.getDefaultUserAgent(paramContext.getApplicationContext());
    }
    catch (Throwable paramContext)
    {
      new StringBuilder("SDK encountered an unexpected error in getting user agent information; ").append(paramContext.getMessage());
      com.inmobi.commons.core.a.a.a().a(new com.inmobi.commons.core.e.a(paramContext));
      try
      {
        if ((str = System.getProperty("http.agent")) == null) {
          return "";
        }
        
      }
      catch (Exception paramContext)
      {
        new StringBuilder("SDK encountered an unexpected error in getting property of http.agent; ").append(paramContext.getMessage());
        
        com.inmobi.commons.core.a.a.a().a(new com.inmobi.commons.core.e.a(paramContext));
      }
    }
    return str;
  }
  
























  public static boolean b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    
    PackageManager localPackageManager = paramContext.getPackageManager();
    
    if (Build.VERSION.SDK_INT < 23)
    {
      paramContext = 0 == localPackageManager.checkPermission(paramString, localPackageManager
        .getNameForUid(Binder.getCallingUid())) ? 1 : 0;


    }
    else
    {

      paramContext = c(paramContext, paramString);
    }
    return paramContext;
  }
  
  private static boolean c(Context paramContext, String paramString) {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    try
    {
      if (getPackageManagergetPackageInfogetPackageName4096requestedPermissions != null) {
        int i = (paramContext = requestedPermissions).length; for (int j = 0; j < i; j++) {
          if (paramContext[j].equals(paramString)) {
            return true;
          }
        }
      }
    } catch (Exception paramContext) {
      new StringBuilder("Could not check manifest for permission:").append(paramString).append(" Error:").append(paramContext.getLocalizedMessage());
    }
    return false;
  }
  



  public static void a(Context paramContext, Intent paramIntent)
  {
    if (!(paramContext instanceof Activity)) {
      paramIntent.setFlags(268435456);
    }
    paramContext.startActivity(paramIntent);
  }
  


  public static File a(String paramString)
  {
    h();
    




































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    paramString = paramString;int i = paramString.length() / 2;
    String str = String.valueOf(paramString.substring(0, i).hashCode() & 0x7FFFFFFF);return new File(a(c), 
      str + String.valueOf(paramString.substring(i).hashCode() & 0x7FFFFFFF));
  }
  
  public a() {}
}
