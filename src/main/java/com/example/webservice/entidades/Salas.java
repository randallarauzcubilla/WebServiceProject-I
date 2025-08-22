package com.example.webservice.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salas")
public class Salas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Integer idSala;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "tematica", nullable = false)
    private String tematica;

    @ManyToOne(fetch = FetchType.EAGER)//<- funciona si no hay miles de sales "EAGER"
    @JoinColumn(name = "idMuseo", nullable = false)
    @JsonIgnoreProperties({"salasCollection"}) // ← evita el ciclo
    private Museos museo;

    // Constructores
    public Salas() {
    }

    public Salas(Integer idSala, String nombre, String descripcion, String tematica, Museos museo) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tematica = tematica;
        this.museo = museo;
    }

    // Getters y Setters
    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Museos getMuseo() {
        return museo;
    }

    public void setMuseo(Museos museo) {
        this.museo = museo;
    }

    @Override
    public int hashCode() {
        return (idSala != null ? idSala.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Salas)) {
            return false;
        }
        Salas other = (Salas) obj;
        return (this.idSala != null && this.idSala.equals(other.idSala));
    }

    @Override
    public String toString() {
        return nombre;
    }
}
