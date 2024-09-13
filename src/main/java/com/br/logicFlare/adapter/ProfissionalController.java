package com.br.logicFlare.adapter;


import com.br.logicFlare.domain.dto.ProfissionalDTO;
import com.br.logicFlare.domain.model.Profissional;
import com.br.logicFlare.service.ProfissionalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    ProfissionalService service;

    @GetMapping("/all")
    public ResponseEntity<List<Profissional>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Profissional>> getById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Profissional> cadastrar(@RequestBody ProfissionalDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(data));
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<Optional<Profissional>> atualizar(@PathVariable UUID id, @RequestBody ProfissionalDTO data){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, data));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletar(id));
    }

}
