package com.example.pruebapractica1dsm_la181955_ma181956

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class DatosVendedorActivity : AppCompatActivity() {
    private lateinit var btnVolver : Button
    private lateinit var txtResNombre : TextView
    private lateinit var txtResCodigo : TextView
    private lateinit var txtResVentas : TextView
    private lateinit var txtResMes : TextView
    private lateinit var txtResPorcentaje : TextView
    private lateinit var txtResComisiones : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_vendedor)

        txtResNombre = findViewById<TextView>(R.id.txtResNombre)
        txtResCodigo = findViewById<TextView>(R.id.txtResCodigo)
        txtResVentas = findViewById<TextView>(R.id.txtResVentas)
        txtResMes = findViewById<TextView>(R.id.txtResMes)
        txtResPorcentaje = findViewById<TextView>(R.id.txtResPorcentaje)
        txtResComisiones = findViewById<TextView>(R.id.txtResComisiones)

        btnVolver = findViewById<Button>(R.id.btnVolver)

        val bundle = intent.extras

        val nombre = bundle?.getString("nombre").toString()
        val codigo = bundle?.getString("codigo").toString()
        val total = bundle?.getString("total").toString()
        val mes = bundle?.getString("mes").toString()
        val porc = CalcularPorcentaje(total.toDouble());
        val comisiones = (total.toDouble() * porc.toDouble())

        txtResNombre.setText(nombre)
        txtResCodigo.setText(codigo)
        txtResVentas.setText(total)
        txtResMes.setText(mes)
        txtResPorcentaje.setText((porc*100).toString()+" %")
        txtResComisiones.setText(comisiones.toString())

        btnVolver.setOnClickListener {
            var intent = Intent(this, FichaVendedorActivity::class.java)
            startActivity(intent)
        }

    }


    fun CalcularPorcentaje(total:Double): Double {
            if(total>=4000) {
                return 0.3
            }else if(total>=3000){
                return 0.2
            }else if(total>=2000){
                return 0.15
            }else if(total>=1000){
                return 0.1
            }else if(total>=500){
                return 0.05
            }else{
                return 0.0
            }

    }
}