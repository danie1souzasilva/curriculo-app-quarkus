package br.com.curriculo.adapter.output.banco.repository;

import br.com.curriculo.adapter.output.banco.entidade.UsuarioEntidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<UsuarioEntidade> {
    // Métodos customizados podem ser adicionados
}

