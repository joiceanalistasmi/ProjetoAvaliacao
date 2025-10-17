package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Servidor;
import app.repository.ServidorRepository;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository servidorRepository;

    // Lista todos os servidores
    public List<Servidor> findAll() {
        return this.servidorRepository.findAll();
    }

    // Busca um servidor por ID
    public Servidor findById(long id) {
        Optional<Servidor> servidor = this.servidorRepository.findById(id);
        if (servidor.isPresent())
        	return servidor.get();
        else
        	return null;
    }

    // Busca servidores por nome (se quiser implementar)
    public List<Servidor> findByNome(String nome) {
        return this.servidorRepository.findByNomeContainingIgnoreCase(nome);
    }
      
      // Salva um novo servidor
    public String save(Servidor servidor) {
        this.servidorRepository.save(servidor);
        return servidor.getNome()  + " Servidor cadastrado com sucesso";
    }

    // Atualiza um servidor existente
    public String update(Servidor servidor, long id) {
        servidor.setId(id);
        this.servidorRepository.save(servidor);
        return servidor.getNome() + "Servidor atualizado com sucesso";
    }

    // deleta um servidor por ID
    public String deleteById(long id) {
        this.servidorRepository.deleteById(id);
        return "Servidor deletado com sucesso";
    }
}
