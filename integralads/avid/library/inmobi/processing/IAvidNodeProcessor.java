package com.integralads.avid.library.inmobi.processing;

import android.view.View;
import org.json.JSONObject;

public abstract interface IAvidNodeProcessor
{
  public abstract JSONObject getState(View paramView);
  
  public abstract void iterateChildren(View paramView, JSONObject paramJSONObject, IAvidViewWalker paramIAvidViewWalker, boolean paramBoolean);
  
  public static abstract interface IAvidViewWalker
  {
    public abstract void walkView(View paramView, IAvidNodeProcessor paramIAvidNodeProcessor, JSONObject paramJSONObject);
  }
}
