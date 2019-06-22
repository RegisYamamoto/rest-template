package com.regis.resttemplate.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectProduto {

	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}