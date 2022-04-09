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
    fun ecuacionResultadoImaginarios() {
        val (result_1, result_2) =
            logicaEcuaciones.operacion(1.0, -2.0, 5.0)
        assertEquals("1 + 2i", result_1)
        assertEquals("1  -2i", result_2)
    }

    @Test
    fun ecuacionResultadoReales(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(1.0,Math.sqrt(2.0),-3.0)

        assertEquals( "1.16372",resultado_1)
        assertEquals("-2.57793",resultado_2)

    }

    @Test
    fun ecuacionEntradaNegativos(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(-1.0,-4.0,-1.0)

        assertEquals("-3,7321" ,resultado_1)
        assertEquals("-0,2679" ,resultado_2)
    }

    @Test
    fun ecuacionEntradaPositivos(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(3.0,6.0,2.0)

        assertEquals("-0.42265" ,resultado_1)
        assertEquals("-1.57735" ,resultado_2)
    }

    @Test
    fun ecuacionVacia(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,0.0,0.0)

        assertEquals("Not defined" ,resultado_1)
        assertEquals("Not defined" ,resultado_2)
    }

    @Test
    fun ecuacionSoloElevado_2(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(2.0,0.0,0.0)

        assertEquals("Not defined" ,resultado_1)
        assertEquals("Not defined" ,resultado_2)
    }

    @Test
    fun ecuacionSoloElevado_1(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,1.0,0.0)

        assertEquals("0" ,resultado_1)
        assertEquals("0" ,resultado_2)
    }

    @Test
    fun ecuacionSoloElevado_0(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,0.0,1.0)

        assertEquals("Es una igualdad falsa" ,resultado_1)
        assertEquals("Es una igualdad falsa" ,resultado_2)
    }

    @Test
    fun sinElevado_2() {

        val (resultado_1, resultado_2) = logicaEcuaciones.operacion(0.0, 2.0, 3.0)

        assertEquals("-1.5", resultado_1)
        assertEquals("-1.5", resultado_2)
    }

    @Test
    fun sinElevado_1(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(1.0,0.0,-4.0)

        assertEquals("2" ,resultado_1)
        assertEquals("-2" ,resultado_2)
    }

    @Test
    fun sinElevado_0(){

        val  (resultado_1,resultado_2) =
            logicaEcuaciones.operacion(6.0,-5.0,0.0)

        assertEquals("0,0000" ,resultado_1)
        assertEquals("0,8333333333333334" ,resultado_2)
    }


    // NO son números muy grandes. Y para estos test se debería provocar una excepción o pensar
    // un protocolo
    @Test
    fun numerosMuyGrandes() {

        val (resultado_1, resultado_2) =
            logicaEcuaciones.operacion(1000.0, 2000.0, 3000.0)

        assertEquals("-1 + 1,41i", resultado_1)
        assertEquals("-1 - 1,41i", resultado_2)
    }


    // Existe una forma de hacer mejor este test
    @Test
    fun ecuacionGrado1() {
        var elevado_1 = 2.0
        var elevado_0 = -2.0
        var resultado = 1.0

        assertEquals(resultado, logicaEcuaciones.ecuacionGrado1(elevado_1, elevado_0), 0.0001)

        elevado_1 = -2.0
        elevado_0 = 2.0
        resultado = 1.0

        assertEquals(resultado, logicaEcuaciones.ecuacionGrado1(elevado_1, elevado_0), 0.0001)

        elevado_1 = 1.0
        elevado_0 = 0.0
        resultado = 0.0

        assertEquals(resultado, logicaEcuaciones.ecuacionGrado1(elevado_1, elevado_0),0.0001)

        elevado_1 = -1.0
        elevado_0 = -2.0
        resultado = -2.0

        assertEquals(resultado, logicaEcuaciones.ecuacionGrado1(elevado_1, elevado_0), 0.0001)
    }

    @Test
    fun testFormatoResta() {

        val resultado = "2 - 4i"

        assertEquals("-1 - 4i", logicaEcuaciones.formatoResta("-1", "-4"))
    }
}