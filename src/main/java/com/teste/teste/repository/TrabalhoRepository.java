package com.teste.teste.repository;

import com.teste.teste.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
}