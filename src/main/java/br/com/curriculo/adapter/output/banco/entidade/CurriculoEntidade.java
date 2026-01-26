package br.com.curriculo.adapter.output.banco.entidade;


import br.com.curriculo.domain.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CURRICULO")
@AllArgsConstructor
@NoArgsConstructor
public class CurriculoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Area area;
    @Column(name = "nome")
    private String nome;
    private String email;
    private String descricao;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "curriculo_formacao")
    @Column(name = "formacao")
    private List<Formacao> formacao;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "curriculo_cargo")
    @Column(name = "cargo")
    private List<Cargo> cargo;
    private Integer anosDeExperiencia;
    private Nivel nivel;
    private List<String> empresa;
    private NivelFormacao nivelFormacao;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "curriculo_curso")
    @Column(name = "curso")
    private List<Curso> cursos;
    private List<String> instituicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Formacao> getFormacao() {
        return formacao;
    }

    public void setFormacao(List<Formacao> formacao) {
        this.formacao = formacao;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }

    public Integer getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(Integer anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<String> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<String> empresa) {
        this.empresa = empresa;
    }

    public NivelFormacao getNivelFormacao() {
        return nivelFormacao;
    }

    public void setNivelFormacao(NivelFormacao nivelFormacao) {
        this.nivelFormacao = nivelFormacao;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<String> getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(List<String> instituicao) {
        this.instituicao = instituicao;
    }
}
