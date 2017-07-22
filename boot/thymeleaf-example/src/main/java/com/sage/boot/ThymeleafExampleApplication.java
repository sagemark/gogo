package com.sage.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class ThymeleafExampleApplication {

	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam(name = "name") String name){
		model.addAttribute("name",name);
		return new ModelAndView("name",model);
	}

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafExampleApplication.class, args);
	}
}
