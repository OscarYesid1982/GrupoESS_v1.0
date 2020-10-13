package com.grupoess.grupoessv10

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
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