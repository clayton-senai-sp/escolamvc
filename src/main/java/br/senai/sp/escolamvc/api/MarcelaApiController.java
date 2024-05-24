package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Marcela;
import br.senai.sp.escolamvc.repository.MarcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcela")
public class MarcelaApiController {

    @Autowired
    private MarcelaRepository marcelaRepository;

    // Listar todos os marcelas
    @GetMapping("/listar")
    public List<Marcela> listar() {
        return marcelaRepository.findAll();
    }

    // Inserir um marcela
    @PostMapping("/inserir")
    public void inserir(@RequestBody  Marcela marcela) {
        marcelaRepository.save(marcela);
    }

    // Update a marcela
    @PutMapping("/alterar")
    public void alterar(@RequestBody Marcela marcela) {
        marcelaRepository.save(marcela);
    }

    // Delete a marcela
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        marcelaRepository.deleteById(id);
    }

}
