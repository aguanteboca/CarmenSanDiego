package applicationModels

import model.detective.Detective
import model.pais.Pais
import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
@Observable
class ViajarAppModel {

    var Detective detective
    var Pais paisSeleccionado
    var String nombreCaso

    new(Detective unDetective, String unCaso){
        detective = unDetective
        nombreCaso = unCaso
    }

    def viajar(){
        detective.viajar(paisSeleccionado)
    }
}