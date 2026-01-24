package br.com.curriculo.adapter.output.banco.entidade;


import jakarta.persistence.*;

@Entity
@Table(name = "CURRICULO")
public class CurriculoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String area;
}
