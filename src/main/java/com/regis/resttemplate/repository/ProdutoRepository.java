package com.regis.resttemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.regis.resttemplate.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Modifying
	@Transactional
    @Query(value = "insert into produto (id, nome, quantidade, valor) values (?1, ?2, ?3, ?4)", nativeQuery=true)
    void inserirProduto(long id, String nome, long quantidade, double valor);
	
}