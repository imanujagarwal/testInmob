package com.integralads.avid.library.inmobi.session.internal.jsbridge;

import android.text.TextUtils;
import android.webkit.WebView;
import com.integralads.avid.library.inmobi.AvidBridge;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.inmobi.utils.AvidCommand;
import com.integralads.avid.library.inmobi.weakreference.AvidWebView;
import java.util.ArrayList;
import org.json.JSONObject;









public class AvidBridgeManager
{
  public static final int VIDEO_EVENT_TAG = 1;
  private final InternalAvidAdSessionContext avidAdSessionContext;
  private boolean isAvidJsInjected;
  private AvidWebView avidWebView;
  private boolean isReadyEventPublished;
  private AvidBridgeManagerListener listener;
  private final ArrayList<AvidEvent> pendingEvents = new ArrayList();
  
  public AvidBridgeManager(InternalAvidAdSessionContext paramInternalAvidAdSessionContext) {
    avidAdSessionContext = paramInternalAvidAdSessionContext;
    avidWebView = new AvidWebView(null);
  }
  
  public boolean isActive() {
    return isAvidJsInjected;
  }
  
  public void setListener(AvidBridgeManagerListener paramAvidBridgeManagerListener) {
    listener = paramAvidBridgeManagerListener;
  }
  
  public void onAvidJsReady() {
    injectAvid();
  }
  
  public void setWebView(WebView paramWebView) {
    if (avidWebView.get() == paramWebView) return;
    avidWebView.set(paramWebView);
    isAvidJsInjected = false;
    if (AvidBridge.isAvidJsReady()) {
      injectAvid();
    }
  }
  
  public void destroy() {
    setWebView(null);
  }
  
  public void callAvidbridge(String paramString) {
    avidWebView.injectFormattedJavaScript(paramString);
  }
  
  public void publishReadyEventForDeferredAdSession() {
    isReadyEventPublished = true;
    publishReadyEventIfNeeded();
  }
  
  public void publishNativeViewState(String paramString) {
    callAvidbridge(AvidCommand.setNativeViewState(paramString));
  }
  
  public void publishAppState(String paramString) {
    callAvidbridge(AvidCommand.setAppState(paramString));
  }
  
  public void publishVideoEvent(String paramString, JSONObject paramJSONObject) {
    if (isActive()) {
      invokePublishVideoEvent(paramString, paramJSONObject);return;
    }
    pendingEvents.add(new AvidEvent(1, paramString, paramJSONObject));
  }
  
  private void injectAvid()
  {
    if (avidWebView.isEmpty()) return;
    isAvidJsInjected = true;
    avidWebView.injectJavaScript(AvidBridge.getAvidJs());
    setAvidAdSessionContext();
    publishReadyEventIfNeeded();
    publishPendingEvents();
    notifyListener();
  }
  
  private void publishReadyEventIfNeeded() {
    if ((isActive()) && (isReadyEventPublished)) {
      callAvidbridge(AvidCommand.publishReadyEventForDeferredAdSession());
    }
  }
  
  private void invokePublishVideoEvent(String paramString, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramJSONObject = paramJSONObject != null ? paramJSONObject.toString() : null)) {
      callAvidbridge(AvidCommand.publishVideoEvent(paramString, paramJSONObject));return;
    }
    callAvidbridge(AvidCommand.publishVideoEvent(paramString));
  }
  
  private void setAvidAdSessionContext()
  {
    callAvidbridge(AvidCommand.setAvidAdSessionContext(avidAdSessionContext.getFullContext().toString()));
  }
  
  private void notifyListener() {
    if (listener != null) {
      listener.avidBridgeManagerDidInjectAvidJs();
    }
  }
  
  private void publishPendingEvents() {
    for (AvidEvent localAvidEvent : pendingEvents) {
      invokePublishVideoEvent(localAvidEvent.getType(), localAvidEvent.getData());
    }
    pendingEvents.clear();
  }
  
  public static abstract interface AvidBridgeManagerListener
  {
    public abstract void avidBridgeManagerDidInjectAvidJs();
  }
}
