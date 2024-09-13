package com.br.logicFlare.domain.model;

import com.br.logicFlare.domain.dto.ProdutoDTO;
import com.br.logicFlare.domain.enums.CategoriaEnum;
import com.br.logicFlare.domain.enums.TipoDeServicoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoDeServicoEnum tipoDeServicoEnum;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoriaEnum;

    @ManyToOne
    private Profissional profissional;

    public Produto(ProdutoDTO data){
        this.nome = data.nome();
        this.valor = data.valor();
        this.tipoDeServicoEnum = data.tipoDeServico();
        this.categoriaEnum = data.categoria();
        this.profissional = data.profissional();
    }

}
