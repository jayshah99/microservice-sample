package com.example.designationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DesignationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignationServiceApplication.class, args);
	}

}
