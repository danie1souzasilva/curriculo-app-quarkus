package br.com.curriculo.adapter.input.dto;

import br.com.curriculo.domain.enums.*;
import lombok.*;

import java.util.List;

public record CurriculoDTO(
        Area area,
        String nome,
        String email,
        String descricao,
        List<Formacao> formacao,
        List<Cargo> cargo,
        Integer anosDeExperiencia,
        Nivel nivel,
        List<String> empresa,
        NivelFormacao nivelFormacao,
        List<Curso> cursos,
        List<String> instituicao
) {}
