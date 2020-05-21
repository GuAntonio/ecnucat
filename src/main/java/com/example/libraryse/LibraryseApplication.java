package com.example.libraryse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LibraryseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryseApplication.class, args);
	}

}
