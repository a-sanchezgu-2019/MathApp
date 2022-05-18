package com.example.ejemplo.conversion

import com.example.ejemplo.util.EquationResolver
import com.example.ejemplo.util.EquationResolverBasic
import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType

class Conversion(val conversionData: Map<UnitType, UnitConversionData>) {

    var magnitude: UnitType? = null
    var initialUnit: String? = null
    var resultUnit: String? = null
    var input: Double? = null

    fun doOperation(): Double? {

        var resultConversion: Double? = null;

        if (magnitude != null && initialUnit != null && resultUnit != null && input != null) {

            val magnitudeConversion = conversionData[magnitude]!!.conversion;

            val equationInitialUnit: String = magnitudeConversion[initialUnit]!!
            val equationResultUnit: String = magnitudeConversion[resultUnit]!!
            val equationResolver: EquationResolver = EquationResolverBasic()

            // Convert from initial unit to base unit (ex: minutes to seconds)
            val resultConversionToBaseUnit: Double? =
                equationResolver.resolve(arrayOf(input!!.toDouble()), equationInitialUnit);

            // Convert from base unit to result unit (ex: seconds to weeks)
            if (resultConversionToBaseUnit != null) {

                resultConversion =
                    equationResolver.resolve(
                        arrayOf(resultConversionToBaseUnit),
                        equationResultUnit
                    );
            }
        }

        return resultConversion
    }
}