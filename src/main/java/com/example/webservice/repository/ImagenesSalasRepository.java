package com.example.webservice.repository;

import com.example.webservice.entidades.ImagenesSalas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagenesSalasRepository extends JpaRepository<ImagenesSalas, Integer> {
    List<ImagenesSalas> findByTipo(String tipo);
    List<ImagenesSalas> findByUrlImagen(String urlImagen);
}