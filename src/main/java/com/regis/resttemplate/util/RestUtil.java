package com.regis.resttemplate.util;

import java.nio.charset.Charset;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
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
	
	public String buscarPorId(long id) {
		HttpHeaders headers = getHttpHeadersAuth();
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		//return restTemplate.exchange(String.format(URL2 + id), HttpMethod.GET, request, String.class); // Utilizado para quando precisa usar proxy
		return restTemplate.getForObject(String.format(URL2 + id), String.class);
	}
	
	public ResponseEntity<Produto> pegarDoBancoEInserirNaAPI(Produto produto) {
		HttpHeaders headers = getHttpHeadersAuth();
		HttpEntity<Produto> request = new HttpEntity<>(produto, headers);
		RestTemplate restTemplate = new RestTemplate(/*getClientHttpRequestFactory()*/);
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate.exchange(String.format("https://produtos-apirest.herokuapp.com/api/produto/"), HttpMethod.POST, request, Produto.class);
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
	
//	private ClientHttpRequestFactory getClientHttpRequestFactory() {
//		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = 
//				new HttpComponentsClientHttpRequestFactory(
//						HttpClientBuilder.create()
//						.setProxy(new HttpHost("proxy.muffato.com.br", 3128, "http"))
//						.build());
//		clientHttpRequestFactory.setConnectTimeout(500000);
//		return clientHttpRequestFactory;
//	}

}