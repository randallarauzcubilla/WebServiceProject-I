package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imagenes_salas")
public class ImagenesSalas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImagen")
    private Integer idImagen;

    @Column(name = "urlImagen", nullable = false)
    private String urlImagen;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSala")
    private Salas sala;

    public ImagenesSalas() {}

    public ImagenesSalas(String urlImagen, String tipo, String descripcion, Salas sala) {
        this.urlImagen = urlImagen;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.sala = sala;
    }

    // Getters and setters
    public Integer getIdImagen() {
        return idImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }
}