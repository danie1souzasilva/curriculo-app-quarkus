package br.com.curriculo.domain.service;

import br.com.curriculo.domain.enums.Area;
import br.com.curriculo.domain.enums.Curso;
import br.com.curriculo.domain.enums.Nivel;
import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.model.Vaga;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servico de dominio responsavel por calcular o score de matching entre
 * um curriculo e uma vaga.
 */
@ApplicationScoped
public class MatchingService {

    private static final Logger logger = LoggerFactory.getLogger(MatchingService.class);

    public int calcularScore(Curriculo curriculo, Vaga vaga) {
        if (curriculo == null || vaga == null) {
            logger.warn("Tentativa de calcular matching com curriculo ou vaga nulos");
            return 0;
        }

        int scoreTotal = 0;
        scoreTotal += scoreArea(curriculo.getArea(), vaga.getArea());
        scoreTotal += scoreExperiencia(curriculo.getAnosDeExperiencia(), vaga.getAnosMinimosExperiencia());
        scoreTotal += scoreNivel(curriculo.getNivel(), vaga.getNivel());
        scoreTotal += scoreTecnologias(curriculo.getCursos(), vaga.getTecnologiasObrigatorias());

        logger.debug("Score de matching calculado: {} pontos", scoreTotal);
        return scoreTotal;
    }

    private int scoreArea(Area areaCurriculo, Area areaVaga) {
        if (areaCurriculo == null || areaVaga == null) {
            return 0;
        }
        return areaCurriculo == areaVaga ? 30 : 0;
    }

    private int scoreExperiencia(Integer anosCurriculo, Integer anosMinimosVaga) {
        if (anosCurriculo == null || anosMinimosVaga == null) {
            return 0;
        }
        return anosCurriculo >= anosMinimosVaga ? 20 : 0;
    }

    private int scoreNivel(Nivel nivelCurriculo, Nivel nivelVaga) {
        if (nivelCurriculo == null || nivelVaga == null) {
            return 0;
        }
        return nivelCurriculo.ordinal() >= nivelVaga.ordinal() ? 15 : 0;
    }

    private int scoreTecnologias(List<Curso> cursosCurriculo, List<Curso> tecnologiasObrigatorias) {
        if (cursosCurriculo == null || cursosCurriculo.isEmpty()) {
            return 0;
        }
        if (tecnologiasObrigatorias == null || tecnologiasObrigatorias.isEmpty()) {
            return 0;
        }

        Set<Curso> cursosSet = new HashSet<>(cursosCurriculo);
        int score = 0;
        for (Curso tecnologia : tecnologiasObrigatorias) {
            if (cursosSet.contains(tecnologia)) {
                score += 10;
            }
        }
        return score;
    }
}
