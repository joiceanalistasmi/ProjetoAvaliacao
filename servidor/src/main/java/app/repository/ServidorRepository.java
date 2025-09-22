package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

 
import app.entity.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {

	public List<Servidor> findByNomeContainingIgnoreCase(String nome);


}
