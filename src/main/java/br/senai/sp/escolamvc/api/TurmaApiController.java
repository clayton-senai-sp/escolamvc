package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Turma;
import br.senai.sp.escolamvc.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
public class TurmaApiController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping("/listar")
    public List<Turma> getTurmas(){
        return turmaRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public void cadastrarTurma(@RequestBody Turma turma) {
        turmaRepository.save(turma);
    }

    @PutMapping("/alterar")
    public void alterarTurma(@RequestBody Turma turma) {
        turmaRepository.save(turma);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirTurma(@PathVariable Long id){
        turmaRepository.deleteById(id);
    }


}
