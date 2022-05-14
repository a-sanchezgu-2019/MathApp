package com.example.ejemplo.conversion

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType
import com.fasterxml.jackson.module.kotlin.*
import java.io.File



class Conversion(var conversionData: List<UnitConversionData>) {

    var initialUnit: UnitType? = null;
    var resultUnit: UnitType? = null;

    init {


    }

    fun operacion(initialUnit: String, resultUnit: String) {


    }
}