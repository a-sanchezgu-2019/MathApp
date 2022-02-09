package com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_ecuaciones.*


class ecuaciones : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuaciones)


        resultadosView2.setBackgroundColor(Color.parseColor("#FFFFFF"))
        resultadosView2.setTextColor(Color.parseColor("#000000"))
        ec_1_campo_1.setTextColor(Color.parseColor("#000000"))
        ec_1_campo_2.setTextColor(Color.parseColor("#000000"))

        // Control de los campos donde el usuario introduce los datos

        val campo_1 = findViewById<EditText>(R.id.ec_1_campo_1)
        val campo_2 = findViewById<EditText>(R.id.ec_1_campo_2)

        val campo_texto_2 = findViewById<EditText>(R.id.ec_1_campo_2)
        campo_texto_2.setOnClickListener {
            val texto_1 = campo_1.text.toString()
            val texto_2 = campo_2.text.toString()

            val numero_1 = texto_1.toDouble()
            val numero_2 = texto_2.toDouble()
            var resultado= "inf"
            if (numero_1 != 0.0) {
                resultado = (-numero_2 / numero_1).toString()
            }
            if("$resultado".endsWith(".0")){
                resultadosView2.setText("$resultado".replace(".0",""))
            }else{
                resultadosView2.setText((resultado))
            }


            //resultadosView2.text = if("$resultado".endsWith(".0")){"$resultado".replace(".0","")}else{"%.4f".format(resultado)}

        }

        if (!Global.modo_noche) {
            fondo_ecuaciones.setBackgroundResource(R.drawable.fondo_calc_dia)
            imageView11.setImageResource(R.drawable.x_dia)
            imageView4.setImageResource(R.drawable.mas_dia)
            imageView7.setImageResource(R.drawable.igual_dia)
            imageView6.setImageResource(R.drawable.cero_dia)
            imageView12.setImageResource(R.drawable.x_dia)
            imageView13.setImageResource(R.drawable.igual_dia)
            resultadosView2.setBackgroundColor(Color.parseColor("#000000"))
            resultadosView2.setTextColor(Color.parseColor("#FFFFFF"))
            ec_1_campo_1.setBackgroundColor(Color.parseColor("#000000"))
            ec_1_campo_1.setTextColor(Color.parseColor("#FFFFFF"))
            ec_1_campo_2.setBackgroundColor(Color.parseColor("#000000"))
            ec_1_campo_2.setTextColor(Color.parseColor("#FFFFFF"))
        }

        if (Global.idioma=="English"){

        }

        // Botón "Casita"
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