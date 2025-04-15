package com.teste.teste.controller;

import com.teste.teste.dto.PessoaDTO;
import com.teste.teste.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> getAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PessoaDTO> getById(@PathVariable Long id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    public PessoaDTO create(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.save(pessoaDTO);
    }

    @PutMapping("/{id}")
    public PessoaDTO update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        //pessoaDTO.setId(id);
        return pessoaService.save(pessoaDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pessoaService.deleteById(id);
    }
}