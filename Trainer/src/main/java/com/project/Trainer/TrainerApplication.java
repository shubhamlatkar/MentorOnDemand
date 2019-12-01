package com.project.Trainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TrainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainerApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTeamplate() {
		return new RestTemplate();
	}
}
