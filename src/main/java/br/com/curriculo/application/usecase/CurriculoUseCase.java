package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.input.dto.CurriculoDTO;
import br.com.curriculo.adapter.output.MapearCurriculo;
import br.com.curriculo.adapter.output.banco.repository.CurriculoRepository;
import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.model.ScoreDetalhado;
import br.com.curriculo.domain.service.CurriculoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Caso de uso responsável pela orquestração das operações com currículos.
 * Gerencia o fluxo de salvamento, busca e cálculo de scores.
 */
@ApplicationScoped
public class CurriculoUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CurriculoUseCase.class);

    @Inject
    CurriculoRepository curriculoRepository;

    @Inject
    MapearCurriculo mapper;

    @Inject
    CurriculoService curriculoService;

    /**
     * Salva um novo currículo no banco de dados e calcula seu score.
     * O score é calculado como informação complementar para futuros rankings.
     *
     * @param dto DTO com os dados do currículo
     * @return score do currículo salvo
     */
    @Transactional
    public int salvarCurriculo(CurriculoDTO dto) {
        logger.debug("Iniciando salvamento de currículo para: {}", dto.nome());

        Curriculo curriculo = mapper.dtoParaDominio(dto);
        curriculoRepository.salvarCurriculo(curriculo);

        int score = curriculoService.calcularScore(curriculo);
        logger.info("Currículo salvo com sucesso. Nome: {}, Score: {}", dto.nome(), score);

        return score;
    }

    /**
     * Calcula o score de um currículo a partir de um DTO.
     *
     * @param dto DTO com os dados do currículo
     * @return score numérico do currículo
     */
    public int calcularScore(CurriculoDTO dto) {
        Curriculo curriculo = mapper.dtoParaDominio(dto);
        int score = curriculoService.calcularScore(curriculo);
        logger.debug("Score calculado para currículo: {}", score);
        return score;
    }

    /**
     * Calcula o score detalhado de um currículo a partir de um DTO.
     * Fornece breakdown por critério (experiência, nível, formação, cursos, área).
     *
     * @param dto DTO com os dados do currículo
     * @return ScoreDetalhado com pontuação de cada aspecto
     */
    public ScoreDetalhado calcularScoreDetalhado(CurriculoDTO dto) {
        Curriculo curriculo = mapper.dtoParaDominio(dto);
        ScoreDetalhado scoreDetalhado = curriculoService.calcularScoreDetalhado(curriculo);
        logger.debug("Score detalhado calculado: {}", scoreDetalhado);
        return scoreDetalhado;
    }

    /**
     * Busca um currículo pelo nome.
     *
     * @param nome nome do candidato
     * @return currículo encontrado ou null se não existir
     */
    public Curriculo buscarCurriculo(String nome) {
        logger.debug("Buscando currículo para nome: {}", nome);
        return curriculoRepository.buscarPorNome(nome);
    }
}
