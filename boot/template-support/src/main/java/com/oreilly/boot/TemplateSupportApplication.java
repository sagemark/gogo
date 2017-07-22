package com.oreilly.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class TemplateSupportApplication {

	@RequestMapping("mustache")
	public String mustache(Model model){
		model.addAttribute("company", "O'Reilly");
		return "template";
	}

	public static void main(String[] args) {
		SpringApplication.run(TemplateSupportApplication.class, args);
	}
}
