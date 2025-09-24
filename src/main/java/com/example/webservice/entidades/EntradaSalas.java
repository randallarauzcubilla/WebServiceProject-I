package com.example.webservice.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "entrada_salas")
public class EntradaSalas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntradaSala")
    private Integer idEntradaSala;

    @Column(name = "precioSala", nullable = false)
    private BigDecimal precioSala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntrada")
    private Entradas entrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSala")
    private Salas sala;

    public EntradaSalas() {}

    public EntradaSalas(BigDecimal precioSala, Entradas entrada, Salas sala) {
        this.precioSala = precioSala;
        this.entrada = entrada;
        this.sala = sala;
    }

    // Getters and setters
    public Integer getIdEntradaSala() {
        return idEntradaSala;
    }

    public BigDecimal getPrecioSala() {
        return precioSala;
    }

    public void setPrecioSala(BigDecimal precioSala) {
        this.precioSala = precioSala;
    }

    public Entradas getEntrada() {
        return entrada;
    }

    public void setEntrada(Entradas entrada) {
        this.entrada = entrada;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }
}