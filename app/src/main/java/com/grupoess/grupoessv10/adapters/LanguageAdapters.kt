package com.grupoess.grupoessv10.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.grupoess.grupoessv10.R
import com.grupoess.grupoessv10.model.LanguageItem

class LanguageAdapters(var context: Context, var arrayList: ArrayList<LanguageItem>):BaseAdapter() {

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

        var listItem: LanguageItem = arrayList.get(position)

        icons.setImageResource(listItem.icons!!)
        names.text = listItem.name

        return view
    }

}