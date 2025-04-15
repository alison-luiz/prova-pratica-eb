package com.teste.teste.mapper;

import com.teste.teste.dto.PessoaDTO;
import com.teste.teste.model.Pessoa;
import java.util.stream.Collectors;

public class PessoaMapper {

    public static PessoaDTO toDto(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setIdade(pessoa.getIdade());
        pessoaDTO.setTrabalhos(pessoa.getTrabalhos().stream()
                .map(TrabalhoMapper::toDto)
                .collect(Collectors.toList()));
        return pessoaDTO;
    }

    public static Pessoa toEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setIdade(pessoaDTO.getIdade());
        pessoa.setTrabalhos(pessoaDTO.getTrabalhos().stream()
                .map(TrabalhoMapper::toEntity)
                .collect(Collectors.toList()));
        return pessoa;
    }
}