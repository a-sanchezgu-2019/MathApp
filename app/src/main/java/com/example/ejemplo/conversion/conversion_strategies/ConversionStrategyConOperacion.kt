package com.example.ejemplo.conversion.conversion_strategies

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType

class ConversionStrategyConOperacion(
    conversionData: Map<String, UnitConversionData>,
    override var initialUnit: UnitType,
    override var resultUnit: UnitType,
    override var input: Double
) : ConversionStrategy(conversionData) {

    override fun doOperation(): Double {
        TODO("Not yet implemented")
    }

}