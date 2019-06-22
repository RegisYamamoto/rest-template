package com.regis.resttemplate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.regis.resttemplate.model.Produto;

public class RestUtils {
	
	private static final Logger log = LoggerFactory.getLogger(RestUtils.class);
	
	public void get(long id) {
		RestTemplate restTemplate = new RestTemplate();
        //Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        Produto produto = restTemplate.getForObject("https://produtos-apirest.herokuapp.com/api/produto/" + id, Produto.class);
        //log.info(quote.toString());
        log.info(produto.toString());
        
	}

}