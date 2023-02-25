package com.example.pruebapractica1dsm_la181955_ma181956

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Opciones : AppCompatActivity() {
    private lateinit var btn_logout : Button
    private lateinit var txt_usuario : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)
        verificarSesion()

        btn_logout = findViewById<Button>(R.id.btn_logout)
        txt_usuario =findViewById<TextView>(R.id.txtUsuario)

        val preferences: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)

        val usuarioActivo = preferences.getString("user", "no hay nada cargado")
        txt_usuario.setText(usuarioActivo)

        btn_logout.setOnClickListener {
            restablecerPreferencias()
            verificarSesion()
        }
    }

    override fun onResume() {
        super.onResume()
        verificarSesion()
        Toast.makeText(this, "onResume2", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        verificarSesion()
        Toast.makeText(this, "onPause2", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        verificarSesion()
        Toast.makeText(this, "onStop2", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        verificarSesion()
        Toast.makeText(this, "onRestart2", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        verificarSesion()
        Toast.makeText(this, "onDestroy2", Toast.LENGTH_SHORT).show()
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

        if(usuarioActivo.toString().isEmpty() && passwordActiva.toString().isEmpty()){
            Toast.makeText(this, "Sin sesión", Toast.LENGTH_SHORT).show()
            var intent = Intent( this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}