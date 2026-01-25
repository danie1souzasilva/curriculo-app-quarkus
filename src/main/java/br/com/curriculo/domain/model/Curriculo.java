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

}
