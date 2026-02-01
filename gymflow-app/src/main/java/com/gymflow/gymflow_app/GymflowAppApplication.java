package com.gymflow.gymflow_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
		basePackages = "com.gymflow.inventory"
)
@EntityScan(
		basePackages = "com.gymflow.inventory"
)
public class GymflowAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymflowAppApplication.class, args);
	}
}
