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
        assertEquals(polinomio.toString(), "x^2-2x+1");
    }

}
