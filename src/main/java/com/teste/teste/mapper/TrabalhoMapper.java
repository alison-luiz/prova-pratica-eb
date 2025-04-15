package com.teste.teste.mapper;

import com.teste.teste.dto.TrabalhoDTO;
import com.teste.teste.model.Trabalho;

public class TrabalhoMapper {

    public static TrabalhoDTO toDto(Trabalho trabalho) {
        TrabalhoDTO trabalhoDTO = new TrabalhoDTO();
        trabalhoDTO.setId(trabalho.getId());
        trabalhoDTO.setDescricao(trabalho.getDescricao());
        return trabalhoDTO;
    }

    public static Trabalho toEntity(TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = new Trabalho();
        trabalho.setId(trabalhoDTO.getId());
        trabalho.setDescricao(trabalhoDTO.getDescricao());
        return trabalho;
    }
}