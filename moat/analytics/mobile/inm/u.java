package com.moat.analytics.mobile.inm;

import android.media.MediaPlayer;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class u
  extends h
  implements NativeVideoTracker
{
  private WeakReference<MediaPlayer> m;
  
  u(String paramString)
  {
    super(paramString);
    p.a(3, "NativeVideoTracker", this, "In initialization method.");
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = "PartnerCode is " + (paramString == null ? "null" : "empty");
      String str = "NativeDisplayTracker creation problem, " + paramString;
      p.a("[ERROR] ", 3, "NativeVideoTracker", this, str);
      a = new m(paramString);
    }
    p.a("[SUCCESS] ", a() + " created");
  }
  
  boolean n()
  {
    return (m != null) && (m.get() != null);
  }
  
  String a()
  {
    return "NativeVideoTracker";
  }
  
  public boolean trackVideoAd(Map<String, String> paramMap, MediaPlayer paramMediaPlayer, View paramView)
  {
    try
    {
      c();
      d();
      a(paramMediaPlayer);
      m = new WeakReference(paramMediaPlayer);
      return super.a(paramMap, paramView);
    }
    catch (Exception localException)
    {
      m.a(paramMap = localException);
      paramMap = m.a("trackVideoAd", paramMap);
      if (d != null) {
        d.onTrackingFailedToStart(paramMap);
      }
      p.a(3, "NativeVideoTracker", this, paramMap);
      p.a("[ERROR] ", a() + " " + paramMap);
    }
    return false;
  }
  
  private void a(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null)
    {
      paramMediaPlayer = "Null player instance";
      throw new m(paramMediaPlayer);
    }
    try
    {
      paramMediaPlayer.getCurrentPosition();
      return;
    }
    catch (Exception localException)
    {
      throw new m("Playback has already completed");
    }
  }
  
  Integer o()
  {
    return Integer.valueOf(((MediaPlayer)m.get()).getCurrentPosition());
  }
  
  boolean q()
  {
    return ((MediaPlayer)m.get()).isPlaying();
  }
  
  Integer r()
  {
    return Integer.valueOf(((MediaPlayer)m.get()).getDuration());
  }
  
  void a(List<String> paramList)
  {
    if (!n()) {
      paramList.add("Player is null");
    }
    super.a(paramList);
  }
  
  Map<String, Object> i()
  {
    MediaPlayer localMediaPlayer = (MediaPlayer)m.get();
    HashMap localHashMap;
    (localHashMap = new HashMap()).put("width", Integer.valueOf(localMediaPlayer.getVideoWidth()));
    localHashMap.put("height", Integer.valueOf(localMediaPlayer.getVideoHeight()));
    localHashMap.put("duration", Integer.valueOf(localMediaPlayer.getDuration()));
    return localHashMap;
  }
}
