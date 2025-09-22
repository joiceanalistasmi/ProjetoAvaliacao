package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.entity.Avaliacao;
import app.service.AvaliacaoService;

@RestController
@RequestMapping("/api/avaliacao")
@CrossOrigin("*")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    // Lista todas as avaliações
    @GetMapping("/findAll")
    public ResponseEntity<List<Avaliacao>> findAll() {
        List<Avaliacao> lista = avaliacaoService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // Busca uma avaliação por ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable long id) {
        Avaliacao avaliacao = avaliacaoService.findById(id);
        if (avaliacao != null) {
            return new ResponseEntity<>(avaliacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Lista avaliações por servidor
    @GetMapping("/findByServidor/{servidorId}")
    public ResponseEntity<List<Avaliacao>> findByServidor(@PathVariable long servidorId) {
        List<Avaliacao> lista = avaliacaoService.findByServidorId(servidorId);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // Salva uma nova avaliação
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Avaliacao avaliacao) {
        String mensagem = avaliacaoService.save(avaliacao);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    // Atualiza uma avaliação
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Avaliacao avaliacao, @PathVariable long id) {
        String mensagem = avaliacaoService.update(avaliacao, id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    // Deleta uma avaliação
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        String mensagem = avaliacaoService.deleteById(id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }
}
