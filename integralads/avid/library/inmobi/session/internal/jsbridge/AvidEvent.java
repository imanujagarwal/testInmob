package com.integralads.avid.library.inmobi.session.internal.jsbridge;

import org.json.JSONObject;

public class AvidEvent
{
  private int tag;
  private String type;
  private JSONObject data;
  
  public AvidEvent() {}
  
  public AvidEvent(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    tag = paramInt;
    type = paramString;
    data = paramJSONObject;
  }
  
  public AvidEvent(int paramInt, String paramString) {
    this(paramInt, paramString, null);
  }
  
  public int getTag() {
    return tag;
  }
  
  public void setTag(int paramInt) {
    tag = paramInt;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String paramString) {
    type = paramString;
  }
  
  public JSONObject getData() {
    return data;
  }
  
  public void setData(JSONObject paramJSONObject) {
    data = paramJSONObject;
  }
}
