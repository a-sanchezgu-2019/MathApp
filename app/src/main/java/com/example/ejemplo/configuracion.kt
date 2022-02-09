package com.example.ejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_configuracion.*
import kotlinx.android.synthetic.main.activity_menu.*

class configuracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        if (!Global.modo_noche) {
            fondo_config.setBackgroundResource(R.drawable.fondo_menu_dia)
            imageButton3.setBackgroundResource(R.drawable.off)
        }
        if (Global.idioma=="English"){
            imageButton5.setBackgroundResource(R.drawable.english)
        }

        if (!Global.modo_noche && Global.idioma=="Spanish"){
            modo_nochetext.setBackgroundResource(R.drawable.modo_noche_dia)
            idiomartext.setBackgroundResource(R.drawable.idioma_dia)
        }
        if (!Global.modo_noche && Global.idioma=="English"){
            modo_nochetext.setBackgroundResource(R.drawable.modo_noche_dia_eng)
            idiomartext.setBackgroundResource(R.drawable.idioma_dia_eng)
        }
        if (Global.modo_noche && Global.idioma=="English"){
            modo_nochetext.setBackgroundResource(R.drawable.modo_noche_eng)
            idiomartext.setBackgroundResource(R.drawable.idioma_eng)
        }

        // Botón "conf"
        val boton1 = findViewById<ImageButton>(R.id.casita)
        boton1.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }

        //Boton On/Off
        val boton3 = findViewById<ImageButton>(R.id.imageButton3)
        boton3.setOnClickListener {
            if (Global.modo_noche) {
                Global.modo_noche = false
                imageButton3.setBackgroundResource(R.drawable.off)
                fondo_config.setBackgroundResource(R.drawable.fondo_menu_dia)
                if (Global.idioma == "Spanish"){
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche_dia)
                    idiomartext.setBackgroundResource(R.drawable.idioma_dia)
                } else {
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche_dia_eng)
                    idiomartext.setBackgroundResource(R.drawable.idioma_dia_eng)
                }
            } else {
                Global.modo_noche = true
                imageButton3.setBackgroundResource(R.drawable.on)
                fondo_config.setBackgroundResource(R.drawable.fondomenu)
                if (Global.idioma == "Spanish"){
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche)
                    idiomartext.setBackgroundResource(R.drawable.idioma)
                } else {
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche_eng)
                    idiomartext.setBackgroundResource(R.drawable.idioma_eng)
                }
            }
        }

        //Boton idioma
        val boton5 = findViewById<ImageButton>(R.id.imageButton5)
        boton5.setOnClickListener {
            if (Global.idioma == "Spanish") {
                Global.idioma = "English"
                imageButton5.setBackgroundResource(R.drawable.english)
                if (Global.modo_noche){
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche_eng)
                    idiomartext.setBackgroundResource(R.drawable.idioma_eng)
                } else {
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche_dia_eng)
                    idiomartext.setBackgroundResource(R.drawable.idioma_dia_eng)
                }
            } else {
                Global.idioma = "Spanish"
                imageButton5.setBackgroundResource(R.drawable.spanish)
                if (Global.modo_noche){
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche)
                    idiomartext.setBackgroundResource(R.drawable.idioma)
                } else {
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche_dia)
                    idiomartext.setBackgroundResource(R.drawable.idioma_dia)
                }
            }
        }
    }
}
