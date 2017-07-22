package com.oreilly.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class MyCommandLineRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("These are the arguments used to start the app");
		Arrays.stream(args).forEach(l -> System.out.println(l));
	}
}
