package com.example.webservice.repository;

import com.example.webservice.entidades.Precios;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface PreciosRepository extends JpaRepository<Precios, Integer> {
    List<Precios> findByPrecioLunesSabado(BigDecimal precioLunesSabado);
    List<Precios> findByPrecioDomingo(BigDecimal precioDomingo);
}