package com.inmobi.commons.core.network;


public final class NetworkError
{
  public ErrorCode a;
  
  public String b;
  
  public static enum ErrorCode
  {
    NETWORK_UNAVAILABLE_ERROR(0), 
    UNKNOWN_ERROR(-1), 
    NETWORK_IO_ERROR(-2), 
    OUT_OF_MEMORY_ERROR(-3), 
    INVALID_ENCRYPTED_RESPONSE_RECEIVED(-4), 
    RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT(-5), 
    GZIP_DECOMPRESSION_FAILED(-6), 
    BAD_REQUEST(-7), 
    GDPR_COMPLIANCE_ENFORCED(-8), 
    HTTP_NO_CONTENT(204), 
    HTTP_NOT_MODIFIED(304), 
    HTTP_SEE_OTHER(303), 
    HTTP_SERVER_NOT_FOUND(404), 
    HTTP_MOVED_TEMP(302), 
    HTTP_INTERNAL_SERVER_ERROR(500), 
    HTTP_NOT_IMPLEMENTED(501), 
    HTTP_BAD_GATEWAY(502), 
    HTTP_SERVER_NOT_AVAILABLE(503), 
    HTTP_GATEWAY_TIMEOUT(504), 
    HTTP_VERSION_NOT_SUPPORTED(505);
    
    private int a;
    
    private ErrorCode(int paramInt) {
      a = paramInt;
    }
    
    public final int getValue() {
      return a;
    }
    
    public static ErrorCode fromValue(int paramInt)
    {
      if ((400 <= paramInt) && (500 > paramInt)) {
        return BAD_REQUEST;
      }
      ErrorCode[] arrayOfErrorCode;
      int i = (arrayOfErrorCode = values()).length; for (int j = 0; j < i; j++) { ErrorCode localErrorCode;
        if (a == paramInt) {
          return localErrorCode;
        }
      }
      
      return null;
    }
  }
  


  public NetworkError(ErrorCode paramErrorCode, String paramString)
  {
    a = paramErrorCode;
    b = paramString;
  }
}
