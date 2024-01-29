package com.kildani.simplebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.kildani.simplebanking.entity")
@ComponentScan(basePackages = "com.kildani.simplebanking")
public class SimpleBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBankingApplication.class, args);
	}
}
