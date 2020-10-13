package com.grupoess.grupoessv10.model

class Productos_object {
    var icons: Int ? = 0
    var name: String ? = null
    var descripcion: String ? = null
    var id: Int ? = 0
    var id_categoria: Int ? = 0

    constructor(id: Int?, id_categoria: Int?, icons: Int?, name: String?, descripcion: String?) {
        this.id = id
        this.icons = icons
        this.name = name
        this.descripcion = descripcion
        this.id_categoria = id_categoria
    }
}