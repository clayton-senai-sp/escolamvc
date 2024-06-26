package br.senai.sp.escolamvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Long matricula;
}
