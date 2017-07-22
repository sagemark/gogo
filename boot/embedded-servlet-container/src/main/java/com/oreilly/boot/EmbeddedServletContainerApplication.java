package com.oreilly.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmbeddedServletContainerApplication {

	@RequestMapping("/")
	public String hello(){
		return "hello";
	}
	@RequestMapping("/thymeleaf")
	public String tleaf(Model model){

		model.addAttribute("name","Mark");
		return "template";
	}

	public static void main(String[] args) {
		SpringApplication.run(EmbeddedServletContainerApplication.class, args);
	}
}
