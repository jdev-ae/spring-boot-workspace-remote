package com.suru.springboot.sampledataapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.suru.springboot.sampledataapp.model"})
public class SampleDataAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleDataAppApplication.class, args);
	}
}
