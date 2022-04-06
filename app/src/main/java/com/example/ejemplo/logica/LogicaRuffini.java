package com.example.ejemplo.logica;

import com.example.ejemplo.util.MonomioRuffini;
import com.example.ejemplo.util.Polinomio;

public class LogicaRuffini {

    private Polinomio dividendo, cociente;

    private MonomioRuffini divisor;

    private int resto;

    public Polinomio calcular() {
        // TODO: realizar operación
        return cociente;
    }

    public Polinomio getDividendo() {
        return dividendo;
    }

    public void setDividendo(Polinomio dividendo) {
        this.dividendo = dividendo;
    }

    public Polinomio getCociente() {
        return cociente;
    }

    public MonomioRuffini getDivisor() {
        return divisor;
    }

    public void setDivisor(MonomioRuffini divisor) {
        this.divisor = divisor;
    }

    public int getResto() {
        return resto;
    }

    public void setOperadores(Polinomio dividendo, MonomioRuffini divisor) {
        this.dividendo = dividendo;
        this.divisor = divisor;
    }

}
