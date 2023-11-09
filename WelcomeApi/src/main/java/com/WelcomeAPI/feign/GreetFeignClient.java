package com.WelcomeAPI.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// we create this interface to communicate another client.
@FeignClient(name = "GREET-API") // this GREET-API name has to be  match in eureka server in which we have try to communicate.
public interface GreetFeignClient {
	@GetMapping("/greet")  // this greet has to be match with the end point we try to communicate.
	public String  invokeGreetApi() ;

}
