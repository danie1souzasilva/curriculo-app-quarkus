package br.com.curriculo.adapter.input.dto;

import br.com.curriculo.domain.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurriculoDTO {
    private Area area;
    private String nome;
    private String email;
    private String descricao;
    private List<Formacao> formacao;
    private List<Cargo> cargo;
    private Integer anosDeExperiencia;
    private Nivel nivel;
    private List<String> empresa;
    private NivelFormacao nivelFormacao;
    private List<Curso> cursos;
    private List<String> instituicao;


}
