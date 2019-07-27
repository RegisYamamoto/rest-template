package com.regis.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Scheduled(fixedDelay = 10000)
	public void buscarEInserirProdutoUnico() {
		RestUtil restUtil = new RestUtil();
		String json = restUtil.buscarPorId(428);
	
		Gson gson = new Gson();

		Produto produto = gson.fromJson(json, Produto.class);
		produtoRepository.inserirProduto(produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getValor());

	}
	
}