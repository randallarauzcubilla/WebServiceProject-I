package com.example.webservice.repository;

import com.example.webservice.entidades.Tematicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Randall AC
 */
@Repository
public interface TematicasRepository extends JpaRepository<Tematicas, Long> {
}