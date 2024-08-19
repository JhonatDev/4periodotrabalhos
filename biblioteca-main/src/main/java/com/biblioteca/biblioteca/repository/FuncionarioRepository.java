package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}

