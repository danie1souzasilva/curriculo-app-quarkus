package br.com.curriculo.adapter.output;

import br.com.curriculo.adapter.output.banco.entidade.VagaEntidade;
import br.com.curriculo.domain.model.Vaga;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface MapearVaga {

    @Mapping(target = "id", ignore = true)
    Vaga entidadeDominio(VagaEntidade vagaEntidade);
}
