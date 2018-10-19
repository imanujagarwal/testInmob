package com.integralads.avid.library.inmobi.session;

public class ExternalAvidAdSessionContext
{
  private String partnerVersion;
  private boolean isDeferred;
  
  public ExternalAvidAdSessionContext(String paramString) {
    this(paramString, false);
  }
  
  public ExternalAvidAdSessionContext(String paramString, boolean paramBoolean) {
    partnerVersion = paramString;
    isDeferred = paramBoolean;
  }
  
  public String getPartnerVersion() {
    return partnerVersion;
  }
  
  public boolean isDeferred() {
    return isDeferred;
  }
}
