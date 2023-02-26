package com.example.pruebapractica1dsm_la181955_ma181956

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class FichaVendedorActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var btnCalcular : Button
    private lateinit var txtPrueba : TextView
    private lateinit var txtNombre : EditText
    private lateinit var txtCodigo : EditText
    private lateinit var txtTotalVenta : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_vendedor)

        spinner = findViewById<Spinner>(R.id.listaMeses)
        btnCalcular = findViewById<Button>(R.id.btnCalcularFicha)
        txtNombre = findViewById<EditText>(R.id.txtNombre)
        txtCodigo = findViewById<EditText>(R.id.txtCodigo)
        txtTotalVenta = findViewById<EditText>(R.id.txtTotalVentas)

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
            spinner.selectedItem
        }
    }
}