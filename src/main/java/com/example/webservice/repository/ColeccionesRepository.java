package com.example.webservice.repository;

import com.example.webservice.entidades.Colecciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Randall AC
 */
@Repository
public interface ColeccionesRepository extends JpaRepository<Colecciones, Integer> {
}