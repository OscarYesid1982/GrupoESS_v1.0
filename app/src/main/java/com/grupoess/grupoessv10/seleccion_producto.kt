package com.grupoess.grupoessv10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.seleccion_producto.*

class seleccion_producto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccion_producto)

        seleccion_producto_id_titulo.setText("Titulo");
        seleccion_producto_id_imagen.setImageResource(R.drawable.calandra)
        seleccion_producto_id_descripcion.text = "Descripción";
        seleccion_producto_id_precio.text = "$50000";

        seleccion_producto_id_compra.setOnClickListener {


        }
    }

}