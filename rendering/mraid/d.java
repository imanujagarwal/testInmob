package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.d.c;








public final class d
{
  public c a;
  
  public d()
  {
    a = c.b("mraid_js_store");
  }
  
  public final void a(String paramString) {
    a.a("mraid_js_string", paramString);
    a.a("last_updated_ts", System.currentTimeMillis() / 1000L);
  }
}
