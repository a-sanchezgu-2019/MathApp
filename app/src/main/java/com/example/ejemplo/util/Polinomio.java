package com.example.ejemplo.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polinomio {

    private List<Integer> coeficientes;

    public Polinomio(List<Integer> coeficientes) {
        this.coeficientes = coeficientes;
    }

    public Polinomio() {
        coeficientes = new ArrayList<>();
    }

    public void set(int grado, int coeficiente) {
        while(coeficientes.size() <= grado) coeficientes.add(0);
        coeficientes.set(grado, coeficiente);
    }

    public int grado() {
        return coeficientes.size() - 1;
    }

    public Integer get(int grado) {
        if(grado >= coeficientes.size()) return null;
        return coeficientes.get(grado);
    }

    public void setCoeficientes(List<Integer> coeficientes) {
        this.coeficientes = coeficientes;
    }

    public List<Integer> getCoeficientes(){
        return coeficientes;
    }

    private String extraerMonomio(int grado) {
        StringBuilder resultado = new StringBuilder("");
        int coef = coeficientes.get(grado);

        if(coef != 0) {

            if(grado < grado() && coef > 0)
                resultado.append("+");

            if(coef == -1) {
                resultado.append("-");
            } else if(coef != 1 || grado == 0) {
                resultado.append(String.valueOf(coef));
            }

            if(grado > 0)
                resultado.append("x");

            if(grado > 1)
                resultado.append("^").append(String.valueOf(grado));
        }

        return resultado.toString();

    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("");
        for(int index=grado(); index>=0; index--) {
            resultado.append(extraerMonomio(index));
        }
        if(resultado.toString().equals(""))
            resultado.append("0");
        return resultado.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polinomio)) return false;
        Polinomio polinomio = (Polinomio) o;
        return Objects.equals(coeficientes, polinomio.coeficientes);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(coeficientes);
    }
}
