package com.example.ejemplo.logica;

import static org.junit.Assert.assertEquals;

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

        assertEquals("El cociente de x²-2x+1 : x-1 no resulta x-1", resultadoEsperado, ruff.calcular());
        assertEquals("El resto de x²-2x+1 : x-1 no resulta 0", restoEsperado, ruff.getResto());

    }

    @Test
    public void divisionEntreX() {

        // Preparación de los datos

        //  Entradas
        dividendo = new Polinomio();
        dividendo.set(2,1);
        dividendo.set(1,-2);
        dividendo.set(0,1);
        divisor = new MonomioRuffini(0);

        //  Salidas
        resultadoEsperado = new Polinomio();
        resultadoEsperado.set(1,1);
        resultadoEsperado.set(0,-2);
        restoEsperado = 1;

        LogicaRuffini ruff = new LogicaRuffini();
        ruff.setOperadores(dividendo, divisor);

        assertEquals("El cociente de x²-2x+1 : x no resulta x-2", resultadoEsperado, ruff.calcular());
        assertEquals("El resto de x²-2x+1 : x no resulta 1", restoEsperado, ruff.getResto());

    }

    @Test
    public void divisionGrado3() {

        // Preparación de los datos

        //  Entradas
        dividendo = new Polinomio();
        dividendo.set(3,1);
        dividendo.set(2,-1);
        dividendo.set(1,-1);
        dividendo.set(0,2);
        divisor = new MonomioRuffini(1);

        //  Salidas
        resultadoEsperado = new Polinomio();
        resultadoEsperado.set(2,1);
        resultadoEsperado.set(1,-2);
        resultadoEsperado.set(0,1);
        restoEsperado = 1;

        LogicaRuffini ruff = new LogicaRuffini();
        ruff.setOperadores(dividendo, divisor);

        assertEquals("El cociente de x³-x²-x+2 : x+1 no resulta x²-2x+1", resultadoEsperado, ruff.calcular());
        assertEquals("El resto de x³-x²-x+2 : x+1 no resulta 1", restoEsperado, ruff.getResto());

    }

}