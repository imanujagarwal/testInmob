package com.integralads.avid.library.inmobi.session.internal;

import android.content.Context;
import com.integralads.avid.library.inmobi.AvidContext;
import com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext;
import org.json.JSONException;
import org.json.JSONObject;




public class InternalAvidAdSessionContext
{
  public static final String CONTEXT_AVID_AD_SESSION_ID = "avidAdSessionId";
  public static final String CONTEXT_BUNDLE_IDENTIFIER = "bundleIdentifier";
  public static final String CONTEXT_PARTNER = "partner";
  public static final String CONTEXT_PARTNER_VERSION = "partnerVersion";
  public static final String CONTEXT_AVID_LIBRARY_VERSION = "avidLibraryVersion";
  public static final String CONTEXT_AVID_AD_SESSION_TYPE = "avidAdSessionType";
  public static final String CONTEXT_MEDIA_TYPE = "mediaType";
  public static final String CONTEXT_IS_DEFERRED = "isDeferred";
  public static final String CONTEXT_AVID_API_LEVEL = "avidApiLevel";
  public static final String CONTEXT_MODE = "mode";
  public static final String AVID_API_LEVEL = "2";
  public static final String AVID_STUB_MODE = "stub";
  private String avidAdSessionId;
  private ExternalAvidAdSessionContext avidAdSessionContext;
  private String avidAdSessionType;
  private String mediaType;
  
  public InternalAvidAdSessionContext(Context paramContext, String paramString1, String paramString2, String paramString3, ExternalAvidAdSessionContext paramExternalAvidAdSessionContext)
  {
    AvidContext.getInstance().init(paramContext);
    avidAdSessionId = paramString1;
    avidAdSessionContext = paramExternalAvidAdSessionContext;
    avidAdSessionType = paramString2;
    mediaType = paramString3;
  }
  
  public String getAvidAdSessionId() {
    return avidAdSessionId;
  }
  
  public ExternalAvidAdSessionContext getAvidAdSessionContext() {
    return avidAdSessionContext;
  }
  
  public void setAvidAdSessionContext(ExternalAvidAdSessionContext paramExternalAvidAdSessionContext) {
    avidAdSessionContext = paramExternalAvidAdSessionContext;
  }
  
  public JSONObject getFullContext() {
    JSONObject localJSONObject = new JSONObject();
    try {
      localJSONObject.put("avidAdSessionId", avidAdSessionId);
      localJSONObject.put("bundleIdentifier", AvidContext.getInstance().getBundleId());
      localJSONObject.put("partner", AvidContext.getInstance().getPartnerName());
      localJSONObject.put("partnerVersion", avidAdSessionContext.getPartnerVersion());
      localJSONObject.put("avidLibraryVersion", AvidContext.getInstance().getAvidVersion());
      localJSONObject.put("avidAdSessionType", avidAdSessionType);
      localJSONObject.put("mediaType", mediaType);
      localJSONObject.put("isDeferred", avidAdSessionContext.isDeferred());
    } catch (JSONException localJSONException) {
      
        localJSONException;
    }
    return localJSONObject;
  }
  
  public JSONObject getStubContext() {
    JSONObject localJSONObject = getFullContext();
    try {
      localJSONObject.put("avidApiLevel", "2");
      localJSONObject.put("mode", "stub");
    } catch (JSONException localJSONException) {
      
        localJSONException;
    }
    return localJSONObject;
  }
}
