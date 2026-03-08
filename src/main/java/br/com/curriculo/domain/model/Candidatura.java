package br.com.curriculo.domain.model;

import java.time.LocalDateTime;

public class Candidatura {
    private Long id;
    private Long usuarioId;
    private Long vagaId;
    private Integer score;
    private LocalDateTime dataCandidatura;

    public Candidatura() {}

    public Candidatura(Long id, Long usuarioId, Long vagaId, Integer score, LocalDateTime dataCandidatura) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.vagaId = vagaId;
        this.score = score;
        this.dataCandidatura = dataCandidatura;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public LocalDateTime getDataCandidatura() { return dataCandidatura; }
    public void setDataCandidatura(LocalDateTime dataCandidatura) { this.dataCandidatura = dataCandidatura; }
}

