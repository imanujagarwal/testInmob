package com.inmobi.commons.core.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;





public final class a
  extends SQLiteOpenHelper
{
  public static final String a = "com.im_7.2.1.db";
  
  public a(Context paramContext)
  {
    super(paramContext, a, null, 1);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}
