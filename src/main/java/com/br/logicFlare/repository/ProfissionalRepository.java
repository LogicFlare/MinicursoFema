package com.br.logicFlare.repository;

import com.br.logicFlare.domain.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfissionalRepository extends JpaRepository<Profissional, UUID> {
}
