package model.ocupante

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import model.orden.Orden

@Accessors
class Informante extends Ocupante{

    var List<String> pistas

    new(List<String> pistas){
        this.pistas = pistas
    }

    override conoceVillano() {
        true
    }

    override actuar(Orden orden) {
        return String.join(", ", pistas)
    }

    override esUnVillano() {
        false
    }
}