package com.inmobi.commons.core.f;

import android.content.ContentValues;



public final class b
{
  public int a;
  public String b;
  public String c;
  public String d;
  public long e;
  public String f;
  public String g;
  public String h;
  public long i;
  public String j;
  long k;
  
  public b(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong2)
  {
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramLong1;
    f = paramString4;
    g = paramString5;
    h = paramString6;
    i = paramLong2;
    j = paramString7;
    k = System.currentTimeMillis();
  }
  











































  static b a(ContentValues paramContentValues)
  {
    Object localObject = paramContentValues.getAsString("eventId");
    String str1 = paramContentValues.getAsString("adMarkup");
    String str2 = paramContentValues.getAsString("eventName");
    long l1 = paramContentValues.getAsLong("imPlid").longValue();
    String str3 = paramContentValues.getAsString("requestId");
    String str4 = paramContentValues.getAsString("eventType");
    String str5 = paramContentValues.getAsString("dNettypeRaw");
    long l2 = paramContentValues.getAsLong("ts").longValue();
    String str6 = paramContentValues.getAsString("adtype");
    long l3 = paramContentValues.getAsLong("timestamp").longValue();
    
    bk = l3;
    a = paramContentValues.getAsInteger("id").intValue();
    return localObject;
  }
}
