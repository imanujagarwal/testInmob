package com.inmobi.rendering;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.view.View;

























public class CustomView
  extends View
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  private int f;
  private int g;
  private Paint h;
  private Path i;
  private RectF j;
  
  private CustomView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomView(Context paramContext, float paramFloat, int paramInt) {
    this(paramContext);
    f = paramInt;
    a = paramFloat;
    g = 15;
    h = new Paint(1);
    j = new RectF();
    i = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    h.reset();
    float f1; float f2; switch (f)
    {
    case 12: 
      d = (50.0F * a / 2.0F);
      b = (3.0F * a);
      c = (3.0F * a);
      
      h.setStyle(Paint.Style.STROKE);
      h.setStrokeWidth(4.0F);
      h.setColor(-1);
      
      i.moveTo(d - b, d - c - 5.0F * a);
      i.lineTo(d - b, d - c);
      i.lineTo(d - b - 5.0F * a, d - c);
      
      i.moveTo(d + b, d - c - 5.0F * a);
      
      i.lineTo(d + b, d - c);
      i.lineTo(d + b + 5.0F * a, d - c);
      
      i.moveTo(d - b, d + c + 5.0F * a);
      
      i.lineTo(d - b, d + c);
      i.lineTo(d - b - 5.0F * a, d + c);
      
      i.moveTo(d + b, d + c + 5.0F * a);
      
      i.lineTo(d + b, d + c);
      i.lineTo(d + b + 5.0F * a, d + c);
      
      paramCanvas.drawPath(i, h);
      
      return;
    case 11: 
      a(paramCanvas);
      h.setColor(-1);
      h.setStrokeWidth(4.0F);
      h.setStyle(Paint.Style.STROKE);
      i.moveTo(d + 10.0F * a, d - c);
      i.lineTo(d + 18.0F * a, d + c);
      i.moveTo(d + 18.0F * a, d - c);
      i.lineTo(d + 10.0F * a, d + c);
      paramCanvas.drawPath(i, h);
      return;
    
    case 9: 
      a(paramCanvas);
      Canvas localCanvas = paramCanvas;CustomView localCustomView = this;
      





































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      RectF localRectF1 = new RectF(d - 10.0F * a, d - c - 2.0F * a, d + 14.0F * a, d + c + 2.0F * a);
      RectF localRectF2 = new RectF(d - 10.0F * a, d - c - 4.0F * a, d + 18.0F * a, d + c + 4.0F * a);
      h.setColor(-1);
      h.setStrokeWidth(4.0F);
      h.setStyle(Paint.Style.STROKE);
      localCanvas.drawArc(localRectF1, -45.0F, 90.0F, false, h);
      localCanvas.drawArc(localRectF2, -45.0F, 90.0F, false, h);
      localCanvas.drawPath(i, h);paramCanvas.drawPath(i, h);return;
    case 8: 
      b(paramCanvas);
      b = (e / 4.0F);
      c = (e / 3.0F);
      
      paramCanvas.drawLine(d - b, d - c, d - b, d + c, h);
      paramCanvas.drawLine(d + b, d - c, d + b, d + c, h);
      
      return;
    case 7: 
      b(paramCanvas);
      b = (e / 3.0F);
      c = (e / 3.0F);
      
      h.setStyle(Paint.Style.FILL);
      
      i.moveTo(d + b, d);
      i.lineTo(d - b, d - c);
      i.lineTo(d - b, d + c);
      i.lineTo(d + b, d);
      paramCanvas.drawPath(i, h);
      return;
    
    case 0: 
      f1 = 50.0F * a / 2.0F;
      f2 = 30.0F * a / 2.0F;
      float f3 = f1 - f2 / 3.0F;
      float f4 = f1 + f2 / 3.0F;
      
      h.setAntiAlias(true);
      h.setColor(-16777216);
      h.setStrokeWidth(3.0F);
      h.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawCircle(f1, f1, f2, h);
      h.setColor(-1);
      h.setStyle(Paint.Style.STROKE);
      paramCanvas.drawLine(f3, f3, f4, f4, h);
      paramCanvas.drawLine(f3, f4, f4, f3, h);
      paramCanvas.drawCircle(f1, f1, f2, h);
      return;
    
    case 3: 
      f1 = 50.0F * a / 2.0F;
      f2 = 30.0F * a / 2.0F;
      
      i.reset();
      h.setAntiAlias(true);
      h.setColor(-16777216);
      h.setStrokeWidth(3.0F);
      h.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawCircle(f1, f1, f2, h);
      
      h.setColor(-1);
      h.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(f1, f1, f2, h);
      j.set(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 - g * a / 2.0F, getWidth() / 2 + g * a / 2.0F, getHeight() / 2 + g * a / 2.0F);
      paramCanvas.drawArc(j, 0.0F, 270.0F, false, h);
      i.setFillType(Path.FillType.EVEN_ODD);
      i.moveTo(getWidth() / 2 + g * a / 2.0F, getHeight() / 2 - 2.0F * a);
      i.lineTo(getWidth() / 2 + g * a / 2.0F - 2.0F * a, getHeight() / 2);
      i.lineTo(getWidth() / 2 + g * a / 2.0F + 2.0F * a, getHeight() / 2);
      i.lineTo(getWidth() / 2 + g * a / 2.0F, getHeight() / 2 - 2.0F * a);
      i.close();
      h.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawPath(i, h);
      return;
    
    case 1: 
      f1 = 50.0F * a / 2.0F;
      h.setAntiAlias(true);
      h.setColor(0);
      h.setStrokeWidth(3.0F);
      h.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawCircle(f1, f1, f1, h);
      return;
    
    case 5: 
      i.reset();
      i.setFillType(Path.FillType.EVEN_ODD);
      i.moveTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 - g * a / 2.0F);
      i.lineTo(getWidth() / 2 + g * a / 2.0F, getHeight() / 2);
      i.lineTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 + g * a / 2.0F);
      i.lineTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 - g * a / 2.0F);
      i.close();
      
      h.setAntiAlias(true);
      h.setColor(-16777216);
      h.setStrokeWidth(3.0F);
      h.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawPath(i, h);
      return;
    
    case 6: 
      i.reset();
      i.setFillType(Path.FillType.EVEN_ODD);
      i.moveTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 - g * a / 2.0F);
      i.lineTo(getWidth() / 2 + g * a / 2.0F, getHeight() / 2);
      i.lineTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 + g * a / 2.0F);
      i.lineTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 - g * a / 2.0F);
      i.close();
      
      h.setAntiAlias(true);
      h.setColor(-12303292);
      h.setStrokeWidth(3.0F);
      h.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawPath(i, h);
      return;
    
    case 4: 
      i.reset();
      i.setFillType(Path.FillType.EVEN_ODD);
      i.moveTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2);
      i.lineTo(getWidth() / 2 + g * a / 2.0F, getHeight() / 2 - g * a / 2.0F);
      i.lineTo(getWidth() / 2 + g * a / 2.0F, getHeight() / 2 + g * a / 2.0F);
      i.lineTo(getWidth() / 2 - g * a / 2.0F, getHeight() / 2);
      i.close();
      
      h.setAntiAlias(true);
      h.setColor(-16777216);
      h.setStrokeWidth(3.0F);
      h.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawPath(i, h);
      return;
    
    case 2: 
      h.setAntiAlias(true);
      h.setColor(-1);
      h.setStrokeWidth(5.0F);
      h.setStyle(Paint.Style.STROKE);
      paramCanvas.drawLine(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 - g * a / 2.0F, getWidth() / 2 + g * a / 2.0F, getHeight() / 2 + g * a / 2.0F, h);
      paramCanvas.drawLine(getWidth() / 2 - g * a / 2.0F, getHeight() / 2 + g * a / 2.0F, getWidth() / 2 + g * a / 2.0F, getHeight() / 2 - g * a / 2.0F, h);
    }
    
  }
  
  private void a(Canvas paramCanvas)
  {
    d = (30.0F * a / 2.0F - 5.0F * a);
    b = (5.0F * a);
    c = (5.0F * a);
    
    h.setStyle(Paint.Style.FILL);
    h.setColor(-1);
    h.setStrokeWidth(4.0F);
    h.setAntiAlias(true);
    i.moveTo(d - b, d - c);
    i.lineTo(d, d - c);
    i.lineTo(d + 6.0F * a, d - c - 4.0F * a);
    i.lineTo(d + 6.0F * a, d + c + 4.0F * a);
    i.lineTo(d, d + c);
    i.lineTo(d - b, d + c);
    i.lineTo(d - b, d - c);
    paramCanvas.drawPath(i, h);
  }
  











  private void b(Canvas paramCanvas)
  {
    e = (25.0F * a);
    d = (30.0F * a);
    h.setAntiAlias(true);
    h.setColor(-1);
    h.setStrokeWidth(7.0F);
    h.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(d, d, e, h);
  }
  
  public void setSwitchInt(int paramInt) {
    f = paramInt;
  }
}
