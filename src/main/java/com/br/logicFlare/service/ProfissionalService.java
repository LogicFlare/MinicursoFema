package com.br.logicFlare.service;

import com.br.logicFlare.domain.dto.ProfissionalDTO;
import com.br.logicFlare.domain.model.Profissional;
import com.br.logicFlare.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfissionalService {

    @Autowired
    ProfissionalRepository repository;

    public List<Profissional> getAll(){
        return repository.findAll();
    }

    public Optional<Profissional> getById(UUID id){

        try {
            return repository.findById(id);
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Profissional não encontrado");
        }

    }

    public Profissional cadastrar(ProfissionalDTO data){
        return repository.save(new Profissional(data));
    }

    public Optional<Profissional> atualizar(UUID id, ProfissionalDTO data){
        Optional<Profissional> profissional = getById(id);

        profissional.get().setNome(data.nome() != null ? data.nome() : profissional.get().getNome());
        profissional.get().setEmail(data.email() != null ? data.email() : profissional.get().getEmail());
        profissional.get().setContato(data.contato() != null ? data.contato() : profissional.get().getContato());
        profissional.get().setHorariosDisponiveis(data.horariosDisponiveis() != null ? data.horariosDisponiveis() : profissional.get().getHorariosDisponiveis());

        return profissional;
    }

    public String deletar(UUID id){
        Optional<Profissional> profissional = getById(id);
        repository.delete(profissional.get());
        return "Profissional deletado com sucesso!";
    }

}
