package com.example.ejemplo

import kotlinx.android.synthetic.main.activity_ecuaciones.*
import kotlinx.android.synthetic.main.activity_ecuaciones2.*
import kotlin.math.sqrt

class logicaEcuaciones {


    public fun operacion( elevado_2: Double, elevado_1: Double, elevado_0: Double):
            Pair<String, String> {
        var resultado_1 = "inf"
        var resultado_2 = "inf"
        var resultado_parteReal = "inf"
        var resultado_parteImaginaria_1 = "inf"
        var resultado_parteImaginaria_2 = "inf"

        if (elevado_2 == 0.0) {
            return resultado_1 to resultado_2
        } else {
            var condicion = Math.pow(elevado_1, 2.0) - 4 * elevado_2 * elevado_0
            if (condicion >= 0.0) { // las raices son reales
                resultado_1 = ((-elevado_1 + sqrt(condicion)) / (2 * elevado_2)).toString()
                resultado_2 = ((-elevado_1 - sqrt(condicion)) / (2 * elevado_2)).toString()

                if ("$resultado_1".endsWith(".0")) {
                    resultado_1 = "$resultado_1".replace(".0", "")
                } else {
                    resultado_1 = "%.4f".format(resultado_2.toDouble());
                }

                if ("$resultado_2".endsWith(".0")) {
                    resultado_2 = "$resultado_2".replace(".0", "")
                } else {
                    resultado_2 = "%.4f".format(resultado_2.toDouble())
                }

                return resultado_1 to resultado_2

            } else {
                resultado_parteReal = ((-elevado_1 / (2 * elevado_2))).toString()

                if ("$resultado_parteReal".endsWith(".0")) {
                    resultado_parteReal =
                        ("$resultado_parteReal".replace(".0", ""))
                } else {
                    resultado_parteReal = "%.2f".format(resultado_parteReal.toDouble())
                }

                resultado_parteImaginaria_1 = ((sqrt(-condicion)) / (2 * elevado_2)).toString()
                if ("$resultado_parteImaginaria_1".endsWith(".0")) {
                    resultado_parteImaginaria_1 =
                        ("$resultado_parteImaginaria_1".replace(".0", ""))
                } else {
                    resultado_parteImaginaria_1 =
                        "%.2f".format(resultado_parteImaginaria_1.toDouble())
                }

                resultado_parteImaginaria_2 = ((-sqrt(-condicion)) / (2 * elevado_2)).toString()
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
                    resultado_2 = resultado_parteReal + "  " + resultado_parteImaginaria_2 + "i"
                    return resultado_1 to resultado_2
                }
            }
        }
    }
}