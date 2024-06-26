package br.senai.sp.escolamvc.repository;

import br.senai.sp.escolamvc.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContainingIgnoreCase(String nome);

    Aluno findByEmail(String email);

    Aluno findByCpf(String cpf);

    Optional<Aluno> findByEmailOrCpf(String email, String cpf);


    // Pesquisa o email e o id seja diferente
    // do id que está sendo alterado
    Aluno findByEmailAndIdNot(String email, Long id);

    // Pesquisa o cpf e o id seja diferente
    // do id que está sendo alterado
    Aluno findByCpfAndIdNot(String cpf, Long id);

    //@Query("select id, nome, cpf, email, enderecoPessoa.id from Aluno")
    @Query(value = "select new br.senai.sp.escolamvc.dto.AlunoDto(id, nome, cpf, email, matricula) from Aluno")
    List<Object> buscarAlunosParaApp();

    // Pesquisa todos os alunos e retorna o id, nome, matricula e email
    //@Query("SELECT id, nome, cpf, email, enderecoPessoa.id FROM Aluno")
    //List<Object[]> buscarAlunosParaApp();




}
