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
import kotlinx.android.synthetic.main.activity_ecuaciones.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.conversion.*
import kotlinx.android.synthetic.main.conversion.cerrar_Boton
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

