package com.uis.carmensandiego.carmensandiego.model;

import java.util.List;

public class PaisSimple {

    private Integer id;
    private String nombre;

    public PaisSimple(int id, String nombre){
        this.id = id;
        this.nombre = nombre;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
