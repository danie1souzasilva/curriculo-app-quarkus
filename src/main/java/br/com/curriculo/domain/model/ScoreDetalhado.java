package br.com.curriculo.domain.service



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

}
