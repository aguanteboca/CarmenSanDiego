package model.orden

import model.excepciones.NoEstaElVillanoException
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class OrdenNula extends Orden{

    new(){
        nombre = "Nadie"
    }

    override fueEmitida() {
        0
    }

    override obtenerVillano() {
        throw new NoEstaElVillanoException()
    }
}