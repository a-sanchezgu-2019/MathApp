package com.example.ejemplo.conversion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View
import android.widget.*
import com.example.ejemplo.MainActivity
import com.example.ejemplo.R
import com.example.ejemplo.configuracion
import com.example.ejemplo.menu

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType
import com.fasterxml.jackson.module.kotlin.*
import kotlinx.android.synthetic.main.conversion.*
import kotlinx.android.synthetic.main.conversion.cerrar_Boton


class ConversionActivity : AppCompatActivity() {

    private var conversionData: Map<UnitType, UnitConversionData>? = null;
    private var listaMedidas: MutableList<String> = mutableListOf();
    private var medidaInicial: MutableList<String> = mutableListOf();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initConversionData();

        val conversion: Conversion =
            Conversion(conversionData.orEmpty());

        setContentView(R.layout.conversion)

        /*
            example from 2 meters to kilometers:

            conversion.magnitude = distancia
            conversion.initialUnit = metros
            conversion.resultUnit = kilometros
            conversion.input = 2
            conversion.doOperation() -> Double?

            Cuando devuelva un Double, tienes que convertir el resultado a String y mostrarlo
         */

        val adapterMagnitude = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item, listaMedidas
        )

        medidas.adapter = adapterMagnitude

        val adapterUnits =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, medidaInicial);

        unidadInicial.adapter = adapterUnits
        unidadFinal.adapter= adapterUnits

        medidas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val opcion = parent.getItemAtPosition(position).toString()

                cambiarUnidades(opcion)

                adapterUnits.clear();
                adapterUnits.addAll(medidaInicial);
                adapterUnits.notifyDataSetChanged();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
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


    fun initConversionData() {

        val file_name = "unit-conversion.json"
        val jsonString = application.assets.open(file_name).bufferedReader().use {
            it.readText()
        }

        val mapper = jacksonObjectMapper()

        conversionData = mapper.readValue(jsonString)

        val keys = conversionData!!.keys;

        keys.forEach {
            listaMedidas.add(it.toString())
        }

        application.assets.close()
    }

    fun cambiarUnidades(opcion: String) {

        val unitTypeChosen = UnitType.valueOf(opcion);
        val UnitConversionData = conversionData!!.get(unitTypeChosen);

        medidaInicial = UnitConversionData!!.conversion.keys.toMutableList();
    }
}

