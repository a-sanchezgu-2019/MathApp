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
     * @return Devuelve un pair con las dos respuestas a la ecuación de segundo grado.
     */
    fun operacion( elevado_2: Double, elevado_1: Double, elevado_0: Double):
            Pair<String, String> {
        var resultado_1 = "inf"
        var resultado_2 = "inf"

        if (elevado_2 == 0.0 && elevado_1 == 0.0) {
            return resolverNoEsEcuacion()

        }else if (elevado_2 == 0.0) {
            val resultadoEcuacionGrado1 = ecuacionGrado1(elevado_1, elevado_0)
            return FormatoEcuacionGrado1(resultadoEcuacionGrado1)

        }else {
            val condicion = Math.pow(elevado_1, 2.0) - 4 * elevado_2 * elevado_0
            if (condicion >= 0.0) { // las raices son reales
                resultado_1 = ((-elevado_1 + sqrt(condicion)) / (2 * elevado_2)).toString()
                resultado_2 = ((-elevado_1 - sqrt(condicion)) / (2 * elevado_2)).toString()

                if ("resultado_1".endsWith(".0")) {
                    resultado_1 = "resultado_1".replace(".0", "")
                } else {
                    resultado_1 = "%.4f".format(resultado_1.toDouble());
                }

                if ("resultado_2".endsWith(".0")) {
                    resultado_2 = "resultado_2".replace(".0", "")
                } else {
                    resultado_2 = "%.4f".format(resultado_2.toDouble())
                }

                return resultado_1 to resultado_2

            } else {
                var resultado_parteReal = ((-elevado_1 / (2 * elevado_2))).toString()

                if ("resultado_parteReal".endsWith(".0")) {
                    resultado_parteReal =
                        ("resultado_parteReal".replace(".0", ""))
                } else {
                    resultado_parteReal = "%.2f".format(resultado_parteReal.toDouble())
                }

                var resultado_parteImaginaria_1 = ((sqrt(-condicion)) / (2 * elevado_2)).toString()
                if ("resultado_parteImaginaria_1".endsWith(".0")) {
                    resultado_parteImaginaria_1 =
                        ("resultado_parteImaginaria_1".replace(".0", ""))
                } else {
                    resultado_parteImaginaria_1 =
                        "%.2f".format(resultado_parteImaginaria_1.toDouble())
                }

                var resultado_parteImaginaria_2 = ((-sqrt(-condicion)) / (2 * elevado_2)).toString()
                if ("$resultado_parteImaginaria_2".endsWith(".0")) {
                    resultado_parteImaginaria_2 =
                        ("$resultado_parteImaginaria_2".replace(".0", ""))
                } else {
                    resultado_parteImaginaria_2 =
                        "%.2f".format(resultado_parteImaginaria_2.toDouble())
                }

                if (resultado_parteReal == "0" || resultado_parteReal == "-0") {
                    resultado_1 = resultado_parteImaginaria_1 + "i"
                    resultado_2 = resultado_parteImaginaria_2 + "i"
                    return resultado_1 to resultado_2

                } else {
                    resultado_1 = resultado_parteReal + " + " + resultado_parteImaginaria_1 + "i"
                    resultado_2 = formatoResta(resultado_parteReal, resultado_parteImaginaria_2)
                    return resultado_1 to resultado_2
                }
            }
        }
    }

    public fun FormatoEcuacionGrado1(resultadoEcuacionGrado1: Double): Pair<String, String> {
        return resultadoEcuacionGrado1.toString() to "Not defined"
    }

    public fun ecuacionGrado1(elevado_1: Double, elevado_0: Double): Double {
        return  -elevado_0 / elevado_1
    }

    public fun resolverNoEsEcuacion(): Pair<String, String> {
        return "Not defined" to "Not defined"
    }

    public fun formatoResta(real: String, imaginario: String): String{

        val imaginarioSinMenos = imaginario.replace("-", "")
        return real + " - " + imaginarioSinMenos + "i"
    }
}