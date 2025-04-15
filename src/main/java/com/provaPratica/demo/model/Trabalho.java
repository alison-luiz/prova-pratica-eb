package com.provaPratica.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pessoa> pessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}