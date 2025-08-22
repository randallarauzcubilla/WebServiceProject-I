package com.example.webservice.repository;

import com.example.webservice.entidades.RegistroComisiones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface RegistroComisionesRepository extends JpaRepository<RegistroComisiones, Integer> {
    List<RegistroComisiones> findByValorCobrado(BigDecimal valorCobrado);
}