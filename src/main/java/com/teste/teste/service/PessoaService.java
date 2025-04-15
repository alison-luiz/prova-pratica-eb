package com.teste.teste.service;

import com.teste.teste.dto.PessoaDTO;
import com.teste.teste.mapper.PessoaMapper;
import com.teste.teste.model.Pessoa;
import com.teste.teste.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll().stream()
                .map(PessoaMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PessoaDTO> findById(Long id) {
        return pessoaRepository.findById(id).map(PessoaMapper::toDto);
    }

    public PessoaDTO save(PessoaDTO pessoaDTO) {
        Pessoa pessoa = PessoaMapper.toEntity(pessoaDTO);
        return PessoaMapper.toDto(pessoaRepository.save(pessoa));
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}