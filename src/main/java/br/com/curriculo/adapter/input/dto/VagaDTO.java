package br.com.curriculo.adapter.input.dto;

import br.com.curriculo.domain.enums.Area;
import br.com.curriculo.domain.enums.Nivel;
import br.com.curriculo.domain.enums.Curso;
import java.util.List;

public record VagaDTO(
    String titulo,
    String descricao,
    Area area,
    Nivel nivel,
    Integer anosMinimosExperiencia,
    List<Curso> tecnologiasObrigatorias,
    List<Curso> tecnologiasDesejadas,
    String empresa
) {}

