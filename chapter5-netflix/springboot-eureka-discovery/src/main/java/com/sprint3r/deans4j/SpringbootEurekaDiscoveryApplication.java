package com.sprint3r.deans4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringbootEurekaDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEurekaDiscoveryApplication.class, args);
	}
}
