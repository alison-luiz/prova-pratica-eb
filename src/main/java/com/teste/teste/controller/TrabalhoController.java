package com.teste.teste.controller;

import com.teste.teste.dto.TrabalhoDTO;
import com.teste.teste.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<TrabalhoDTO> getAll() {
        return trabalhoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TrabalhoDTO> getById(@PathVariable Long id) {
        return trabalhoService.findById(id);
    }

    @PostMapping
    public TrabalhoDTO create(@RequestBody TrabalhoDTO trabalhoDTO) {
        return trabalhoService.save(trabalhoDTO);
    }

    @PutMapping("/{id}")
    public TrabalhoDTO update(@PathVariable Long id, @RequestBody TrabalhoDTO trabalhoDTO) {
        //trabalhoDTO.setId(id);
        return trabalhoService.save(trabalhoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trabalhoService.deleteById(id);
    }
}