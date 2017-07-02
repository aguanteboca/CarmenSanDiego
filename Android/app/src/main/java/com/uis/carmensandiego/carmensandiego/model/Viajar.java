package com.uis.carmensandiego.carmensandiego.model;

public class Viajar {

    private Integer destinoId;
    private Integer casoId;

    public Viajar(Integer destinoId, Integer casoId){
        this.destinoId = destinoId;
        this.casoId = casoId;

    }
    public Integer getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Integer destinoId) {
        this.destinoId = destinoId;
    }

    public Integer getCasoId() {
        return casoId;
    }

    public void setCasoId(Integer casoId) {
        this.casoId = casoId;
    }
}
