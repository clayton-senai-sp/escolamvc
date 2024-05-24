package br.senai.sp.escolamvc.api;


import br.senai.sp.escolamvc.model.Aluno;
import br.senai.sp.escolamvc.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno")
public class AlunoApiController {
    @Autowired
    private AlunoRepository alunoRepository;

    private RestClient restClient = RestClient.create();

    @GetMapping("/listar")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("/buscaralunosparaapp")
    public List<Object> buscarAlunosParaApp(){
        return alunoRepository.buscarAlunosParaApp();
    }


    @PostMapping("/inserir")
    public void inserir(@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
    }

    // Inserir vários alunos
    @PostMapping("/inserir-varios")
    public void inserirVarios(@RequestBody List<Aluno> alunos) {
        alunoRepository.saveAll(alunos);
    }

    @PutMapping("/alterar")
    public void alterar(@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id){
        alunoRepository.deleteById(id);
    }

    @GetMapping("/client/listar")
    public String alunosViaApi(Model model) {

        // Busca a lista de alunos via API
        String alunos = restClient.get()
                .uri("http://localhost/api/aluno/listar")
                .retrieve()
                .body(String.class);

        return alunos;
    }

    @GetMapping("/client/inserir")
    public void inserirAlunoViaApi(Aluno aluno) {
        // Insere o aluno via API
        ResponseEntity<Void> response = restClient.post()
                .uri("http://localhost/api/aluno/inserir")
                .body(aluno)
                .retrieve()
                .toBodilessEntity();
    }

}