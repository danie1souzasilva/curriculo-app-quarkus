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
@Data
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
}
