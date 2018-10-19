package com.integralads.avid.library.inmobi.walking.async;

import android.support.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class AvidAsyncTaskQueue
  implements AvidAsyncTask.AvidAsyncTaskListener
{
  private static final int THREAD_COUNT = 1;
  private final BlockingQueue<Runnable> workQueue;
  private final ThreadPoolExecutor threadPoolExecutor;
  private final ArrayDeque<AvidAsyncTask> pendingTasks = new ArrayDeque();
  private AvidAsyncTask currentTask = null;
  
  public AvidAsyncTaskQueue() {
    workQueue = new LinkedBlockingQueue();
    threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, workQueue);
  }
  
  public void submitTask(AvidAsyncTask paramAvidAsyncTask) {
    paramAvidAsyncTask.setListener(this);
    pendingTasks.add(paramAvidAsyncTask);
    if (currentTask == null) {
      executeNextTask();
    }
  }
  
  private void executeNextTask() {
    currentTask = ((AvidAsyncTask)pendingTasks.poll());
    if (currentTask != null) {
      currentTask.start(threadPoolExecutor);
    }
  }
  
  public void onTaskCompleted(AvidAsyncTask paramAvidAsyncTask)
  {
    currentTask = null;
    executeNextTask();
  }
  
  @VisibleForTesting
  AvidAsyncTask getCurrentTask() {
    return currentTask;
  }
  
  @VisibleForTesting
  ArrayDeque<AvidAsyncTask> getPendingTasks() {
    return pendingTasks;
  }
}
