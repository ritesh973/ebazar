package com.rits.ebazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class EbazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbazarApplication.class, args);
	}

}
