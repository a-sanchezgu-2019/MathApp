package com.example.ejemplo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Ecuaciones2Test {

    private val logicaEcuaciones: LogicaEcuaciones = LogicaEcuaciones()

    @Test
    fun addition_isCorrect() {
        var (result_1, result_2) =
            logicaEcuaciones.operacion(1.0, -2.0, 5.0)
        assertEquals("1 + 2i", result_1)
        assertEquals("1 - 2i", result_2)
    }
}