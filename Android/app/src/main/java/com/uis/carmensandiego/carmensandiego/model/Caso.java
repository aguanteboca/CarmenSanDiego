package com.uis.carmensandiego.carmensandiego.model;

import java.util.List;

public class Caso {

    private Integer id;
    private String ordenContra;
    private Pais pais;//lista de pais complejo
    private PaisSimple paisAnterior;//lista de pais simple
    private List<String> paisesVisitados;
    private List<String> paisesFallidos;


    public Caso(int id, String ordenContra, Pais pais, PaisSimple paisAnterior, List<String> paisesVisitados, List<String> paisesFallidos){
        this.id = id;
        this.ordenContra = ordenContra;
        this.pais = pais;
        this.paisAnterior = paisAnterior;
        this.paisesVisitados = paisesVisitados;
        this.paisesFallidos = paisesFallidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdenContra() {
        return ordenContra;
    }

    public void setOrdenContra(String ordenContra) {
        this.ordenContra = ordenContra;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public PaisSimple getPaisAnterior() {
        return paisAnterior;
    }

    public void setPaisAnterior(PaisSimple paisAnterior) {
        this.paisAnterior = paisAnterior;
    }

    public List<String> getPaisesVisitados() {
        return paisesVisitados;
    }

    public void setPaisesVisitados(List<String> paisesVisitados) {
        this.paisesVisitados = paisesVisitados;
    }

    public List<String> getPaisesFallidos() {
        return paisesFallidos;
    }

    public void setPaisesFallidos(List<String> paisesFallidos) {
        this.paisesFallidos = paisesFallidos;
    }


}
