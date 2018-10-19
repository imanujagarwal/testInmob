package com.integralads.avid.library.inmobi.session.internal;

import android.view.View;
import com.integralads.avid.library.inmobi.weakreference.AvidView;
import java.util.ArrayList;

public class ObstructionsWhiteList
{
  public ObstructionsWhiteList() {}
  
  private final ArrayList<AvidView> whiteList = new ArrayList();
  
  public void add(View paramView) {
    whiteList.add(new AvidView(paramView));
  }
  
  public boolean contains(View paramView) {
    for (java.util.Iterator localIterator = whiteList.iterator(); localIterator.hasNext();) {
      if (((AvidView)localIterator.next()).contains(paramView)) return true;
    }
    return false;
  }
  
  public ArrayList<AvidView> getWhiteList() {
    return whiteList;
  }
}
