package com.integralads.avid.library.inmobi.walking.async;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;










public abstract class AvidAsyncTask
  extends AsyncTask<Object, Void, String>
{
  private AvidAsyncTaskListener listener;
  protected final StateProvider stateProvider;
  
  public AvidAsyncTask(StateProvider paramStateProvider)
  {
    stateProvider = paramStateProvider;
  }
  
  public void setListener(AvidAsyncTaskListener paramAvidAsyncTaskListener) {
    listener = paramAvidAsyncTaskListener;
  }
  
  public AvidAsyncTaskListener getListener() {
    return listener;
  }
  
  public StateProvider getStateProvider() {
    return stateProvider;
  }
  
  public void start(ThreadPoolExecutor paramThreadPoolExecutor) {
    if (Build.VERSION.SDK_INT > 11) {
      executeOnExecutor(paramThreadPoolExecutor, new Object[0]);return;
    }
    execute(new Object[0]);
  }
  

  protected void onPostExecute(String paramString)
  {
    if (listener != null) {
      listener.onTaskCompleted(this);
    }
  }
  
  @VisibleForTesting
  String invokeDoInBackground() {
    return (String)doInBackground(new Object[0]);
  }
  
  @VisibleForTesting
  void invokeOnPostExecute(String paramString) {
    onPostExecute(paramString);
  }
  
  public static abstract interface StateProvider
  {
    public abstract JSONObject getPreviousState();
    
    public abstract void setPreviousState(JSONObject paramJSONObject);
  }
  
  public static abstract interface AvidAsyncTaskListener
  {
    public abstract void onTaskCompleted(AvidAsyncTask paramAvidAsyncTask);
  }
}
