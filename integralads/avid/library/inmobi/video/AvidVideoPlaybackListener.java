package com.integralads.avid.library.inmobi.video;

public abstract interface AvidVideoPlaybackListener
{
  public abstract void recordAdImpressionEvent();
  
  public abstract void recordAdStartedEvent();
  
  public abstract void recordAdLoadedEvent();
  
  public abstract void recordAdVideoStartEvent();
  
  public abstract void recordAdStoppedEvent();
  
  public abstract void recordAdCompleteEvent();
  
  public abstract void recordAdClickThruEvent();
  
  public abstract void recordAdVideoFirstQuartileEvent();
  
  public abstract void recordAdVideoMidpointEvent();
  
  public abstract void recordAdVideoThirdQuartileEvent();
  
  public abstract void recordAdPausedEvent();
  
  public abstract void recordAdPlayingEvent();
  
  public abstract void recordAdExpandedChangeEvent();
  
  public abstract void recordAdUserMinimizeEvent();
  
  public abstract void recordAdUserAcceptInvitationEvent();
  
  public abstract void recordAdUserCloseEvent();
  
  public abstract void recordAdSkippedEvent();
  
  public abstract void recordAdVolumeChangeEvent(Integer paramInteger);
  
  public abstract void recordAdEnteredFullscreenEvent();
  
  public abstract void recordAdExitedFullscreenEvent();
  
  public abstract void recordAdDurationChangeEvent(String paramString1, String paramString2);
  
  public abstract void recordAdError(String paramString);
}
