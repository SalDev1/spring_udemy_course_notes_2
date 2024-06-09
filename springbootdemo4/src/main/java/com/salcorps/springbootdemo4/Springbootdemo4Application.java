package com.salcorps.springbootdemo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.salcorps.springbootdemo4.proxy")
public class Springbootdemo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo4Application.class, args);
	}

}
