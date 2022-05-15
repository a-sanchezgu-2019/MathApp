package com.example.ejemplo.conversion.conversion_strategies

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType

interface ConversionStrategy {

    var conversionToStandar: String;

    var conversionToResult: String;

    var input: Double;

    fun doOperation(): Double
}