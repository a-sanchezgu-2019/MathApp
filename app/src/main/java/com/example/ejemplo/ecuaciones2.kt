package com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_ecuaciones.*
import kotlinx.android.synthetic.main.activity_ecuaciones.cerrar_Boton
import kotlinx.android.synthetic.main.activity_ecuaciones.ec_1_campo_1
import kotlinx.android.synthetic.main.activity_ecuaciones.ec_1_campo_2
import kotlinx.android.synthetic.main.activity_ecuaciones.fondo_ecuaciones
import kotlinx.android.synthetic.main.activity_ecuaciones.imageView11
import kotlinx.android.synthetic.main.activity_ecuaciones.imageView12
import kotlinx.android.synthetic.main.activity_ecuaciones.imageView13
import kotlinx.android.synthetic.main.activity_ecuaciones.imageView4
import kotlinx.android.synthetic.main.activity_ecuaciones.imageView6
import kotlinx.android.synthetic.main.activity_ecuaciones.imageView7
import kotlinx.android.synthetic.main.activity_ecuaciones.resultadosView2
import kotlinx.android.synthetic.main.activity_ecuaciones2.*
import kotlin.math.sqrt

class ecuaciones2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuaciones2)

        val blanco = "#FFFFFF"
        val negro = "#000000"
        resultadosView2.setBackgroundColor(Color.parseColor(blanco))
        resultadosView2.setTextColor(Color.parseColor(negro))
        resultadosView4.setBackgroundColor(Color.parseColor(blanco))
        resultadosView4.setTextColor(Color.parseColor(negro))
        ec_1_campo_1.setTextColor(Color.parseColor(negro))
        ec_1_campo_2.setTextColor(Color.parseColor(negro))
        ec_1_campo.setTextColor(Color.parseColor(negro))


        // Control de los campos donde el usuario introduce los datos

        val campo = findViewById<EditText>(R.id.ec_1_campo)
        val campo_1 = findViewById<EditText>(R.id.ec_1_campo_1)
        val campo_2 = findViewById<EditText>(R.id.ec_1_campo_2)

        val campo_texto_2 = findViewById<EditText>(R.id.ec_1_campo_2)
        campo_texto_2.setOnClickListener {
            val texto = campo.text.toString()
            val texto_1 = campo_1.text.toString()
            val texto_2 = campo_2.text.toString()
            // ax^2 + bx + c = 0
            val numero = texto.toDouble() // a
            val numero_1 = texto_1.toDouble() //b
            val numero_2 = texto_2.toDouble() // c
            var resultado= "inf"
            var resultado2= "inf"
            var resultado_parteReal= "inf"
            var resultado_parteImaginaria= "inf"
            var resultado2_parteImaginaria= "inf"

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

        if (!Global.modo_noche) {
            fondo_ecuaciones_grado2.setBackgroundResource(R.drawable.fondo_ecuaciones_grado2_dia_1)
            resultadosView2.setBackgroundColor(Color.parseColor(negro))
            resultadosView2.setTextColor(Color.parseColor(blanco))
            resultadosView4.setBackgroundColor(Color.parseColor(negro))
            resultadosView4.setTextColor(Color.parseColor(blanco))
            ec_1_campo.setBackgroundColor(Color.parseColor(negro))
            ec_1_campo.setTextColor(Color.parseColor(blanco))
            ec_1_campo_1.setBackgroundColor(Color.parseColor(negro))
            ec_1_campo_1.setTextColor(Color.parseColor(blanco))
            ec_1_campo_2.setBackgroundColor(Color.parseColor(negro))
            ec_1_campo_2.setTextColor(Color.parseColor(blanco))
        }


        // Botón "Casita"
        val boton1 = findViewById<ImageButton>(R.id.boton_menu_ecuaciones)
        boton1.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }

        // Boton "CONFIGURACIÓN"
        val boton2 = findViewById<ImageButton>(R.id.ajuste_ec1)
        boton2.setOnClickListener {
            val intento2 = Intent(this, configuracion::class.java)
            startActivity(intento2)
        }

        //BOTON CERRAR APP
        cerrar_Boton.setOnClickListener {
            val salida = Intent(Intent.ACTION_MAIN)
            finishAffinity()
        }
    }
}