package com.OauthSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// we just require oauth dependencies and configure client id and client secret in application properties file.
@SpringBootApplication
public class OauthSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthSpringSecurityApplication.class, args);
	}

}
