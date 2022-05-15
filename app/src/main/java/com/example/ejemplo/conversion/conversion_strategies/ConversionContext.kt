package com.example.ejemplo.conversion.conversion_strategies

import com.example.ejemplo.util.UnitType

class ConversionContext(

) {

    var strategy: ConversionStrategy? = null

    fun doOperation(): Double? {

        if (strategy != null) {
            strategy.let { return doOperation() }
        }

        return null
    }
}