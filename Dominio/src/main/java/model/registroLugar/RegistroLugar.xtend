package model.registroLugar

import model.lugar.Lugar
import model.ocupante.Ocupante
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class RegistroLugar {

    var Lugar lugar
    var Ocupante ocupante

    new(Lugar unLugar, Ocupante unOcupante){
        lugar = unLugar
        ocupante = unOcupante
    }

    def nombreLugar(){
        lugar.nombre
    }
}