package com.WelcomeAPI.Rest;


// this class called another api
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WelcomeAPI.feign.GreetFeignClient;
@RestController
public class WelcomeController {
	
	@Autowired
	private GreetFeignClient greetFeignClient;  // autowire the interface we have created .
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		String greetresponse = greetFeignClient.invokeGreetApi();
		return greetresponse + "Welcome Nishchal Ghimire to our community";
		
		
	}

}
