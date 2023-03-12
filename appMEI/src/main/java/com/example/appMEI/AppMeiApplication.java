package com.example.appMEI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppMeiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMeiApplication.class, args);
	}

}
