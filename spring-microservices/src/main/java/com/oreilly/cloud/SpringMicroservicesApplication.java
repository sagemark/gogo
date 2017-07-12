package com.oreilly.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@Import(DemoConfiguration.class)
@ImportResource("/simple-context.xml")
public class SpringMicroservicesApplication {

//	@Bean
//	public DispatcherServlet dispatcherServlet(){
//		return new DispatcherServlet();
//	}
// OR autowire the default dispatcherServlet
	@Autowired
	private DispatcherServlet dispatcherServlet;

	@Bean
	public ServletRegistrationBean registration(){
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet, "/servlet/*");
		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
		return registration;
	}

	@Autowired
	@Resource(name = "circus")
	public List<String> list;



	@RequestMapping("/")
	public String message(){
		return String.join(", ",list);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesApplication.class, args);
	}
}
