package br.senai.sp.escolamvc.repository;

import br.senai.sp.escolamvc.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    List<Telefone> findByPessoaId(Long idPessoa);
    //List<Telefone> findByPessoaId(Long idPessoa);
}
