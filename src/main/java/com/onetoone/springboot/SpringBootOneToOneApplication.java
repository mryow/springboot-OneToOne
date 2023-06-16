package com.onetoone.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.onetoone"})
@EntityScan(basePackages = {"com.onetoone.models"})
@EnableJpaRepositories(basePackages = {"com.onetoone.repositories"})
public class SpringBootOneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneToOneApplication.class, args);
	}

}
