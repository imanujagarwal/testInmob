package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.inmobi.commons.a.a;
import com.inmobi.rendering.RenderView;





@SuppressLint({"ClickableViewAccessibility"})
public final class MraidMediaProcessor
{
  private static final String f = MraidMediaProcessor.class.getSimpleName();
  public RenderView a;
  public MediaRenderView b;
  public RingerModeChangeReceiver c;
  public a d;
  public HeadphonesPluggedChangeReceiver e;
  
  public final class RingerModeChangeReceiver extends BroadcastReceiver { public RingerModeChangeReceiver(String paramString) { b = paramString; }
    
    private String b;
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("android.media.RINGER_MODE_CHANGED".equals(paramIntent.getAction()))) {
        paramContext = paramIntent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
        MraidMediaProcessor.f();
        MraidMediaProcessor.a(MraidMediaProcessor.this, b, 2 != paramContext);
      }
    }
  }
  
  public final class HeadphonesPluggedChangeReceiver extends BroadcastReceiver
  {
    private String b;
    
    public HeadphonesPluggedChangeReceiver(String paramString) {
      b = paramString;
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))) {
        paramContext = paramIntent.getIntExtra("state", 0);
        MraidMediaProcessor.f();
        MraidMediaProcessor.b(MraidMediaProcessor.this, b, 1 == paramContext);
      }
    }
  }
  
  public final class a extends ContentObserver
  {
    private Context b;
    private int c;
    private String d;
    
    public a(String paramString, Context paramContext, Handler paramHandler) {
      super();
      d = paramString;
      b = paramContext;
      c = -1;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      
      if (b != null)
      {


        if ((paramBoolean = ((AudioManager)b.getSystemService("audio")).getStreamVolume(3)) != c) {
          c = paramBoolean;
          MraidMediaProcessor.a(MraidMediaProcessor.this, d, paramBoolean);
        }
      }
    }
  }
  





  public MraidMediaProcessor(RenderView paramRenderView)
  {
    a = paramRenderView;
  }
  










































































  public static boolean a()
  {
    if ((localObject = a.b()) == null) return false;
    Object localObject = (AudioManager)((Context)localObject).getSystemService("audio");
    return 2 != ((AudioManager)localObject).getRingerMode();
  }
  





  public final void b()
  {
    Context localContext;
    



    if ((localContext = a.b()) == null) return;
    if (c != null) {
      localContext.unregisterReceiver(c);
      c = null;
    }
  }
  




  public final void c()
  {
    Context localContext;
    



    if ((localContext = a.b()) == null) return;
    if (d != null) {
      localContext.getContentResolver().unregisterContentObserver(d);
      d = null;
    }
  }
  






  public static boolean d()
  {
    Context localContext;
    




    if ((localContext = a.b()) == null) { return false;
    }
    return ((AudioManager)localContext.getSystemService("audio")).isWiredHeadsetOn();
  }
  





  public final void e()
  {
    Context localContext;
    



    if ((localContext = a.b()) == null) return;
    if (e != null) {
      localContext.unregisterReceiver(e);
      e = null;
    }
  }
}
