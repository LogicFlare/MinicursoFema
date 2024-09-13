package com.br.logicFlare.domain.model;

import com.br.logicFlare.domain.dto.ProfissionalDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String contato;

    @Column(unique = true)
    @Email
    private String email;

    private List<LocalDateTime> horariosDisponiveis = new ArrayList<>();

    // Deixa como uni-direcional ou bi-direcional ?
    @OneToMany
    private List<Produto> produtos = new ArrayList<>();

    public Profissional(ProfissionalDTO data){
        this.nome = data.nome();
        this.contato = data.contato();
        this.email = data.email();
        this.horariosDisponiveis = data.horariosDisponiveis();
    }

}
