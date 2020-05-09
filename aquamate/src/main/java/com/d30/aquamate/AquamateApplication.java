package com.d30.aquamate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@EnableSwagger2
//@ComponentScan(basePackages = "com.d30.aquamate")
public class AquamateApplication {
	

	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	Logger logger = LoggerFactory.getLogger(AquamateApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(AquamateApplication.class, args);
	}

}
