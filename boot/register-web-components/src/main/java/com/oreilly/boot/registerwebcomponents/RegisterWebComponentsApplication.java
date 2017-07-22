package com.oreilly.boot.registerwebcomponents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
//@ServletComponentScan
public class RegisterWebComponentsApplication {

	@RequestMapping("/hot")
	public String hot(){
		return "hotstuff";
	}


	public static void main(String[] args) {
		SpringApplication.run(RegisterWebComponentsApplication.class, args);
	}
}
