package com.example.ejemplo.conversion

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter;
import android.widget.Spinner
import android.widget.Toast
import com.example.ejemplo.MainActivity
import com.example.ejemplo.R

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.conversion.*
import org.json.JSONObject


class ConversionActivity : AppCompatActivity() {

    private var conversionData: Map<UnitType, UnitConversionData>? = null;
    var listaMedidas = ArrayList<String>()
    var medidaInicial = ArrayList<String>()

    /*
        - tiempo
        - espacio
        - volumen
        - masa
        - ángulos
        - temperatura
     */
    fun cambiarunidades(opcion: String): ArrayList<String> {
            medidaInicial.clear()
            val file_name = "unit-conversion.json"
            val jsonString = application.assets.open(file_name).bufferedReader().use {
                it.readText()
            }
            val ob = JSONObject(jsonString)
            var medida = ob.getJSONObject(opcion)
            var claves = medida.keys()
            var unidad = ""
            while (claves.hasNext()) {
                var clave = claves.next();
                if (clave.equals("conversion")) {
                    var unidadConversión = medida.getJSONObject(clave)
                    var clavesConversión = unidadConversión.keys()
                    while (clavesConversión.hasNext()) {
                        var claveConversion = clavesConversión.next();
                        medidaInicial.add(claveConversion)
                    }

                }
                // loop to get the dynamic key
                else {
                    unidad = medida.getString(clave)
                    medidaInicial.add(unidad)
                }


            }

            // get selected item text

        return medidaInicial
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initConversionData();
        val conversion: Conversion =
            Conversion(conversionData.orEmpty());

        setContentView(R.layout.conversion)

        listaMedidas.toTypedArray()
        val adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item, listaMedidas
        )


        val desplegableMedidas =
            findViewById<Spinner>(R.id.medidas)

        desplegableMedidas.adapter = adapter
        var array2 =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, medidaInicial);
        // spinner on item selected listener
        desplegableMedidas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val file_name = "unit-conversion.json"
                val jsonString = application.assets.open(file_name).bufferedReader().use {
                    it.readText()
                }
                var opcion = parent.getItemAtPosition(position).toString()
                medidaInicial =cambiarunidades(opcion)
                medidaInicial.toArray()
                unidadInicial.adapter = array2
                unidadFinal.adapter=array2
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        medidaInicial.toArray()
        unidadInicial.adapter = array2
        unidadFinal.adapter= array2

    }


    fun initConversionData(): ArrayList<String> {

        val file_name = "unit-conversion.json"
        val jsonString = application.assets.open(file_name).bufferedReader().use {
            it.readText()
        }

        val ob = JSONObject(jsonString)

        var keys = ob.keys();
        while (keys.hasNext()) {
            // loop to get the dynamic key
            var medida = keys.next();
            // con esto te quedas con todas las claves del jsnon y se las añades
            // a lo que luego pondrás como desplegable
            listaMedidas.add(medida)
        }

        // application.assets.close()

        //conversionData = mapper.readValue(jsonString)
        return listaMedidas
    }

}

