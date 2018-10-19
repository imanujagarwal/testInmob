package com.integralads.avid.library.inmobi.walking.async;

import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.inmobi.utils.AvidCommand;
import com.integralads.avid.library.inmobi.utils.AvidJSONUtil;
import java.util.HashSet;
import org.json.JSONObject;

public class AvidEmptyPublishAsyncTask
  extends AbstractAvidPublishAsyncTask
{
  public AvidEmptyPublishAsyncTask(AvidAsyncTask.StateProvider paramStateProvider, AvidAdSessionRegistry paramAvidAdSessionRegistry, HashSet<String> paramHashSet, JSONObject paramJSONObject, double paramDouble)
  {
    super(paramStateProvider, paramAvidAdSessionRegistry, paramHashSet, paramJSONObject, paramDouble);
  }
  

  protected String doInBackground(Object... paramVarArgs)
  {
    return AvidCommand.setNativeViewState(AvidJSONUtil.getTreeJSONObject(state, timestamp).toString());
  }
  
  protected void onPostExecute(String paramString)
  {
    for (InternalAvidAdSession localInternalAvidAdSession : adSessionRegistry.getInternalAvidAdSessions()) {
      if (sessionIds.contains(localInternalAvidAdSession.getAvidAdSessionId())) {
        localInternalAvidAdSession.publishEmptyNativeViewStateCommand(paramString, timestamp);
      }
    }
    super.onPostExecute(paramString);
  }
}
