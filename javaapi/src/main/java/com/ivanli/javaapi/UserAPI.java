package com.ivanli.javaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserAPI {
	public static void main(String[] args) {
		SpringApplication.run(UserAPI.class, args);
	}

}
