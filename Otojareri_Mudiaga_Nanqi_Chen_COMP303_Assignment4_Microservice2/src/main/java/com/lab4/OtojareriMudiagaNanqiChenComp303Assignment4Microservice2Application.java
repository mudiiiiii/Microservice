package com.lab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OtojareriMudiagaNanqiChenComp303Assignment4Microservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(OtojareriMudiagaNanqiChenComp303Assignment4Microservice2Application.class, args);
		System.setProperty("spring.config.name", "assignment-four-ui2");
		System.out.println("Assignment four started!!");
	}

}
