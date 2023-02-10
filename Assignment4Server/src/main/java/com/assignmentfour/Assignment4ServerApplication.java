package com.assignmentfour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Assignment4ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4ServerApplication.class, args);
		System.out.println("Spring Boot Eureka server started");
	}

}
