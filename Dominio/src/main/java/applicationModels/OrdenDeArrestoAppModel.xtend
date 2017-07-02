package applicationModels

import model.detective.Detective
import java.util.List
import model.ocupante.Villano
import dummies.VillanosRepositorio
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class OrdenDeArrestoAppModel {

    var Detective detective
    var String nombreCaso
    var List<Villano> villanos = VillanosRepositorio.getVillanos()
    var Villano villanoSeleccionado

    new(Detective unDetective, String unCaso){
        nombreCaso = unCaso
        detective = unDetective
    }

    def setOrden(){
        detective.emitirOrden(villanoSeleccionado)
    }
}