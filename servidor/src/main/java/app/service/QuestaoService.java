package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Questao;
import app.repository.QuestaoRepository;

@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository questaoRepository;

	public List<Questao> findAll() {
		return this.questaoRepository.findAll();
	}

	public Questao findById(long id) {
		Optional<Questao> questao = this.questaoRepository.findById(id);
		return questao.orElse(null);
	}

	public String save(Questao q) {
		this.questaoRepository.save(q);
		return " Questão Cadastrada";
	}

	public String update(Questao q, long id) {
		q.setId(id);
		this.questaoRepository.save(q);
		return " Questão atualizada!";
	}

	public String deleteById(long id) {
		if (!questaoRepository.existsById(id)) {
			return "Questao com ID" + id + " não encontrada";
		}
		this.questaoRepository.deleteById(id);
		return " Questão deletada";
	}

	public List<Questao> findByTitulo(java.lang.String enunciado) {
		return this.questaoRepository.findByEnunciadoContainingIgnoreCase(enunciado);
	}

}
