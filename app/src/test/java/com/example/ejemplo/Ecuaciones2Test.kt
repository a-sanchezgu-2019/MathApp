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

    @Test
    fun ecuacionesconReales(){

        var  (resultado_1,resultado_2) = logicaEcuaciones.operacion(1.0,Math.sqrt(2.0),-3.0)

        assertEquals( "1.16372",resultado_1)
        assertEquals("-2.57793",resultado_2)

    }

    @Test
    fun ecuacionesconNegativos(){

        var  (resultado_1,resultado_2) = logicaEcuaciones.operacion(-1.0,-4.0,-1.0)

        assertEquals("-3.7320" ,resultado_1)
        assertEquals("-0.2679" ,resultado_2)
    }

    @Test
    fun ecuacionesconPositivos(){

        var  (resultado_1,resultado_2) = logicaEcuaciones.operacion(3.0,6.0,2.0)

        assertEquals("-0.42265" ,resultado_1)
        assertEquals("-1.57735" ,resultado_2)
    }

    @Test
    fun ecuacionesSolo0(){

        var  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,0.0,0.0)

        assertEquals("0" ,resultado_1)
        assertEquals("0" ,resultado_2)
    }

    @Test
    fun ecuacionPrimerParametro(){

        var  (resultado_1,resultado_2) = logicaEcuaciones.operacion(2.0,0.0,0.0)

        assertEquals("0" ,resultado_1)
        assertEquals("0" ,resultado_2)
    }

    @Test
    fun ecuacionSegundoParametro(){

        var  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,1.0,0.0)

        assertEquals("0" ,resultado_1)
        assertEquals("0" ,resultado_2)
    }

    @Test
    fun ecuacionTercerParametro(){

        var  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,0.0,1.0)

        assertEquals("Es una igualdad falsa" ,resultado_1)
        assertEquals("Es una igualdad falsa" ,resultado_2)
    }

}