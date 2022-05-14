package com.example.ejemplo.conversion.conversion_strategies

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType

class ConversionStrategyConOperacion(
    override var conversionToStandar: String,
    override var conversionToResult: String,
    override var input: Double
) : ConversionStrategy {

    override fun doOperation(): Double {
        TODO("Not yet implemented")
    }

}