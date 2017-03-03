package com.sprint3r.deans4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(MyCustomProperties.class)
public class SpringbootGradleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGradleProjectApplication.class, args);
	}
}
