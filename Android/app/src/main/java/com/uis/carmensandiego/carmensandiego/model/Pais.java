package com.uis.carmensandiego.carmensandiego.model;

import java.util.List;

public class Pais {

    private Integer id;
    private String nombre;
    private List<String> lugares;
    private List<Pais> conexiones;//lista de pais simple

    public Pais(int id, String nombre, List<String> lugares, List<Pais> conexiones){
        this.id = id;
        this.nombre = nombre;
        this.lugares = lugares;
        this.conexiones=conexiones;

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

    public List<String> getLugares() {
        return lugares;
    }

    public void setLugares(List<String> lugares) {
        this.lugares = lugares;
    }

    public List<Pais> getConexiones() {
        return conexiones;
    }

    public void setConexiones(List<Pais> conexiones) {
        this.conexiones = conexiones;
    }

}
