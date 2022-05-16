package com.example.ejemplo.conversion.conversion_strategies

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType

class ConversionStrategySinOperacion(
    override var conversionToStandar: String,
    override var conversionToResult: String,
    override var input: Double
) : ConversionStrategy {

    override fun doOperation(): Double {


        return 0.0
    }
}