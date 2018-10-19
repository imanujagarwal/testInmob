package com.integralads.avid.library.inmobi.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvidJSONUtil
{
  public static final String KEY_TIMESTAMP = "timestamp";
  public static final String KEY_ROOT_VIEW = "rootView";
  public static final String KEY_ID = "id";
  public static final String KEY_X = "x";
  public static final String KEY_Y = "y";
  public static final String KEY_WIDTH = "width";
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_CHILD_VIEWS = "childViews";
  public static final String KEY_IS_FRIENDLY_OBSTRUCTION_FOR = "isFriendlyObstructionFor";
  
  public AvidJSONUtil() {}
  
  private static String[] KEYS = { "x", "y", "width", "height" };
  
  static float density = getSystemgetDisplayMetricsdensity;
  
  public static void init(Context paramContext) {
    if (paramContext != null) {
      density = getResourcesgetDisplayMetricsdensity;
    }
  }
  
  public static JSONObject getEmptyTreeJSONObject()
  {
    return getTreeJSONObject(getViewState(0, 0, 0, 0), AvidTimestamp.getCurrentTime());
  }
  
  public static JSONObject getTreeJSONObject(JSONObject paramJSONObject, double paramDouble) {
    JSONObject localJSONObject = new JSONObject();
    try {
      localJSONObject.put("timestamp", paramDouble);
      localJSONObject.put("rootView", paramJSONObject);
    }
    catch (JSONException paramJSONObject) {
      AvidLogs.e("Error with creating treeJSONObject", paramJSONObject);
    }
    return localJSONObject;
  }
  
  public static JSONObject getViewState(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    JSONObject localJSONObject = new JSONObject();
    try {
      localJSONObject.put("x", pxToDp(paramInt1));
      localJSONObject.put("y", pxToDp(paramInt2));
      localJSONObject.put("width", pxToDp(paramInt3));
      localJSONObject.put("height", pxToDp(paramInt4));
    } catch (JSONException paramInt1) {
      AvidLogs.e("Error with creating viewStateObject", paramInt1);
    }
    return localJSONObject;
  }
  
  static float pxToDp(int paramInt) {
    return paramInt / density;
  }
  
  public static void addAvidId(JSONObject paramJSONObject, String paramString) {
    try {
      paramJSONObject.put("id", paramString); return;
    }
    catch (JSONException paramJSONObject) {
      AvidLogs.e("Error with setting avid id", paramJSONObject);
    }
  }
  
  public static void addFriendlyObstruction(JSONObject paramJSONObject, List<String> paramList) {
    JSONArray localJSONArray = new JSONArray();
    for (String str : paramList) {
      localJSONArray.put(str);
    }
    try {
      paramJSONObject.put("isFriendlyObstructionFor", localJSONArray); return;
    }
    catch (JSONException paramList) {
      AvidLogs.e("Error with setting friendly obstruction", paramList);
    }
  }
  
  public static void addChildState(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    try {
      JSONArray localJSONArray;
      if ((localJSONArray = paramJSONObject1.optJSONArray("childViews")) == null) {
        localJSONArray = new JSONArray();
        paramJSONObject1.put("childViews", localJSONArray);
      }
      localJSONArray.put(paramJSONObject2); return;
    } catch (JSONException localJSONException) {
      
        localJSONException;
    }
  }
  
  public static void fixStateFrame(JSONObject paramJSONObject) {
    JSONArray localJSONArray;
    if ((localJSONArray = paramJSONObject.optJSONArray("childViews")) == null) {
      return;
    }
    int i = 0;
    int j = 0;
    int k = localJSONArray.length();
    for (int m = 0; m < k; m++) {
      JSONObject localJSONObject;
      if ((localJSONObject = localJSONArray.optJSONObject(m)) != null) {
        int i1 = localJSONObject.optInt("x");
        int i2 = localJSONObject.optInt("y");
        int i3 = localJSONObject.optInt("width");
        int n = localJSONObject.optInt("height");
        i = Math.max(i, i1 + i3);
        j = Math.max(j, i2 + n);
      }
    }
    try {
      paramJSONObject.put("width", i);
      paramJSONObject.put("height", j); return;
    } catch (JSONException localJSONException) {
      
        localJSONException;
    }
  }
  
  public static boolean equalStates(@NonNull JSONObject paramJSONObject1, @android.support.annotation.Nullable JSONObject paramJSONObject2) {
    if (paramJSONObject2 == null) {
      return false;
    }
    


    return (compareRequiredValues(paramJSONObject1, paramJSONObject2)) && (compareSessionId(paramJSONObject1, paramJSONObject2)) && (compareFriendlySessionIds(paramJSONObject1, paramJSONObject2)) && (compareChildren(paramJSONObject1, paramJSONObject2));
  }
  
  private static boolean compareRequiredValues(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    for (String str : KEYS) {
      if (paramJSONObject1.optDouble(str) != paramJSONObject2.optDouble(str)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean compareSessionId(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    return paramJSONObject1.optString("id", "").equals(paramJSONObject2.optString("id", ""));
  }
  
  private static boolean compareFriendlySessionIds(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    paramJSONObject1 = paramJSONObject1.optJSONArray("isFriendlyObstructionFor");
    paramJSONObject2 = paramJSONObject2.optJSONArray("isFriendlyObstructionFor");
    if (!compareJSONArrays(paramJSONObject1, paramJSONObject2)) {
      return false;
    }
    if (paramJSONObject1 == null) {
      return true;
    }
    for (int i = 0; i < paramJSONObject1.length(); i++) {
      String str1 = paramJSONObject1.optString(i, "");
      String str2 = paramJSONObject2.optString(i, "");
      if (!str1.equals(str2)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean compareChildren(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    paramJSONObject1 = paramJSONObject1.optJSONArray("childViews");
    paramJSONObject2 = paramJSONObject2.optJSONArray("childViews");
    if (!compareJSONArrays(paramJSONObject1, paramJSONObject2)) {
      return false;
    }
    if (paramJSONObject1 == null) {
      return true;
    }
    for (int i = 0; i < paramJSONObject1.length(); i++) {
      JSONObject localJSONObject1 = paramJSONObject1.optJSONObject(i);
      JSONObject localJSONObject2 = paramJSONObject2.optJSONObject(i);
      if (!equalStates(localJSONObject1, localJSONObject2)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean compareJSONArrays(JSONArray paramJSONArray1, JSONArray paramJSONArray2) {
    if ((paramJSONArray1 == null) && (paramJSONArray2 == null)) {
      return true;
    }
    if (((paramJSONArray1 == null) && (paramJSONArray2 != null)) || ((paramJSONArray1 != null) && (paramJSONArray2 == null)))
    {
      return false;
    }
    return paramJSONArray1.length() == paramJSONArray2.length();
  }
}
