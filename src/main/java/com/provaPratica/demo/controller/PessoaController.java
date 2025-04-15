package com.provaPratica.demo.controller;

import com.provaPratica.demo.dto.PessoaDTO;
import com.provaPratica.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> listarTodos() {
        return pessoaService.listarTodos();
    }

    @PostMapping
    public PessoaDTO salvar(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.salvar(pessoaDTO);
    }

    @PutMapping("/{id}")
    public PessoaDTO atualizar(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.atualizar(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
    }
}