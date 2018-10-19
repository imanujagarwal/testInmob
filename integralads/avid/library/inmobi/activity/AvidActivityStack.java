package com.integralads.avid.library.inmobi.activity;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.Window;
import com.integralads.avid.library.inmobi.weakreference.AvidActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AvidActivityStack
{
  public AvidActivityStack() {}
  
  private static AvidActivityStack avidActivityStackInstance = new AvidActivityStack();
  
  private final ArrayList<AvidActivity> activities = new ArrayList();
  
  public static AvidActivityStack getInstance() {
    return avidActivityStackInstance;
  }
  
  public void addActivity(Activity paramActivity) {
    if (find(paramActivity) == null) {
      activities.add(new AvidActivity(paramActivity));
    }
  }
  
  public List<View> getRootViews() {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    for (Iterator localIterator = activities.iterator(); localIterator.hasNext();) {
      Object localObject2 = (AvidActivity)localIterator.next();
      if (isFinished((AvidActivity)localObject2)) {
        localIterator.remove();


      }
      else if ((localObject2 = getRootView((AvidActivity)localObject2)) != null) {
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      localArrayList.add(localObject1);
    }
    return localArrayList;
  }
  
  public void cleanup() {
    activities.clear();
  }
  
  @VisibleForTesting
  AvidActivity find(Activity paramActivity) {
    for (Iterator localIterator = activities.iterator(); localIterator.hasNext();) { AvidActivity localAvidActivity;
      if ((localAvidActivity = (AvidActivity)localIterator.next()).contains(paramActivity)) {
        return localAvidActivity;
      }
    }
    return null;
  }
  
  @VisibleForTesting
  List<AvidActivity> getActivities() {
    return activities;
  }
  
  @VisibleForTesting
  boolean isFinished(AvidActivity paramAvidActivity)
  {
    if ((paramAvidActivity = (Activity)paramAvidActivity.get()) == null) {
      return true;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      return paramAvidActivity.isDestroyed();
    }
    return paramAvidActivity.isFinishing();
  }
  
  @VisibleForTesting
  private View getRootView(AvidActivity paramAvidActivity)
  {
    if ((paramAvidActivity = (Activity)paramAvidActivity.get()) == null) {
      return null;
    }
    Window localWindow;
    if (((localWindow = paramAvidActivity.getWindow()) == null) || (!paramAvidActivity.hasWindowFocus())) {
      return null;
    }
    
    if (((paramAvidActivity = localWindow.getDecorView()) != null) && (paramAvidActivity.isShown())) return paramAvidActivity; return null;
  }
  
  @VisibleForTesting
  static void setAvidActivityStackInstance(AvidActivityStack paramAvidActivityStack) {
    avidActivityStackInstance = paramAvidActivityStack;
  }
}
