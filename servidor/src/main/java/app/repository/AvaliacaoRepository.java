package app.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	

	public List<Avaliacao> findByAvaliadorContainingIgnoreCase(String nomeAvaliador);

	//public List<Avaliacao> findByServidorId(long servidorId);

	public List<Avaliacao> findByPeriodo(Date periodo);
}
