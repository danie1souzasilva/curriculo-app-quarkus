package br.com.curriculo.adapter.output;

import br.com.curriculo.adapter.input.dto.CurriculoDTO;
import br.com.curriculo.adapter.output.banco.entidade.CurriculoEntidade;
import br.com.curriculo.domain.model.Curriculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MapearCurriculo {

    Curriculo entidadeDominio(CurriculoEntidade curriculoEntidade);
    List<Curriculo> entidadeDominioList(List<CurriculoEntidade> curriculos);

    CurriculoEntidade dominioEntidade(Curriculo curriculo);
    List<CurriculoEntidade> dominioEntidadeList(List<Curriculo> curriculos);

    @Mapping(target = "area", source = "area")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "formacao", source = "formacao")
    @Mapping(target = "cargo", source = "cargo")
    @Mapping(target = "anosDeExperiencia", source = "anosDeExperiencia")
    @Mapping(target = "nivel", source = "nivel")
    @Mapping(target = "empresa", source = "empresa")
    @Mapping(target = "nivelFormacao", source = "nivelFormacao")
    @Mapping(target = "cursos", source = "cursos")
    @Mapping(target = "instituicao", source = "instituicao")
    Curriculo dtoParaDominio(CurriculoDTO dto);
}
