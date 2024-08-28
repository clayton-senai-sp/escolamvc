package br.senai.sp.escolamvc.model;

import br.senai.sp.escolamvc.enums.EstadoCivil;
import br.senai.sp.escolamvc.enums.Etnia;
import br.senai.sp.escolamvc.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "tipoPessoa",
    length = 1,
    discriminatorType = DiscriminatorType.STRING
)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true)
    private Long id;


    @NotEmpty(message = "O CPF deve ser informado")
    @CPF(message = "O CPF informado é inválido")
    private String cpf;

    @NotEmpty(message = "O nome deve ser informado")
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoPessoa enderecoPessoa;

    @NotEmpty(message = "O e-mail deve ser informado")
    @Email(message = "O e-mail informado é inválido")
    private String email;
    private String foto;
    private Etnia etnia;
    private Sexo sexo;
    private EstadoCivil estadoCivil;
    private String naturalidade;
    private String nacionalidade;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String senha;
    private Boolean sistema;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<NotasAlunos> notas = new ArrayList<NotasAlunos>();


    //@JsonManagedReference
    @ManyToMany(mappedBy = "pessoas", fetch = FetchType.LAZY)
    private List<Turma> turmas = new ArrayList<Turma>();

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public void addTurma(Turma turma){
        //turma.getPessoas().add(this);
        this.turmas.add(turma);
    }

    public void removeTurma(Turma turma){
        //turma.getPessoas().remove(this);
        this.turmas.remove(turma);
    }


    public void addTelefone(Telefone telefone){
        this.telefones.add(telefone);
    }

    public void removeTelefone(Telefone telefone){
        this.telefones.remove(telefone);
    }







}
