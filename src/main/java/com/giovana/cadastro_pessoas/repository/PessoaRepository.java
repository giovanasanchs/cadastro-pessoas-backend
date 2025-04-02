package com.giovana.cadastro_pessoas.repository;

import com.giovana.cadastro_pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
