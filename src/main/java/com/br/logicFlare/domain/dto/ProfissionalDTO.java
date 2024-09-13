package com.br.logicFlare.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ProfissionalDTO(String nome, String contato, String email, List<LocalDateTime> horariosDisponiveis) {
}
