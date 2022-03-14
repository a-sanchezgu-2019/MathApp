package com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_ecuaciones.cerrar_Boton
import kotlinx.android.synthetic.main.activity_ecuaciones.ec_1_campo_1
import kotlinx.android.synthetic.main.activity_ecuaciones.ec_1_campo_2
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

            val logEcuaciones = logicaEcuaciones();
            val (resultado_1, resultado_2) = logEcuaciones.operacion(numero, numero_1, numero_2)

            resultadosView2.setText(resultado_1)
            resultadosView4.setText(resultado_2)

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