package com.oreilly.cloud;

import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

public class DemoConfiguration {

	@Bean
	public List<String> cats(){
		return Arrays.asList("Bengal", "Lion");
	}
}
