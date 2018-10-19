package com.integralads.avid.library.inmobi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



public class NetworkUtils
{
  public NetworkUtils() {}
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    return ((paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo()) != null) && (paramContext.isConnectedOrConnecting());
  }
}
