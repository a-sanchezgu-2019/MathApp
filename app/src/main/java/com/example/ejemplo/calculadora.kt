package  com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_calculadora.*

class calculadora:AppCompatActivity(){

    private var logCalculadora: LogicaCalculadora = LogicaCalculadora()

    override fun onCreate(savedInstanceState: Bundle?) {
        //lateinit var editText: EditText
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        if (!Global.modo_noche) {
            fondoCalculadora.setBackgroundResource(R.drawable.fondo_calc_dia)
            resultadosView.setBackgroundResource(R.drawable.fondo_resultadodia)
            nueveBoton.setBackgroundResource(R.drawable.nuevedia)
            ochoBoton.setBackgroundResource(R.drawable.ochodia)
            sieteBoton.setBackgroundResource(R.drawable.sietedia)
            seisBoton.setBackgroundResource(R.drawable.seisdia)
            cincoBoton.setBackgroundResource(R.drawable.cincodia)
            cuatroBoton.setBackgroundResource(R.drawable.cuatrodia)
            tresBoton.setBackgroundResource(R.drawable.tresdia)
            dosBoton.setBackgroundResource(R.drawable.dosdia)
            unoBoton.setBackgroundResource(R.drawable.unodia)
            ceroBoton.setBackgroundResource(R.drawable.cerodia)
            comaBoton.setBackgroundResource(R.drawable.comadia)
            resultadosView.setTextColor(Color.parseColor("#000000") )
            ListaOperaciones.setTextColor(Color.parseColor("#080808") )
        }


        // Botón "Casita"
        val boton1 = findViewById<ImageButton>(R.id.boton_decalculadora_amenu)
        boton1.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }

        // Botón "confi"
        val boton2 = findViewById<ImageButton>(R.id.boton_config_calc)
        boton2.setOnClickListener {
            val intento2 = Intent(this, configuracion::class.java)
            startActivity(intento2)
        }


        cierreBoton.setOnClickListener {
            //val salida = Intent(Intent.ACTION_MAIN)
            finishAffinity()
        }

        ceroBoton.setOnClickListener { numeroPresionado(digito = "0") }
        unoBoton.setOnClickListener { numeroPresionado(digito = "1") }
        dosBoton.setOnClickListener { numeroPresionado(digito = "2") }
        tresBoton.setOnClickListener { numeroPresionado(digito = "3") }
        cuatroBoton.setOnClickListener { numeroPresionado(digito = "4") }
        cincoBoton.setOnClickListener { numeroPresionado(digito = "5") }
        seisBoton.setOnClickListener { numeroPresionado(digito = "6") }
        sieteBoton.setOnClickListener { numeroPresionado(digito = "7") }
        ochoBoton.setOnClickListener { numeroPresionado(digito = "8") }
        nueveBoton.setOnClickListener { numeroPresionado(digito = "9") }

        comaBoton.setOnClickListener { numeroPresionado(digito=".") }
        borrarBoton.setOnClickListener {
            val numeroBorrado:String
            if(resultadosView.length()>0 && logCalculadora.operacion == Operacion.SIN_OPERACION){

                numeroBorrado=resultadosView.text.substring(0,resultadosView.length()-1)
                resultadosView.text=numeroBorrado
            }

            if(ListaOperaciones.length()>0){
                val numeroBorrado2=ListaOperaciones.text.substring(0,ListaOperaciones.length()-1)
                ListaOperaciones.text=numeroBorrado2
            }

            logCalculadora.borrar()

        }


        sumaBoton.setOnClickListener { operacionPresinado(Operacion.SUMA) }
        restaBoton.setOnClickListener { operacionPresinado(Operacion.RESTA) }
        multBoton.setOnClickListener { operacionPresinado(Operacion.MULTIPLICACION) }
        divBoton.setOnClickListener { operacionPresinado(Operacion.DIVISION) }
        porcentajeBoton.setOnClickListener {operacionPresinado(Operacion.PORCENTAJE) }

