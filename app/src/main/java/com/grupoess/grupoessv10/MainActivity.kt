package com.grupoess.grupoessv10

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.grupoess.grupoessv10.adapters.LanguageAdaptersCategorias
import com.grupoess.grupoessv10.model.Categorias_object
import com.grupoess.grupoessv10.variables.Cateogorias

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var arrayList:ArrayList<Categorias_object> ? = null
    private var gridView:GridView ? = null
    private var languageAdapters:LanguageAdaptersCategorias ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        gridView = findViewById(R.id.grid_view_contet_main)
        arrayList = ArrayList()
        arrayList = setDataList()
        languageAdapters = LanguageAdaptersCategorias(applicationContext, arrayList!!)
        gridView?.adapter = languageAdapters
        gridView?.onItemClickListener = this
    }

    private fun setDataList() : ArrayList<Categorias_object>{

        var arrayList:ArrayList<Categorias_object> = ArrayList()

        arrayList.add(Categorias_object(R.drawable.calandra, "Calandras",1))
        arrayList.add(Categorias_object(R.drawable.equipos, "Equipos",2))
        arrayList.add(Categorias_object(R.drawable.insumos, "Insumos",3))
        arrayList.add(Categorias_object(R.drawable.papel_sublima, "Papel Sublimación",4))
        arrayList.add(Categorias_object(R.drawable.repuestos, "Repuestos",5))
        arrayList.add(Categorias_object(R.drawable.servicios_tecnicos, "Servicios Tecnicos",6))
        arrayList.add(Categorias_object(R.drawable.tintas_titan, "Tintas Titanium",7))
        arrayList.add(Categorias_object(R.drawable.vinilo, "Vinilos",8))

        return arrayList
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items: Categorias_object = arrayList!!.get(position)
        var cat = Cateogorias();
        cat.set_id_categoria(items.id!!)

        val intent = Intent(this, productos::class.java)
        startActivityForResult(intent, 0)
    }


}