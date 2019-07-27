package com.regis.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.regis.resttemplate.util.RestUtil;

@SpringBootApplication
@EnableScheduling
public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}
	
	//@Scheduled(fixedDelay = 10000)
	public void mostrarProdutos() {
		RestUtil restUtil = new RestUtil();
		System.out.println(restUtil.buscarTodos());
	}
	
	//@Scheduled(fixedDelay = 10000)
	public void mostrarProdutoUnico() {
		RestUtil restUtil = new RestUtil();
		System.out.println(restUtil.buscarPorId(428));
	}

}