package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

