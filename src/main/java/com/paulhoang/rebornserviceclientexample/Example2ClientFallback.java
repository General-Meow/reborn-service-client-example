package com.paulhoang.rebornserviceclientexample;

import org.springframework.stereotype.Component;

@Component
public class Example2ClientFallback implements Example2Client {
  @Override
  public String getHello() {
    return "This is the fallback string";
  }
}
