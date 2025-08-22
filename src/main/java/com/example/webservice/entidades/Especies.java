package com.example.webservice.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Randall AC
 */
@Entity
@Table(name = "especies")
public class Especies implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecie;

    @Column(nullable = false, length = 100)
    private String nombreCientificoDeEspecie;

    @Column(length = 100)
    private String nombreComunDeEspecie;

    private LocalDate fechaExtincion;

    @Column(length = 50)
    private String epoca;

    private BigDecimal peso;

    private BigDecimal tamanio;

    @ManyToOne
    @JoinColumn(name = "id_coleccion")
    @JsonIgnoreProperties("especies")
    private Colecciones coleccion;

    // Getters y Setters
    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreCientificoDeEspecie() {
        return nombreCientificoDeEspecie;
    }

    public void setNombreCientificoDeEspecie(String nombreCientificoDeEspecie) {
        this.nombreCientificoDeEspecie = nombreCientificoDeEspecie;
    }

    public String getNombreComunDeEspecie() {
        return nombreComunDeEspecie;
    }

    public void setNombreComunDeEspecie(String nombreComunDeEspecie) {
        this.nombreComunDeEspecie = nombreComunDeEspecie;
    }

    public LocalDate getFechaExtincion() {
        return fechaExtincion;
    }

    public void setFechaExtincion(LocalDate fechaExtincion) {
        this.fechaExtincion = fechaExtincion;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getTamanio() {
        return tamanio;
    }

    public void setTamanio(BigDecimal tamanio) {
        this.tamanio = tamanio;
    }

    public Colecciones getColeccion() {
        return coleccion;
    }

    public void setColeccion(Colecciones coleccion) {
        this.coleccion = coleccion;
    }

    // equals y hashCode para defensa académica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Especies)) return false;
        Especies especies = (Especies) o;
        return Objects.equals(idEspecie, especies.idEspecie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEspecie);
    }

    @Override
    public String toString() {
        return "Especies{" +
                "idEspecie=" + idEspecie +
                ", nombreCientificoDeEspecie='" + nombreCientificoDeEspecie + '\'' +
                ", nombreComunDeEspecie='" + nombreComunDeEspecie + '\'' +
                ", fechaExtincion=" + fechaExtincion +
                ", epoca='" + epoca + '\'' +
                ", peso=" + peso +
                ", tamanio=" + tamanio +
                '}';
    }
}