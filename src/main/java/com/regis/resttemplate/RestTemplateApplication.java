package com.regis.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.regis.resttemplate.util.RestUtils;

@SpringBootApplication

public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
		
		RestUtils ru = new RestUtils();
		ru.get(428);
		
	}

}
