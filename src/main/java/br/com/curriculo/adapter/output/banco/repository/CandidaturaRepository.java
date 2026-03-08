package br.com.curriculo.adapter.output.banco.repository;

import br.com.curriculo.adapter.output.banco.entidade.CandidaturaEntidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CandidaturaRepository implements PanacheRepository<CandidaturaEntidade> {
    public List<CandidaturaEntidade> findByVagaIdOrderByScoreDesc(Long vagaId) {
        return list("vagaId = ?1 ORDER BY score DESC", vagaId);
    }
}

