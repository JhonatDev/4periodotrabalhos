package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.biblioteca.biblioteca.entity.Funcionario;
import com.biblioteca.biblioteca.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        if (funcionario.isPresent()) {
            Funcionario funcionarioAtualizado = funcionario.get();
            funcionarioAtualizado.setNome(funcionarioDetails.getNome());
            funcionarioAtualizado.setIdade(funcionarioDetails.getIdade());
            funcionarioAtualizado.setEmail(funcionarioDetails.getEmail());
            funcionarioAtualizado.setCpf(funcionarioDetails.getCpf());
            funcionarioAtualizado.setCep(funcionarioDetails.getCep());
            funcionarioAtualizado.setEndereco(funcionarioDetails.getEndereco());
            funcionarioAtualizado.setTelefone(funcionarioDetails.getTelefone());
            return ResponseEntity.ok(funcionarioService.save(funcionarioAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        if (funcionarioService.findById(id).isPresent()) {
            funcionarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

