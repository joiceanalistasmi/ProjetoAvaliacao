package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Servidor;
import app.service.ServidorService;

@RestController
@RequestMapping("/api/servidor")
@CrossOrigin("*")
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findAll")
    public ResponseEntity<List<Servidor>> findAll() {
        List<Servidor> lista = this.servidorService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Servidor> findById(@PathVariable long id) {
        Servidor servidor = this.servidorService.findById(id);
        return new ResponseEntity<>(servidor, HttpStatus.OK);
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Servidor>> findByNome(@RequestParam String nome) {
        List<Servidor> lista = this.servidorService.findByNome(nome);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Servidor servidor) {
        String mensagem = this.servidorService.save(servidor);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Servidor servidor, @PathVariable long id) {
        String mensagem = this.servidorService.update(servidor, id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        String mensagem = this.servidorService.deleteById(id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }
}
