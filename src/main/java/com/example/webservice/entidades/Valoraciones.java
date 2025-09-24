package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "valoraciones")
public class Valoraciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idValoracion")
    private Integer idValoracion;

    @Column(name = "estrellas")
    private Integer estrellas;

    @Lob
    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSala")
    private Salas sala;

    public Valoraciones() {}

    public Valoraciones(Integer estrellas, String observacion, Salas sala) {
        this.estrellas = estrellas;
        this.observacion = observacion;
        this.sala = sala;
    }

    // Getters and setters
    public Integer getIdValoracion() {
        return idValoracion;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }
}