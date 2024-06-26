package br.senai.sp.escolamvc.api;


import br.senai.sp.escolamvc.model.Aluno;
import br.senai.sp.escolamvc.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoApiController {
    private final AlunoRepository alunoRepository;

    private final RestClient restClient = RestClient.create();

    public AlunoApiController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping("/listartodos")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("/listar")
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
    public String alunosViaApi() {

        // Busca a lista de alunos via API
        return restClient.get()
                .uri("http://localhost/api/aluno/listar")
                .retrieve()
                .body(String.class);
    }

    @GetMapping("/client/inserir")
    public void inserirAlunoViaApi(Aluno aluno) {
        // Insere o aluno via API
        restClient.post()
                .uri("http://localhost/api/aluno/inserir")
                .body(aluno)
                .retrieve()
                .toBodilessEntity();
    }

}