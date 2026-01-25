package br.com.curriculo.adapter.input.rest;

import br.com.curriculo.application.usecase.CurriculoUseCase;
import br.com.curriculo.domain.model.Curriculo;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/curriculo")
public class CurriculoController {

    @Inject
    CurriculoUseCase curriculoUseCase;

    @POST
    public Response salvarCurriculo(Curriculo curriculo){
        curriculoUseCase.salvarCurriculo(curriculo);
        return Response.ok().build();
    }
}
