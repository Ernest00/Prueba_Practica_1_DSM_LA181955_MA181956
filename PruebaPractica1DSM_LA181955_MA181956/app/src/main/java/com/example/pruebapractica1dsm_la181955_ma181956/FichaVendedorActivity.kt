package com.example.pruebapractica1dsm_la181955_ma181956

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class FichaVendedorActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var btnCalcular : Button
    private lateinit var txtNombre : EditText
    private lateinit var txtCodigo : EditText
    private lateinit var txtTotalVenta : EditText

    private lateinit var txtErrorNombre : TextView
    private lateinit var txtErrorCodigo : TextView
    private lateinit var txtErrorVentas : TextView

    private lateinit var btnVolverMenu1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_vendedor)

        spinner = findViewById<Spinner>(R.id.listaMeses)
        btnCalcular = findViewById<Button>(R.id.btnCalcularFicha)
        txtNombre = findViewById<EditText>(R.id.txtNombre)
        txtErrorNombre = findViewById<TextView>(R.id.txtErrorNombre)
        txtCodigo = findViewById<EditText>(R.id.txtCodigo)
        txtErrorCodigo = findViewById<TextView>(R.id.txtErrorCodigo)
        txtTotalVenta = findViewById<EditText>(R.id.txtTotalVentas)
        txtErrorVentas = findViewById<TextView>(R.id.txtErrorVentas)
        btnVolverMenu1 = findViewById<Button>(R.id.btnVolverMenu1)

        // Cargando el listado de meses desde un array de recursos al objeto spinner (dropdown)
        ArrayAdapter.createFromResource(
            this,
            R.array.meses_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        btnCalcular.setOnClickListener {
            if(txtNombre.text.toString().trim().isNotEmpty() && txtCodigo.text.toString().trim().isNotEmpty() && txtTotalVenta.text.toString().trim().isNotEmpty()){
                var intent = Intent( this, DatosVendedorActivity::class.java)
                intent.putExtra("nombre", txtNombre.text.toString())
                intent.putExtra("codigo", txtCodigo.text.toString())
                intent.putExtra("total", txtTotalVenta.text.toString())
                intent.putExtra("mes", spinner.selectedItem.toString())
                startActivity(intent)
            }

            if(txtNombre.text.toString().trim().isEmpty()){
                txtErrorNombre.setText("No ha ingresado el nombre del empleado")
            }else{
                txtErrorNombre.setText("")
            }

            if(txtCodigo.text.toString().trim().isEmpty()){
                txtErrorCodigo.setText("No ha ingresado el código del empleado")
            }else{
                txtErrorCodigo.setText("")
            }

            if(txtTotalVenta.text.toString().trim().isEmpty()){
                txtErrorVentas.setText("No ha ingresado el total de ventas")
            }else{
                txtErrorVentas.setText("")
            }
        }

        btnVolverMenu1.setOnClickListener {
            finish()
        }
    }
}