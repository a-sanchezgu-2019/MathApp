package com.example.ejemplo.conversion.conversion_strategies

import com.example.ejemplo.util.UnitConversionData
import com.example.ejemplo.util.UnitType

abstract class ConversionStrategy(val conversionData: Map<String, UnitConversionData>) {

    abstract var initialUnit: UnitType;

    abstract var resultUnit: UnitType;

    abstract var input: Double;

    abstract fun doOperation(): Double
}