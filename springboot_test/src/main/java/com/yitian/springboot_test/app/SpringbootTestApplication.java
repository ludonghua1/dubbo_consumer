package com.yitian.springboot_test.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(value = ApplicationConfig.class)
public class SpringbootTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}

}

