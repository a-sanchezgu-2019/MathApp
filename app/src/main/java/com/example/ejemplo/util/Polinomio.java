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
