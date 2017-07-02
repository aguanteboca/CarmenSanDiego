package com.uis.carmensandiego.carmensandiego.model;

public class OrdenEmitida {

    private Integer villanoId;
    private Integer casoId;

    public OrdenEmitida(Integer villanoId, Integer casoId) {
        this.villanoId = villanoId;
        this.casoId = casoId;

    }

    public Integer getVillanoId() {
        return villanoId;
    }

    public void setVillanoId(Integer villanoId) {
        this.villanoId = villanoId;
    }

    public Integer getCasoId() {
        return casoId;
    }

    public void setCasoId(Integer casoId) {
        this.casoId = casoId;
    }

}
