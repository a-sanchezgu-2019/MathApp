package com.example.ejemplo

import kotlinx.android.synthetic.main.activity_ecuaciones.*
import kotlinx.android.synthetic.main.activity_ecuaciones2.*
import kotlin.math.sqrt

class logicaEcuaciones {


    public  fun  operacion(elevado_2: Double, elevado_1: Double, elevado_0: Double): Map<Double, Double>{
        var resultado_1= "inf"
        var resultado_2= "inf"
        var resultado_parteReal= "inf"
        var resultado_parteImaginaria_1= "inf"
        var resultado_parteImaginaria_2= "inf"

        if (numero == 0.0){
            resultado = "inf"
            resultado2 = "inf"
            resultadosView2.setText(resultado)
            resultadosView4.setText(resultado2)
        }else {
            var condicion = Math.pow(numero_1, 2.0) - 4 * numero * numero_2
            if (condicion >= 0.0) { // las raices son reales
                resultado = ((-numero_1 + sqrt(condicion)) / (2 * numero)).toString()
                resultado2 = ((-numero_1 - sqrt(condicion)) / (2 * numero)).toString()

                //resultadosView2.setText(resultado)
                //resultadosView4.setText(resultado2)
                if("$resultado".endsWith(".0")){
                    resultadosView2.setText("$resultado".replace(".0",""))
                }else{
                    resultadosView2.setText("%.4f".format(resultado2.toDouble()))
                }

                if("$resultado2".endsWith(".0")){
                    resultadosView4.setText("$resultado2".replace(".0",""))
                }else{
                    resultadosView4.setText("%.4f".format(resultado2.toDouble()))
                }

            } else { // las raices son complejos conjugadas
                resultado_parteReal = ((-numero_1 / (2 * numero))).toString()

                if("$resultado_parteReal".endsWith(".0")){
                    resultado_parteReal=("$resultado_parteReal".replace(".0",""))
                }else{
                    resultado_parteReal="%.2f".format(resultado_parteReal.toDouble())
                }



                resultado_parteImaginaria = ((sqrt(-condicion)) / (2 * numero)).toString()
                if("$resultado_parteImaginaria".endsWith(".0")){
                    resultado_parteImaginaria=("$resultado_parteImaginaria".replace(".0",""))
                }else{
                    resultado_parteImaginaria="%.2f".format(resultado_parteImaginaria.toDouble())
                }

                resultado2_parteImaginaria = ((-sqrt(-condicion)) / (2 * numero)).toString()
                if("$resultado2_parteImaginaria".endsWith(".0")){
                    resultado2_parteImaginaria=("$resultado2_parteImaginaria".replace(".0",""))
                }else{
                    resultado2_parteImaginaria="%.2f".format(resultado2_parteImaginaria.toDouble())
                }
                if(resultado_parteReal=="0" || resultado_parteReal=="-0" ){
                    resultado = resultado_parteImaginaria + "i"
                    resultado2 = resultado2_parteImaginaria + "i"
                    resultadosView2.setText(resultado)
                    resultadosView4.setText(resultado2)
                }else{
                    resultado = resultado_parteReal + " + " + resultado_parteImaginaria + "i"
                    resultado2 = resultado_parteReal + "  " + resultado2_parteImaginaria + "i"
                    resultadosView2.setText(resultado)
                    resultadosView4.setText(resultado2)
                }
            }
        }

    }