package br.com.curriculo.adapter.input.dto;

import br.com.curriculo.domain.enums.Nivel;

public record SugestaoCandidatoDTO(
    String nome,
    String email,
    Nivel nivel,
    Integer anosDeExperiencia,
    Integer score
) {}
