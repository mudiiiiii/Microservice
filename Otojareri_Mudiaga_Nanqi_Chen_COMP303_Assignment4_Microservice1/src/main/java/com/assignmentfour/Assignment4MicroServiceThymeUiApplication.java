package com.assignmentfour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment4MicroServiceThymeUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4MicroServiceThymeUiApplication.class, args);
		System.setProperty("spring.config.name", "assignment-four-ui");
	    System.out.println("Assignment four started!!");
	}

}
