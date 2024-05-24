package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.EnderecoPessoa;
import br.senai.sp.escolamvc.repository.EnderecoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco-pessoa")
public class EnderecoPessoaApiController {

    @Autowired
    private EnderecoPessoaRepository enderecoPessoaRepository;

    // Listar todos os endereços
    @GetMapping("/listar")
    public List<EnderecoPessoa> listar() {
        return enderecoPessoaRepository.findAll();
    }

    // Inserir um endereço
    @PostMapping("/inserir")
    public void inserir(@RequestBody EnderecoPessoa enderecoPessoa) {
        enderecoPessoaRepository.save(enderecoPessoa);
    }

    // Alterar um endereço
    @PutMapping("/alterar")
    public void alterar(@RequestBody EnderecoPessoa enderecoPessoa) {
        enderecoPessoaRepository.save(enderecoPessoa);
    }

    // Excluir um endereço
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        enderecoPessoaRepository.deleteById(id);
    }

    // Listar endereço pelo id
    @GetMapping("/listar/{id}")
    public EnderecoPessoa listarPorId(@PathVariable Long id) {
        return enderecoPessoaRepository.findById(id).get();
    }
}
