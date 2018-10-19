package com.inmobi.commons.core.utilities.a;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;



public class c
{
  private static final String a = c.class.getSimpleName();
  



  public c() {}
  


  @SuppressLint({"TrulyRandom"})
  public static String a(String paramString)
  {
    String str = null;
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    try
    {
      Object localObject1 = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
      Object localObject2 = new BigInteger("010001", 16);
      KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
      localObject1 = new RSAPublicKeySpec((BigInteger)localObject1, (BigInteger)localObject2);
      localObject1 = (RSAPublicKey)localKeyFactory.generatePublic((KeySpec)localObject1);
      
      (
        localObject2 = Cipher.getInstance("RSA/ECB/nopadding")).init(1, (Key)localObject1);
      


      paramString = Base64.encode(a(paramString.getBytes("UTF-8"), (Cipher)localObject2), 0);
      
      str = new String(paramString);
    }
    catch (Exception localException)
    {
      new StringBuilder("SDK encountered unexpected error in getting encrypted UID-map; ").append(localException.getMessage());
    }
    return str;
  }
  

  private static byte[] a(byte[] paramArrayOfByte, Cipher paramCipher)
    throws IllegalBlockSizeException, BadPaddingException
  {
    byte[] arrayOfByte3 = new byte[0];
    

    int j = paramArrayOfByte.length;
    
    byte[] arrayOfByte1 = new byte[64];
    
    for (int k = 0; k < j; k++) {
      if ((k > 0) && (k % 64 == 0)) {
        arrayOfByte1 = paramCipher.doFinal(arrayOfByte1);
        arrayOfByte3 = a(arrayOfByte3, arrayOfByte1);
        int i = 64;
        if (k + 64 > j) {
          i = j - k;
        }
        arrayOfByte2 = new byte[i];
      }
      arrayOfByte2[(k % 64)] = paramArrayOfByte[k];
    }
    
    byte[] arrayOfByte2 = paramCipher.doFinal(arrayOfByte2);
    
    return a(arrayOfByte3, arrayOfByte2);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
}
