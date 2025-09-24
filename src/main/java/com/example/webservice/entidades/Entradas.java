package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "entradas")
public class Entradas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntrada")
    private Integer idEntrada;

    @Column(name = "fechaCompra", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;

    @Column(name = "fechaVisita", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVisita;

    @Column(name = "precioTotal", nullable = false)
    private BigDecimal precioTotal;

    @Column(name = "codigoQR", nullable = false)
    private String codigoQR;

    @OneToMany(mappedBy = "entrada", fetch = FetchType.LAZY)
    private List<EntradaSalas> entradaSalas;

    @OneToMany(mappedBy = "entrada", fetch = FetchType.LAZY)
    private List<RegistroComisiones> registroComisiones;

    public Entradas() {}

    public Entradas(Date fechaCompra, Date fechaVisita, BigDecimal precioTotal, String codigoQR) {
        this.fechaCompra = fechaCompra;
        this.fechaVisita = fechaVisita;
        this.precioTotal = precioTotal;
        this.codigoQR = codigoQR;
    }

    // Getters and setters
    public Integer getIdEntrada() {
        return idEntrada;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public List<EntradaSalas> getEntradaSalas() {
        return entradaSalas;
    }

    public void setEntradaSalas(List<EntradaSalas> entradaSalas) {
        this.entradaSalas = entradaSalas;
    }

    public List<RegistroComisiones> getRegistroComisiones() {
        return registroComisiones;
    }

    public void setRegistroComisiones(List<RegistroComisiones> registroComisiones) {
        this.registroComisiones = registroComisiones;
    }
}