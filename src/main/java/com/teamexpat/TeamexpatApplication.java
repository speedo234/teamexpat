package com.teamexpat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamexpatApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeamexpatApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TeamexpatApplication.class, args);
	}

}
