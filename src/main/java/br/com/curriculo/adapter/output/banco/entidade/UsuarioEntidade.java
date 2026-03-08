package br.com.curriculo.adapter.output.banco.entidade;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntidade extends PanacheEntity {
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private Long curriculoId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public Long getCurriculoId() { return curriculoId; }
    public void setCurriculoId(Long curriculoId) { this.curriculoId = curriculoId; }
}

