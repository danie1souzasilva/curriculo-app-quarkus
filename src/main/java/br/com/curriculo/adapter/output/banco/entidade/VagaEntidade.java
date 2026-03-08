package br.com.curriculo.adapter.output.banco.entidade;

import br.com.curriculo.domain.enums.Area;
import br.com.curriculo.domain.enums.Nivel;
import br.com.curriculo.domain.enums.Curso;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vaga")
public class VagaEntidade extends PanacheEntity {
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Area area;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Nivel nivel;
    @Column(nullable = false)
    private Integer anosMinimosExperiencia;
    @ElementCollection(targetClass = Curso.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "vaga_tecnologias_obrigatorias", joinColumns = @JoinColumn(name = "vaga_id"))
    @Column(name = "tecnologia_obrigatoria")
    private List<Curso> tecnologiasObrigatorias;
    @ElementCollection(targetClass = Curso.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "vaga_tecnologias_desejadas", joinColumns = @JoinColumn(name = "vaga_id"))
    @Column(name = "tecnologia_desejada")
    private List<Curso> tecnologiasDesejadas;
    @Column(nullable = false)
    private String empresa;
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Area getArea() { return area; }
    public void setArea(Area area) { this.area = area; }
    public Nivel getNivel() { return nivel; }
    public void setNivel(Nivel nivel) { this.nivel = nivel; }
    public Integer getAnosMinimosExperiencia() { return anosMinimosExperiencia; }
    public void setAnosMinimosExperiencia(Integer anosMinimosExperiencia) { this.anosMinimosExperiencia = anosMinimosExperiencia; }
    public List<Curso> getTecnologiasObrigatorias() { return tecnologiasObrigatorias; }
    public void setTecnologiasObrigatorias(List<Curso> tecnologiasObrigatorias) { this.tecnologiasObrigatorias = tecnologiasObrigatorias; }
    public List<Curso> getTecnologiasDesejadas() { return tecnologiasDesejadas; }
    public void setTecnologiasDesejadas(List<Curso> tecnologiasDesejadas) { this.tecnologiasDesejadas = tecnologiasDesejadas; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
