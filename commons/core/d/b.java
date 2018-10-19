package com.inmobi.commons.core.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;





public final class b
{
  private static final String a = b.class.getSimpleName();
  private static volatile b b;
  private static final Object c = new Object();
  private static final Object d = new Object();
  

  private static int e = 0;
  private SQLiteDatabase f;
  
  private b() {
    a localA = new a(com.inmobi.commons.a.a.b());
    try {
      f = localA.getWritableDatabase();
      b = this;
      

      return;
    } catch (Exception localException) {}
  }
  
  public static synchronized b a() { synchronized (d) {
      e += 1;
    }
    
    if ((??? = b) == null) {
      synchronized (c)
      {
        if ((??? = b) == null)
        {
          ??? = b.b = new b();
        }
      }
    }
    return localB;
  }
  
  public final synchronized void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try {
      if (!a(paramString1, paramContentValues)) {
        b(paramString1, paramContentValues, paramString2, paramArrayOfString);
      }
      return;
    } catch (Exception paramString1) {
      new StringBuilder("SDK encountered unexpected error in DbStore.insertOrUpdate() method; ").append(paramString1.getMessage());
    }
  }
  
  public final synchronized boolean a(String paramString, ContentValues paramContentValues)
  {
    try {
      return f.insertWithOnConflict(paramString, null, paramContentValues, 4) != -1L;
    }
    catch (Exception paramString) {
      new StringBuilder("SDK encountered unexpected error in DbStore.insert() method; ").append(paramString.getMessage()); }
    return false;
  }
  
  public final synchronized int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try {
      return f.delete(paramString1, paramString2, paramArrayOfString);
    }
    catch (Exception paramString1) {
      new StringBuilder("SDK encountered an unexpected error in DbStore.delete() method; ").append(paramString1.getMessage()); }
    return -1;
  }
  



  public final synchronized int b(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      return f.updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 4);
    }
    catch (Exception paramString1) {
      new StringBuilder("SDK encountered an unexpected error in DbStore.delete() method; ").append(paramString1.getMessage()); }
    return -1;
  }
  
  public final synchronized List<ContentValues> a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = null;
    
    try
    {
      if ((localCursor = f.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6)).moveToFirst()) {
        do {
          paramString1 = new ContentValues();
          DatabaseUtils.cursorRowToContentValues(localCursor, paramString1);
          localArrayList.add(paramString1);
        } while (localCursor.moveToNext());
      }
      
      localCursor.close();
    }
    catch (Exception paramString1) {
      new StringBuilder("SDK encountered unexpected error in DbStore.getRows() method; ").append(paramString1.getMessage());
    } finally {
      if (localCursor != null) localCursor.close();
    }
    return localArrayList;
  }
  
  public final synchronized int a(String paramString) {
    try {
      paramString = "SELECT COUNT(*) FROM " + paramString + " ; ";
      (
        paramString = f.rawQuery(paramString, null)).moveToFirst();
      int i = paramString.getInt(0);
      paramString.close();
      return i;
    }
    catch (Exception paramString) {
      new StringBuilder("SDK encountered unexpected error in DbStore.getCount() method; ").append(paramString.getMessage()); }
    return -1;
  }
  
  public final synchronized int b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try {
      paramString1 = "SELECT COUNT(*) FROM " + paramString1 + " WHERE " + paramString2 + " ; ";
      (
        paramString1 = f.rawQuery(paramString1, paramArrayOfString)).moveToFirst();
      paramString2 = paramString1.getInt(0);
      paramString1.close();
      return paramString2;
    }
    catch (Exception paramString1) {
      new StringBuilder("SDK encountered unexpected error in DbStore.getCount() method; ").append(paramString1.getMessage()); }
    return -1;
  }
  









  public final synchronized void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = "CREATE TABLE IF NOT EXISTS " + paramString1 + paramString2 + ";";
      f.execSQL(paramString1); return;
    }
    catch (Exception paramString1) {
      new StringBuilder("SDK encountered unexpected error in DbStore.createTableIfNotExists() method; ").append(paramString1.getMessage());
    }
  }
  
  public final synchronized void b() {
    try {
      synchronized (d)
      {
        if (--e == 0) {
          f.close();
          b = null;
        }
        return;
      }
    } catch (Exception localException) {
      new StringBuilder("SDK encountered unexpected error in DbStore.close() method; ").append(localException.getMessage());
    }
  }
}
