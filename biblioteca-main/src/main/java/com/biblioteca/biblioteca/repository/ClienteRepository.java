package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

