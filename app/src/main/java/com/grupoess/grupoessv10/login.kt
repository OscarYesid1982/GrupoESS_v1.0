package com.grupoess.grupoessv10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        //se llama la funcion para la conxion a FireBase
        val mAuth: FirebaseAuth
        mAuth = FirebaseAuth.getInstance()

        //se comprueba si el usuario esta logueado
        val user = FirebaseAuth.getInstance().currentUser
        //si es diferente de null es porque ya esta logueado
        if (user != null) {
            Log.w("Elkin", "user.displayName: "+user.displayName)
            Log.w("Elkin", "user.email: "+user.email)
            Log.w("Elkin", "user.photoUrl: "+user.photoUrl)

            Log.w("Elkin", "user.isEmailVerified: "+user.isEmailVerified)

            Log.w("Elkin", "user.uid: "+user.uid)

            val uid = user.uid

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }


        //se llama la clase que contiene las alertas
        var v_alertas = alertas();

        //accion de cuando le dan el click sobre el boton de logueo
        id_login_boton.setOnClickListener {
            if(id_login_correo.text.toString() == "" || id_login_clave.text.toString() == ""){
                v_alertas.mensaje("Alerta", "Debe llenar el correo y la clave para continuar", "Aceptar", this)
                return@setOnClickListener;
            }
            else if(id_login_clave.text.count() < 7){
                v_alertas.mensaje("Alerta", "La clave debe tener mas de 7 caracteres", "Aceptar", this)
                return@setOnClickListener;
            }
            mAuth.signInWithEmailAndPassword(
                id_login_correo.text.toString(),
                id_login_clave.text.toString()
            )
            .addOnCompleteListener(this, OnCompleteListener<AuthResult?> { task ->
                if (task.isSuccessful) {
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                } else {
                    val e = task.exception
                    v_alertas.mensaje("Alerta", "Error: " + e.toString(), "Aceptar", this)
                }
            })

        }

        //escucha el boton de registrarse
        id_login_registrar.setOnClickListener {
            val i = Intent(this, registrarse::class.java)
            startActivity(i)
        }
    }
}