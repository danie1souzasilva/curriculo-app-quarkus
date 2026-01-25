package br.com.curriculo.adapter.output;

import br.com.curriculo.adapter.output.banco.entidade.CurriculoEntidade;
import br.com.curriculo.domain.model.Curriculo;
import jakarta.enterprise.inject.Model;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MapearCurriculo {

    Curriculo entidadeDominio(CurriculoEntidade curriculoEntidade);
    List<Curriculo> entidadeDominioList(List<CurriculoEntidade> curriculos);

    CurriculoEntidade dominioEntidade(Curriculo curriculo);
    List<CurriculoEntidade> dominioEntidadeList(List<Curriculo> curriculos);

}
