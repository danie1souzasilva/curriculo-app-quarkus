package br.com.curriculo.adapter.output.banco.entidade;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidatura")
public class CandidaturaEntidade extends PanacheEntity {
    @Column(nullable = false)
    private Long usuarioId;
    @Column(nullable = false)
    private Long vagaId;
    @Column(nullable = false)
    private Integer score;
    @Column(nullable = false)
    private LocalDateTime dataCandidatura;

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public LocalDateTime getDataCandidatura() { return dataCandidatura; }
    public void setDataCandidatura(LocalDateTime dataCandidatura) { this.dataCandidatura = dataCandidatura; }
}

