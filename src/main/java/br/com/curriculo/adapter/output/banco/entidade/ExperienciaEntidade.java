package br.com.curriculo.adapter.output.banco.entidade;

import br.com.curriculo.domain.enums.Area;
import br.com.curriculo.domain.enums.Cargo;
import br.com.curriculo.domain.enums.Nivel;
import jakarta.persistence.*;

@Entity
@Table(name = "EXPERIENCIA")
public class ExperienciaEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Cargo cargo;
    private Area area;
    private Integer anosDeExperiencia;
    private Nivel nivel;
    private String empresa;
}
