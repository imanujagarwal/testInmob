package com.integralads.avid.library.inmobi.walking;

import android.support.annotation.VisibleForTesting;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.walking.async.AvidAsyncTask.StateProvider;
import com.integralads.avid.library.inmobi.walking.async.AvidAsyncTaskQueue;
import com.integralads.avid.library.inmobi.walking.async.AvidCleanupAsyncTask;
import com.integralads.avid.library.inmobi.walking.async.AvidEmptyPublishAsyncTask;
import com.integralads.avid.library.inmobi.walking.async.AvidPublishAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;



public class AvidStatePublisher
  implements AvidAsyncTask.StateProvider
{
  private final AvidAdSessionRegistry adSessionRegistry;
  private JSONObject previousState;
  private final AvidAsyncTaskQueue taskQueue;
  
  public AvidStatePublisher(AvidAdSessionRegistry paramAvidAdSessionRegistry, AvidAsyncTaskQueue paramAvidAsyncTaskQueue)
  {
    adSessionRegistry = paramAvidAdSessionRegistry;
    taskQueue = paramAvidAsyncTaskQueue;
  }
  
  public void publishState(JSONObject paramJSONObject, HashSet<String> paramHashSet, double paramDouble) {
    taskQueue.submitTask(new AvidPublishAsyncTask(this, adSessionRegistry, paramHashSet, paramJSONObject, paramDouble));
  }
  
  public void publishEmptyState(JSONObject paramJSONObject, HashSet<String> paramHashSet, double paramDouble) {
    taskQueue.submitTask(new AvidEmptyPublishAsyncTask(this, adSessionRegistry, paramHashSet, paramJSONObject, paramDouble));
  }
  
  public void cleanupCache() {
    taskQueue.submitTask(new AvidCleanupAsyncTask(this));
  }
  
  @VisibleForTesting
  public JSONObject getPreviousState() {
    return previousState;
  }
  
  @VisibleForTesting
  public void setPreviousState(JSONObject paramJSONObject) {
    previousState = paramJSONObject;
  }
}
