package com.example.ejemplo.conversion

import com.example.ejemplo.conversion.conversion_strategies.ConversionContext
import com.example.ejemplo.conversion.conversion_strategies.ConversionStrategy
import com.example.ejemplo.conversion.conversion_strategies.ConversionStrategyConOperacion
import com.example.ejemplo.conversion.conversion_strategies.ConversionStrategySinOperacion
import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType

class Conversion(val conversionData: Map<UnitType, UnitConversionData>) {

    var magnitude: UnitType? = null
    var initialUnit: String? = null
    var resultUnit: String? = null
    var input: Double? = null

    fun doOperation(): String? {

        if (magnitude != null && initialUnit != null && resultUnit != null && input != null) {

            val context: ConversionContext = ConversionContext();
            val strategy: ConversionStrategy? = selectStrategy()

        }

        return null;
    }

    private fun selectStrategy(): ConversionStrategy? {

        var conversionStrategy: ConversionStrategy? = null;
        val operatorInitialUnit: String? = conversionData[magnitude]?.conversion?.get(initialUnit)
        val operatorResultUnit: String? = conversionData[magnitude]?.conversion?.get(resultUnit)

        if (operatorInitialUnit != null && operatorResultUnit != null) {


            if (isEquation(operatorInitialUnit.orEmpty())) {

                conversionStrategy = ConversionStrategyConOperacion(
                    operatorInitialUnit,
                    operatorResultUnit,
                    input!!)
            } else {

                conversionStrategy = ConversionStrategySinOperacion(
                    operatorInitialUnit,
                    operatorResultUnit,
                    input!!)
            }
        }

        return conversionStrategy;
    }

    private fun isEquation(operator: String): Boolean {

        val equationCharacters: Regex = Regex("[+*]")

        val isEquation = operator.contains(equationCharacters)
        return isEquation;
    }
}