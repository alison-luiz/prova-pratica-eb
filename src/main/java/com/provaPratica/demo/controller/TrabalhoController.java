package com.provaPratica.demo.controller;

import com.provaPratica.demo.dto.TrabalhoDTO;
import com.provaPratica.demo.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<TrabalhoDTO> listarTodos() {
        return trabalhoService.listarTodos();
    }

    @PostMapping
    public TrabalhoDTO salvar(@RequestBody TrabalhoDTO trabalhoDTO) {
        return trabalhoService.salvar(trabalhoDTO);
    }

    @PutMapping("/{id}")
    public TrabalhoDTO atualizar(@PathVariable Long id, @RequestBody TrabalhoDTO trabalhoDTO) {
        return trabalhoService.atualizar(id, trabalhoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        trabalhoService.deletar(id);
    }
}