package com.vectoritcgroup.rastreo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class RastreoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RastreoApplication.class, args);
	}
}
