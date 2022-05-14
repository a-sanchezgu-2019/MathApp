package com.example.ejemplo.logica;

import com.example.ejemplo.util.MonomioRuffini;
import com.example.ejemplo.util.Polinomio;

public class LogicaRuffini {

    private Polinomio dividendo, cociente;

    private MonomioRuffini divisor;

    private int resto;

    public Polinomio calcular() {
        cociente = new Polinomio();
        cociente.set(dividendo.grado() - 1, dividendo.get(dividendo.grado()));
        for(int grado = dividendo.grado() - 2; grado >= 0; grado--){
            cociente.set(grado, dividendo.get(grado + 1) - divisor.getTerminoIndependiente() * cociente.get(grado + 1));
        }
        resto = dividendo.get(0) - divisor.getTerminoIndependiente() * cociente.get(0);
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
