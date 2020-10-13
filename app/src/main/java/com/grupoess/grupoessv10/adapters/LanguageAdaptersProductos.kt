package com.grupoess.grupoessv10.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.grupoess.grupoessv10.R
import com.grupoess.grupoessv10.model.Categorias_object
import com.grupoess.grupoessv10.model.Productos_object
import com.squareup.picasso.Picasso

class LanguageAdaptersProductos(var context: Context, var arrayList: ArrayList<Productos_object>):BaseAdapter() {

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View = View.inflate(context, R.layout.card_view_item_grid, null)
        var icons: ImageView = view.findViewById(R.id.icons)
        var names: TextView = view.findViewById(R.id.name_text_view)

        var listItem: Productos_object = arrayList.get(position)

        Picasso.with(context).load(listItem.icons).into(icons);
        names.text = listItem.name

        return view
    }
}