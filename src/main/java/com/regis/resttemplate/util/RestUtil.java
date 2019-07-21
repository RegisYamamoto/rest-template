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

public class RestUtil {
	
	private static final Logger log = LoggerFactory.getLogger(RestUtil.class);
	
	public static final String URL1 = "https://produtos-apirest.herokuapp.com/api/produtos/";
	public static final String URL2 = "https://produtos-apirest.herokuapp.com/api/produto/";
	
//	public void get() {
//		RestTemplate restTemplate = new RestTemplate();
//        Produto[] produtos = restTemplate.getForObject("https://produtos-apirest.herokuapp.com/api/produtos/", Produto[].class);
//        Arrays.asList(produtos).forEach(System.out::println);
//	}
	
	public HttpEntity<String> buscarTodos() {
		HttpHeaders headers = getHttpHeadersAuth();
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate.exchange(String.format(URL1), HttpMethod.GET, request, String.class);
	}
	
	public HttpEntity<String> buscarPorId(long id) {
		HttpHeaders headers = getHttpHeadersAuth();
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate.exchange(String.format(URL2 + id), HttpMethod.GET, request, String.class);
	}
	
//	public ResponseEntity<String> put(String json) {
//		HttpHeaders headers = getHttpHeadersAuth();
//		HttpEntity<String> request = new HttpEntity<>(json, headers);
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
//		return restTemplate.exchange(String.format("https://produtos-apirest.herokuapp.com/api/produto/"), HttpMethod.PUT, request, String.class);
//	}

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