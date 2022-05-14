package com.example.ejemplo.conversion

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import kotlinx.android.synthetic.main.conversion.*
import android.widget.ArrayAdapter;
import com.example.ejemplo.conversion.conversion_strategies.ConversionContext
import com.fasterxml.jackson.module.kotlin.*

import com.example.ejemplo.util.UnitConversionData
import java.io.File


class ConversionActivity : AppCompatActivity() {

    private var conversionData: Map<String, UnitConversionData>? = null;

    /*
        - tiempo
        - espacio
        - volumen
        - masa
        - ángulos
        - temperatura
     */
    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)

            initConversionData();
            val conversionContext: ConversionContext =
                ConversionContext(null)

            setContentView(com.example.ejemplo.R.layout.conversion)

            val adapter =
                ArrayAdapter.createFromResource(this, com.example.ejemplo.R.array.lMedidas,
                    com.example.ejemplo.R.layout.support_simple_spinner_dropdown_item)

            adapter.setDropDownViewResource(com.example.ejemplo.R.layout
                .support_simple_spinner_dropdown_item)

            medidas.setAdapter(adapter);

        }

        fun initConversionData () {

            val jsonString: String = File("src/main/assets/unit-conversion.json")
                .readText(Charsets.UTF_8)

            val mapper = jacksonObjectMapper()
            conversionData = mapper.readValue(jsonString)
        }
    }
