package com.oreilly.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@EnableAutoConfiguration
//@Import(MyConfiguration.class)
//@ComponentScan
@SpringBootApplication
public class Application {

	@Value("${name}")
	String name;

	@Autowired
	String message;

	@RequestMapping("/")
	public String home(){
		return message;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
