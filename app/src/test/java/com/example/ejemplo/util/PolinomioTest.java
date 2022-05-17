package com.example.ejemplo.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PolinomioTest {

    private Polinomio polinomio;

    @Test
    public void polinomioToString() {
        polinomio = new Polinomio();
        polinomio.set(0,1);
        polinomio.set(1,-2);
        polinomio.set(2,1);
        assertEquals("x^2-2x+1",polinomio.toString());
    }

    @Test
    public void polinomioTermIndNegToString() {
        polinomio = new Polinomio();
        polinomio.set(0,-1);
        polinomio.set(1,1);
        assertEquals("x-1", polinomio.toString());
    }

}
