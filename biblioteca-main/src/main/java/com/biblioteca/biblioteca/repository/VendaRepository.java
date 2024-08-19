package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}

