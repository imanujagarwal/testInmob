package com.integralads.avid.library.inmobi.utils;

import android.view.View;

public class AvidViewUtil
{
  public AvidViewUtil() {}
  
  public static boolean isViewVisible(View paramView) {
    if (paramView.getVisibility() != 0) {
      return false;
    }
    if (android.os.Build.VERSION.SDK_INT >= 11) {
      return paramView.getAlpha() > 0.0D;
    }
    return true;
  }
}
