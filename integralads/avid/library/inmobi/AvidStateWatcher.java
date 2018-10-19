package com.integralads.avid.library.inmobi;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.VisibleForTesting;
import com.integralads.avid.library.inmobi.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import java.util.Collection;
import java.util.Iterator;


public class AvidStateWatcher
{
  public static final String CONTEXT_AVID_AD_SESSION_ID = "avidAdSessionId";
  public static final String CONTEXT_BUNDLE_IDENTIFIER = "bundleIdentifier";
  public static final String CONTEXT_PARTNER = "partner";
  public static final String CONTEXT_PARTNER_VERSION = "partnerVersion";
  public static final String CONTEXT_AVID_LIBRARY_VERSION = "avidLibraryVersion";
  
  public AvidStateWatcher() {}
  
  private static AvidStateWatcher avidStateWatcher = new AvidStateWatcher();
  
  public static AvidStateWatcher getInstance() {
    return avidStateWatcher;
  }
  
  private Context context;
  private BroadcastReceiver receiver;
  private boolean isStarted;
  private boolean isScreenOff;
  private AvidStateWatcherListener stateWatcherListener;
  public void init(Context paramContext)
  {
    unregisterReceiver();
    context = paramContext;
    registerReceiver();
  }
  
  public void start() {
    isStarted = true;
    notifyScreenModeChanged();
  }
  
  public void stop() {
    unregisterReceiver();
    context = null;
    isStarted = false;
    isScreenOff = false;
    stateWatcherListener = null;
  }
  
  public boolean isActive() {
    return !isScreenOff;
  }
  
  public AvidStateWatcherListener getStateWatcherListener() {
    return stateWatcherListener;
  }
  
  public void setStateWatcherListener(AvidStateWatcherListener paramAvidStateWatcherListener) {
    stateWatcherListener = paramAvidStateWatcherListener;
  }
  
  private void onScreenModeChanged(boolean paramBoolean) {
    if (isScreenOff != paramBoolean) {
      isScreenOff = paramBoolean;
      if (isStarted) {
        notifyScreenModeChanged();
        if (stateWatcherListener != null) {
          stateWatcherListener.onAppStateChanged(isActive());
        }
      }
    }
  }
  
  private void registerReceiver() {
    receiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
        if (paramAnonymousIntent == null)
          return;
        if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) {
          AvidStateWatcher.this.onScreenModeChanged(true);return; }
        if ("android.intent.action.USER_PRESENT".equals(paramAnonymousIntent.getAction())) {
          AvidStateWatcher.this.onScreenModeChanged(false);return; }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousIntent.getAction()))
        {
          if (((paramAnonymousContext = (KeyguardManager)paramAnonymousContext.getSystemService("keyguard")) != null) && (!paramAnonymousContext.inKeyguardRestrictedInputMode())) {
            AvidStateWatcher.this.onScreenModeChanged(false);
          }
        }
      }
    };
    IntentFilter localIntentFilter;
    (localIntentFilter = new IntentFilter()).addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    context.registerReceiver(receiver, localIntentFilter);
  }
  
  private void unregisterReceiver() {
    if ((context != null) && (receiver != null)) {
      context.unregisterReceiver(receiver);
      receiver = null;
    }
  }
  
  private void notifyScreenModeChanged() {
    boolean bool = !isScreenOff;
    for (Iterator localIterator = AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions().iterator(); localIterator.hasNext();) {
      ((InternalAvidAdSession)localIterator.next()).setScreenMode(bool);
    }
  }
  
  @VisibleForTesting
  BroadcastReceiver getReceiver() {
    return receiver;
  }
  
  @VisibleForTesting
  void setScreenOff(boolean paramBoolean)
  {
    isScreenOff = paramBoolean;
  }
  
  public static abstract interface AvidStateWatcherListener
  {
    public abstract void onAppStateChanged(boolean paramBoolean);
  }
}
