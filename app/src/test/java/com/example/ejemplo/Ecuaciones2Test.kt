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
        assertEquals("1 - 2i", result_2)
    }

    @Test
    fun ecuacionResultadoReales(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(1.0,Math.sqrt(2.0),-3.0)

        assertEquals( "1.1637e+00",resultado_1)
        assertEquals("-2.5779e+00",resultado_2)

    }

    @Test
    fun ecuacionEntradaNegativos(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(-1.0,-4.0,-1.0)

        assertEquals("-3.7321e+00" ,resultado_1)
        assertEquals("-2.6795e-01" ,resultado_2)
    }

    @Test
    fun ecuacionEntradaPositivos(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(3.0,6.0,2.0)

        assertEquals("-4.2265e-01" ,resultado_1)
        assertEquals("-1.5774e+00" ,resultado_2)
    }

    @Test
    fun ecuacionVacia(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,0.0,0.0)

        assertEquals("Es una igualdad falsa" ,resultado_1)
        assertEquals("Es una igualdad falsa" ,resultado_2)
    }

    @Test
    fun ecuacionSoloElevado_2(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(2.0,0.0,0.0)

        assertEquals("0" ,resultado_1)
        assertEquals("0" ,resultado_2)
    }

    @Test
    fun ecuacionSoloElevado_1(){

        val  (resultado_1,resultado_2) = logicaEcuaciones.operacion(0.0,1.0,0.0)

        assertEquals("0" ,resultado_1)
        assertEquals("No hay segundo resultado" ,resultado_2)
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

        assertEquals("-1.5000", resultado_1)
        assertEquals("No hay segundo resultado", resultado_2)
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

        assertEquals("8.3333e-01" ,resultado_1)
        assertEquals("0" ,resultado_2)
    }

    // NO son números muy grandes. Y para estos test se debería provocar una excepción o pensar
    // un protocolo

    @Test
    fun numerosMuyGrandes() {

        val (resultado_1, resultado_2) =
            logicaEcuaciones.operacion(1000.0, 2000.0, 3000.0)

        assertEquals("-1 + 1.41i", resultado_1)
        assertEquals("-1 - 1.41i", resultado_2)
    }


    // Existe una forma de hacer mejor este test
    @Test
    fun ecuacionGrado1() {
        var elevado_1 = 2.0
        var elevado_0 = -2.0
        var (resultado, resultado_2) = logicaEcuaciones.operacion(0.0, elevado_1, elevado_0)
        assertEquals("1", resultado)
        assertEquals("No hay segundo resultado", resultado_2)
    }
    @Test
    fun ecuacionGrado1XNegativa() {
        var elevado_1 = -2.0
        var elevado_0 = 2.0
        //resultado = "1.0"

        var (resultado, resultado_2) = logicaEcuaciones.operacion(0.0, elevado_1, elevado_0)
        assertEquals("1", resultado)
        assertEquals("No hay segundo resultado", resultado_2)
    }
    @Test
    fun ecuacionGrado1XIgual0() {
        var elevado_1 = 1.0
        var elevado_0 = 0.0
        //resultado = "0.0"

        var (resultado, resultado_2) = logicaEcuaciones.operacion(0.0, elevado_1, elevado_0)
        assertEquals("0", resultado)
        assertEquals("No hay segundo resultado", resultado_2)
    }
    @Test
    fun ecuacionGrado1ParametrosNegativos(){
        var elevado_1 = -1.0
        var elevado_0 = -2.0
        //resultado = "-2.0"

        var (resultado,resultado_2) = logicaEcuaciones.operacion(0.0, elevado_1, elevado_0)
        assertEquals("-2", resultado )
        assertEquals("No hay segundo resultado",resultado_2)

    }

    @Test
    fun testFormatoResta() {

        val resultado = "2 - 4i"

        assertEquals("-1 - 4i", logicaEcuaciones.formatoResta("-1", "-4"))
    }
}