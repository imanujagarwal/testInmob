package com.integralads.avid.library.inmobi;

import android.content.Context;

public class AvidContext
{
  private static final AvidContext instance = new AvidContext();
  private String bundleId;
  
  public AvidContext() {}
  
  public static AvidContext getInstance() { return instance; }
  
  public void init(Context paramContext)
  {
    if (bundleId == null) {
      bundleId = paramContext.getApplicationContext().getPackageName();
    }
  }
  
  public String getBundleId() {
    return bundleId;
  }
  
  public String getAvidVersion() {
    return "3.6.4";
  }
  
  public String getAvidReleaseDate() {
    return "13-Jun-17";
  }
  
  public String getPartnerName() {
    return "inmobi";
  }
}
