package com.salcorps.springbootdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.salcorps.springbootdemo2.repository")
@EntityScan("com.salcorps.springbootdemo2.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class Springbootdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo2Application.class, args);
	}

}
