package com.br.logicFlare.domain.dto;

import com.br.logicFlare.domain.enums.CategoriaEnum;
import com.br.logicFlare.domain.enums.TipoDeServicoEnum;
import com.br.logicFlare.domain.model.Profissional;

import java.math.BigDecimal;

public record ProdutoDTO(String nome, BigDecimal valor, TipoDeServicoEnum tipoDeServico, CategoriaEnum categoria, Profissional profissional) {
}
