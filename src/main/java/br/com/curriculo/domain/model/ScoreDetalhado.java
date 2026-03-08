package br.com.curriculo.domain.model;

public class ScoreDetalhado {

    private int pontuacaoTotal;
    private String detalhes;

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public ScoreDetalhado() {
    }
    public ScoreDetalhado(int pontuacaoTotal, String detalhes) {
        this.pontuacaoTotal = pontuacaoTotal;
        this.detalhes = detalhes;
    }
    public ScoreDetalhado(int scoreTotal, int scoreExperiencia, int scoreNivel, int scoreFormacao, int scoreCursos, int scoreArea) {
        this.pontuacaoTotal = scoreTotal;
        this.detalhes = detalhes;
    }

}
