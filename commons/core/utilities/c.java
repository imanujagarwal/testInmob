package com.inmobi.commons.core.utilities;

import android.net.Uri;
import java.io.File;

public class c
{
  private static final String a = c.class.getSimpleName();
  
  public c() {}
  
  public static void a(File paramFile) {
    try {
      if (paramFile.exists()) {
        File[] arrayOfFile;
        if ((arrayOfFile = paramFile.listFiles()) != null) {
          int i = (arrayOfFile = arrayOfFile).length; for (int j = 0; j < i; j++) { File localFile;
            if ((localFile = arrayOfFile[j]).isDirectory()) {
              a(localFile);
            } else {
              localFile.delete();
            }
          }
        }
        paramFile.delete();
      }
      return;
    }
    catch (Exception localException) {
      new StringBuilder("SDK encountered unexpected error in deleting directory; ").append(localException.getMessage());
    }
  }
  
  public static long a(String paramString) {
    long l = 0L;
    try
    {
      if ((paramString = new File(Uri.parse(paramString).getPath())).exists()) {
        l = paramString.length();
      }
    } catch (Exception localException) {
      l = 0L;
    }
    
    return l;
  }
}
