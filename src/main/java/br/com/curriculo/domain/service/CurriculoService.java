package br.com.curriculo.domain.service;

import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.model.ScoreDetalhado;


public class CurriculoService {

    public ScoreDetalhado calcularScoreDetalhado(Curriculo curriculo) {
        // Lógica para calcular o score detalhado com base no currículo
        ScoreDetalhado scoreDetalhado = new ScoreDetalhado();
        // Exemplo de cálculo (substitua pela lógica real)
        scoreDetalhado.setPontuacaoTotal(85);
        scoreDetalhado.setDetalhes("Experiência relevante em Java e Quarkus.");
        return scoreDetalhado;
    }

}
