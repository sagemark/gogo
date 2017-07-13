package com.oreilly.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@RestController
public class SpringMicroservicesConfigClientApplication {

	@Value("${message}")
	private String message;

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesConfigClientApplication.class, args);
	}

	@RequestMapping("/message")
	public String getMessage(){
		return message;
	}
}
