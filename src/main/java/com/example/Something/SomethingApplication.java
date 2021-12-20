package com.example.Something;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SomethingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomethingApplication.class, args);
	}

}
