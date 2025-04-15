package com.teste.teste.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trabalho> trabalhos;

    // Construtor padrão
    public Pessoa() {
    }

    // Construtor com parâmetros
    public Pessoa(Long id, String nome, int idade, List<Trabalho> trabalhos) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.trabalhos = trabalhos;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }
}