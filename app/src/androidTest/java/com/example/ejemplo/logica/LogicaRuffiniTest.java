package com.example.ejemplo.logica;

import static org.junit.Assert.*;

import com.example.ejemplo.util.MonomioRuffini;
import com.example.ejemplo.util.Polinomio;

import org.junit.Test;

public class LogicaRuffiniTest {

    private Polinomio dividendo, resultadoEsperado;
    private MonomioRuffini divisor;
    private int restoEsperado;

    @Test
    public void calcular() {

        // Preparación de los datos

        //  Entradas
        dividendo = new Polinomio();
        dividendo.set(2,1);
        dividendo.set(1,-2);
        dividendo.set(0,1);
        divisor = new MonomioRuffini(-1);

        //  Salidas
        resultadoEsperado = new Polinomio();
        resultadoEsperado.set(1,1);
        resultadoEsperado.set(0,-1);
        restoEsperado = 0;

        LogicaRuffini ruff = new LogicaRuffini();
        ruff.setOperadores(dividendo, divisor);

        assertEquals(resultadoEsperado, ruff.calcular());
        assertEquals(restoEsperado, ruff.getResto());

    }

}