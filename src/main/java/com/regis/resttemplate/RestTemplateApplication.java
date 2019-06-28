package com.regis.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.regis.resttemplate.util.RestUtils;

@SpringBootApplication

public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
		
		RestUtils restUtils = new RestUtils();
//		restUtils.put("{\n" +  
//				"  \"nome\": \"teste\",\n" + 
//				"  \"quantidade\": 10,\n" + 
//				"  \"valor\": 99\n" + 
//				"}");
		//restUtils.get(428);
		
		restUtils.get();
	}
	

}
