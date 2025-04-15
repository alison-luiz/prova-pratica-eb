package com.teste.teste.model;

import jakarta.persistence.*;

@Entity
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    // Construtor padrão
    public Trabalho() {
    }

    // Construtor com parâmetros
    public Trabalho(Long id, String descricao, Pessoa pessoa) {
        this.id = id;
        this.descricao = descricao;
        this.pessoa = pessoa;
    }

    // Getters e Setters

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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}