package br.senai.sp.escolamvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoas_turmas")
public class PessoasTurmas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long pessoa_id;
    private Long turma_id;



}
