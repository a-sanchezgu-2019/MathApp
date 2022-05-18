package com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculadora_trigonometrica.*
import kotlinx.android.synthetic.main.activity_configuracion.*
import kotlinx.android.synthetic.main.activity_menu.*

class configuracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        val text10 = findViewById<TextView>(R.id.textView10)
        if (Global.fondo_cambiado) {
            fondo_config.setBackgroundResource(R.drawable.fondo_menu_azul)
        }
        if (!Global.modo_noche) {
            if (!Global.fondo_cambiado) {
                fondo_config.setBackgroundResource(R.drawable.fondo_menu_dia)
            }
            imageButton3.setBackgroundResource(R.drawable.off)
        }
        if (Global.idioma=="English"){
            imageButton5.setBackgroundResource(R.drawable.english)
            text10.setText("Change Background")
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
        val boton6 = findViewById<ImageButton>(R.id.imageButton6)
        boton3.setOnClickListener {
            if (Global.modo_noche) {
                Global.modo_noche = false
                imageButton3.setBackgroundResource(R.drawable.off)
                if (!Global.fondo_cambiado) {
                    fondo_config.setBackgroundResource(R.drawable.fondo_menu_dia)
                } else {
                    boton6.setBackgroundResource(R.drawable.color_fondo_dia)
                }
                text10.setTextColor(Color.parseColor("000000"))
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
                if (!Global.fondo_cambiado) {
                    fondo_config.setBackgroundResource(R.drawable.fondomenu)
                } else {
                    boton6.setBackgroundResource(R.drawable.color_fondo_noche)
                }
                text10.setTextColor(Color.parseColor("#FFFFFF"))
                if (Global.idioma == "Spanish"){
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche)
                    idiomartext.setBackgroundResource(R.drawable.idioma)
                } else {
                    modo_nochetext.setBackgroundResource(R.drawable.modo_noche_eng)
                    idiomartext.setBackgroundResource(R.drawable.idioma_eng)
                }
            }
        }

        //Boton nuevo fondo
        boton6.setOnClickListener {
            if (Global.fondo_cambiado) { //El fondo estaba cambiado y pulsan para quitarlo
                Global.fondo_cambiado = false
                fondo_config.setBackgroundResource(R.drawable.fondo_menu_azul)
                if (!Global.modo_noche) {
                    boton6.setBackgroundResource(R.drawable.color_fondo_dia)
                } else {
                    boton6.setBackgroundResource(R.drawable.color_fondo_noche)
                }
            } else { //El fondo no estaba cambiado y pulsan para cambiarlo
                Global.fondo_cambiado = true
                fondo_config.setBackgroundResource(R.drawable.fondo_menu_azul)
                if (!Global.modo_noche) {
                    boton6.setBackgroundResource(R.drawable.color_fondo_dia)
                } else {
                    boton6.setBackgroundResource(R.drawable.color_fondo_noche)
                }
            }
        }

        //Boton idioma
        val boton5 = findViewById<ImageButton>(R.id.imageButton5)
        boton5.setOnClickListener {
            if (Global.idioma == "Spanish") {
                Global.idioma = "English"
                imageButton5.setBackgroundResource(R.drawable.english)
                text10.setText("Change Background")
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
                text10.setText("Cambiar Fondo")
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
