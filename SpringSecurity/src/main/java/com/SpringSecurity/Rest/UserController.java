package com.SpringSecurity.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/contact")
	public String contact() {
		
		return "Hello please contact to this number: 5124452365";
	}
	@GetMapping("/accountInfo")
	public String accountInfo() {
		
		return "To visit to you account please login";
	}


}
