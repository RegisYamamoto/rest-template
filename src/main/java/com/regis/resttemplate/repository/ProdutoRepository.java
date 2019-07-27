package com.regis.resttemplate.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.regis.resttemplate.model.Produto;

@Repository
public class ProdutoRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertWithQuery(Produto produto) {
	    entityManager.createNativeQuery("INSERT INTO produto (id, nome, quantidade, valor) VALUES (?,?,?,?)")
	      .setParameter(1, produto.getId())
	      .setParameter(2, produto.getNome())
	      .setParameter(3, produto.getQuantidade())
	      .setParameter(4, produto.getValor())
	      .executeUpdate();
	}
	
}