package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

	public List<Questao> findByEnunciadoContainingIgnoreCase(String enunciado);
	
	

}
