package com.provaPratica.demo.service;

import com.provaPratica.demo.dto.TrabalhoDTO;
import com.provaPratica.demo.model.Trabalho;
import com.provaPratica.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<TrabalhoDTO> listarTodos() {
        return trabalhoRepository.findAll().stream().map(trabalho -> {
            TrabalhoDTO dto = new TrabalhoDTO();
            dto.setId(trabalho.getId());
            dto.setDescricao(trabalho.getDescricao());
            return dto;
        }).collect(Collectors.toList());
    }

    public TrabalhoDTO salvar(TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = new Trabalho();
        trabalho.setDescricao(trabalhoDTO.getDescricao());
        Trabalho trabalhoSalvo = trabalhoRepository.save(trabalho);
        trabalhoDTO.setId(trabalhoSalvo.getId());
        return trabalhoDTO;
    }

    public TrabalhoDTO atualizar(Long id, TrabalhoDTO trabalhoDTO) {
        Trabalho trabalhoExistente = trabalhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabalho não encontrado com o ID: " + id));

        trabalhoExistente.setDescricao(trabalhoDTO.getDescricao());
        Trabalho trabalhoAtualizado = trabalhoRepository.save(trabalhoExistente);

        TrabalhoDTO trabalhoAtualizadoDTO = new TrabalhoDTO();
        trabalhoAtualizadoDTO.setId(trabalhoAtualizado.getId());
        trabalhoAtualizadoDTO.setDescricao(trabalhoAtualizado.getDescricao());

        return trabalhoAtualizadoDTO;
    }

    public void deletar(Long id) {
        if (!trabalhoRepository.existsById(id)) {
            throw new RuntimeException("Trabalho não encontrado com o ID: " + id);
        }
        trabalhoRepository.deleteById(id);
    }
}