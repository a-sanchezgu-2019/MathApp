package com.example.ejemplo.conversion.conversion_strategies

import com.example.ejemplo.util.UnitType

class ConversionContext(
    var strategy: ConversionStrategy?
) {

    var initialUnit: UnitType? = null
    var resultUnit: UnitType? = null
    var input: Double? = null

    fun doOperation(): Double? {

        if (initialUnit != null && resultUnit != null && input != null && strategy != null) {

            return strategy?.doOperation()
        }

        return null
    }

    fun setStrategy() {

    }
}