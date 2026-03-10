package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.output.banco.repository.UsuarioRepository;
import br.com.curriculo.adapter.output.banco.repository.CurriculoRepository;
import br.com.curriculo.adapter.output.banco.repository.CandidaturaRepository;
import br.com.curriculo.adapter.output.banco.repository.VagaRepository;
import br.com.curriculo.adapter.output.banco.entidade.UsuarioEntidade;
import br.com.curriculo.adapter.output.banco.entidade.CurriculoEntidade;
import br.com.curriculo.adapter.output.banco.entidade.CandidaturaEntidade;
import br.com.curriculo.adapter.output.banco.entidade.VagaEntidade;
import br.com.curriculo.adapter.output.MapearCurriculo;
import br.com.curriculo.adapter.output.MapearVaga;
import br.com.curriculo.domain.service.CurriculoScoreService;
import br.com.curriculo.domain.service.MatchingService;
import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.model.Vaga;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class CandidaturaService {

    @Inject UsuarioRepository usuarioRepository;
    @Inject CurriculoRepository curriculoRepository;
    @Inject CandidaturaRepository candidaturaRepository;
    @Inject VagaRepository vagaRepository;
    @Inject CurriculoScoreService curriculoScoreService;
    @Inject MatchingService matchingService;
    @Inject MapearCurriculo mapearCurriculo;
    @Inject MapearVaga mapearVaga;

    @Transactional
    public void candidatar(Long usuarioId, Long vagaId) {
        UsuarioEntidade usuario = usuarioRepository.findById(usuarioId);
        if (usuario == null) throw new IllegalArgumentException("Usuário não encontrado");
        CurriculoEntidade curriculo = curriculoRepository.findById(usuario.getCurriculoId());
        if (curriculo == null) throw new IllegalArgumentException("Currículo não encontrado");
        VagaEntidade vaga = vagaRepository.findById(vagaId);
        if (vaga == null) throw new IllegalArgumentException("Vaga não encontrada");

        Curriculo curriculoDominio = mapearCurriculo.entidadeDominio(curriculo);
        Vaga vagaDominio = mapearVaga.entidadeDominio(vaga);
        int scoreCurriculo = curriculoScoreService.calcularScore(curriculoDominio);
        int scoreMatchVaga = matchingService.calcularScore(curriculoDominio, vagaDominio);
        int scoreFinal = scoreCurriculo + scoreMatchVaga;

        CandidaturaEntidade candidatura = new CandidaturaEntidade();
        candidatura.setUsuarioId(usuarioId);
        candidatura.setVagaId(vagaId);
        candidatura.setScore(scoreFinal);
        candidatura.setDataCandidatura(LocalDateTime.now());
        candidaturaRepository.persist(candidatura);
    }

    public List<CandidaturaEntidade> listarRanking(Long vagaId) {
        return candidaturaRepository.findByVagaIdOrderByScoreDesc(vagaId);
    }
}
