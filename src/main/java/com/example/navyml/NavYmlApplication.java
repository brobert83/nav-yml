package com.example.navyml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class NavYmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavYmlApplication.class, args);
    }

}
