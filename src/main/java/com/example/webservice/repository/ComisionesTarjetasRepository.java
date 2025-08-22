package com.example.webservice.repository;

import com.example.webservice.entidades.ComisionesTarjetas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ComisionesTarjetasRepository extends JpaRepository<ComisionesTarjetas, Integer> {
    List<ComisionesTarjetas> findByTipoTarjeta(String tipoTarjeta);
    List<ComisionesTarjetas> findByPorcentajeComision(BigDecimal porcentajeComision);
}