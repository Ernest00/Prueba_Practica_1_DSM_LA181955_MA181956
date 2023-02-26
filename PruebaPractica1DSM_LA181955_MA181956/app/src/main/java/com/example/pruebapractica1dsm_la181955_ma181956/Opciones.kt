package com.example.pruebapractica1dsm_la181955_ma181956

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Opciones : AppCompatActivity() {
    private lateinit var btn_logout : Button
    private lateinit var btn_ejercicio1 : Button
    private lateinit var btn_ejercicio2 : Button
    private lateinit var txt_usuario : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        txt_usuario =findViewById<TextView>(R.id.txtUsuario)
        btn_ejercicio1 = findViewById<Button>(R.id.btn_ejercicio1)
        btn_ejercicio2 = findViewById<Button>(R.id.btn_ejercicio2)
        btn_logout = findViewById<Button>(R.id.btn_logout)

        val preferences: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)

        val usuarioActivo = preferences.getString("user", "no hay nada cargado")
        txt_usuario.setText(usuarioActivo)

        btn_ejercicio1.setOnClickListener{
            var intent = Intent( this, FichaVendedorActivity::class.java)
            startActivity(intent)
        }

        btn_ejercicio2.setOnClickListener{
            var intent = Intent( this, EcuacionCuadraticaActivity::class.java)
            startActivity(intent)
        }

        btn_logout.setOnClickListener {
            restablecerPreferencias()
            verificarSesion()
        }
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this, "onResume2", Toast.LENGTH_SHORT).show()
        Log.i("Estado","onResume2")
    }

    override fun onPause() {
        super.onPause()
        //Toast.makeText(this, "onPause2", Toast.LENGTH_SHORT).show()
        Log.i("Estado","onPause2")
    }

    override fun onStop() {
        super.onStop()
        //Toast.makeText(this, "onStop2", Toast.LENGTH_SHORT).show()
        Log.i("Estado","onStop2")
    }

    override fun onRestart() {
        super.onRestart()
        //Toast.makeText(this, "onRestart2", Toast.LENGTH_SHORT).show()
        Log.i("Estado","onRestart2")
    }

    override fun onDestroy() {
        super.onDestroy()
        //Toast.makeText(this, "onDestroy2", Toast.LENGTH_SHORT).show()
        Log.i("Estado","onDestroy2")
    }

    private fun restablecerPreferencias(){
        val preferences: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()

        editor.putString("user","")
        editor.putString("pass","")

        editor.commit()
    }

    private fun verificarSesion(){
        val preferences: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)

        val usuarioActivo = preferences.getString("user", "no hay nada cargado")
        val passwordActiva = preferences.getString("pass", "no hay nada cargao")
finish()
       /* if(usuarioActivo.toString().isEmpty() && passwordActiva.toString().isEmpty()){
            Toast.makeText(this, "Sin sesión", Toast.LENGTH_SHORT).show()
            var intent = Intent( this, MainActivity::class.java)
            startActivity(intent)
        }*/
    }
}