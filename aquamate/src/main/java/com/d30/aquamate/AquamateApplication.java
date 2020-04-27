package com.d30.aquamate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AquamateApplication {
	
	Logger logger = LoggerFactory.getLogger(AquamateApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(AquamateApplication.class, args);
	}

}
