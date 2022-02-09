package com.example.ejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast






class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.ejemplo.R.layout.activity_main)
    /* Maneja el botón "Ir a menu" que estaba en la pantalla principal
        val boton1 = findViewById<Button>(R.id.boton_comenzar)
        boton1.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }
*/

        //Ponemos a "Dormir" el programa durante los ms que queremos
        val circularIndicator: ProgressBar = findViewById(R.id.progressBar)
        Thread {
            circularIndicator.post(Runnable { circularIndicator.setProgress(0) })
            for (i in 1..3) {
                tareaLarga()
            }
            runOnUiThread {
                val intento2 = Intent(this, menu::class.java)
                startActivity(intento2)
            }
        }.start()

    }
    private fun tareaLarga() {
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }
    }


}






