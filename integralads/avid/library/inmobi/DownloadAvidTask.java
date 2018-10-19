package com.integralads.avid.library.inmobi;

import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.integralads.avid.library.inmobi.utils.AvidLogs;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;





public class DownloadAvidTask
  extends AsyncTask<String, Void, String>
{
  private static final int BSIZE = 1024;
  private DownloadAvidTaskListener listener;
  
  public DownloadAvidTask() {}
  
  public DownloadAvidTaskListener getListener()
  {
    return listener;
  }
  
  public void setListener(DownloadAvidTaskListener paramDownloadAvidTaskListener) {
    listener = paramDownloadAvidTaskListener;
  }
  

  protected String doInBackground(String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramVarArgs = paramVarArgs[0])) {
      AvidLogs.e("AvidLoader: URL is empty");
      return null;
    }
    
    BufferedInputStream localBufferedInputStream = null;
    
    try
    {
      (localObject = new URL(paramVarArgs).openConnection()).connect();
      localBufferedInputStream = new BufferedInputStream(((URLConnection)localObject).getInputStream());
      Object localObject = new StringWriter();
      

      byte[] arrayOfByte = new byte['Ѐ'];
      int i; while ((i = localBufferedInputStream.read(arrayOfByte)) != -1) {
        ((Writer)localObject).write(new String(arrayOfByte, 0, i));
      }
      localObject = localObject.toString();
      






      try
      {
        localBufferedInputStream.close();
      }
      catch (IOException paramVarArgs) {
        AvidLogs.e("AvidLoader: can not close Stream", paramVarArgs);
        return null; } return localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AvidLogs.e("AvidLoader: something is wrong with the URL '" + paramVarArgs + "'");
      










      return null;
    }
    catch (IOException localIOException2)
    {
      AvidLogs.e("AvidLoader: IO error " + localIOException2.getLocalizedMessage());
      







      return null;
    }
    finally
    {
      try
      {
        if (localBufferedInputStream != null) {
          localBufferedInputStream.close();
        }
      } catch (IOException paramVarArgs) {
        AvidLogs.e("AvidLoader: can not close Stream", paramVarArgs);
        return null;
      }
    }
  }
  
  protected void onPostExecute(String paramString)
  {
    if (listener != null) {
      if (!TextUtils.isEmpty(paramString)) {
        listener.onLoadAvid(paramString);return;
      }
      listener.failedToLoadAvid();
    }
  }
  

  protected void onCancelled()
  {
    if (listener != null) {
      listener.failedToLoadAvid();
    }
  }
  
  @VisibleForTesting
  void invokeOnPostExecute(String paramString) {
    onPostExecute(paramString);
  }
  
  @VisibleForTesting
  void invokeOnCancelled() {
    onCancelled();
  }
  
  public static abstract interface DownloadAvidTaskListener
  {
    public abstract void onLoadAvid(String paramString);
    
    public abstract void failedToLoadAvid();
  }
}
