package com.example.pruebapractica1dsm_la181955_ma181956

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btn_login : Button
    private lateinit var btn_credenciales : Button
    private lateinit var txt_user : EditText
    private lateinit var txt_pass : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

cargarPreferencias("usuario1", "12345")
        btn_login = findViewById<Button>(R.id.btn_login)
        btn_credenciales = findViewById<Button>(R.id.btn_verCredenciales)
        txt_user = findViewById<EditText>(R.id.et_user)
        txt_pass = findViewById<EditText>(R.id.et_password)

        btn_login.setOnClickListener {
            this.Login(txt_user.text.toString().trim(), txt_pass.text.toString().trim())
        }

        btn_credenciales.setOnClickListener {
            cargarPreferencias2("usuario1", "12345")
        }
    }

    private fun cargarPreferencias(user: String, pass:String){
        val preferences: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()

        editor.putString("user",user)
        editor.putString("pass",pass)

        editor.commit()
    }
    private fun cargarPreferencias2(user: String, pass:String){
        val preferences: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()

        editor.putString("user",user)
        editor.putString("pass",pass)

        editor.commit()

        val usuarioActivo = preferences.getString("user", "no hay nada cargado")
        val passwordActiva = preferences.getString("pass", "no hay nada cargado")
        Toast.makeText(this, "Usuario: ${usuarioActivo} \ncontraseña: ${passwordActiva}", Toast.LENGTH_LONG).show()

    }

 fun Login(user:String,pass:String){
     if(user.toString().isEmpty() || pass.toString().isEmpty()){
         Toast.makeText(this, "Debe ingresar usuario y contraseña", Toast.LENGTH_SHORT).show()
     }else{
         /*Si no estan los campos vacíos*/
         val preferences: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)
         val usuarioActivo = preferences.getString("user", "no hay nada cargado")
         val passwordActiva = preferences.getString("pass", "no hay nada cargao")

         /*Abrir nueva Activity*/
         if(user.toString()==usuarioActivo && pass.toString()==passwordActiva){
             Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
             var intent = Intent( this, Opciones::class.java)
             startActivity(intent)
         }else{
             Toast.makeText(this, "Verifique usuario y contraseña", Toast.LENGTH_SHORT).show()
         }
     }
 }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume Login", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause Login", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop Login", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        txt_user = findViewById<EditText>(R.id.et_user)
        txt_pass = findViewById<EditText>(R.id.et_password)

        txt_pass.setText("")
        txt_user.setText("")
        Toast.makeText(this, "onRestart Login", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy Login", Toast.LENGTH_SHORT).show()
    }

}