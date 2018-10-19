package com.integralads.avid.library.inmobi.registration;

import android.view.View;
import com.integralads.avid.library.inmobi.session.AbstractAvidAdSession;
import com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class AvidAdSessionRegistry implements com.integralads.avid.library.inmobi.session.internal.InternalAvidAdSessionListener
{
  public AvidAdSessionRegistry() {}
  
  private static AvidAdSessionRegistry instance = new AvidAdSessionRegistry();
  
  private final HashMap<String, InternalAvidAdSession> internalAvidAdSessions = new HashMap();
  private final HashMap<String, AbstractAvidAdSession> avidAdSessions = new HashMap();
  private AvidAdSessionRegistryListener listener;
  
  private int activeSessionCount = 0;
  
  public static AvidAdSessionRegistry getInstance() {
    return instance;
  }
  
  public AvidAdSessionRegistryListener getListener() {
    return listener;
  }
  
  public void setListener(AvidAdSessionRegistryListener paramAvidAdSessionRegistryListener) {
    listener = paramAvidAdSessionRegistryListener;
  }
  
  public void registerAvidAdSession(AbstractAvidAdSession paramAbstractAvidAdSession, InternalAvidAdSession paramInternalAvidAdSession) {
    avidAdSessions.put(paramAbstractAvidAdSession.getAvidAdSessionId(), paramAbstractAvidAdSession);
    internalAvidAdSessions.put(paramAbstractAvidAdSession.getAvidAdSessionId(), paramInternalAvidAdSession);
    
    paramInternalAvidAdSession.setListener(this);
    
    if ((avidAdSessions.size() == 1) && (listener != null)) {
      listener.registryHasSessionsChanged(this);
    }
  }
  
  public Collection<InternalAvidAdSession> getInternalAvidAdSessions() {
    return internalAvidAdSessions.values();
  }
  
  public Collection<AbstractAvidAdSession> getAvidAdSessions() {
    return avidAdSessions.values();
  }
  
  public boolean isEmpty() {
    return avidAdSessions.isEmpty();
  }
  
  public boolean hasActiveSessions() {
    return activeSessionCount > 0;
  }
  
  public AbstractAvidAdSession findAvidAdSessionById(String paramString) {
    return (AbstractAvidAdSession)avidAdSessions.get(paramString);
  }
  
  public InternalAvidAdSession findInternalAvidAdSessionById(String paramString) {
    return (InternalAvidAdSession)internalAvidAdSessions.get(paramString);
  }
  
  public InternalAvidAdSession findInternalAvidAdSessionByView(View paramView) {
    for (Iterator localIterator = internalAvidAdSessions.values().iterator(); localIterator.hasNext();) { InternalAvidAdSession localInternalAvidAdSession;
      if ((localInternalAvidAdSession = (InternalAvidAdSession)localIterator.next()).doesManageView(paramView)) {
        return localInternalAvidAdSession;
      }
    }
    return null;
  }
  
  public void sessionDidEnd(InternalAvidAdSession paramInternalAvidAdSession)
  {
    avidAdSessions.remove(paramInternalAvidAdSession.getAvidAdSessionId());
    internalAvidAdSessions.remove(paramInternalAvidAdSession.getAvidAdSessionId());
    
    paramInternalAvidAdSession.setListener(null);
    if ((avidAdSessions.size() == 0) && (listener != null)) {
      listener.registryHasSessionsChanged(this);
    }
  }
  
  public void sessionHasBecomeActive(InternalAvidAdSession paramInternalAvidAdSession)
  {
    activeSessionCount += 1;
    if ((activeSessionCount == 1) && (listener != null)) {
      listener.registryHasActiveSessionsChanged(this);
    }
  }
  
  public void sessionHasResignedActive(InternalAvidAdSession paramInternalAvidAdSession)
  {
    activeSessionCount -= 1;
    if ((activeSessionCount == 0) && (listener != null)) {
      listener.registryHasActiveSessionsChanged(this);
    }
  }
}
