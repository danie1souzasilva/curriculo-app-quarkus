package br.com.curriculo.adapter.input.rest;

import br.com.curriculo.adapter.input.dto.CurriculoDTO;
import br.com.curriculo.application.usecase.CurriculoUseCase;
import br.com.curriculo.domain.model.Curriculo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/curriculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CurriculoController {

    @Inject
    CurriculoUseCase curriculoUseCase;

    private final Logger logger = LoggerFactory.getLogger(CurriculoController.class);

    @POST
    @Path("/lista")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response salvarCurriculo(CurriculoDTO dto) {
        logger.debug("DTO recebido: {}", dto);
        System.out.println("DTO recebido: " + dto);
        curriculoUseCase.salvarCurriculo(dto);
        return Response.status(Response.Status.CREATED).entity(dto).build();
    }
    @GET
    @Path("/lista")
    public Response listarPorNome(@QueryParam("nome") String nome) {
        Curriculo curriculo = curriculoUseCase.buscarCurriculo(nome);
        System.out.println("CurriculoRepository.buscarPorNome");
        return Response.ok(curriculo).build();
    }
}
