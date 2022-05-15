package com.example.ejemplo.conversion

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import kotlinx.android.synthetic.main.conversion.*
import android.R
import android.widget.ArrayAdapter;
import android.widget.Spinner
import com.fasterxml.jackson.module.kotlin.*

import com.example.ejemplo.util.UnitConversionData
import org.json.JSONObject





class ConversionActivity : AppCompatActivity() {

    var conversionData: List<UnitConversionData>? = null;
    var listaMedidas = arrayListOf<String>()
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
        setContentView(com.example.ejemplo.R.layout.conversion)

        initConversionData();
        val conversionLogic: Conversion = Conversion(conversionData.orEmpty())

        listaMedidas.toTypedArray()
        val adapter = ArrayAdapter(
            this,
            R.layout.simple_dropdown_item_1line, listaMedidas
        )

        val textView =
            findViewById<Spinner>(com.example.ejemplo.R.id.medidas)

        textView.setAdapter(adapter)
//            val adapter =
//                ArrayAdapter.createFromResource(this, com.example.ejemplo.R.array.lMedidas,
//                    com.example.ejemplo.R.layout.support_simple_spinner_dropdown_item)
//
//            adapter.setDropDownViewResource(com.example.ejemplo.R.layout
//                .support_simple_spinner_dropdown_item)
//
//            medidas.setAdapter(adapter);

    }

        fun initConversionData () : ArrayList<String> {

            val file_name = "unit-conversion.json"
            val jsonString = application.assets.open(file_name).bufferedReader().use{
                it.readText()
            }

            val ob = JSONObject(jsonString)

            var  keys = ob.keys();
            while(keys.hasNext()) {
            // loop to get the dynamic key
            var  medida =  keys.next();
            // con esto te quedas con todas las claves del jsnon y se las añades
            // a lo que luego pondrás como desplegable
            listaMedidas.add(medida)
            }

            application.assets.close()

            //conversionData = mapper.readValue(jsonString)
            return listaMedidas
        }



    }

