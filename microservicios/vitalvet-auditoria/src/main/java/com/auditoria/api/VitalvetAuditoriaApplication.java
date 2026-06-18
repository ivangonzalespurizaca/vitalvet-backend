package com.auditoria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VitalvetAuditoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalvetAuditoriaApplication.class, args);
	}

}
