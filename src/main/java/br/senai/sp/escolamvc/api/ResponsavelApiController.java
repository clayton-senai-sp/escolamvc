package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Responsavel;
import br.senai.sp.escolamvc.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsavel")
public class ResponsavelApiController {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @GetMapping("/listar")
    public List<Responsavel> getResponsaveis(){
        return responsavelRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public void cadastrarResponsavel(@RequestBody Responsavel responsavel) {
        responsavelRepository.save(responsavel);
    }

    @PutMapping("/alterar")
    public void alterarResponsavel(@RequestBody Responsavel responsavel) {
        responsavelRepository.save(responsavel);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirResponsavel(@PathVariable Long id){
        responsavelRepository.deleteById(id);
    }


}
