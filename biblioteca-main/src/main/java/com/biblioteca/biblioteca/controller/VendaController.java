package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.biblioteca.biblioteca.entity.Venda;
import com.biblioteca.biblioteca.service.VendaService;

@RestController
@RequestMapping("/vendas")
@CrossOrigin(origins = "*")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getAllVendas() {
        return vendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable Long id) {
        Optional<Venda> venda = vendaService.findById(id);
        if (venda.isPresent()) {
            return ResponseEntity.ok(venda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Venda> createVenda(@RequestBody Venda venda) {
        Venda novaVenda = vendaService.save(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> updateVenda(@PathVariable Long id, @RequestBody Venda vendaDetails) {
        Optional<Venda> venda = vendaService.findById(id);
        if (venda.isPresent()) {
            Venda vendaAtualizada = venda.get();
            vendaAtualizada.setObservacao(vendaDetails.getObservacao());
            vendaAtualizada.setCliente(vendaDetails.getCliente());
            vendaAtualizada.setFuncionario(vendaDetails.getFuncionario());
            vendaAtualizada.setProdutos(vendaDetails.getProdutos());
            return ResponseEntity.ok(vendaService.save(vendaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenda(@PathVariable Long id) {
        if (vendaService.findById(id).isPresent()) {
            vendaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
