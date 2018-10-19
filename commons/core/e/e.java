package com.inmobi.commons.core.e;

import android.content.ContentValues;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;






public class e
  extends com.inmobi.commons.core.b.b
{
  private static final String a = e.class.getSimpleName();
  










  public e()
  {
    com.inmobi.commons.core.d.b localB;
    









    (localB = com.inmobi.commons.core.d.b.a()).a("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventId TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
    localB.b();
  }
  







  public static List<f> a(int paramInt)
  {
    Object localObject;
    






    paramInt = (localObject = com.inmobi.commons.core.d.b.a()).a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(paramInt));
    ArrayList localArrayList = new ArrayList();
    ((com.inmobi.commons.core.d.b)localObject).b();
    for (paramInt = paramInt.iterator(); paramInt.hasNext();) { localObject = (ContentValues)paramInt.next();
      localArrayList.add(f.a((ContentValues)localObject));
    }
    return localArrayList;
  }
  
  public final boolean a(long paramLong, String paramString)
  {
    paramString = a(1);
    boolean bool = false;
    if ((paramString.size() > 0) && 
      (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - 
      

































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      get0e) > paramLong)) {
      bool = true;
    }
    
    return bool;
  }
  

  public final int a(String paramString)
  {
    int i = (paramString = com.inmobi.commons.core.d.b.a()).a("telemetry");
    paramString.b();
    return i;
  }
  
  public final int b(long paramLong, String paramString)
  {
    paramString = com.inmobi.commons.core.d.b.a();
    long l = System.currentTimeMillis() - paramLong * 1000L;
    paramLong = paramString.a("telemetry", "ts<?", new String[] { String.valueOf(l) });
    new StringBuilder("Deleted ").append(paramLong).append(" expired events from telemetry DB");
    paramString.b();
    return paramLong;
  }
  
  public final void a(List<Integer> paramList)
  {
    if (paramList.isEmpty())
      return;
    com.inmobi.commons.core.d.b localB = com.inmobi.commons.core.d.b.a();
    StringBuffer localStringBuffer = new StringBuffer("");
    for (int i = 0; i < paramList.size() - 1; i++) {
      localStringBuffer.append(paramList.get(i)).append(",");
    }
    localStringBuffer.append(String.valueOf(paramList.get(paramList.size() - 1)));
    
    localB.a("telemetry", "id IN (" + localStringBuffer + ")", null);
    localB.b();
  }
  
  public static void a()
  {
    com.inmobi.commons.core.d.b localB;
    Object localObject;
    if (!(localObject = (localB = com.inmobi.commons.core.d.b.a()).a("telemetry", null, null, null, null, null, "ts ASC", "1")).isEmpty())
    {
      localObject = ((ContentValues)((List)localObject).get(0)).getAsString("id");
      
      localB.a("telemetry", "id IN (" + (String)localObject + ")", null);
    }
    
    localB.b();
  }
  

  public final void c(long paramLong, String paramString)
  {
    if (a.a()) {
      c.b("batch_processing_info").a("telemetry_last_batch_process", paramLong);
    }
  }
  
  public final long b(String paramString)
  {
    if (a.a()) {
      return c.b("batch_processing_info").b("telemetry_last_batch_process", -1L);
    }
    return -1L;
  }
  























































































































































































































































































































  public static void a(f paramF)
  {
    com.inmobi.commons.core.d.b localB;
    





















































































































































































































































































































    ContentValues localContentValues;
    





















































































































































































































































































































    (localContentValues = new ContentValues()).put("eventId", 
    




























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      b);localContentValues.put("componentType", 
    


      d);localContentValues.put("eventType", 
    


      c);localContentValues.put("payload", paramF.a());localContentValues.put("ts", String.valueOf(
    






      e));(localB = com.inmobi.commons.core.d.b.a()).a("telemetry", localContentValues);localB.b();
  }
}
