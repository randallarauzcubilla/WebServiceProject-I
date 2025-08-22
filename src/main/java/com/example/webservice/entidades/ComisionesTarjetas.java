package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "comisionestarjetas")
public class ComisionesTarjetas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComision")
    private Integer idComision;

    @Column(name = "tipoTarjeta", nullable = false)
    private String tipoTarjeta;

    @Column(name = "porcentajeComision", nullable = false)
    private BigDecimal porcentajeComision;

    @OneToMany(mappedBy = "comision", fetch = FetchType.LAZY)
    private Collection<RegistroComisiones> registroComisiones;

    public ComisionesTarjetas() {}

    public ComisionesTarjetas(String tipoTarjeta, BigDecimal porcentajeComision) {
        this.tipoTarjeta = tipoTarjeta;
        this.porcentajeComision = porcentajeComision;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public BigDecimal getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(BigDecimal porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public Collection<RegistroComisiones> getRegistroComisiones() {
        return registroComisiones;
    }

    public void setRegistroComisiones(Collection<RegistroComisiones> registroComisiones) {
        this.registroComisiones = registroComisiones;
    }
}