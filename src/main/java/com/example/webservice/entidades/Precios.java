package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "precios")
public class Precios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrecio")
    private Integer idPrecio;

    @Column(name = "precioLunesSabado", nullable = false)
    private BigDecimal precioLunesSabado;

    @Column(name = "precioDomingo", nullable = false)
    private BigDecimal precioDomingo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSala")
    private Salas sala;

    public Precios() {}

    public Precios(BigDecimal precioLunesSabado, BigDecimal precioDomingo, Salas sala) {
        this.precioLunesSabado = precioLunesSabado;
        this.precioDomingo = precioDomingo;
        this.sala = sala;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public BigDecimal getPrecioLunesSabado() {
        return precioLunesSabado;
    }

    public void setPrecioLunesSabado(BigDecimal precioLunesSabado) {
        this.precioLunesSabado = precioLunesSabado;
    }

    public BigDecimal getPrecioDomingo() {
        return precioDomingo;
    }

    public void setPrecioDomingo(BigDecimal precioDomingo) {
        this.precioDomingo = precioDomingo;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }
}
