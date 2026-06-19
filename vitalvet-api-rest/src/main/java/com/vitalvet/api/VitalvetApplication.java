package com.vitalvet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VitalvetApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalvetApplication.class, args);
	}

}
