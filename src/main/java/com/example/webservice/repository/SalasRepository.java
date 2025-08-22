package com.example.webservice.repository;
import com.example.webservice.entidades.Salas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalasRepository extends JpaRepository<Salas, Integer> {
}