package com.provaPratica.demo.service;

import com.provaPratica.demo.dto.PessoaDTO;
import com.provaPratica.demo.model.Pessoa;
import com.provaPratica.demo.model.Trabalho;
import com.provaPratica.demo.repository.PessoaRepository;
import com.provaPratica.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<PessoaDTO> listarTodos() {
        return pessoaRepository.findAll().stream()
                .map(pessoa -> {
                    PessoaDTO dto = new PessoaDTO();
                    dto.setId(pessoa.getId());
                    dto.setNome(pessoa.getNome());
                    dto.setEmail(pessoa.getEmail());
                    dto.setTrabalhoId(pessoa.getTrabalho().getId());
                    dto.setTrabalhoDescricao(pessoa.getTrabalho().getDescricao());
                    return dto;
                }).collect(Collectors.toList());
    }

    public PessoaDTO salvar(PessoaDTO pessoaDTO) {
        Trabalho trabalho = trabalhoRepository.findById(pessoaDTO.getTrabalhoId())
                .orElseThrow(() -> new RuntimeException("Trabalho não encontrado com o ID: " + pessoaDTO.getTrabalhoId()));

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setTrabalho(trabalho);

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        pessoaDTO.setId(pessoaSalva.getId());
        pessoaDTO.setTrabalhoDescricao(trabalho.getDescricao());
        return pessoaDTO;
    }

    public PessoaDTO atualizar(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoaExistente = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));

        pessoaExistente.setNome(pessoaDTO.getNome());
        pessoaExistente.setEmail(pessoaDTO.getEmail());

        Trabalho trabalho = trabalhoRepository.findById(pessoaDTO.getTrabalhoId())
                .orElseThrow(() -> new RuntimeException("Trabalho não encontrado com o ID: " + pessoaDTO.getTrabalhoId()));
        pessoaExistente.setTrabalho(trabalho);

        Pessoa pessoaAtualizada = pessoaRepository.save(pessoaExistente);

        PessoaDTO pessoaAtualizadaDTO = new PessoaDTO();
        pessoaAtualizadaDTO.setId(pessoaAtualizada.getId());
        pessoaAtualizadaDTO.setNome(pessoaAtualizada.getNome());
        pessoaAtualizadaDTO.setEmail(pessoaAtualizada.getEmail());
        pessoaAtualizadaDTO.setTrabalhoId(trabalho.getId());

        return pessoaAtualizadaDTO;
    }

    public void deletar(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new RuntimeException("Pessoa não encontrada com o ID: " + id);
        }
        pessoaRepository.deleteById(id);
    }
}