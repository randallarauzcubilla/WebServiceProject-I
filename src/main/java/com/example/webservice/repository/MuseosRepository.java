package com.example.webservice.repository;

import com.example.webservice.entidades.Museos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseosRepository extends JpaRepository<Museos, Integer> {
}