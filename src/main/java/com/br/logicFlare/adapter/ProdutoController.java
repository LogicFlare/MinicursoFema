package com.br.logicFlare.adapter;

import com.br.logicFlare.domain.dto.ProdutoDTO;
import com.br.logicFlare.domain.model.Produto;
import com.br.logicFlare.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/all")
    public ResponseEntity<List<Produto>> getProduto() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> getById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(data));
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<Optional<Produto>> atualizar(@PathVariable UUID id, @RequestBody ProdutoDTO data){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, data));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletar(id));
    }

}
