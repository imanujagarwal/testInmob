package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.commons.a.a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;






@SuppressLint({"ViewConstructor"})
public final class MediaRenderView
  extends VideoView
  implements Application.ActivityLifecycleCallbacks, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static final String l = MediaRenderView.class.getSimpleName();
  
  public CustomMediaController a;
  
  public Bitmap b;
  
  public ViewGroup c;
  public a d;
  private boolean m = false;
  
  private MediaPlayer n;
  private WeakReference<Activity> o;
  int e;
  boolean f;
  public String g;
  public String h;
  boolean i;
  int j;
  int k;
  
  public MediaRenderView(Activity paramActivity)
  {
    super(paramActivity);
    
    setZOrderOnTop(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT < 28) {
      setDrawingCacheEnabled(true);
    }
    e = 100;
    j = -1;
    k = 0;
    f = false;
    o = new WeakReference(paramActivity);
    paramActivity.getApplication().registerActivityLifecycleCallbacks(this);
  }
  
  protected final void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    new StringBuilder(">>> onWindowVisibilityChanged (").append(paramInt).append(")");
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getHolder().setSizeFromLayout();
  }
  

  @TargetApi(16)
  protected final void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    new StringBuilder(">>> onVisibilityChanged (").append(paramInt).append(")");
    if (paramInt == 0) {
      if (Build.VERSION.SDK_INT >= 16)
      {
        if ((paramView = a.b()) != null) {
          setBackground(new BitmapDrawable(paramView.getResources(), b));
        }
        return; }
      setBackgroundDrawable(new BitmapDrawable(b));
    }
  }
  


  public final void onCompletion(MediaPlayer paramMediaPlayer) {}
  


  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    new StringBuilder(">>> onError (").append(paramInt1).append(", ").append(paramInt2).append(")");
    a();
    return false;
  }
  






  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    n = paramMediaPlayer;
    paramMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2) {
        MediaRenderView.b();
        if (null == MediaRenderView.a(MediaRenderView.this)) {
          MediaRenderView.a(MediaRenderView.this, new MediaRenderView.CustomMediaController(getContext()));
          MediaRenderView.a(MediaRenderView.this).setAnchorView(MediaRenderView.this);
          setMediaController(MediaRenderView.a(MediaRenderView.this));
          requestLayout();
          requestFocus();
        }
        
      }
    });
    int i1 = k;paramMediaPlayer = this;
    

























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    if (i1 < paramMediaPlayer.getDuration()) {
      k = i1;
      paramMediaPlayer.seekTo(i1);
    }
    i = true;
    d.a();
    start();
  }
  
  public final void setPlaybackData(String paramString) {
    h = a(paramString);
    g = "anonymous";
    
    if (b == null) {
      b = Bitmap.createBitmap(24, 24, Bitmap.Config.ARGB_8888);
      b = b(h);
    }
  }
  
  public final void start()
  {
    if (m) {
      return;
    }
    
    super.start();
  }
  

  public final void pause()
  {
    super.pause();
  }
  


























  public final void a()
  {
    stopPlayback();
    
































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    MediaRenderView localMediaRenderView = this; if (c != null) {
      ViewGroup localViewGroup;
      if ((localViewGroup = (ViewGroup)c.getParent()) != null) {
        localViewGroup.removeView(c);
      }
      

      if ((localViewGroup = (ViewGroup)localMediaRenderView.getParent()) != null) {
        localViewGroup.removeView(localMediaRenderView);
      }
      
      localMediaRenderView.setBackgroundColor(0);
      c = null;
    }
    super.setMediaController(null);
    a = null;
    if (d != null) {
      d.a(this);
    }
  }
  
  public final ViewGroup getViewContainer() {
    return c;
  }
  
  public final void setViewContainer(ViewGroup paramViewGroup) {
    c = paramViewGroup;
  }
  
  public final void setListener(a paramA) {
    d = paramA;
  }
  




















  public static String a(String paramString)
  {
    String str = "";
    paramString = paramString.getBytes();
    
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString;int i1 = paramString.length; for (int i2 = 0; i2 < i1; i2++) { int i3;
      char[] arrayOfChar1; if (((i3 = paramString[i2]) & 0x80) > 0)
      {






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        char[] arrayOfChar2 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        
        arrayOfChar1 = new char[] { arrayOfChar2[(i3 >> 4 & 0xF)], arrayOfChar2[(i3 & 0xF)] };localStringBuilder.append("%").append(
          new String(arrayOfChar1));
      }
      else
      {
        localStringBuilder.append((char)arrayOfChar1);
      }
    }
    try
    {
      return new String(localStringBuilder.toString().getBytes(), "ISO-8859-1");
    } catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return str;
  }
  


  public static Bitmap b(String paramString)
  {
    try
    {
      return (Bitmap)Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[] { String.class, Integer.TYPE }).invoke(null, new Object[] { paramString, Integer.valueOf(1) });
    } catch (ClassNotFoundException localClassNotFoundException) {
      return null;
    } catch (InvocationTargetException localInvocationTargetException) {
      return null;
    } catch (NoSuchMethodException localNoSuchMethodException) {
      return null;
    } catch (IllegalAccessException localIllegalAccessException) {}
    return null;
  }
  




  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  



  static class CustomMediaController
    extends MediaController
  {
    public CustomMediaController(Context paramContext)
    {
      super();
    }
    
    public final void show(int paramInt)
    {
      super.show(paramInt);
      
      if (Build.VERSION.SDK_INT < 19) {
        try
        {
          (paramInt = MediaController.class.getDeclaredField("mAnchor")).setAccessible(true);
          paramInt = (View)paramInt.get(this);
          
          (
            localObject1 = MediaController.class.getDeclaredField("mDecor")).setAccessible(true);
          Object localObject1 = (View)((Field)localObject1).get(this);
          
          (
            localObject2 = MediaController.class.getDeclaredField("mDecorLayoutParams")).setAccessible(true);
          Object localObject2 = (WindowManager.LayoutParams)((Field)localObject2).get(this);
          
          (
            localObject3 = MediaController.class.getDeclaredField("mWindowManager")).setAccessible(true);
          Object localObject3 = (WindowManager)((Field)localObject3).get(this);
          

          int[] arrayOfInt = new int[2];
          paramInt.getLocationOnScreen(arrayOfInt);
          


          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(paramInt.getWidth(), Integer.MIN_VALUE), 
            View.MeasureSpec.makeMeasureSpec(paramInt.getHeight(), Integer.MIN_VALUE));
          
          ((View)localObject1).setPadding(0, 0, 0, 0);
          
          verticalMargin = 0.0F;
          horizontalMargin = 0.0F;
          width = paramInt.getWidth();
          gravity = 8388659;
          x = arrayOfInt[0];
          y = (arrayOfInt[1] + paramInt.getHeight() - ((View)localObject1).getMeasuredHeight());
          ((WindowManager)localObject3).updateViewLayout((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          

          return;
        }
        catch (Exception localException) {}
      }
    }
  }
  



  public final void onActivityStarted(Activity paramActivity)
  {
    if ((o.get() != null) && (((Activity)o.get()).equals(paramActivity))) {
      m = false;
      

      start();
    }
  }
  


  public final void onActivityResumed(Activity paramActivity) {}
  


  public final void onActivityPaused(Activity paramActivity) {}
  

  public final void onActivityStopped(Activity paramActivity)
  {
    Activity localActivity;
    
    if (((localActivity = (Activity)o.get()) != null) && (localActivity.equals(paramActivity))) {
      m = true;
      if (getCurrentPosition() != 0) {
        k = getCurrentPosition();
      }
      pause();
    }
  }
  


  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  


  public final void onActivityDestroyed(Activity paramActivity)
  {
    paramActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
  }
  
  static abstract interface a
  {
    public abstract void a(MediaRenderView paramMediaRenderView);
    
    public abstract void a();
  }
}
