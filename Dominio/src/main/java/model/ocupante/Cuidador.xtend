package model.ocupante

import org.eclipse.xtend.lib.annotations.Accessors
import model.orden.Orden

@Accessors
class Cuidador extends Ocupante{

    var String pista

    new(){
        pista = "Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas"
    }

    override conoceVillano() {
        false
    }

    override actuar(Orden orden) {
        return pista
    }

    override esUnVillano() {
        false
    }
}