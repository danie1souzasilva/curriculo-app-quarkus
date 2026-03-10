package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.input.dto.SugestaoCandidatoDTO;
import br.com.curriculo.adapter.output.MapearCurriculo;
import br.com.curriculo.adapter.output.MapearVaga;
import br.com.curriculo.adapter.output.banco.entidade.CurriculoEntidade;
import br.com.curriculo.adapter.output.banco.entidade.VagaEntidade;
import br.com.curriculo.adapter.output.banco.repository.CurriculoRepository;
import br.com.curriculo.adapter.output.banco.repository.VagaRepository;
import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.model.Vaga;
import br.com.curriculo.domain.service.CurriculoScoreService;
import br.com.curriculo.domain.service.MatchingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SugestaoCandidatoService {

    private static final int LIMITE_PADRAO = 10;

    @Inject CurriculoRepository curriculoRepository;
    @Inject VagaRepository vagaRepository;
    @Inject MapearCurriculo mapearCurriculo;
    @Inject MapearVaga mapearVaga;
    @Inject CurriculoScoreService curriculoScoreService;
    @Inject MatchingService matchingService;

    public List<SugestaoCandidatoDTO> sugerir(Long vagaId, Integer limite) {
        VagaEntidade vagaEntidade = vagaRepository.findById(vagaId);
        if (vagaEntidade == null) {
            throw new IllegalArgumentException("Vaga não encontrada");
        }

        int limiteEfetivo = (limite == null || limite <= 0) ? LIMITE_PADRAO : limite;

        Vaga vaga = mapearVaga.entidadeDominio(vagaEntidade);
        List<CurriculoEntidade> curriculos = curriculoRepository.listAll();

        return curriculos.stream()
                .map(entidade -> {
                    Curriculo curriculo = mapearCurriculo.entidadeDominio(entidade);
                    int scoreCurriculo = curriculoScoreService.calcularScore(curriculo);
                    int scoreMatch = matchingService.calcularScore(curriculo, vaga);
                    int scoreFinal = scoreCurriculo + scoreMatch;
                    return new SugestaoCandidatoDTO(
                            curriculo.getNome(),
                            curriculo.getEmail(),
                            curriculo.getNivel(),
                            curriculo.getAnosDeExperiencia(),
                            scoreFinal
                    );
                })
                .sorted(Comparator.comparingInt(SugestaoCandidatoDTO::score).reversed())
                .limit(limiteEfetivo)
                .collect(Collectors.toList());
    }
}
