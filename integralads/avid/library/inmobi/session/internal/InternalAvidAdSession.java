package com.integralads.avid.library.inmobi.session.internal;

import android.view.View;
import com.integralads.avid.library.inmobi.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.inmobi.session.internal.jsbridge.AvidWebViewManager;
import com.integralads.avid.library.inmobi.weakreference.AvidView;

public abstract class InternalAvidAdSession<T extends View> implements com.integralads.avid.library.inmobi.session.internal.jsbridge.AvidBridgeManager.AvidBridgeManagerListener
{
  private final InternalAvidAdSessionContext internalContext;
  private AvidBridgeManager avidBridgeManager;
  private AvidWebViewManager webViewManager;
  private AvidView<T> avidView;
  private com.integralads.avid.library.inmobi.deferred.AvidDeferredAdSessionListenerImpl avidDeferredAdSessionListener;
  private InternalAvidAdSessionListener listener;
  private boolean isReady;
  private boolean isActive;
  private final ObstructionsWhiteList obstructionsWhiteList;
  private AdState adState;
  private double lastUpdated;
  
  static enum AdState
  {
    AD_STATE_IDLE, 
    AD_STATE_VISIBLE, 
    AD_STATE_HIDDEN;
    





    private AdState() {}
  }
  





  public InternalAvidAdSession(android.content.Context paramContext, String paramString, com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext paramExternalAvidAdSessionContext)
  {
    internalContext = new InternalAvidAdSessionContext(paramContext, paramString, getSessionType().toString(), getMediaType().toString(), paramExternalAvidAdSessionContext);
    avidBridgeManager = new AvidBridgeManager(internalContext);
    avidBridgeManager.setListener(this);
    webViewManager = new AvidWebViewManager(internalContext, avidBridgeManager);
    avidView = new AvidView(null);
    isReady = (!paramExternalAvidAdSessionContext.isDeferred());
    if (!isReady) {
      avidDeferredAdSessionListener = new com.integralads.avid.library.inmobi.deferred.AvidDeferredAdSessionListenerImpl(this, avidBridgeManager);
    }
    obstructionsWhiteList = new ObstructionsWhiteList();
    onViewChanged();
  }
  
  public abstract SessionType getSessionType();
  
  public abstract MediaType getMediaType();
  
  public String getAvidAdSessionId() { return internalContext.getAvidAdSessionId(); }
  
  public com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext getAvidAdSessionContext()
  {
    return internalContext.getAvidAdSessionContext();
  }
  
  public T getView() {
    return (View)avidView.get();
  }
  
  public com.integralads.avid.library.inmobi.deferred.AvidDeferredAdSessionListener getAvidDeferredAdSessionListener() {
    return avidDeferredAdSessionListener;
  }
  
  public InternalAvidAdSessionListener getListener() {
    return listener;
  }
  
  public void setListener(InternalAvidAdSessionListener paramInternalAvidAdSessionListener) {
    listener = paramInternalAvidAdSessionListener;
  }
  
  public boolean isEmpty() {
    return avidView.isEmpty();
  }
  
  public boolean isActive() {
    return isActive;
  }
  
  public boolean isReady() {
    return isReady;
  }
  
  public AvidBridgeManager getAvidBridgeManager() {
    return avidBridgeManager;
  }
  
  public ObstructionsWhiteList getObstructionsWhiteList() {
    return obstructionsWhiteList;
  }
  
  public void registerAdView(T paramT) {
    if (!doesManageView(paramT)) {
      onViewChanged();
      avidView.set(paramT);
      onViewRegistered();
      sessionStateCanBeChanged();
    }
  }
  
  public void unregisterAdView(T paramT) {
    if (doesManageView(paramT)) {
      onViewChanged();
      cleanupViewState();
      avidView.set(null);
      onViewUnregistered();
      sessionStateCanBeChanged();
    }
  }
  
  public boolean doesManageView(View paramView) {
    return avidView.contains(paramView);
  }
  

  public void onStart() {}
  
  public void onEnd()
  {
    cleanupViewState();
    if (avidDeferredAdSessionListener != null) {
      avidDeferredAdSessionListener.destroy();
    }
    avidBridgeManager.destroy();
    webViewManager.destroy();
    isReady = false;
    sessionStateCanBeChanged();
    if (listener != null) {
      listener.sessionDidEnd(this);
    }
  }
  
  public void onReady() {
    isReady = true;
    sessionStateCanBeChanged();
  }
  
  public void avidBridgeManagerDidInjectAvidJs()
  {
    sessionStateCanBeChanged();
  }
  
  public void setScreenMode(boolean paramBoolean) {
    if (isActive()) {
      paramBoolean = paramBoolean ? "active" : "inactive";
      avidBridgeManager.publishAppState(paramBoolean);
    }
  }
  
  public void publishNativeViewStateCommand(String paramString, double paramDouble) {
    if (paramDouble > lastUpdated) {
      avidBridgeManager.callAvidbridge(paramString);
      adState = AdState.AD_STATE_VISIBLE;
    }
  }
  
  public void publishEmptyNativeViewStateCommand(String paramString, double paramDouble) {
    if ((paramDouble > lastUpdated) && (adState != AdState.AD_STATE_HIDDEN)) {
      avidBridgeManager.callAvidbridge(paramString);
      adState = AdState.AD_STATE_HIDDEN;
    }
  }
  
  protected void cleanupViewState() {
    if (isActive()) {
      avidBridgeManager.publishNativeViewState(com.integralads.avid.library.inmobi.utils.AvidJSONUtil.getEmptyTreeJSONObject().toString());
    }
  }
  

  protected void onViewRegistered() {}
  

  protected void onViewUnregistered() {}
  

  protected void updateWebViewManager()
  {
    webViewManager.setWebView(getWebView());
  }
  
  protected void sessionStateCanBeChanged() {
    boolean bool = (avidBridgeManager.isActive()) && (isReady) && (!isEmpty());
    if (isActive != bool) {
      setActive(bool);
    }
  }
  
  protected void setActive(boolean paramBoolean) {
    isActive = paramBoolean;
    if (listener != null) {
      if (paramBoolean) {
        listener.sessionHasBecomeActive(this);return;
      }
      listener.sessionHasResignedActive(this);
    }
  }
  
  private void onViewChanged()
  {
    lastUpdated = com.integralads.avid.library.inmobi.utils.AvidTimestamp.getCurrentTime();
    adState = AdState.AD_STATE_IDLE;
  }
  
  public abstract android.webkit.WebView getWebView();
  
  @android.support.annotation.VisibleForTesting
  void setAvidBridgeManager(AvidBridgeManager paramAvidBridgeManager) {
    avidBridgeManager = paramAvidBridgeManager;
  }
  
  @android.support.annotation.VisibleForTesting
  AdState getAdState() {
    return adState;
  }
  
  @android.support.annotation.VisibleForTesting
  double getLastUpdated() {
    return lastUpdated;
  }
  
  @android.support.annotation.VisibleForTesting
  void setAvidWebViewManager(AvidWebViewManager paramAvidWebViewManager) {
    webViewManager = paramAvidWebViewManager;
  }
}
