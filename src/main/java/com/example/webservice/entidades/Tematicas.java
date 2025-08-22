package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tematicas")
public class Tematicas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTematica")
    private Integer id;

    @Column(name = "nombreDeTematica", nullable = false)
    private String nombre;

    @Lob
    @Column(name = "caracteristicas", nullable = false)
    private String caracteristicas;

    @Column(name = "epocaDeTematica", nullable = false)
    private String epoca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSala")
    private Salas sala;

    // Constructores
    public Tematicas() {}

    public Tematicas(String nombre, String caracteristicas, String epoca, Salas sala) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.epoca = epoca;
        this.sala = sala;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }

    // Métodos utilitarios
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tematicas)) return false;
        Tematicas that = (Tematicas) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Tematica{id=" + id + ", nombre='" + nombre + "'}";
    }
}
