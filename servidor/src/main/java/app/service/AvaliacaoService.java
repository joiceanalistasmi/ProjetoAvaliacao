package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Avaliacao;
import app.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // Lista todas as avaliações
    public List<Avaliacao> findAll() {
        return this.avaliacaoRepository.findAll();
    }

    // Busca uma avaliação por ID
    public Avaliacao findById(long id) {
        Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(id);
        return avaliacao.orElse(null);
    }

    // Salva uma nova avaliação
    public String save(Avaliacao avaliacao) {
        this.avaliacaoRepository.save(avaliacao);
        return "Avaliação cadastrada com sucesso!";
    }

    // Atualiza uma avaliação
    public String update(Avaliacao avaliacao, long id) {
        avaliacao.setId(id);
        this.avaliacaoRepository.save(avaliacao);
        return "Avaliação atualizada com sucesso!";
    }

    // Deleta uma avaliação por ID
    public String deleteById(long id) {
        this.avaliacaoRepository.deleteById(id);
        return "Avaliação deletada com sucesso!";
    }

    // Lista avaliações por servidor_id
    public List<Avaliacao> findByServidorId(long servidorId) {
        return this.avaliacaoRepository.findByServidorId(servidorId);
    }

    // (Opcional) Buscar por período
    public List<Avaliacao> findByPeriodo(java.sql.Date periodo) {
        return this.avaliacaoRepository.findByPeriodo(periodo);
    }
}
