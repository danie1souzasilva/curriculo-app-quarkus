package br.com.curriculo.adapter.input.rest;

import br.com.curriculo.application.usecase.CandidaturaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/candidaturas")
public class CandidaturaResource {

    @Inject CandidaturaService candidaturaService;

    @POST
    @Path("/candidatar")
    public Response candidatar(@QueryParam("usuarioId") Long usuarioId, @QueryParam("vagaId") Long vagaId) {
        candidaturaService.candidatar(usuarioId, vagaId);
        return Response.status(Response.Status.CREATED).build();
    }
}

