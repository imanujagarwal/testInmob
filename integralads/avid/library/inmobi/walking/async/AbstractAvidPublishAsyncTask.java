package com.integralads.avid.library.inmobi.walking.async;

import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class AbstractAvidPublishAsyncTask
  extends AvidAsyncTask
{
  protected final AvidAdSessionRegistry adSessionRegistry;
  protected final HashSet<String> sessionIds;
  protected final JSONObject state;
  protected final double timestamp;
  
  public AvidAdSessionRegistry getAdSessionRegistry()
  {
    return adSessionRegistry;
  }
  
  public HashSet<String> getSessionIds() {
    return sessionIds;
  }
  
  public JSONObject getState() {
    return state;
  }
  
  public double getTimestamp() {
    return timestamp;
  }
  
  public AbstractAvidPublishAsyncTask(AvidAsyncTask.StateProvider paramStateProvider, AvidAdSessionRegistry paramAvidAdSessionRegistry, HashSet<String> paramHashSet, JSONObject paramJSONObject, double paramDouble) {
    super(paramStateProvider);
    adSessionRegistry = paramAvidAdSessionRegistry;
    sessionIds = new HashSet(paramHashSet);
    state = paramJSONObject;
    timestamp = paramDouble;
  }
}
