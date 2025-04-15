package com.teste.teste.dto;


import java.util.List;

public class PessoaDTO {

    private Long id;
    private String nome;
    private int idade;
    private List<TrabalhoDTO> trabalhos;

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

    public List<TrabalhoDTO> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<TrabalhoDTO> trabalhos) {
        this.trabalhos = trabalhos;
    }

}