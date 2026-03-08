package br.com.curriculo.adapter.input.rest;

import br.com.curriculo.application.usecase.CandidaturaService;
import br.com.curriculo.adapter.input.dto.RankingCandidatoDTO;
import br.com.curriculo.adapter.output.banco.entidade.CandidaturaEntidade;
import br.com.curriculo.adapter.output.banco.entidade.UsuarioEntidade;
import br.com.curriculo.adapter.output.banco.repository.UsuarioRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/v1/vagas/{vagaId}/ranking")
public class RankingResource {

    @Inject CandidaturaService candidaturaService;
    @Inject UsuarioRepository usuarioRepository;

    @GET
    public Response getRanking(@PathParam("vagaId") Long vagaId) {
        List<CandidaturaEntidade> candidaturas = candidaturaService.listarRanking(vagaId);
        List<RankingCandidatoDTO> ranking = candidaturas.stream().map(c -> {
            UsuarioEntidade usuario = usuarioRepository.findById(c.getUsuarioId());
            return new RankingCandidatoDTO(
                usuario.getNome(),
                c.getScore(),
                "NIVEL", // Ajuste para buscar o nível do candidato
                0 // Ajuste para buscar anos de experiência
            );
        }).collect(Collectors.toList());
        return Response.ok(ranking).build();
    }
}

