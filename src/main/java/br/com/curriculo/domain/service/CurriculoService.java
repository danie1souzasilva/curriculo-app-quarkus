package br.com.curriculo.domain.service;

import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.enums.Curso;


public class CurriculoService {

    
    public int calcularScore(Curriculo c) {
        return scoreExperiencia(c)
             + scoreSenioridade(c)
             + scoreFormacao(c)
             + scoreCursos(c)
             + scoreArea(c);
    }

    // -----------------------------
    // EXPERIÊNCIA
    // -----------------------------
    private int scoreExperiencia(Curriculo c) {
        int anos = c.getAnosDeExperiencia();

        if (anos >= 7) return 50;
        if (anos >= 4) return 30;
        if (anos >= 2) return 15;
        return 5;
    }

    // -----------------------------
    // SENIORIDADE
    // -----------------------------
    private int scoreSenioridade(Curriculo c) {
        if (c.getNivel() == null) return 0;
        return switch (c.getNivel()) {
            case JUNIOR -> 10;
            case PLENO  -> 25;
            case SENIOR -> 40;
            case ESPECIALISTA -> 50;
        };
    }

    // -----------------------------
    // FORMAÇÃO
    // -----------------------------
    private int scoreFormacao(Curriculo c) {
        return switch (c.getNivelFormacao()) {
            case MEDIO         -> 10;
            case TECNICO       -> 15;
            case GRADUACAO     -> 25;
            case POS_GRADUACAO -> 35;
            case MESTRADO,
                 DOUTORADO     -> 45;
        };
    }

    // -----------------------------
    // CURSOS / TECNOLOGIAS
    // -----------------------------
    private int scoreCursos(Curriculo c) {
        int score = 0;
        
        if (c.getCursos() == null) return 0;

        for (Curso curso : c.getCursos()) {
            score += switch (curso) {
                case JAVA, SPRING, QUARKUS -> 10;
                case KAFKA, DOCKER -> 8;
                case AWS, GCP, AZURE -> 12;
                default -> 5;
            };
        }
        return score;
    }

    // -----------------------------
    // ÁREA
    // -----------------------------
    private int scoreArea(Curriculo c) {
        if (c.getArea() == null) return 0;
        return switch (c.getArea()) {
            case BACK_END, DEVOPS -> 20;
            case FRONT_END -> 10;
            case ANALISE_DE_DADOS, CIENCIA_DE_DADOS -> 18;
            default -> 5;
        };
    }
}