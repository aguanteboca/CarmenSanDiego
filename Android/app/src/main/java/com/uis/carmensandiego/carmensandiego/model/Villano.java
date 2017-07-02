package com.uis.carmensandiego.carmensandiego.model;

public class Villano {

    private String nombre;

    private int id;

	public Villano(String unNombre, int unId){
        this.nombre = unNombre;
        this.id = unId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
