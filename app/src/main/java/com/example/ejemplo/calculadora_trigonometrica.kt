package com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton
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
            resultadosTrig.setBackgroundResource(R.drawable.fondo_resultadodia)
            inversoBotonTrig.setBackgroundResource(R.drawable.inversodia)
            eBotonTrig.setBackgroundResource(R.drawable.edia)
            piBotonTrig.setBackgroundResource(R.drawable.pidia)
            nueveBotonTrig.setBackgroundResource(R.drawable.nuevedia)
            ochoBotonTrig.setBackgroundResource(R.drawable.ochodia)
            sieteBotonTrig.setBackgroundResource(R.drawable.sietedia)
            seisBotonTrig.setBackgroundResource(R.drawable.seisdia)
            cincoBotonTrig.setBackgroundResource(R.drawable.cincodia)
            cuatroBotonTrig.setBackgroundResource(R.drawable.cuatrodia)
            tresBotonTrig.setBackgroundResource(R.drawable.tresdia)
            dosBotonTrig.setBackgroundResource(R.drawable.dosdia)
            unoBotonTrig.setBackgroundResource(R.drawable.unodia)
            ceroBotonTrig.setBackgroundResource(R.drawable.cerodia)
            comaBotonTrig.setBackgroundResource(R.drawable.comadia)

            resultadosTrig.setTextColor(Color.parseColor("#000000") )
            ListaOperaciones1.setTextColor(Color.parseColor("#080808") )
        }

        gradosRadianesBotonTrig.setBackgroundResource(R.drawable.deg)//inicializamos el fondo del boton porque si no no sale

        // Botón "Casita"
        val boton1 = findViewById<ImageButton>(R.id.boton_decalculadoraTrigo_amenu)
        boton1.setOnClickListener {
            val intento1 = Intent(this, menu::class.java)
            startActivity(intento1)
        }

        // Boton "CONFIGURACIÓN"
        val boton2 = findViewById<ImageButton>(R.id.boton_config_calc_trig)
        boton2.setOnClickListener {
            val intento2 = Intent(this, configuracion::class.java)
            startActivity(intento2)
        }

        //BOTON CERRAR APP
        cierraApp_calTrigo.setOnClickListener {
            val salida = Intent(Intent.ACTION_MAIN)
            finishAffinity()
        }

        ceroBotonTrig.setOnClickListener { numeroPresionado(digito = "0") }
        unoBotonTrig.setOnClickListener { numeroPresionado(digito = "1") }
        dosBotonTrig.setOnClickListener { numeroPresionado(digito = "2") }
        tresBotonTrig.setOnClickListener { numeroPresionado(digito = "3") }
        cuatroBotonTrig.setOnClickListener { numeroPresionado(digito = "4") }
        cincoBotonTrig.setOnClickListener { numeroPresionado(digito = "5") }
        seisBotonTrig.setOnClickListener { numeroPresionado(digito = "6") }
        sieteBotonTrig.setOnClickListener { numeroPresionado(digito = "7") }
        ochoBotonTrig.setOnClickListener { numeroPresionado(digito = "8") }
        nueveBotonTrig.setOnClickListener { numeroPresionado(digito = "9") }

        comaBotonTrig.setOnClickListener { numeroPresionado(digito=".") }

        //BOTONES DE LA CALCULADORA DEL SPRINT 2
        gradosRadianesBotonTrig.setOnClickListener { cambiarGradosRadianes() }
        piBotonTrig.setOnClickListener { numeroPresionado(digito="π") }
        eBotonTrig.setOnClickListener { numeroPresionado(digito="e") }


        borrarBotonTrig.setOnClickListener {
            var numeroBorrado:String
            if(resultadosTrig.length()>0 && operacion==0){

                numeroBorrado=resultadosTrig.text.substring(0,resultadosTrig.length()-1)
                resultadosTrig.text=numeroBorrado
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


        sumaBotonTrig.setOnClickListener { operacionPresinado(SUMA) }
        restaBotonTrig.setOnClickListener { operacionPresinado(RESTA) }
        multbotonTrig.setOnClickListener { operacionPresinado(MULTIPLICACION) }
        divBotonTrig.setOnClickListener { operacionPresinado(DIVISION) }
        //OPERACIONES DEL SEGUNDO SPRINT
        raizBotonTrig.setOnClickListener { operacionPresinado(RAIZ) }
        potenciaBotonTrig.setOnClickListener { operacionPresinado(POTENCIA) }
        inversoBotonTrig.setOnClickListener { operacionPresinado(INVERSO) }
        senoBotonTrig.setOnClickListener {operacionPresinado(SENO)}
        cosenoBotonTrig.setOnClickListener {operacionPresinado(COSENO)}
        tangenteBotonTrig.setOnClickListener {operacionPresinado(TANGENTE)}
        parentesis_iz.setOnClickListener { operacionPresinado(PARENIZ)}
        parentesis_der.setOnClickListener { operacionPresinado(PARENDER)}
        //OPERACIONES DEL TERCER SPRINT
        porcentajeBotonTrig.setOnClickListener {operacionPresinado(PORCENTAJE)}



        clearBotonTrig.setOnClickListener {
            num1 = 0.0
            num2 = 0.0

            resultadosTrig.text = ""
            operacion = SIN_OPERACION
            ListaOperaciones1.text=""
        }

        igualBotonTrig.setOnClickListener {
            var nuevapi = ListaOperaciones1.text.toString()//tengo que hacer esto para π ya que si no no se hacer que vaya
            ListaOperaciones1.text = "$nuevapi".replace("π","3.14159265358979323846")
            var nuevae=ListaOperaciones1.text.toString()
            ListaOperaciones1.text = "$nuevae".replace("e","2.71828182845904523536")
            var nuevaporcent = ListaOperaciones1.text.toString()
            ListaOperaciones1.text = "$nuevaporcent".replace("%","/100")

            resultado = igual(ListaOperaciones1.text.toString())
            resultadosTrig.text = if("$resultado".endsWith(".0")){"$resultado".replace(".0","")}else{"%.2f".format(resultado)}

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
        if (resultadosTrig.text=="0" && digito != "."){
            resultadosTrig.text="$digito"
            ListaOperaciones1.text="$digito"
        }else{
            resultadosTrig.text="${resultadosTrig.text}$digito"
            ListaOperaciones1.text="${ListaOperaciones1.text}$digito"
        }

        if(operacion == SIN_OPERACION){
            if(resultadosTrig.text.toString()=="π"){
                num1=Math.PI
            }else if(resultadosTrig.text.toString()=="e"){
                num1=Math.E
            }else
                num1=resultadosTrig.text.toString().toDouble()
        }else{
            if(resultadosTrig.text.toString()=="π"){
                num1=Math.PI
            }else if(resultadosTrig.text.toString()=="e"){
                num1=Math.E
            }else
                num2=resultadosTrig.text.toString().toDouble()
        }
    }

    private fun operacionPresinado(operacion:Int) {

        this.operacion=operacion
        resultadosTrig.text=""



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
            gradosRadianesBotonTrig.setBackgroundResource(R.drawable.rad)

        }else{
            botonDegRad=true
            gradosRadianesBotonTrig.setBackgroundResource(R.drawable.deg)

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