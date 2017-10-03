package com.suru.springboot.bootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.suru.springboot.bootrest.model" })
public class BootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestApiApplication.class, args);
	}
}
