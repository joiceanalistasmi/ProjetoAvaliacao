package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import jakarta.validation.Valid;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/servidor")
@CrossOrigin("*") // liberar requisições de qualquer origem
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findAll")
    public ResponseEntity<List<Servidor>> findAll() {
        try {
            List<Servidor> lista = servidorService.findAll();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Servidor> findById(@PathVariable long id) {
        try {
            Servidor servidor = servidorService.findById(id);
            return new ResponseEntity<Servidor>(servidor, HttpStatus.OK);
        } catch (Exception e) {
        	 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Servidor>> findByNome(@RequestParam String nome) {
        try {
            List<Servidor> lista = servidorService.findByNome(nome);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

 
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody  @Valid Servidor servidor) {
    	//try {
           String mensagem = servidorService.save(servidor);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    	//}catch (Exception e) {
          //  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          //          .body("Erro ao salvar: " + e.getMessage());
    //	}
       
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Servidor servidor, @PathVariable long id) {
        try {
            String mensagem = servidorService.update(servidor, id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            String mensagem = servidorService.deleteById(id);
            return ResponseEntity.ok(mensagem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar: " + e.getMessage());
        }
    }
}
