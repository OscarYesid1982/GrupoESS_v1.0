package com.grupoess.grupoessv10

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.grupoess.grupoessv10.adapters.LanguageAdapters
import com.grupoess.grupoessv10.model.LanguageItem

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var arrayList:ArrayList<LanguageItem> ? = null
    private var gridView:GridView ? = null
    private var languageAdapters:LanguageAdapters ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

            gridView = findViewById(R.id.grid_view_cater)
            arrayList = ArrayList()
            arrayList = setDataList()
            languageAdapters = LanguageAdapters(applicationContext, arrayList!!)
            gridView?.adapter = languageAdapters
            gridView?.onItemClickListener = this




        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setDataList() : ArrayList<LanguageItem>{

        var arrayList:ArrayList<LanguageItem> = ArrayList()

        arrayList.add(LanguageItem(R.drawable.calandra, "Calandras"))
        arrayList.add(LanguageItem(R.drawable.equipos, "Equipos"))
        arrayList.add(LanguageItem(R.drawable.insumos, "Insumos"))
        arrayList.add(LanguageItem(R.drawable.papel_sublima, "Papel Sublimación"))
        arrayList.add(LanguageItem(R.drawable.repuestos, "Repuestos"))
        arrayList.add(LanguageItem(R.drawable.servicios_tecnicos, "Servicios Tecnicos"))
        arrayList.add(LanguageItem(R.drawable.tintas_titan, "Tintas Titanium"))
        arrayList.add(LanguageItem(R.drawable.vinilo, "Vinilos"))


        return arrayList

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_filtrar -> true
            R.id.action_buscar -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var items: LanguageItem = arrayList!!.get(position)
        Toast.makeText(applicationContext, items.name, Toast.LENGTH_LONG).show()
    }
}