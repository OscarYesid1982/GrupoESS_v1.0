package com.grupoess.grupoessv10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.grupoess.grupoessv10.adapters.LanguageAdaptersProductos
import com.grupoess.grupoessv10.model.Productos_object


class productos : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var arrayList:ArrayList<Productos_object> ? = null
    private var gridView:GridView ? = null
    private var languageAdapters:LanguageAdaptersProductos ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        gridView = findViewById(R.id.grid_view_contet_main)
        arrayList = ArrayList()
        arrayList = setDataList()
        languageAdapters = LanguageAdaptersProductos(applicationContext, arrayList!!)
        gridView?.adapter = languageAdapters
        gridView?.onItemClickListener = this
    }

    private fun setDataList() : ArrayList<Productos_object>{

        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        //val myRef = database.getReference("productos")

        var myRef = database.getReference("categorias/1/Imagen")
        myRef.setValue("https://www.ambientum.com/wp-content/uploads/2019/02/ropa-696x468.jpg")


        // Read from the database

        /*
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)!!
                Log.d("Alerta", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Alerta", "Failed to read value.", error.toException())
            }
        })*/

        var arrayList:ArrayList<Productos_object> = ArrayList()

        arrayList.add(Productos_object(1, 1, R.drawable.calandra, "xxxxx",""))
        arrayList.add(Productos_object(2, 2, R.drawable.equipos, "Equipos",""))
        arrayList.add(Productos_object(3, 1, R.drawable.insumos, "Insumos",""))

        return arrayList
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //var items: Productos_object = arrayList!!.get(position)
        //var cat = Cateogorias();
        //cat.set_id_categoria(items.id!!)

        val intent = Intent(this, seleccion_producto::class.java)
        startActivityForResult(intent, 0)
    }
}