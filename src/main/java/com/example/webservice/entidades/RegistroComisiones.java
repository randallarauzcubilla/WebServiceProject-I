package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "registro_comisiones")
public class RegistroComisiones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistroComision")
    private Integer idRegistroComision;

    @Column(name = "valorCobrado", nullable = false)
    private BigDecimal valorCobrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idComision")
    private ComisionesTarjetas comision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntrada")
    private Entradas entrada;

    public RegistroComisiones() {}

    public RegistroComisiones(BigDecimal valorCobrado, ComisionesTarjetas comision, Entradas entrada) {
        this.valorCobrado = valorCobrado;
        this.comision = comision;
        this.entrada = entrada;
    }

    // Getters and setters
    public Integer getIdRegistroComision() {
        return idRegistroComision;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public ComisionesTarjetas getComision() {
        return comision;
    }

    public void setComision(ComisionesTarjetas comision) {
        this.comision = comision;
    }

    public Entradas getEntrada() {
        return entrada;
    }

    public void setEntrada(Entradas entrada) {
        this.entrada = entrada;
    }
}