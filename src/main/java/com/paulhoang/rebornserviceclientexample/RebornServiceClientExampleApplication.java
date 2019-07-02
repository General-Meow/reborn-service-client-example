package com.paulhoang.rebornserviceclientexample;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class RebornServiceClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RebornServiceClientExampleApplication.class, args);
	}

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private Example2Client example2Client;

	@GetMapping(path = "/test")
	public String test() {
		InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("REBORN-SERVICE-CLIENT-EXAMPLE-2", false);
		return "client 2 homepage: " + nextServerFromEureka.getHomePageUrl();
	}

	@GetMapping(path = "/feignTest")
	public String feignTest() {
		return example2Client.getHello();
	}
}
