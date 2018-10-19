package com.integralads.avid.library.inmobi.walking.async;

public class AvidCleanupAsyncTask extends AvidAsyncTask
{
  public AvidCleanupAsyncTask(AvidAsyncTask.StateProvider paramStateProvider) {
    super(paramStateProvider);
  }
  
  protected String doInBackground(Object... paramVarArgs)
  {
    stateProvider.setPreviousState(null);
    return null;
  }
}
