package com.paulhoang.rebornserviceclientexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "REBORN-SERVICE-CLIENT-EXAMPLE-2", fallback = Example2ClientFallback.class)
public interface Example2Client {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  String getHello();
}
