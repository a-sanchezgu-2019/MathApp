package com.example.ejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.ejemplo.conversion.ConversionActivity
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        if (!Global.modo_noche) {
            fondoMenu.setBackgroundResource(R.drawable.fondo_menu_dia)
        }

        if (Global.idioma=="English"){
            boton_basica.setBackgroundResource(R.drawable.calculadora_eng)
            boton_calculadoracientifica.setBackgroundResource(R.drawable.calculadora_cientifica_eng)
            boton_ecuacion.setBackgroundResource(R.drawable.ecuaciones_grado_1_eng)
            boton_ajustes.setBackgroundResource(R.drawable.ajustes_eng)
            boton_ecuacion2.setBackgroundResource(R.drawable.boton_ecuaciones_grado2_eng)
        }
        



        // Botón "CALCULADORA CLÁSICA"
        val boton1 = findViewById<Button>(R.id.boton_basica)
        boton1.setOnClickListener {
            val intento1 = Intent(this, calculadora::class.java)
            startActivity(intento1)
        }

        // Botón "CALCULADORA TRIGONOMÉTRICA"
        val boton3 = findViewById<ImageButton>(R.id.boton_calculadoracientifica)
        boton3.setOnClickListener {
            val intento3 = Intent(this, calculadora_trigonometrica::class.java)
            startActivity(intento3)
        }

        // Botón "AYUDA"
        val botonAyuda = findViewById<Button>(R.id.boton_ayuda)
        botonAyuda.setOnClickListener {
            val intentoAyuda = Intent(this, Activity_ayuda::class.java)
            startActivity(intentoAyuda)
        }


        val boton4 = findViewById<Button>(R.id.boton_ecuacion)
        boton4.setOnClickListener {
            val intento4 = Intent(this, ecuaciones::class.java)
            startActivity(intento4)
        }

        val boton5 = findViewById<ImageButton>(R.id.boton_ajustes)
        boton5.setOnClickListener {
            val intento5 = Intent(this, configuracion::class.java)
            startActivity(intento5)
        }


        val boton6 = findViewById<Button>(R.id.boton_ecuacion2)
        boton6.setOnClickListener {
            val intento6 = Intent(this, ecuaciones2::class.java)
            startActivity(intento6)
        }

        val botonRuffini = findViewById<Button>(R.id.boton_ruff)
        botonRuffini.setOnClickListener {
            val intentoRuffini = Intent(this, ruffini::class.java)
            startActivity(intentoRuffini)
        }

        val boton7 = findViewById<Button>(R.id.boton_conversion)
        boton7.setOnClickListener {
            val intento7 = Intent(this, ConversionActivity::class.java)
            startActivity(intento7)
        }
    }
}