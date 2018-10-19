package com.inmobi.commons.core.network;









public final class f
  extends b
{
  public f(c paramC)
  {
    super(paramC);
  }
  
  /* Error */
  protected final d b()
  {
    // Byte code:
    //   0: new 14	com/inmobi/commons/core/network/d
    //   3: dup
    //   4: invokespecial 39	com/inmobi/commons/core/network/d:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 32	com/inmobi/commons/core/network/f:c	Ljava/net/HttpURLConnection;
    //   12: invokevirtual 48	java/net/HttpURLConnection:getResponseCode	()I
    //   15: istore_2
    //   16: new 19	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   23: aload_0
    //   24: getfield 31	com/inmobi/commons/core/network/f:b	Lcom/inmobi/commons/core/network/c;
    //   27: getfield 28	com/inmobi/commons/core/network/c:q	Ljava/lang/String;
    //   30: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 5
    //   35: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_2
    //   39: invokevirtual 43	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_0
    //   45: getfield 32	com/inmobi/commons/core/network/f:c	Ljava/net/HttpURLConnection;
    //   48: invokevirtual 47	java/net/HttpURLConnection:getContentLength	()I
    //   51: putfield 30	com/inmobi/commons/core/network/d:c	I
    //   54: aload_0
    //   55: getfield 32	com/inmobi/commons/core/network/f:c	Ljava/net/HttpURLConnection;
    //   58: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   61: goto +189 -> 250
    //   64: astore_3
    //   65: aload_0
    //   66: getfield 32	com/inmobi/commons/core/network/f:c	Ljava/net/HttpURLConnection;
    //   69: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   72: aload_3
    //   73: athrow
    //   74: pop
    //   75: aload_1
    //   76: new 10	com/inmobi/commons/core/network/NetworkError
    //   79: dup
    //   80: getstatic 24	com/inmobi/commons/core/network/NetworkError$ErrorCode:HTTP_GATEWAY_TIMEOUT	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   83: getstatic 24	com/inmobi/commons/core/network/NetworkError$ErrorCode:HTTP_GATEWAY_TIMEOUT	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   86: invokevirtual 36	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   89: invokespecial 35	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   92: putfield 29	com/inmobi/commons/core/network/d:b	Lcom/inmobi/commons/core/network/NetworkError;
    //   95: goto +155 -> 250
    //   98: pop
    //   99: aload_1
    //   100: new 10	com/inmobi/commons/core/network/NetworkError
    //   103: dup
    //   104: getstatic 25	com/inmobi/commons/core/network/NetworkError$ErrorCode:NETWORK_IO_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   107: getstatic 25	com/inmobi/commons/core/network/NetworkError$ErrorCode:NETWORK_IO_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   110: invokevirtual 36	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   113: invokespecial 35	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   116: putfield 29	com/inmobi/commons/core/network/d:b	Lcom/inmobi/commons/core/network/NetworkError;
    //   119: goto +131 -> 250
    //   122: pop
    //   123: aload_1
    //   124: new 10	com/inmobi/commons/core/network/NetworkError
    //   127: dup
    //   128: getstatic 26	com/inmobi/commons/core/network/NetworkError$ErrorCode:OUT_OF_MEMORY_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   131: getstatic 26	com/inmobi/commons/core/network/NetworkError$ErrorCode:OUT_OF_MEMORY_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   134: invokevirtual 36	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   137: invokespecial 35	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   140: putfield 29	com/inmobi/commons/core/network/d:b	Lcom/inmobi/commons/core/network/NetworkError;
    //   143: goto +107 -> 250
    //   146: astore_2
    //   147: aload_1
    //   148: new 10	com/inmobi/commons/core/network/NetworkError
    //   151: dup
    //   152: getstatic 27	com/inmobi/commons/core/network/NetworkError$ErrorCode:UNKNOWN_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   155: getstatic 27	com/inmobi/commons/core/network/NetworkError$ErrorCode:UNKNOWN_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   158: invokevirtual 36	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   161: invokespecial 35	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   164: putfield 29	com/inmobi/commons/core/network/d:b	Lcom/inmobi/commons/core/network/NetworkError;
    //   167: new 22	java/util/HashMap
    //   170: dup
    //   171: invokespecial 49	java/util/HashMap:<init>	()V
    //   174: dup
    //   175: astore_3
    //   176: ldc 8
    //   178: ldc 4
    //   180: invokeinterface 50 3 0
    //   185: pop
    //   186: aload_3
    //   187: ldc 6
    //   189: new 19	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   196: aload_2
    //   197: invokevirtual 40	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokeinterface 50 3 0
    //   211: pop
    //   212: invokestatic 33	com/inmobi/commons/core/e/b:a	()Lcom/inmobi/commons/core/e/b;
    //   215: pop
    //   216: ldc 7
    //   218: ldc 3
    //   220: aload_3
    //   221: invokestatic 34	com/inmobi/commons/core/e/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   224: goto +26 -> 250
    //   227: pop
    //   228: new 19	java/lang/StringBuilder
    //   231: dup
    //   232: ldc 2
    //   234: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: aload_2
    //   238: invokevirtual 40	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 1
    //   246: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: areturn
    // Line number table:
    //   Java source line #21	-> byte code offset #0
    //   Java source line #24	-> byte code offset #8
    //   Java source line #25	-> byte code offset #16
    //   Java source line #1118	-> byte code offset #27
    //   Java source line #25	-> byte code offset #30
    //   Java source line #27	-> byte code offset #43
    //   Java source line #2089	-> byte code offset #51
    //   Java source line #29	-> byte code offset #54
    //   Java source line #30	-> byte code offset #61
    //   Java source line #29	-> byte code offset #64
    //   Java source line #31	-> byte code offset #74
    //   Java source line #32	-> byte code offset #75
    //   Java source line #3070	-> byte code offset #92
    //   Java source line #53	-> byte code offset #95
    //   Java source line #33	-> byte code offset #98
    //   Java source line #34	-> byte code offset #99
    //   Java source line #4070	-> byte code offset #116
    //   Java source line #53	-> byte code offset #119
    //   Java source line #35	-> byte code offset #122
    //   Java source line #36	-> byte code offset #123
    //   Java source line #5070	-> byte code offset #140
    //   Java source line #53	-> byte code offset #143
    //   Java source line #37	-> byte code offset #146
    //   Java source line #42	-> byte code offset #147
    //   Java source line #6070	-> byte code offset #164
    //   Java source line #45	-> byte code offset #167
    //   Java source line #46	-> byte code offset #175
    //   Java source line #47	-> byte code offset #186
    //   Java source line #48	-> byte code offset #212
    //   Java source line #52	-> byte code offset #224
    //   Java source line #49	-> byte code offset #227
    //   Java source line #50	-> byte code offset #228
    //   Java source line #51	-> byte code offset #238
    //   Java source line #54	-> byte code offset #250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	f
    //   7	244	1	localD	d
    //   15	24	2	i	int
    //   146	92	2	localException1	Exception
    //   64	9	3	localObject	Object
    //   175	46	3	localHashMap	java.util.HashMap
    //   74	1	6	localSocketTimeoutException	java.net.SocketTimeoutException
    //   98	1	7	localIOException	java.io.IOException
    //   122	1	8	localOutOfMemoryError	OutOfMemoryError
    //   227	1	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   43	54	64	finally
    //   8	74	74	java/net/SocketTimeoutException
    //   8	74	98	java/io/IOException
    //   8	74	122	java/lang/OutOfMemoryError
    //   8	74	146	java/lang/Exception
    //   167	224	227	java/lang/Exception
  }
}
