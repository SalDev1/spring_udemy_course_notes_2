package com.example.springbootdemo5;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Springbootdemo5Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo5Application.class, args);
	}

}
