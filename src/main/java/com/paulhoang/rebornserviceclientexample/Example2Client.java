package com.paulhoang.rebornserviceclientexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "reborn-service-client-example-2", fallback = Example2ClientFallback.class)
public interface Example2Client {

  @RequestMapping("/hello")
  String getHello();
}
