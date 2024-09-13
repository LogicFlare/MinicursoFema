package com.br.logicFlare.service;

import com.br.logicFlare.domain.dto.ProdutoDTO;
import com.br.logicFlare.domain.model.Produto;
import com.br.logicFlare.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<Produto> getAll(){
        return repository.findAll();
    }

    public Optional<Produto> getById(UUID id){
        try {
            return repository.findById(id);
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Produto não encontrado");
        }
    }

    public Produto cadastrar(ProdutoDTO data){
        return repository.save(new Produto(data));
    }

    public Optional<Produto> atualizar(UUID id, ProdutoDTO data){
        Optional<Produto> produto = getById(id);

        produto.get().setNome(data.nome() != null ? data.nome() : produto.get().getNome());
        produto.get().setValor(data.valor() != null ? data.valor() : produto.get().getValor());
        produto.get().setCategoriaEnum(data.categoria() != null ? data.categoria() : produto.get().getCategoriaEnum());
        produto.get().setTipoDeServicoEnum(data.tipoDeServico() != null ? data.tipoDeServico() : produto.get().getTipoDeServicoEnum());
        produto.get().setProfissional(data.profissional() != null ? data.profissional() : produto.get().getProfissional());

        return produto;
    }

    public String deletar(UUID id){
        Optional<Produto> produto = getById(id);
        repository.delete(produto.get());
        return "Produto deletado com sucesso!";
    }

}
