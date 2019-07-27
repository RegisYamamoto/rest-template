package com.regis.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.regis.resttemplate.model.Produto;
import com.regis.resttemplate.repository.ProdutoRepository;
import com.regis.resttemplate.util.RestUtil;

@Service
@EnableScheduling
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Scheduled(fixedDelay = 5000)
	public void buscarProdutoUnico() {
		RestUtil restUtil = new RestUtil();
		HttpEntity<String> json = restUtil.buscarPorId(428);
		String jsonString = json.toString();
		System.out.println(jsonString);
	
		Gson gson = new Gson();
		
		try {
			Produto produto = gson.fromJson(jsonString, Produto.class);
			System.out.println(produto);
			produtoRepository.insertWithQuery(produto);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}