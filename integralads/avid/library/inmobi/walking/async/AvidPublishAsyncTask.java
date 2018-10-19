package com.integralads.avid.library.inmobi.walking.async;

import android.text.TextUtils;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.inmobi.utils.AvidCommand;
import com.integralads.avid.library.inmobi.utils.AvidJSONUtil;
import java.util.HashSet;
import org.json.JSONObject;


public class AvidPublishAsyncTask
  extends AbstractAvidPublishAsyncTask
{
  public AvidPublishAsyncTask(AvidAsyncTask.StateProvider paramStateProvider, AvidAdSessionRegistry paramAvidAdSessionRegistry, HashSet<String> paramHashSet, JSONObject paramJSONObject, double paramDouble)
  {
    super(paramStateProvider, paramAvidAdSessionRegistry, paramHashSet, paramJSONObject, paramDouble);
  }
  
  protected String doInBackground(Object... paramVarArgs)
  {
    if (AvidJSONUtil.equalStates(state, stateProvider.getPreviousState())) {
      return null;
    }
    stateProvider.setPreviousState(state);
    
    return AvidCommand.setNativeViewState(AvidJSONUtil.getTreeJSONObject(state, timestamp).toString());
  }
  
  protected void onPostExecute(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      injectCommand(paramString);
    }
    super.onPostExecute(paramString);
  }
  
  private void injectCommand(String paramString) {
    for (InternalAvidAdSession localInternalAvidAdSession : adSessionRegistry.getInternalAvidAdSessions()) {
      if (sessionIds.contains(localInternalAvidAdSession.getAvidAdSessionId())) {
        localInternalAvidAdSession.publishNativeViewStateCommand(paramString, timestamp);
      }
    }
  }
}
