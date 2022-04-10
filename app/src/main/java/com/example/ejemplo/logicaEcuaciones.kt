package com.example.ejemplo

import kotlin.math.sqrt

class LogicaEcuaciones {

    /**
     * Ejecuta una ecuación de segundo grado.
     *
     * La estructura de la operación sería a*x^2 + b*x + c = 0 y daría dos resultados.
     * @param[elevado_2] parámetro 'a' de la operación.
     * @param[elevado_1] parámetro 'b' de la operación.
     * @param[elevado_0] parámetro 'c' de la operación
     * @return
     */

    public fun operacion( elevado_2: Double, elevado_1: Double, elevado_0: Double):
            Pair<String, String> {
        var resultado_1 = "inf"
        var resultado_2 = "inf"
        if (elevado_2 == 0.0 && elevado_1 == 0.0){
            resultado_1 = "Es una igualdad falsa"
            resultado_2 = "Es una igualdad falsa"
            return resultado_1 to resultado_2

        }else if (elevado_2 == 0.0) {
            val resultadoEcuacionGrado1 =  EcuacionGrado1(elevado_1, elevado_0)
            return FormatoEcuacionGrado1(resultadoEcuacionGrado1)

        }else {
            var condicion = Math.pow(elevado_1, 2.0) - 4 * elevado_2 * elevado_0

            if (condicion >= 0.0) { // las raices son reales
                val resultadoEcuacionGrado2real =  EcuacionGrado2real( elevado_1, elevado_0, elevado_2, resultado_1, resultado_2, condicion)
                return FormatoEcuacion(resultadoEcuacionGrado2real)
            } else {
                var resultado_parteReal = ((-elevado_1 / (2 * elevado_2))).toString()
                var resultado_parteImaginaria_1 = ((sqrt(-condicion)) / (2 * elevado_2)).toString()
                var resultado_parteImaginaria_2 = ((-sqrt(-condicion)) / (2 * elevado_2)).toString()
                var resultadoEcuacionGrado2Imag =  EcuacionGrado2Imag(elevado_1, elevado_2,resultado_parteReal,resultado_parteImaginaria_1,resultado_parteImaginaria_2,resultado_1,
                    resultado_2,condicion)
                return FormatoEcuacion(resultadoEcuacionGrado2Imag)

            }
        }
    }


    fun EcuacionGrado2Imag(elevado1: Double, elevado_2: Double,resultado_parteReal1: String,resultado_parteImaginari_1: String,resultado_parteImaginari_2: String,resul_1: String,
                           resul_2: String,condicion: Double): Pair<String, String> {
        var resultado_1= resul_1
        var resultado_2= resul_2
        var resultado_parteImaginaria_1= resultado_parteImaginari_1
        var resultado_parteImaginaria_2 = resultado_parteImaginari_2
        var resultado_parteReal = resultado_parteReal1

        if (resultado_parteReal.endsWith(".0")) {
            resultado_parteReal = (
                    (resultado_parteReal.replace(".0", "")))
        } else {
            resultado_parteReal=(  "%.2f".format(resultado_parteReal.toDouble()))
        }
        if ("$resultado_parteImaginaria_1".endsWith(".0")) {
            resultado_parteImaginaria_1 =(
                    ("$resultado_parteImaginaria_1".replace(".0", "")))
        } else {
            resultado_parteImaginaria_1 =(
                    "%.2f".format(resultado_parteImaginaria_1.toDouble()))
        }

        resultado_parteImaginaria_2=((-sqrt(-condicion)) / (2 * elevado_2)).toString()
        if ("$resultado_parteImaginaria_2".endsWith(".0")) {
            resultado_parteImaginaria_2=(
                    ("$resultado_parteImaginaria_2".replace(".0", "")))
        } else {
            resultado_parteImaginaria_2=(
                    "%.2f".format(resultado_parteImaginaria_2.toDouble()))
        }

        if (resultado_parteReal == "0" || resultado_parteReal == "-0") {
            resultado_1=( resultado_parteImaginaria_1 + "i")
            resultado_2=(resultado_parteImaginaria_2 + "i")
            return resultado_1 to resultado_2

        } else {
            resultado_1=( resultado_parteReal + " + " + resultado_parteImaginaria_1 + "i")
            resultado_2=(formatoResta(resultado_parteReal, resultado_parteImaginaria_2))
            return resultado_1 to resultado_2
        }
    }

    private fun EcuacionGrado2real(
        elevado1: Double,
        elevado0: Double,
        elevado2: Double,
        resul_1: String,
        resul_2: String,
        condicion: Double
    ): Pair<String, String> {
        var resultado_1= resul_1
        var resultado_2= resul_2
        resultado_1 = ((-elevado1 + sqrt(condicion)) / (2 * elevado2)).toString()
        resultado_2=( ((-elevado1 - sqrt(condicion)) / (2 * elevado2)).toString())
        if (resultado_2 == "-0.0") {
            resultado_2 = "0.0"
        }
        if ("$resultado_1".endsWith(".0")) {
            resultado_1 =( "$resultado_1".replace(".0", ""))
        } else {
            resultado_1=(  "%.4f".format(resultado_1.toDouble()))
        }

        if ("$resultado_2".endsWith(".0")) {
            resultado_2=("$resultado_2".replace(".0", ""))
        } else {
            resultado_2= ( "%.4f".format(resultado_2.toDouble()))
        }

        return resultado_1 to resultado_2

    }

    private fun FormatoEcuacion(elevado_1: Pair<String, String>): Pair<String, String> {
        val resultado_1 =elevado_1




        return resultado_1
    }

    private fun FormatoEcuacionGrado1(elevado_1: Double): Pair<String, String> {
        var resultado_1 =elevado_1.toString()
        val resultado_2 = "No hay segundo resultado"
        if (resultado_1 == "0.0"){
            resultado_1 = "0"
        }
        return resultado_1 to resultado_2

    }

    fun EcuacionGrado1(elevado_1: Double, elevado_0: Double): Double {
        if (elevado_0 == 0.0){
            return  elevado_0 / elevado_1}
        return -elevado_0 / elevado_1

    }

    // public fun formatonegativos(resultado: String): String{
    //   resultado.split("-")
    //   for (i in resultado):
    //     resultadoreformateado = resultadoreformateado + i + " "
    // }

    public fun formatoResta(real: String, imaginario: String): String{

        val imaginarioSinMenos = imaginario.replace("-", "")
        return real + " - " + imaginarioSinMenos + "i"
    }
}