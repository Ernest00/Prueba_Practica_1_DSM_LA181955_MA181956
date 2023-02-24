package com.example.pruebapractica1dsm_la181955_ma181956

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btn_login : Button
    private lateinit var txt_user : EditText
    private lateinit var txt_pass : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_login = findViewById<Button>(R.id.btn_login)
        txt_user = findViewById<EditText>(R.id.et_user)
        txt_pass = findViewById<EditText>(R.id.et_password)

        btn_login.setOnClickListener {
            this.Login(txt_user.text.toString().trim(), txt_pass.text.toString().trim())
        }
    }


 fun Login(user:String,pass:String){
     if(user.toString().isEmpty() || pass.toString().isEmpty()){
         Toast.makeText(this, "Debe ingresar usuario y contraseña", Toast.LENGTH_SHORT).show()
     }else{
         var intent = Intent( this, Prueba::class.java)
         startActivity(intent)
     }
 }
}