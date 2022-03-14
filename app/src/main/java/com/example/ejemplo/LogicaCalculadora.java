package com.example.ejemplo;

public class LogicaCalculadora {

    private double num1 = 0.0;
    private double num2 = 0.0;
    private double resultado = 0.0;
    private Operacion operacion = Operacion.SIN_OPERACION;

    private int decNum1 = -1;
    private int decNum2 = -1;

    public double calcular() {
        return operacion.calcular(num1, num2);
    }

    public double igual() {
        resultado = calcular();
        num1 = resultado;
        num2 = 0.0;
        operacion = Operacion.SIN_OPERACION;
        return resultado;
    }

    public void numeroPresionado(String digito) {

        if(digito.equals(".")) {
            if(operacion == Operacion.SIN_OPERACION) {
                decNum1++;
            } else {
                decNum2++;
            }
            return;
        }

        double digitoNum = Double.parseDouble(digito);
        if(operacion == Operacion.SIN_OPERACION){
            if(decNum1 == -1 && (digitoNum != 0 || num1 != 0.0)) {
                num1 = num1 * 10 + digitoNum;
            } else if(decNum1 >= 0) {
                decNum1++;
                num1 += digitoNum * Math.pow(10.0, -decNum1);
            }
        }else{
            if(decNum2 == -1 && (digitoNum != 0 || num2 != 0.0)) {
                num2 = num2 * 10 + digitoNum;
            } else if(decNum2 >= 0) {
                decNum2++;
                num2 += digitoNum * Math.pow(10.0, -decNum2);
            }
        }

    }

    public void borrar() {

        if(operacion != Operacion.SIN_OPERACION){
            if(num2 == 0.0) {
                operacion = Operacion.SIN_OPERACION;
            } else {
                if(decNum2 == -1) {
                    num2 = Math.floor(num2 / 10);
                } else {
                    decNum2--;
                    num2 = Math.floor(num2 * Math.pow(10, decNum2)) / decNum2;
                }
            }
        } else if(decNum1 == -1) {
            num1 = Math.floor(num1 / 10);
        } else {
            decNum1--;
            num1 = Math.floor(num2 * Math.pow(10, decNum2)) / decNum2;
        }

    }

    public void clear() {
        num1 = 0.0;
        num2 = 0.0;
        decNum1 = -1;
        decNum2 = -1;
        resultado = 0.0;
        operacion = Operacion.SIN_OPERACION;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public int getDecNum1() {
        return decNum1;
    }

    public void setDecNum1(int decNum1) {
        this.decNum1 = decNum1;
    }

    public int getDecNum2() {
        return decNum2;
    }

    public void setDecNum2(int decNum2) {
        this.decNum2 = decNum2;
    }

}
