package com.example.ejemplo.conversion

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import kotlinx.android.synthetic.main.conversion.*
import android.widget.ArrayAdapter;
import android.widget.Spinner
import com.example.ejemplo.R
import com.example.ejemplo.conversion.conversion_strategies.ConversionContext
import com.fasterxml.jackson.module.kotlin.*

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType
import org.json.JSONObject
import java.io.File


class ConversionActivity : AppCompatActivity() {

    private var conversionData: Map<UnitType, UnitConversionData>? = null;
    val listaMedidas = ArrayList<String>()
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
            val conversion: Conversion =
                Conversion(conversionData.orEmpty());

            setContentView(R.layout.conversion)

        listaMedidas.toTypedArray()
        val adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item, listaMedidas
        )

        val textView =
            findViewById<Spinner>(R.id.medidas)

        textView.setAdapter(adapter)


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
