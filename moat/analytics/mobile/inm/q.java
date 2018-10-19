package com.moat.analytics.mobile.inm;

import com.moat.analytics.mobile.inm.a.b.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

class q
{
  q() {}
  
  private static String a(InputStream paramInputStream)
  {
    char[] arrayOfChar = new char['Ā'];
    StringBuilder localStringBuilder = new StringBuilder();
    paramInputStream = new InputStreamReader(paramInputStream, "UTF-8");
    int j = 0;
    do
    {
      int i;
      if ((i = paramInputStream.read(arrayOfChar, 0, 256)) <= 0) {
        break;
      }
      j += i;
      localStringBuilder.append(arrayOfChar, 0, i);
    } while (j < 1024);
    return localStringBuilder.toString();
  }
  
  static a<String> a(String paramString)
  {
    InputStream localInputStream = null;
    try
    {
      (paramString = (HttpURLConnection)new URL(paramString).openConnection()).setUseCaches(false);
      paramString.setReadTimeout(10000);
      paramString.setConnectTimeout(15000);
      paramString.setRequestMethod("GET");
      paramString.setDoInput(true);
      paramString.connect();
      if (paramString.getResponseCode() >= 400)
      {
        paramString = a.a();
        return paramString;
      }
      paramString = a.a(a(localInputStream = paramString.getInputStream()));
      return paramString;
    }
    catch (IOException localIOException2)
    {
      paramString = a.a();
      return paramString;
    }
    finally
    {
      if (localInputStream != null) {
        try
        {
          localInputStream.close();
        }
        catch (IOException localIOException4) {}
      }
    }
  }
  
  static void b(String paramString)
  {
    new Thread()
    {
      public final void run()
      {
        try
        {
          q.a(a);
          return;
        }
        catch (Exception localException) {}
      }
    }.start();
  }
}
