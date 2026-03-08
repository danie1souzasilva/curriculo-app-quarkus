package br.com.curriculo.domain.model;

import br.com.curriculo.domain.enums.Area;
import br.com.curriculo.domain.enums.Nivel;
import br.com.curriculo.domain.enums.Curso;
import java.time.LocalDateTime;
import java.util.List;

public class Vaga {
    private Long id;
    private String titulo;
    private String descricao;
    private Area area;
    private Nivel nivel;
    private Integer anosMinimosExperiencia;
    private List<Curso> tecnologiasObrigatorias;
    private List<Curso> tecnologiasDesejadas;
    private String empresa;
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Integer getAnosMinimosExperiencia() {
        return anosMinimosExperiencia;
    }

    public void setAnosMinimosExperiencia(Integer anosMinimosExperiencia) {
        this.anosMinimosExperiencia = anosMinimosExperiencia;
    }

    public List<Curso> getTecnologiasObrigatorias() {
        return tecnologiasObrigatorias;
    }

    public void setTecnologiasObrigatorias(List<Curso> tecnologiasObrigatorias) {
        this.tecnologiasObrigatorias = tecnologiasObrigatorias;
    }

    public List<Curso> getTecnologiasDesejadas() {
        return tecnologiasDesejadas;
    }

    public void setTecnologiasDesejadas(List<Curso> tecnologiasDesejadas) {
        this.tecnologiasDesejadas = tecnologiasDesejadas;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}

