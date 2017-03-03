package com.sprint3r.deans4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDataJpaApplication {

	@Bean
	public InitializingBean seedDatabase(ProductRepository repository) {
		return () -> {
			repository.save(new Product("Intel i7", "CPU", "i7 7700k"));
			repository.save(new Product("AMD Raizen 1700X", "CPU", "AMD 1700X"));
			repository.save(new Product("Galax HOF GTX1080", "GPU", "GTX 1080"));
			repository.save(new Product("Raiden Plasma","RAM", "DDR4 32GB"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaApplication.class, args);
	}
}
