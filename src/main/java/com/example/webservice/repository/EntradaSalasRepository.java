package com.example.webservice.repository;

import com.example.webservice.entidades.EntradaSalas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface EntradaSalasRepository extends JpaRepository<EntradaSalas, Integer> {
    List<EntradaSalas> findByPrecioSala(BigDecimal precioSala);
}