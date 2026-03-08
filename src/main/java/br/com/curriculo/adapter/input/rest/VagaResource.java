package br.com.curriculo.adapter.input.rest;

import br.com.curriculo.adapter.input.dto.VagaDTO;
import br.com.curriculo.adapter.output.banco.entidade.VagaEntidade;
import br.com.curriculo.application.usecase.VagaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/vagas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VagaResource {

    @Inject
    VagaService vagaService;

    @POST
    @Transactional
    public Response cadastrarVaga(VagaDTO dto) {
        vagaService.salvarVaga(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listarVagas() {
        List<VagaEntidade> vagas = vagaService.listarVagas();
        return Response.ok(vagas).build();
    }
}

