package com.example.webservice.repository;

import com.example.webservice.entidades.Valoraciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValoracionesRepository extends JpaRepository<Valoraciones, Integer> {
    List<Valoraciones> findByEstrellas(Integer estrellas);
}