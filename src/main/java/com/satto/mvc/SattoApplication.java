package com.satto.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SattoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SattoApplication.class, args);
	}

}
