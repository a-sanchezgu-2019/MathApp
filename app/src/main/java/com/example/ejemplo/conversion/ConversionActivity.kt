
package com.example.ejemplo.conversion

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import kotlinx.android.synthetic.main.conversion.*
import android.R
import android.widget.ArrayAdapter;



class ConversionActivity : AppCompatActivity() {

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
            val adapter =
                ArrayAdapter.createFromResource(this, com.example.ejemplo.R.array.lMedidas, com.example.ejemplo.R.layout.support_simple_spinner_dropdown_item)

            adapter.setDropDownViewResource(com.example.ejemplo.R.layout.support_simple_spinner_dropdown_item)

            medidas.setAdapter(adapter);

        }

    }
