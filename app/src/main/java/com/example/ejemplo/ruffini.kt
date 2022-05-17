package com.example.ejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.ejemplo.logica.LogicaRuffini
import com.example.ejemplo.util.MonomioRuffini
import com.example.ejemplo.util.Polinomio
import kotlinx.android.synthetic.main.activity_calculadora.*

class ruffini : AppCompatActivity() {

    private lateinit var resultadoView: TextView
    private lateinit var restoView: TextView
    private lateinit var coeficientes: Array<EditText>
    private lateinit var termInd: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ruffini)

        resultadoView = findViewById(R.id.resultadosViewRuff)
        restoView = findViewById(R.id.resultadosRestoViewRuff)
        coeficientes = arrayOf(
            findViewById(R.id.inCoef0),
            findViewById(R.id.inCoef1),
            findViewById(R.id.inCoef2),
            findViewById(R.id.inCoef3),
            findViewById(R.id.inCoef4),
            findViewById(R.id.inCoef5)
        )
        termInd = findViewById(R.id.inIndTerm)

        clear()

        val clearButton: ImageButton = findViewById(R.id.clearBotonRuff)
        clearButton.setOnClickListener {clear()}

        val solveButton: ImageButton = findViewById(R.id.igualBotonRuff)
        solveButton.setOnClickListener {solve()}

        val botonCasa = findViewById<ImageButton>(R.id.boton_deruffini_amenu)
        botonCasa.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }

        val botonConfig = findViewById<ImageButton>(R.id.boton_config_ruff)
        botonConfig.setOnClickListener {
            val intento2 = Intent(this, configuracion::class.java)
            startActivity(intento2)
        }

        val botonCierre: ImageButton = findViewById(R.id.cierreBotonRuff)
        botonCierre.setOnClickListener {
            finishAffinity()
        }
    }

    private fun clear() {
        resultadoView.text = "0"
        restoView.text = "0"
        for(coeficiente in coeficientes) {
            coeficiente.setText("0")
        }
        termInd.setText("0")
    }

    private fun solve() {
        val ruff: LogicaRuffini = LogicaRuffini();
        val polinomio: Polinomio = Polinomio()
        val divisor: MonomioRuffini = MonomioRuffini(Integer.parseInt(termInd.text.toString()))
        for(index in coeficientes.indices) {
            if(!coeficientes[index].text.toString().equals("0")) {
                polinomio.set(index, Integer.parseInt(coeficientes[index].text.toString()))
            }
        }
        ruff.setOperadores(polinomio, divisor)
        val resultado: Polinomio = ruff.calcular()
        restoView.text = ruff.resto.toString()
        resultadoView.text = resultado.toString()
        if(resultadoView.text.toString().equals("")) resultadoView.text = "0"
    }

}