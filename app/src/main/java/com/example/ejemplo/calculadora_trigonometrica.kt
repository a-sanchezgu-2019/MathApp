package com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_calculadora_trigonometrica.*
import kotlin.math.truncate

// EN CONSTRUCCIÓN...
class calculadora_trigonometrica:AppCompatActivity() {
    private var num1:Double=0.0
    private var num2 : Double = 0.0
    private var resultado : Double = 0.0
    private var botonDegRad: Boolean = true //true es deg, false es Rad


    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var editText: EditText
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_trigonometrica)

        if (!Global.modo_noche) {
            parentesisiz.setBackgroundResource(R.drawable.fondo_calc_dia)
            resultadosTrigo.setBackgroundResource(R.drawable.fondo_resultadodia)
            inversoBoton1.setBackgroundResource(R.drawable.inversodia)
            eBoton1.setBackgroundResource(R.drawable.edia)
            piBoton1.setBackgroundResource(R.drawable.pidia)
            nueveBoton1.setBackgroundResource(R.drawable.nuevedia)
            ochoBoton1.setBackgroundResource(R.drawable.ochodia)
            sieteBoton1.setBackgroundResource(R.drawable.sietedia)
            seisBoton1.setBackgroundResource(R.drawable.seisdia)
            cincoBoton1.setBackgroundResource(R.drawable.cincodia)
            cuatroBoton1.setBackgroundResource(R.drawable.cuatrodia)
            tresBoton1.setBackgroundResource(R.drawable.tresdia)
            dosBoton1.setBackgroundResource(R.drawable.dosdia)
            unoBoton1.setBackgroundResource(R.drawable.unodia)
            ceroBoton1.setBackgroundResource(R.drawable.cerodia)
            comaBoton1.setBackgroundResource(R.drawable.comadia)

            resultadosTrigo.setTextColor(Color.parseColor("#000000") )
            ListaOperaciones1.setTextColor(Color.parseColor("#080808") )
        }

        gradosRadianesBoton1.setBackgroundResource(R.drawable.deg)//inicializamos el fondo del boton porque si no no sale

        // Botón "Casita"
        val boton1 = findViewById<ImageButton>(R.id.boton_decalculadoraTrigo_amenu)
        boton1.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }

        // Boton "CONFIGURACIÓN"
        val boton2 = findViewById<ImageButton>(R.id.boton_config_calc_trigo)
        boton2.setOnClickListener {
            val intento2 = Intent(this, configuracion::class.java)
            startActivity(intento2)
        }

        //BOTON CERRAR APP
        cierraApp_calTrigo.setOnClickListener {
            val salida = Intent(Intent.ACTION_MAIN)
            finishAffinity()
        }

        ceroBoton1.setOnClickListener { numeroPresionado(digito = "0") }
        unoBoton1.setOnClickListener { numeroPresionado(digito = "1") }
        dosBoton1.setOnClickListener { numeroPresionado(digito = "2") }
        tresBoton1.setOnClickListener { numeroPresionado(digito = "3") }
        cuatroBoton1.setOnClickListener { numeroPresionado(digito = "4") }
        cincoBoton1.setOnClickListener { numeroPresionado(digito = "5") }
        seisBoton1.setOnClickListener { numeroPresionado(digito = "6") }
        sieteBoton1.setOnClickListener { numeroPresionado(digito = "7") }
        ochoBoton1.setOnClickListener { numeroPresionado(digito = "8") }
        nueveBoton1.setOnClickListener { numeroPresionado(digito = "9") }

        comaBoton1.setOnClickListener { numeroPresionado(digito=".") }

        //BOTONES DE LA CALCULADORA DEL SPRINT 2
        gradosRadianesBoton1.setOnClickListener { cambiarGradosRadianes() }
        piBoton1.setOnClickListener { numeroPresionado(digito="π") }
        eBoton1.setOnClickListener { numeroPresionado(digito="e") }


        borrarBoton1.setOnClickListener {
            var numeroBorrado:String
            if(resultadosTrigo.length()>0 && operacion==0){

                numeroBorrado=resultadosTrigo.text.substring(0,resultadosTrigo.length()-1)
                resultadosTrigo.text=numeroBorrado
            }

            if(ListaOperaciones1.length()>0){
                var numeroBorrado2=ListaOperaciones1.text.substring(0,ListaOperaciones1.length()-1)
                ListaOperaciones1.text=numeroBorrado2}

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


        sumaBoton1.setOnClickListener { operacionPresinado(SUMA) }
        restaBoton1.setOnClickListener { operacionPresinado(RESTA) }
        multboton1.setOnClickListener { operacionPresinado(MULTIPLICACION) }
        divBoton1.setOnClickListener { operacionPresinado(DIVISION) }
        //OPERACIONES DEL SEGUNDO SPRINT
        raizBoton1.setOnClickListener { operacionPresinado(RAIZ) }
        potenciaBoton1.setOnClickListener { operacionPresinado(POTENCIA) }
        inversoBoton1.setOnClickListener { operacionPresinado(INVERSO) }
        senoBoton1.setOnClickListener {operacionPresinado(SENO)}
        cosenoBoton1.setOnClickListener {operacionPresinado(COSENO)}
        tangenteBoton1.setOnClickListener {operacionPresinado(TANGENTE)}
        parentesis_iz.setOnClickListener { operacionPresinado(PARENIZ)}
        parentesis_der.setOnClickListener { operacionPresinado(PARENDER)}
        //OPERACIONES DEL TERCER SPRINT
        porcentajeBoton1.setOnClickListener {operacionPresinado(PORCENTAJE)}



        clearBoton1.setOnClickListener {
            num1 = 0.0
            num2 = 0.0

            resultadosTrigo.text = ""
            operacion = SIN_OPERACION
            ListaOperaciones1.text=""
        }

        igualBoton1.setOnClickListener {
            var nuevapi = ListaOperaciones1.text.toString()//tengo que hacer esto para π ya que si no no se hacer que vaya
            ListaOperaciones1.text = "$nuevapi".replace("π","3.14159265358979323846")
            var nuevae=ListaOperaciones1.text.toString()
            ListaOperaciones1.text = "$nuevae".replace("e","2.71828182845904523536")
            var nuevaporcent = ListaOperaciones1.text.toString()
            ListaOperaciones1.text = "$nuevaporcent".replace("%","/100")

            resultado = igual(ListaOperaciones1.text.toString())
            resultadosTrigo.text = if("$resultado".endsWith(".0")){"$resultado".replace(".0","")}else{"%.2f".format(resultado)}

            var nueva1pi = ListaOperaciones1.text.toString()//esto lo hago para que se muestre "bonito" en la pantalla de la calcu
            ListaOperaciones1.text = "$nueva1pi".replace("3.14159265358979323846","π")
            var nueva1e=ListaOperaciones1.text.toString()
            ListaOperaciones1.text = "$nueva1e".replace("2.71828182845904523536","e")
            var nueva2porcent = ListaOperaciones1.text.toString()//esto lo hago para que se muestre "bonito" en la pantalla de la calcu
            ListaOperaciones1.text = "$nueva2porcent ".replace("/100","%")
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
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt() ) { // numbers
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                }

                else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) { // functions
                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                    x = if (func == "sqrt") Math.sqrt(x)
                    else if (func == "sin") Math.sin(x)
                    else if (func == "cos") Math.cos(x)
                    else if (func == "tan") Math.tan(x)
                    else if(func == "^-1") Math.pow(x,-1.0)

                    else throw RuntimeException(
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
        if (resultadosTrigo.text=="0" && digito != "."){
            resultadosTrigo.text="$digito"
            ListaOperaciones1.text="$digito"
        }else{
            resultadosTrigo.text="${resultadosTrigo.text}$digito"
            ListaOperaciones1.text="${ListaOperaciones1.text}$digito"
        }

        if(operacion == SIN_OPERACION){
            if(resultadosTrigo.text.toString()=="π"){
                num1=Math.PI
            }else if(resultadosTrigo.text.toString()=="e"){
                num1=Math.E
            }else
                num1=resultadosTrigo.text.toString().toDouble()
        }else{
            if(resultadosTrigo.text.toString()=="π"){
                num1=Math.PI
            }else if(resultadosTrigo.text.toString()=="e"){
                num1=Math.E
            }else
                num2=resultadosTrigo.text.toString().toDouble()
        }
    }

    private fun operacionPresinado(operacion:Int) {

        this.operacion=operacion
        resultadosTrigo.text=""



        if (operacion==1){
            var ope = "+"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }
        if(operacion==2){
            var ope = "-"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"

        }
        if(operacion==3){
            var ope = "*"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"

        }
        if(operacion==4){
            var ope = "/"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }

        if(operacion==5){
            var ope="sqrt"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }

        if(operacion==6){
            var ope="^"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }

        if(operacion==7){
            var ope="^-1"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }

        if(operacion==8){
            var ope="sin"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }

        if(operacion==9){
            var ope="cos"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }

        if(operacion==10){
            var ope="tan"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }
        if(operacion==11){
            var ope="("
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }
        if(operacion==12){
            var ope=")"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }
        if(operacion==13){
            var ope = "%"
            ListaOperaciones1.text="${ListaOperaciones1.text}$ope"
        }
    }

    private fun cambiarGradosRadianes(){
        if(botonDegRad){
            botonDegRad=false
            gradosRadianesBoton1.setBackgroundResource(R.drawable.rad)

        }else{
            botonDegRad=true
            gradosRadianesBoton1.setBackgroundResource(R.drawable.deg)

        }
    }

    companion object {
        const val SUMA=1
        const val RESTA = 2
        const val MULTIPLICACION =3
        const val DIVISION = 4
        const val RAIZ=5
        const val POTENCIA=6
        const val INVERSO = 7
        const val SENO=8
        const val COSENO=9
        const val TANGENTE=10
        const val SIN_OPERACION=0
        const val PARENIZ = 11
        const val PARENDER = 12
        const val PORCENTAJE = 13
    }


}