package br.com.curriculo.adapter.input.rest;

import br.com.curriculo.adapter.input.dto.CurriculoDTO;
import br.com.curriculo.application.usecase.CurriculoUseCase;
import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.model.ScoreDetalhado;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller REST para gerenciar operações com currículos.
 * Responsável pela exposição das APIs de salvamento, busca e avaliação de currículos.
 */
@Path("/curriculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CurriculoController {

    private static final Logger logger = LoggerFactory.getLogger(CurriculoController.class);

    @Inject
    CurriculoUseCase curriculoUseCase;

    /**
     * Salva um novo currículo e retorna seu score.
     *
     * @param dto dados do currículo a ser salvo
     * @return resposta com o DTO e o score calculado
     */
    @POST
    @Path("/lista")
    @Transactional
    public Response salvarCurriculo(CurriculoDTO dto) {
        logger.debug("DTO recebido para salvamento: {}", dto);

        int score = curriculoUseCase.salvarCurriculo(dto);

        Map<String, Object> response = new HashMap<>();
        response.put("curriculo", dto);
        response.put("score", score);

        logger.info("Currículo salvo com sucesso. Score: {}", score);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    /**
     * Busca um currículo pelo nome do candidato.
     *
     * @param nome nome do candidato a buscar
     * @return currículo encontrado ou erro 404
     */
    @GET
    @Path("/lista")
    public Response listarPorNome(@QueryParam("nome") String nome) {
        logger.debug("Buscando currículo para nome: {}", nome);

        Curriculo curriculo = curriculoUseCase.buscarCurriculo(nome);

        if (curriculo == null) {
            logger.warn("Currículo não encontrado para nome: {}", nome);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Currículo não encontrado")
                    .build();
        }

        logger.info("Currículo encontrado para nome: {}", nome);
        return Response.ok(curriculo).build();
    }

    /**
     * Calcula o score simples de um currículo.
     * Útil para validação antes de salvar.
     *
     * @param dto dados do currículo para avaliação
     * @return score numérico do currículo
     */
    @POST
    @Path("/score")
    public Response calcularScore(CurriculoDTO dto) {
        logger.debug("Calculando score para currículo: {}", dto.nome());

        int score = curriculoUseCase.calcularScore(dto);

        Map<String, Object> response = new HashMap<>();
        response.put("nome", dto.nome());
        response.put("score", score);

        return Response.ok(response).build();
    }

    /**
     * Calcula o score detalhado de um currículo com breakdown por critério.
     * Fornece informações sobre qual aspecto do currículo contribuiu mais para o score.
     *
     * @param dto dados do currículo para avaliação detalhada
     * @return ScoreDetalhado com pontuação de cada aspecto
     */
    @POST
    @Path("/score-detalhado")
    public Response calcularScoreDetalhado(CurriculoDTO dto) {
        logger.debug("Calculando score detalhado para currículo: {}", dto.nome());

        ScoreDetalhado scoreDetalhado = curriculoUseCase.calcularScoreDetalhado(dto);

        Map<String, Object> response = new HashMap<>();
        response.put("nome", dto.nome());
        response.put("scoreDetalhado", scoreDetalhado);

        return Response.ok(response).build();
    }
}
