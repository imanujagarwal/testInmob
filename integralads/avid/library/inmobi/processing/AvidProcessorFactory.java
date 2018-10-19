package com.integralads.avid.library.inmobi.processing;

public class AvidProcessorFactory
{
  private AvidSceenProcessor screenProcessor;
  private AvidViewProcessor viewProcessor;
  
  public AvidProcessorFactory() {
    viewProcessor = new AvidViewProcessor();
    screenProcessor = new AvidSceenProcessor(viewProcessor);
  }
  
  public IAvidNodeProcessor getRootProcessor() {
    return screenProcessor;
  }
}
