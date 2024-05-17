package br.senai.sp.escolamvc.repository;

import br.senai.sp.escolamvc.model.EnderecoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoa, Long> {}
