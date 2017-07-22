package com.oreilly.boot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class MyApplicationRunner implements ApplicationRunner {
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("These are the arguments used by the application runner");
		Arrays.stream(args.getSourceArgs()).forEach(l -> System.out.println(l));
	}
}
