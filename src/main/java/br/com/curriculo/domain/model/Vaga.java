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

    // Getters e setters
    // ...existing code...
}

