package com.scheila.netflix_a3sdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class NetflixA3sdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixA3sdmApplication.class, args);
	}

}
