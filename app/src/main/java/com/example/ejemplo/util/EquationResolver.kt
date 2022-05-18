package com.example.ejemplo.util

interface EquationResolver {

    fun resolve(args: Array<Double>, equation: String): Double?;
    fun isEquation(equation: String): Boolean;
}