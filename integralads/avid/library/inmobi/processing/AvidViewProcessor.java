package com.integralads.avid.library.inmobi.processing;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.integralads.avid.library.inmobi.utils.AvidJSONUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;


public class AvidViewProcessor
  implements IAvidNodeProcessor
{
  private final int[] xyAxisCoordinates = new int[2];
  
  public AvidViewProcessor() {}
  
  public JSONObject getState(View paramView) { int i = paramView.getWidth();
    int j = paramView.getHeight();
    paramView.getLocationOnScreen(xyAxisCoordinates);
    return AvidJSONUtil.getViewState(xyAxisCoordinates[0], xyAxisCoordinates[1], i, j);
  }
  
  public void iterateChildren(View paramView, JSONObject paramJSONObject, IAvidNodeProcessor.IAvidViewWalker paramIAvidViewWalker, boolean paramBoolean)
  {
    if (!(paramView instanceof ViewGroup)) {
      return;
    }
    paramView = (ViewGroup)paramView;
    if ((!paramBoolean) || (Build.VERSION.SDK_INT < 21)) {
      iterateChilren(paramView, paramJSONObject, paramIAvidViewWalker);return;
    }
    sortAndIterateChilren(paramView, paramJSONObject, paramIAvidViewWalker);
  }
  
  private void iterateChilren(ViewGroup paramViewGroup, JSONObject paramJSONObject, IAvidNodeProcessor.IAvidViewWalker paramIAvidViewWalker)
  {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View localView = paramViewGroup.getChildAt(i);
      paramIAvidViewWalker.walkView(localView, this, paramJSONObject);
    }
  }
  
  @TargetApi(21)
  private void sortAndIterateChilren(ViewGroup paramViewGroup, JSONObject paramJSONObject, IAvidNodeProcessor.IAvidViewWalker paramIAvidViewWalker) {
    HashMap localHashMap = new HashMap();
    Object localObject3; for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      localObject2 = paramViewGroup.getChildAt(i);
      
      if ((localObject3 = (ArrayList)localHashMap.get(Float.valueOf(((View)localObject2).getZ()))) == null) {
        localObject3 = new ArrayList();
        localHashMap.put(Float.valueOf(((View)localObject2).getZ()), localObject3);
      }
      ((ArrayList)localObject3).add(localObject2);
    }
    Object localObject1;
    Collections.sort(localObject1 = new ArrayList(localHashMap.keySet()));
    for (Object localObject2 = ((ArrayList)localObject1).iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (Float)((Iterator)localObject2).next();
      
      for (paramViewGroup = ((ArrayList)localHashMap.get(localObject3)).iterator(); paramViewGroup.hasNext();) { localObject1 = (View)paramViewGroup.next();
        paramIAvidViewWalker.walkView((View)localObject1, this, paramJSONObject);
      }
    }
  }
}
