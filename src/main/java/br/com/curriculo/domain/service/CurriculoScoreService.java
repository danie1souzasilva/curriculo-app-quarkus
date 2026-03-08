package br.com.curriculo.domain.service;

import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.enums.*;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Serviço de domínio responsável por calcular o score de um currículo.
 *
 * A lógica de pontuação considera:
 * - Anos de experiência
 * - Nível profissional (Junior, Pleno, Sênior, Especialista)
 * - Nível de formação (Médio, Técnico, Graduação, Pós-graduação, Mestrado, Doutorado)
 * - Cursos/Tecnologias
 * - Área de atuação
 *
 * Score máximo esperado: ~180 pontos (dependendo da configuração)
 */
@ApplicationScoped
public class CurriculoScoreService {

    private static final Logger logger = LoggerFactory.getLogger(CurriculoScoreService.class);

    /**
     * Calcula o score total de um currículo baseado em múltiplos critérios.
     *
     * @param curriculo o currículo a ser avaliado
     * @return score numérico do currículo
     */
    public int calcularScore(Curriculo curriculo) {
        if (curriculo == null) {
            logger.warn("Tentativa de calcular score com currículo nulo");
            return 0;
        }

        int scoreTotal = 0;
        scoreTotal += calcularScoreExperiencia(curriculo.getAnosDeExperiencia());
        scoreTotal += calcularScoreNivel(curriculo.getNivel());
        scoreTotal += calcularScoreFormacao(curriculo.getNivelFormacao());
        scoreTotal += calcularScoreCursos(curriculo.getCursos());
        scoreTotal += calcularScoreArea(curriculo.getArea());

        logger.debug("Score calculado para currículo: {} pontos", scoreTotal);
        return scoreTotal;
    }

    /**
     * Calcula o score baseado nos anos de experiência.
     *
     * Regra:
     * 0–1 anos = 5 pontos
     * 2–3 anos = 15 pontos
     * 4–6 anos = 30 pontos
     * 7+ anos = 50 pontos
     *
     * @param anosDeExperiencia anos de experiência
     * @return score de experiência
     */
    private int calcularScoreExperiencia(Integer anosDeExperiencia) {
        if (anosDeExperiencia == null || anosDeExperiencia < 0) {
            return 0;
        }

        return switch (anosDeExperiencia) {
            case 0, 1 -> 5;
            case 2, 3 -> 15;
            case 4, 5, 6 -> 30;
            default -> anosDeExperiencia >= 7 ? 50 : 0;
        };
    }

    /**
     * Calcula o score baseado no nível profissional.
     *
     * Regra:
     * JUNIOR = 10 pontos
     * PLENO = 25 pontos
     * SENIOR = 40 pontos
     * ESPECIALISTA = 50 pontos
     *
     * @param nivel nível profissional
     * @return score de nível
     */
    private int calcularScoreNivel(Nivel nivel) {
        if (nivel == null) {
            return 0;
        }

        return switch (nivel) {
            case JUNIOR -> 10;
            case PLENO -> 25;
            case SENIOR -> 40;
            case ESPECIALISTA -> 50;
        };
    }

    /**
     * Calcula o score baseado no nível de formação.
     *
     * Regra:
     * MEDIO = 10 pontos
     * TECNICO = 15 pontos
     * GRADUACAO = 25 pontos
     * POS_GRADUACAO = 35 pontos
     * MESTRADO = 45 pontos
     * DOUTORADO = 45 pontos
     *
     * @param nivelFormacao nível de formação
     * @return score de formação
     */
    private int calcularScoreFormacao(NivelFormacao nivelFormacao) {
        if (nivelFormacao == null) {
            return 0;
        }

        return switch (nivelFormacao) {
            case MEDIO -> 10;
            case TECNICO -> 15;
            case GRADUACAO -> 25;
            case POS_GRADUACAO -> 35;
            case MESTRADO, DOUTORADO -> 45;
        };
    }

    /**
     * Calcula o score baseado nos cursos/tecnologias.
     *
     * Regra de pontuação por curso:
     * JAVA, SPRING, QUARKUS = +10 pontos
     * KAFKA, DOCKER = +8 pontos
     * AWS, GCP, AZURE = +12 pontos
     * Outros cursos = +5 pontos
     *
     * @param cursos lista de cursos
     * @return score total de cursos
     */
    private int calcularScoreCursos(java.util.List<Curso> cursos) {
        if (cursos == null || cursos.isEmpty()) {
            return 0;
        }

        int scoreTotal = 0;
        Map<Curso, Integer> pontuacaoPorCurso = buildMapPontuacaoCursos();

        for (Curso curso : cursos) {
            scoreTotal += pontuacaoPorCurso.getOrDefault(curso, 5);
        }

        return scoreTotal;
    }

    /**
     * Constrói o mapa de pontuação para cada curso.
     * Facilita a manutenção e extensão da lógica de pontuação.
     *
     * @return mapa com pontuações de cada curso
     */
    private Map<Curso, Integer> buildMapPontuacaoCursos() {
        Map<Curso, Integer> pontuacao = new HashMap<>();

        // Backend - 10 pontos
        pontuacao.put(Curso.JAVA, 10);
        pontuacao.put(Curso.SPRING, 10);
        pontuacao.put(Curso.QUARKUS, 10);

        // Infraestrutura - 8 pontos
        pontuacao.put(Curso.KAFKA, 8);
        pontuacao.put(Curso.DOCKER, 8);

        // Cloud - 12 pontos
        pontuacao.put(Curso.AWS, 12);
        pontuacao.put(Curso.GCP, 12);
        pontuacao.put(Curso.AZURE, 12);

        // Para qualquer outro curso não mapeado, o método calcularScoreCursos
        // usa getOrDefault com 5 como valor padrão

        return pontuacao;
    }

    /**
     * Calcula o score baseado na área de atuação.
     *
     * Regra:
     * BACK_END ou DEVOPS = +20 pontos
     * FRONT_END = +10 pontos
     * Outras áreas = 0 pontos
     *
     * @param area área de atuação
     * @return score de área
     */
    private int calcularScoreArea(Area area) {
        if (area == null) {
            return 0;
        }

        return switch (area) {
            case BACK_END, DEVOPS -> 20;
            case FRONT_END -> 10;
            default -> 0;
        };
    }
}

