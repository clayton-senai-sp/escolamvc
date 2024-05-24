package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Telefone;
import br.senai.sp.escolamvc.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telefone")
public class TelefoneApiController {

    @Autowired
    private TelefoneRepository telefoneRepository;

    // Listar todos os telefones
    @GetMapping("/listar")
    public List<Telefone> listar() {
        return telefoneRepository.findAll();
    }

    // Inserir um telefone
    @PostMapping("/inserir")
    public void inserir(@RequestBody Telefone telefone) {
        telefoneRepository.save(telefone);
    }

    // Alterar um telefone
    @PutMapping("/alterar")
    public void alterar(@RequestBody Telefone telefone) {
        telefoneRepository.save(telefone);
    }

    // Excluir um telefone
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        telefoneRepository.deleteById(id);
    }

    // Listar telefones por id da pessoa
    @GetMapping("/listar/{idPessoa}")
    public List<Telefone> listarPorIdPessoa(@PathVariable Long idPessoa) {
        return telefoneRepository.findByPessoaId(idPessoa);
    }


}
