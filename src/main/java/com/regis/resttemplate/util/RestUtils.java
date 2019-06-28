package com.regis.resttemplate.util;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.regis.resttemplate.model.Produto;

public class RestUtils {
	
	private static final Logger log = LoggerFactory.getLogger(RestUtils.class);
	
	public void get() {
		RestTemplate restTemplate = new RestTemplate();
        Produto[] produtos = restTemplate.getForObject("https://produtos-apirest.herokuapp.com/api/produtos/", Produto[].class);
        Arrays.asList(produtos).forEach(System.out::println);
	}
	
	public void get(long id) {
		RestTemplate restTemplate = new RestTemplate();
        Produto produto = restTemplate.getForObject("https://produtos-apirest.herokuapp.com/api/produto/" + id, Produto.class);
        log.info(produto.toString());
	}
	
	public ResponseEntity<String> put(String json) {
		HttpHeaders headers = getHttpHeadersAuth();
		HttpEntity<String> request = new HttpEntity<>(json, headers);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate.exchange(String.format("https://produtos-apirest.herokuapp.com/api/produto/"), HttpMethod.PUT, request, String.class);
	}

	private HttpHeaders getHttpHeadersAuth() {
		return new HttpHeaders() {

			private static final long serialVersionUID = 1L;

			{
				//set("X-Auth-Token", "615700A6E7F6241BE0536AF3A8C0ED63");
				set("Content-Type", "application/json");
			}
		};
	}

}