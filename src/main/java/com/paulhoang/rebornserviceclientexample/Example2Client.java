package com.paulhoang.rebornserviceclientexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "REBORN-SERVICE-CLIENT-EXAMPLE-2", fallback = Example2ClientFallback.class)
public interface Example2Client {

  @RequestMapping("/hello")
  String getHello();
}
