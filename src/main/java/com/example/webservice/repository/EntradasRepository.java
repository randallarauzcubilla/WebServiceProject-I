package com.example.webservice.repository;
import com.example.webservice.entidades.Entradas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EntradasRepository extends JpaRepository<Entradas, Integer> {
    List<Entradas> findByFechaCompra(Date fechaCompra);
    List<Entradas> findByFechaVisita(Date fechaVisita);
    List<Entradas> findByCodigoQR(String codigoQR);
}