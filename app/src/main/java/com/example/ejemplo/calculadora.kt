package  com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_calculadora_trigonometrica.*
import kotlin.math.truncate

class calculadora:AppCompatActivity(){
    private var num1:Double=0.0
    private var num2 : Double = 0.0
    private var resultado : Double = 0.0

    private var operacion: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var editText: EditText
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
            val salida = Intent(Intent.ACTION_MAIN)
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
            var numeroBorrado:String
            if(resultadosView.length()>0 && operacion==0){

                numeroBorrado=resultadosView.text.substring(0,resultadosView.length()-1)
                resultadosView.text=numeroBorrado
            }

            if(ListaOperaciones.length()>0){
            var numeroBorrado2=ListaOperaciones.text.substring(0,ListaOperaciones.length()-1)
            ListaOperaciones.text=numeroBorrado2}

            if(operacion!=0){
                operacion=0
                num2=0.0
            }

            if(num2==0.0 && operacion!=0){
                var num = truncate(num1/10)
                num1=num
            }else{
                var num = truncate(num2/10)
                num2=num
            }
        }


        sumaBoton.setOnClickListener { operacionPresinado(SUMA) }
        restaBoton.setOnClickListener { operacionPresinado(RESTA) }
        multBoton.setOnClickListener { operacionPresinado(MULTIPLICACION) }
        divBoton.setOnClickListener { operacionPresinado(DIVISION) }
        porcentajeBoton.setOnClickListener {operacionPresinado(PORCENTAJE) }

        clearBoton.setOnClickListener {
            num1 = 0.0
            num2 = 0.0

            resultadosView.text = ""
            operacion = SIN_OPERACION
            ListaOperaciones.text=""
        }

        igualBoton.setOnClickListener {

            var porcent = ListaOperaciones.text.toString()
            ListaOperaciones.text = "$porcent".replace("%","/100")

            resultado = igual(ListaOperaciones.text.toString())
            resultadosView.text = if("$resultado".endsWith(".0")){"$resultado".replace(".0","")}else{"%.2f".format(resultado)}

            var porcent2 = ListaOperaciones.text.toString()//esto lo hago para que se muestre "bonito" en la pantalla de la calcu
            ListaOperaciones.text = "$porcent2 ".replace("/100","%")
        }
    }



        private fun igual(str: String): Double {

            return object : Any() {
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
            }.parse()




        }


    private fun numeroPresionado(digito:String) {
        if (resultadosView.text=="0" && digito != "."){
            resultadosView.text="$digito"
            ListaOperaciones.text="$digito"
        }else{
            resultadosView.text="${resultadosView.text}$digito"
            ListaOperaciones.text="${ListaOperaciones.text}$digito"
        }

        if(operacion ==SIN_OPERACION){
            num1=resultadosView.text.toString().toDouble()
        }else{
                num2=resultadosView.text.toString().toDouble()
        }
    }

    private fun operacionPresinado(operacion:Int) {

        this.operacion=operacion
        resultadosView.text=""

        if (operacion==1){
            var ope = "+"
            ListaOperaciones.text="${ListaOperaciones.text}$ope"
        }
        if(operacion==2){
            var ope = "-"
            ListaOperaciones.text="${ListaOperaciones.text}$ope"

        }
        if(operacion==3){
            var ope = "*"
            ListaOperaciones.text="${ListaOperaciones.text}$ope"

        }
        if(operacion==4){
            var ope = "/"
            ListaOperaciones.text="${ListaOperaciones.text}$ope"
        }

        if(operacion==5){
            var ope = "%"
            ListaOperaciones.text="${ListaOperaciones.text}$ope"
        }

    }

    companion object {
        const val SUMA=1
        const val RESTA = 2
        const val MULTIPLICACION =3
        const val DIVISION = 4
        const val SIN_OPERACION=0
        const val PORCENTAJE=5

    }
}