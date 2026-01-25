package br.com.curriculo.adapter.output.banco.repository;

import br.com.curriculo.adapter.output.banco.entidade.CurriculoEntidade;
import br.com.curriculo.domain.model.Curriculo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.vavr.control.Try;

import java.util.List;

public class CurriculoRepository implements PanacheRepository<CurriculoEntidade> {

    public void salvarCurriculo(Curriculo curriculo){
         persist(curriculo);
    }
    public CurriculoEntidade buscarCurriculo(String nome){
        List<CurriculoEntidade> curriculoEntidade = list("nome", nome);
        return  curriculoEntidade.get(0);
    }
}
