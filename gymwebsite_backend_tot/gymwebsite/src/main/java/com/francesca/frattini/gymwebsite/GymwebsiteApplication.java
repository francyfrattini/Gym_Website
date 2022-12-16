package com.francesca.frattini.gymwebsite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GymwebsiteApplication implements CommandLineRunner {


	public static void main( String[] args ) {
		SpringApplication.run( GymwebsiteApplication.class, args );
		System.out.println("hello");
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

