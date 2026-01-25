package br.com.curriculo.adapter.output.banco.repository;

import br.com.curriculo.adapter.output.MapearCurriculo;
import br.com.curriculo.adapter.output.banco.entidade.CurriculoEntidade;
import br.com.curriculo.domain.model.Curriculo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.vavr.control.Try;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;


@ApplicationScoped
public class CurriculoRepository implements PanacheRepository<CurriculoEntidade> {

    @Inject
    MapearCurriculo converter;

    public void salvarCurriculo(Curriculo curriculo){
        CurriculoEntidade curriculoEntidade = converter.dominioEntidade(curriculo);
         persist(curriculoEntidade);
    }
    public Curriculo buscarCurriculo(String nome){
        List<CurriculoEntidade> curriculoEntidade = list("nome", nome);
        List<Curriculo> curriculos = converter.entidadeDominioList(curriculoEntidade);
        return  curriculos.get(0);
    }
}
