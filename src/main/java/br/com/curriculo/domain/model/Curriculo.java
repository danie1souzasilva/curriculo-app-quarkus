package br.com.curriculo.domain.model;

import br.com.curriculo.domain.enums.*;

import java.util.List;

public class Curriculo {

    private String nome;
    private String email;
    private String descricao;
    private List<Formacao> formacao;
    private List<Cargo> cargo;
    private Area area;
    private Integer anosDeExperiencia;
    private Nivel nivel;
    private List<String> empresa;
    private NivelFormacao nivelFormacao;
    private List<Curso> cursos;
    private List<String> instituicao;

    public Curriculo() {
    }

    public Curriculo(String nome, String email, String descricao,
                     List<Formacao> formacao, List<Cargo> cargo,
                     Area area, Integer anosDeExperiencia, Nivel nivel,
                     List<String> empresa, NivelFormacao nivelFormacao,
                     List<Curso> cursos, List<String> instituicao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.formacao = formacao;
        this.cargo = cargo;
        this.area = area;
        this.anosDeExperiencia = anosDeExperiencia;
        this.nivel = nivel;
        this.empresa = empresa;
        this.nivelFormacao = nivelFormacao;
        this.cursos = cursos;
        this.instituicao = instituicao;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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
