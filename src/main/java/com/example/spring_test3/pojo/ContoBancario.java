package com.example.spring_test3.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private double saldo = 0;

    public ContoBancario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposito(int importo) throws IllegalArgumentException {
        if (importo <= 0) {
            throw new IllegalArgumentException("Il deposito deve essere maggiore di 0 euro");
        } else {
            this.saldo += importo;
        }
    }

    public void prelievo(int importo) throws IllegalArgumentException {
        if (importo >= getSaldo()) {
            throw new IllegalArgumentException("Il prelievo non può essere maggiore del saldo attuale!");
        } else if (importo < 0) {
            throw new IllegalArgumentException("Il prelievo deve essere maggiore di 0 euro");
        } else {
            this.saldo -= importo;
        }
    }

    @Override
    public String toString() {
        return "Saldo Attuale del conto ID " + getId() + ": " + getSaldo();
    }

}
