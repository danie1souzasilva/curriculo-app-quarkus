package br.com.curriculo.adapter.output.banco.repository;

import br.com.curriculo.adapter.output.MapearCurriculo;
import br.com.curriculo.adapter.output.banco.entidade.CurriculoEntidade;
import br.com.curriculo.domain.model.Curriculo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class CurriculoRepository implements PanacheRepository<CurriculoEntidade> {

    @Inject
    MapearCurriculo converter;

    private final Logger logger = LoggerFactory.getLogger(CurriculoRepository.class);

    public Curriculo salvarCurriculo(Curriculo curriculo) {
        CurriculoEntidade entidade = converter.dominioEntidade(curriculo);
        System.out.println("CurriculoRepository.salvarCurriculo");
        persist(entidade);
        return converter.entidadeDominio(entidade);
    }

    public List<Curriculo> buscarPorNome(String nome) {
        List<CurriculoEntidade> entidades =
                find("LOWER(nome) like LOWER(?1)", "%" + nome + "%").list();
        System.out.println("CurriculoRepository.buscarPorNome");

        return converter.entidadeDominioList(entidades);
    }
}
