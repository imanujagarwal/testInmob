package com.integralads.avid.library.inmobi.processing;

import android.view.View;
import com.integralads.avid.library.inmobi.activity.AvidActivityStack;
import com.integralads.avid.library.inmobi.utils.AvidJSONUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;



public class AvidSceenProcessor
  implements IAvidNodeProcessor
{
  private final IAvidNodeProcessor childrenProcessor;
  
  public AvidSceenProcessor(IAvidNodeProcessor paramIAvidNodeProcessor)
  {
    childrenProcessor = paramIAvidNodeProcessor;
  }
  
  public JSONObject getState(View paramView)
  {
    return AvidJSONUtil.getViewState(0, 0, 0, 0);
  }
  

  public void iterateChildren(View paramView, JSONObject paramJSONObject, IAvidNodeProcessor.IAvidViewWalker paramIAvidViewWalker, boolean paramBoolean)
  {
    for (paramView = AvidActivityStack.getInstance().getRootViews().iterator(); paramView.hasNext();) { paramBoolean = (View)paramView.next();
      paramIAvidViewWalker.walkView(paramBoolean, childrenProcessor, paramJSONObject);
    }
  }
}
