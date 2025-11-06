package com.example.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		/*
		* spring-boot-starter-web
		    Embedded Tomcat, Jackson for JSON, Spring MVC (Model view architecture)
		*spring-boot-starter-data-jpa
	 	    Hibernate,H2 database
		*spring-boot-starter-security
		    Basic auth setup
		*spring-boot-starter-test
		    JUnit, Mockito, Spring test setup
		 */


		/*
		Starter-dependency - Prepackaged set of libraries
		Opinionated SetUp - means spring boot will autoconfigure most of the things by default
		Application.properties or application.yml - additional customization , database connectivity , cloud configuration
		CommandLineRunner and ApplicationRunner - Custom logic to run at the starting of the application
		 */

		
	}


}
