package br.com.curriculo.adapter.output.banco.repository;

import br.com.curriculo.adapter.output.banco.entidade.VagaEntidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VagaRepository implements PanacheRepository<VagaEntidade> {
    // Métodos customizados podem ser adicionados futuramente
}

