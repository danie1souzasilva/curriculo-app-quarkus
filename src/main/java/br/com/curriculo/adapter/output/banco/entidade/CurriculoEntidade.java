package br.com.curriculo.adapter.output.banco.entidade;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURRICULO")
public class CurriculoEntidade {
    private Long id;
    private String area;
}
