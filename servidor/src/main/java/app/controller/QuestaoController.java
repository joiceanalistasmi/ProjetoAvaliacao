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

import app.entity.Questao;
import app.service.QuestaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/questao")
@CrossOrigin("*")
public class QuestaoController {

	@Autowired
	private QuestaoService questaoService;

	   // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findAll")
    public ResponseEntity<List<Questao>> findAll() {
        try {
            List<Questao> lista = questaoService.findAll();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


	@GetMapping("/findById/{id}")
	public ResponseEntity<Questao> findById(@PathVariable long id) {
		Questao questao = this.questaoService.findById(id);
		return new ResponseEntity<>(questao, HttpStatus.OK);
	}

	@GetMapping("/findByTitulo")
	public ResponseEntity<List<Questao>> findByTitulo(@RequestParam String titulo) {
		List<Questao> lista = this.questaoService.findByTitulo(titulo);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody @Valid Questao q) {
	    String mensagem = this.questaoService.save(q);
	    return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Questao questao, @PathVariable long id) {
		String mensagem = this.questaoService.update(questao, id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		String mensagem = this.questaoService.deleteById(id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

}
