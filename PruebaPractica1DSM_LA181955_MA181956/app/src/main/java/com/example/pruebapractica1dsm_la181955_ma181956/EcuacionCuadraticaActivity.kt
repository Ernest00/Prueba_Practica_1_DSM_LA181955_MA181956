package com.example.pruebapractica1dsm_la181955_ma181956

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EcuacionCuadraticaActivity : AppCompatActivity() {
    private lateinit var txtA : EditText
    private lateinit var txtB : EditText
    private lateinit var txtC : EditText
    private lateinit var btnCalcular : Button
    private lateinit var txtX1 : TextView
    private lateinit var txtX2 : TextView
    private lateinit var textoRespuesta : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuacion_cuadratica)

        txtA = findViewById<EditText>(R.id.txtNumberA)
        txtB = findViewById<EditText>(R.id.txtNumberB)
        txtC = findViewById<EditText>(R.id.txtNumberC)
        btnCalcular = findViewById<Button>(R.id.btnCalcular)
        txtX1 = findViewById<TextView>(R.id.txtResX1)
        txtX2 = findViewById<TextView>(R.id.txtResX2)
        textoRespuesta = findViewById<TextView>(R.id.textoRespuesta)

        btnCalcular.setOnClickListener {
            if (txtA.text.toString().isEmpty() || txtB.text.toString().isEmpty() || txtC.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese todos los coeficientes para calcular las 2 respuestas de (X)", Toast.LENGTH_SHORT).show()
            } else if (txtA.text.toString().toDouble() == 0.0){
                Toast.makeText(this, "El valor del coeficiente (A) NO puede ser cero.", Toast.LENGTH_SHORT).show()
            } else {
                var x1 : Double = 0.0
                var x2 : Double = 0.0
                var a : Double = txtA.text.toString().toDouble()
                var b : Double = txtB.text.toString().toDouble()
                var c : Double = txtC.text.toString().toDouble()
                var discriminante : Double = (Math.pow(b, 2.0) - (4*a*c))
                var resImaginaria : Boolean = false

                // Calculando respuestas con números complejos (raíz cuadrada de números negativos)
                if (discriminante < 0) {
                    discriminante = -1 * discriminante;
                    var parteReal : Double = -b / 2*a
                    var parteImaginaria : Double = Math.sqrt(discriminante) / 2*a
                    // Mostrando respuestas al usuario
                    textoRespuesta.text = "Resultado con números complejos: "
                    txtX1.text = "x1: " + parteReal.toString() + " + " + parteImaginaria.toString() + "i"
                    txtX2.text = "x2: " + parteReal.toString() + " - " + parteImaginaria.toString() + "i"
                } else {
                    // Calculando raíces del polinomio
                    x1 = (-b + Math.sqrt(discriminante)) / 2*a
                    x2 = (-b - Math.sqrt(discriminante)) / 2*a
                    // Mostrando respuestas al usuario
                    textoRespuesta.text = "Resultado: "
                    txtX1.text = "x1: " + x1.toString()
                    txtX2.text = "x2: " + x2.toString()
                }
            }
        }
    }
}