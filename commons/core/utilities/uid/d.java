package com.inmobi.commons.core.utilities.uid;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;









public class d
{
  private Map<String, Boolean> a;
  
  public d(Map<String, Boolean> paramMap)
  {
    a = paramMap;
  }
  






























  public final Map<String, String> a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str = null;
    try
    {
      if (((Boolean)a.get("GPID")).booleanValue()) {
        c.a();
        a localA; if (((localA = c.f()) != null) && ((str = 
        



























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































          a) != null))
        {
          if (paramBoolean) {
            str = a(str, paramString);
          }
          localHashMap.put("GPID", str);
        }
      }
      a(paramString, paramBoolean, localHashMap, str);
    } catch (Exception localException) {
      d.class.getSimpleName();
      
      a(paramString, paramBoolean, localHashMap, str);
    }
    return localHashMap;
  }
  
  private void a(String paramString1, boolean paramBoolean, Map<String, String> paramMap, String paramString2) {
    try { String str;
      if ((((Boolean)a.get("UM5")).booleanValue()) && 
        (paramString2 == null)) {
        c.a();c.a();str = 
        
















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































          c.a(c.e(), "MD5");
        if (paramBoolean) {
          str = a(str, paramString1);
        }
        paramMap.put("UM5", str);
      }
      

      if ((((Boolean)a.get("O1")).booleanValue()) && 
        (paramString2 == null)) {
        c.a();c.a();str = 
        









































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































          c.a(c.e(), "SHA-1");
        if (paramBoolean) {
          str = a(str, paramString1);
        }
        paramMap.put("O1", str);
      }
      return;
    } catch (Exception localException) {
      d.class.getSimpleName();
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    String str = "";
    
    try
    {
      byte[] arrayOfByte1 = new byte[(paramString1 = paramString1.getBytes("UTF-8")).length];
      paramString2 = paramString2.getBytes("UTF-8");
      
      for (int i = 0; i < paramString1.length; i++) {
        arrayOfByte1[i] = ((byte)(paramString1[i] ^ paramString2[(i % paramString2.length)]));
      }
      byte[] arrayOfByte2 = Base64.encode(arrayOfByte1, 2);
      str = new String(arrayOfByte2, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    

    return str;
  }
}