        clearBoton.setOnClickListener {

            logCalculadora.clear()

            resultadosView.text = ""
            ListaOperaciones.text=""
        }

        igualBoton.setOnClickListener {

            val porcent = ListaOperaciones.text.toString()
            ListaOperaciones.text = porcent.replace("%","/100")

            val resultado = igual(/*ListaOperaciones.text.toString()*/)
            resultadosView.text = if("$resultado".endsWith(".0")){"$resultado".replace(".0","")}else{"%.2f".format(resultado)}

            val porcent2 = ListaOperaciones.text.toString()//esto lo hago para que se muestre "bonito" en la pantalla de la calcu
            ListaOperaciones.text = porcent2.replace("/100","%")
        }
    }



        private fun igual(/*str: String*/): Double {
            // Original Block (Commented by Adri)
            /*return object : Any() {
                var pos = -1
                var ch = 0
                fun nextChar() {
                    ch = if (++pos < str.length) str[pos].toInt() else -1
                }

                fun eat(charToEat: Int): Boolean {
                    while (ch == ' '.toInt()) nextChar()
                    if (ch == charToEat) {
                        nextChar()
                        return true
                    }
                    return false
                }

                fun parse(): Double {
                    nextChar()
                    val x = parseExpression()
                    if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                    return x
                }

                // Grammar:
                // expression = term | expression `+` term | expression `-` term
                // term = factor | term `*` factor | term `/` factor
                // factor = `+` factor | `-` factor | `(` expression `)`
                //        | number | functionName factor | factor `^` factor
                fun parseExpression(): Double {
                    var x = parseTerm()
                    while (true) {
                        if (eat('+'.toInt())) x += parseTerm() // addition
                        else if (eat('-'.toInt())) x -= parseTerm() // subtraction
                        else return x
                    }
                }

                fun parseTerm(): Double {
                    var x = parseFactor()
                    while (true) {
                        if (eat('*'.toInt())) x *= parseFactor() // multiplication
                        else if (eat('/'.toInt())) x /= parseFactor() // division
                        else return x
                    }
                }

                fun parseFactor(): Double {
                    if (eat('+'.toInt())) return parseFactor() // unary plus
                    if (eat('-'.toInt())) return -parseFactor() // unary minus
                    var x: Double
                    val startPos = pos
                    if (eat('('.toInt())) { // parentheses
                        x = parseExpression()
                        eat(')'.toInt())
                    } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) { // numbers
                        while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                        x = str.substring(startPos, pos).toDouble()
                    } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) { // functions
                        while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                        val func = str.substring(startPos, pos)
                        x = parseFactor()
                        x =
                            if (func == "sqrt") Math.sqrt(x) else if (func == "sin") Math.sin(
                                Math.toRadians(
                                    x
                                )
                            ) else if (func == "cos") Math.cos(
                                Math.toRadians(x)
                            ) else if (func == "tan") Math.tan(Math.toRadians(x)) else throw RuntimeException(
                                "Unknown function: $func"
                            )
                    } else {
                        throw RuntimeException("Unexpected: " + ch.toChar())
                    }
                    if (eat('^'.toInt())) x = Math.pow(x, parseFactor()) // exponentiation
                    return x
                }
            }.parse()*/

            return logCalculadora.igual()

        }



    private fun numeroPresionado(digito:String) {

        if (resultadosView.text=="0" && digito != "."){
            resultadosView.text= digito
            ListaOperaciones.text= digito
        }else{
            resultadosView.text="${resultadosView.text}$digito"
            ListaOperaciones.text="${ListaOperaciones.text}$digito"
        }

        logCalculadora.numeroPresionado(digito)

    }

    private fun operacionPresinado(operacion: Operacion) {

        logCalculadora.operacion = operacion
        resultadosView.text=""
        ListaOperaciones.text = "${ListaOperaciones.text}${operacion.toString()}"

    }

}