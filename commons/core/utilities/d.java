package com.inmobi.commons.core.utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import com.inmobi.commons.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class d
{
  private static final String a = d.class.getSimpleName();
  
  public d() {}
  
  @SuppressLint({"MissingPermission"})
  public static boolean a() {
    try {
      NetworkInfo localNetworkInfo;
      return ((localNetworkInfo = ((ConnectivityManager)a.b().getSystemService("connectivity")).getActiveNetworkInfo()) != null) && (localNetworkInfo.isConnected()) && (!b());
    }
    catch (Exception localException)
    {
      new StringBuilder("SDK encountered unexpected error in checking network availability; ").append(localException.getMessage()); }
    return false;
  }
  
  private static boolean b()
  {
    boolean bool = false;
    try {
      PowerManager localPowerManager = (PowerManager)a.b().getSystemService("power");
      if (Build.VERSION.SDK_INT > 22) {
        bool = localPowerManager.isDeviceIdleMode();
      }
    }
    catch (Exception localException)
    {
      new StringBuilder("SDK encountered unexpected error in checking idle mode; ").append(localException.getMessage());
    }
    return bool;
  }
  

  public static String a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (Map.Entry localEntry : paramMap.entrySet()) {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(String.format(Locale.US, "%s=%s", new Object[] { a((String)localEntry.getKey()), a((String)localEntry.getValue()) }));
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString) {
    String str = "";
    try {
      str = URLEncoder.encode(paramString, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    
    return str;
  }
  







  public static void a(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      Iterator localIterator = paramMap.entrySet().iterator();
      HashMap localHashMap = new HashMap();
      
      while (localIterator.hasNext()) {
        Map.Entry localEntry;
        if (((localEntry = (Map.Entry)localIterator.next()).getValue() != null) && (((String)localEntry.getValue()).trim().length() != 0) && 
          (localEntry.getKey() != null) && (((String)localEntry.getKey()).trim().length() != 0)) {
          localHashMap.put(((String)localEntry.getKey()).trim(), ((String)localEntry.getValue()).trim());
        }
      }
      
      paramMap.clear();
      paramMap.putAll(localHashMap);
    }
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0)) {
      for (Map.Entry localEntry : paramMap.entrySet()) {
        paramString = paramString.replace((CharSequence)localEntry.getKey(), (CharSequence)localEntry.getValue());
      }
    }
    return paramString;
  }
  
  public static byte[] a(@NonNull byte[] paramArrayOfByte) {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = null;
    try
    {
      return a(localGZIPInputStream = new GZIPInputStream(paramArrayOfByte));
    } catch (IOException localIOException) {
      Logger.a(Logger.InternalLogLevel.DEBUG, a, "Failed to decompress response", localIOException);
      return null;
    } finally {
      a(paramArrayOfByte);
      a(localGZIPInputStream);
    }
  }
  
  public static byte[] a(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    try {
      int i;
      while (-1 != (i = paramInputStream.read(arrayOfByte))) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return localByteArrayOutputStream.toByteArray();
    } finally {
      localByteArrayOutputStream.close();
    }
  }
  
  public static void a(Closeable paramCloseable) {
    try {
      if (paramCloseable != null) {
        paramCloseable.close();
      }
      

      return;
    }
    catch (IOException localIOException) {}
  }
}
