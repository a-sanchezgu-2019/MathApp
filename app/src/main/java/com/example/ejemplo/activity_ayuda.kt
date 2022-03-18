package com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_ayuda.*

class Activity_ayuda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        if (!Global.modo_noche) {
            fondo_ayuda.setBackgroundResource(R.drawable.fondo_calc_dia)
            textViewMenu.setTextColor(Color.parseColor("#000000"))
            textViewAyudaMenu.setTextColor(Color.parseColor("#000000"))
            textViewCalculadoraBasica.setTextColor(Color.parseColor("#000000"))
            textViewAyudaCalculadoraBasica.setTextColor(Color.parseColor("#000000"))
            textViewCalculadoraTrigonometrica.setTextColor(Color.parseColor("#000000"))
            textViewAyudaCalculadoraTrigonometrica.setTextColor(Color.parseColor("#000000"))
            textViewEcuaciones1.setTextColor(Color.parseColor("#000000"))
            textViewAyudaEcuaciones1.setTextColor(Color.parseColor("#000000"))
            textViewAjustes.setTextColor(Color.parseColor("#000000"))
            textViewAyudaAjustes.setTextColor(Color.parseColor("#000000"))
        }

        if (Global.idioma == "English") {
            textViewMenu.text = "MENU"
            textViewAyudaMenu.text = "Pressing the button 'Basic calculator' you go to the basic calculator with additions, substractions, multiplications and divisions.\n \nPressing the button 'Scientific calculator', you go to a calculator with basic operations, trigonometric operations, square roots and the numbers π and e. \n \nPressing the button 'Equations grade 1' (WORK IN PROGRESS).\n \nPressing the button 'Settings' you go to the settings menu."
            textViewCalculadoraBasica.text = "BASIC CALCULATOR"
            textViewAyudaCalculadoraBasica.text = "By pressing any number, it will be added to the operation and it will be shown in the screen.\n \nBy pressing any operand (+,-,x,/), it will be added to the operation and it will be shown in the screen.\n \nBy pressing the button 'delete', the last number or operator will be deleted form the operation.\n \nBy pressing the button 'Clear', the whole operation will be deleted.\n \nBy pressing the button '=', the operation will be done and the result will be shown in the screen.\n \nBy pressing the 'Home' button, you will return to the main menu.\n \nBy pressing the top 'x' button, you will exit the app.\n \nBy pressing the button 'Settings' you go to the settings menu."
            textViewCalculadoraTrigonometrica.text = "SCIENTIFIC CALCULATOR"
            textViewAyudaCalculadoraTrigonometrica.text = "Read the upper paragraph in order to understand the basic buttons.\n \nBy pressing a trigonometric operand (sin,cos,tg), it will be added to the operation.\n \nBy pressing the 'deg' button you can change between degrees and radians.\n \nThe 'π' and 'e' buttons work as the other numbers.\n \nPressing the '1/x' button you can set a fraction.\n \nBy pressing the '^' button you can use powers."
            textViewEcuaciones1.text = "1st DEGREE EQUATIONS"
            textViewAyudaEcuaciones1.text = "DEVELOPING"
            textViewAjustes.text = "SETTINGS"
            textViewAyudaAjustes.text = "By pressing the 'ON' button next to the 'Night mode' text, you can change between night mode and day mode.\\n \\nBy pressing the 'Spanish' button next to the 'Language' text, you can change the languaje between spanish and english.\\n \\nBy pressing the 'Home' button, you will return to the main menu."
        }


        // Botón "Casita"
        val boton1 = findViewById<ImageButton>(R.id.boton_ayuda_menu)
        boton1.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }
    }
}