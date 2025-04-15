package com.provaPratica.demo.dto;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String email;
    private Long trabalhoId;
    private String trabalhoDescricao;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTrabalhoId() {
        return trabalhoId;
    }

    public void setTrabalhoId(Long trabalhoId) {
        this.trabalhoId = trabalhoId;
    }

    public String getTrabalhoDescricao() {
        return trabalhoDescricao;
    }

    public void setTrabalhoDescricao(String trabalhoDescricao) {
        this.trabalhoDescricao = trabalhoDescricao;
    }
}