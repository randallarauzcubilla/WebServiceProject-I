package com.example.webservice.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "colecciones")
public class Colecciones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idColeccion;

    @Column(nullable = false)
    private String nombreColeccion;

    @Column(nullable = false)
    private String siglo;

    @Lob
    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSala", nullable = false)
    @JsonIgnoreProperties("coleccionesCollection")
    private Salas sala;

    public Colecciones() {}

    public Colecciones(String nombreColeccion, String siglo, String descripcion, Salas sala) {
        this.nombreColeccion = nombreColeccion;
        this.siglo = siglo;
        this.descripcion = descripcion;
        this.sala = sala;
    }

    public Integer getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getNombreColeccion() {
        return nombreColeccion;
    }

    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }

    public String getSiglo() {
        return siglo;
    }

    public void setSiglo(String siglo) {
        this.siglo = siglo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Colecciones)) return false;
        Colecciones that = (Colecciones) o;
        return Objects.equals(idColeccion, that.idColeccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idColeccion);
    }

    @Override
    public String toString() {
        return "Colección: " + nombreColeccion + " (" + siglo + ")";
    }
}