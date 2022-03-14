package  com.example.ejemplo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_calculadora.*

class calculadora:AppCompatActivity(){

    private var logCalculadora: LogicaCalculadora = LogicaCalculadora()

    override fun onCreate(savedInstanceState: Bundle?) {
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

            val resultado = igual()
            resultadosView.text = if("$resultado".endsWith(".0")){"$resultado".replace(".0","")}else{"%.2f".format(resultado)}

            val porcent2 = ListaOperaciones.text.toString()//esto lo hago para que se muestre "bonito" en la pantalla de la calcu
            ListaOperaciones.text = porcent2.replace("/100","%")
        }
    }

        private fun igual(): Double {

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

        if(logCalculadora.operacion != Operacion.SIN_OPERACION) {
            logCalculadora.igual()
        }
        logCalculadora.operacion = operacion

        resultadosView.text = ""
        ListaOperaciones.text = "${ListaOperaciones.text}${operacion.toString()}"

    }

}