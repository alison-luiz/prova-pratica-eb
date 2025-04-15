package com.teste.teste.service;

import com.teste.teste.dto.TrabalhoDTO;
import com.teste.teste.mapper.TrabalhoMapper;
import com.teste.teste.model.Trabalho;
import com.teste.teste.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<TrabalhoDTO> findAll() {
        return trabalhoRepository.findAll().stream()
                .map(TrabalhoMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<TrabalhoDTO> findById(Long id) {
        return trabalhoRepository.findById(id).map(TrabalhoMapper::toDto);
    }

    public TrabalhoDTO save(TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = TrabalhoMapper.toEntity(trabalhoDTO);
        return TrabalhoMapper.toDto(trabalhoRepository.save(trabalho));
    }

    public void deleteById(Long id) {
        trabalhoRepository.deleteById(id);
    }
}