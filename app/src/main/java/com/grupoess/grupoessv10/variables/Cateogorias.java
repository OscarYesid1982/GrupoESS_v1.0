package com.grupoess.grupoessv10.variables;

import com.grupoess.grupoessv10.model.Productos_object;

import java.util.ArrayList;

public class Cateogorias {
    private static int id;
    private ArrayList<Productos_object> list;

    public void set_id_categoria(int v_id){
        id = v_id;
    }

    public int _id_categoria(){
        return id;
    }

    public ArrayList<Productos_object> traerProductos(){
        list = new ArrayList();
        list.add(new Productos_object(1, 2, "https://grupoess.com/wp-content/uploads/2019/12/paper3.png", "Tinta de sublimacióna", "La Tinta Sublimación Qualitink ha sido diseñada para el uso óptimo de impresoras de gran formato. Que con su estabilidad garantiza un proceso de impresión de alta pigmentación para largos períodos y duplicando la productividad."));
        return list;
    }


}
