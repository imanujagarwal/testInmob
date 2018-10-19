package com.inmobi.commons.core.utilities.a;

import com.inmobi.commons.core.d.c;











public final class a
{
  c a;
  
  public a()
  {
    a = c.b("aes_key_store");
  }
  
  public final void a(String paramString) {
    a.a("aes_public_key", paramString);
    a.a("last_generated_ts", System.currentTimeMillis() / 1000L);
  }
}
