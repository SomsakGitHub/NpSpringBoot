package com.somsakKaeworasan.marauders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MaraudersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaraudersApplication.class, args);
	}

}
