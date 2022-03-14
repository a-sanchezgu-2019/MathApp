package com.example.ejemplo;

public enum Operacion {
    SIN_OPERACION,
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    PORCENTAJE;

    public double calcular(double num1, double num2) {
        switch (this) {
            case SUMA:
                return num1 + num2;
            case RESTA:
                return num1 - num2;
            case MULTIPLICACION:
                return num1 * num2;
            case DIVISION:
                return num1 / num2;
            case PORCENTAJE:
                return num1 * num2 / 100;
            default:
                return 0;
        }
    }

    public String toString() {
        switch (this) {
            case SUMA:
                return "+";
            case RESTA:
                return "-";
            case MULTIPLICACION:
                return "*";
            case DIVISION:
                return "/";
            case PORCENTAJE:
                return "%";
            default:
                return " ";
        }
    }

}
