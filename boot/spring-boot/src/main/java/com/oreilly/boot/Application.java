package com.oreilly.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableConfigurationProperties(value = MyMessage.class)
public class Application {

	@Autowired
	ApplicationArguments arguments;

	@Autowired
	private MyMessage myMessage;

	@RequestMapping("/cat")
	public Cat cat(){
		return new Cat("Ernesto", 4);
	}

	@RequestMapping("/")
	public String welcome(){
		String value = arguments.getOptionNames().iterator().next();
		return "Message: " + myMessage.getMessageValue() + ", Argumemt: " + value;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
