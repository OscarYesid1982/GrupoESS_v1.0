package com.grupoess.grupoessv10.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.grupoess.grupoessv10.DataProductos
import com.grupoess.grupoessv10.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_productos.view.*

class ProductosAdapter (val productoAdapter: List<DataProductos>): RecyclerView.Adapter<ProductosHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return ProductosHolder(layoutInflater.inflate(R.layout.item_productos, parent, false))

    }

    override fun getItemCount(): Int = productoAdapter.size

    override fun onBindViewHolder(holder: ProductosHolder, position: Int) {
        holder.render(productoAdapter[position])
    }
}

class ProductosHolder (val view:View): RecyclerView.ViewHolder(view) {
    fun render(productoAdapter: DataProductos){
        view.NombreProducto.text = productoAdapter.productosNombre
        view.DescripcionProducto.text = productoAdapter.descripcionProducto
        view.PrecioVenta.text = productoAdapter.precioVenta
        Picasso.get().load(productoAdapter.image).into(view.Imageview_Producto)
        view.setOnClickListener{Toast.makeText(view.context, "Has seleccionado $productoAdapter", Toast.LENGTH_SHORT).show()}

    }
}
