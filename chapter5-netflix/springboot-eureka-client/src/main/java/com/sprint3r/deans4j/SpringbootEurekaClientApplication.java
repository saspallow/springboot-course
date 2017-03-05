package com.sprint3r.deans4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpringbootEurekaClientApplication {

	@GetMapping("/")
	public String sayHi() {
		return "hello";
	}

	@GetMapping("/{name}")
	public String sayHiWithName(@PathVariable("name") String name) {
		return "hello, " + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEurekaClientApplication.class, args);
	}
}
