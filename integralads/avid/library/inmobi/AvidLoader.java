package com.integralads.avid.library.inmobi;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import com.integralads.avid.library.inmobi.utils.NetworkUtils;







public class AvidLoader
  implements DownloadAvidTask.DownloadAvidTaskListener
{
  private static final int DOWNLOAD_ATTEMPT_PERIOD = 2000;
  private static final String AVID_URL = "https://mobile-static.adsafeprotected.com/avid-v2.js";
  
  public AvidLoader() {}
  
  private static AvidLoader avidLoader = new AvidLoader();
  
  public static AvidLoader getInstance() {
    return avidLoader; }
  

  private AvidLoaderListener listener;
  private DownloadAvidTask activeTask;
  private Context context;
  private TaskExecutor taskExecutor = new TaskExecutor();
  private TaskRepeater taskRepeater;
  
  public void registerAvidLoader(Context paramContext) {
    context = paramContext;
    taskRepeater = new TaskRepeater();
    loadAvidJSFromUrl();
  }
  
  public void unregisterAvidLoader() {
    if (taskRepeater != null) {
      taskRepeater.cleanup();
      taskRepeater = null;
    }
    listener = null;
    context = null;
  }
  
  public void setListener(AvidLoaderListener paramAvidLoaderListener) {
    listener = paramAvidLoaderListener;
  }
  
  public AvidLoaderListener getListener() {
    return listener;
  }
  
  private void loadAvidJSFromUrl() {
    if ((!AvidBridge.isAvidJsReady()) && (activeTask == null)) {
      activeTask = new DownloadAvidTask();
      activeTask.setListener(this);
      taskExecutor.executeTask(activeTask);
    }
  }
  
  private void repeatLoading() {
    if (taskRepeater != null) {
      taskRepeater.repeatLoading();
    }
  }
  
  public void onLoadAvid(String paramString)
  {
    activeTask = null;
    AvidBridge.setAvidJs(paramString);
    if (listener != null) {
      listener.onAvidLoaded();
    }
  }
  
  public void failedToLoadAvid()
  {
    activeTask = null;
    repeatLoading();
  }
  
  @VisibleForTesting
  DownloadAvidTask getAsyncTask() {
    return activeTask;
  }
  
  @VisibleForTesting
  TaskRepeater getTaskRepeater() {
    return taskRepeater;
  }
  
  @VisibleForTesting
  void setTaskRepeater(TaskRepeater paramTaskRepeater) {
    taskRepeater = paramTaskRepeater;
  }
  
  @VisibleForTesting
  void setTaskExecutor(TaskExecutor paramTaskExecutor) {
    taskExecutor = paramTaskExecutor;
  }
  

  @VisibleForTesting
  static void setAvidLoaderInstance(AvidLoader paramAvidLoader) { avidLoader = paramAvidLoader; }
  
  public static abstract interface AvidLoaderListener { public abstract void onAvidLoaded(); }
  
  public class TaskExecutor { public TaskExecutor() {}
    
    public void executeTask(DownloadAvidTask paramDownloadAvidTask) { if (Build.VERSION.SDK_INT >= 11) {
        activeTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { "https://mobile-static.adsafeprotected.com/avid-v2.js" });return;
      }
      activeTask.execute(new String[] { "https://mobile-static.adsafeprotected.com/avid-v2.js" });
    }
  }
  
  public class TaskRepeater {
    public TaskRepeater() {}
    
    private Handler handler = new Handler();
    
    public void repeatLoading() {
      handler.postDelayed(avidDownloadRunnable, 2000L);
    }
    
    public void cleanup() {
      handler.removeCallbacks(avidDownloadRunnable);
    }
  }
  
  private final Runnable avidDownloadRunnable = new Runnable()
  {
    public void run() {
      if ((context != null) && (NetworkUtils.isNetworkAvailable(context))) {
        AvidLoader.this.loadAvidJSFromUrl();return;
      }
      AvidLoader.this.repeatLoading();
    }
  };
}
