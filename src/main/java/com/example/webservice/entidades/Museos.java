package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "museos")
public class Museos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMuseo")
    private Integer idMuseo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaFundacion", nullable = false)
    private Date fechaFundacion;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "sitioWeb")
    private String sitioWeb;

    @OneToMany(mappedBy = "museo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Salas> salasCollection;

    public Museos() {
    }

    public Museos(Integer idMuseo, String nombre, String tipo, String ubicacion, Date fechaFundacion, String director) {
        this.idMuseo = idMuseo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.fechaFundacion = fechaFundacion;
        this.director = director;
    }

    // Getters y Setters
    public Integer getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(Integer idMuseo) {
        this.idMuseo = idMuseo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public List<Salas> getSalasCollection() {
        return salasCollection;
    }

    public void setSalasCollection(List<Salas> salasCollection) {
        this.salasCollection = salasCollection;
    }

    // Métodos auxiliares
    @Override
    public int hashCode() {
        return (idMuseo != null ? idMuseo.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Museos)) {
            return false;
        }
        Museos other = (Museos) obj;
        return (this.idMuseo != null && this.idMuseo.equals(other.idMuseo));
    }

    @Override
    public String toString() {
        return nombre;
    }
}
