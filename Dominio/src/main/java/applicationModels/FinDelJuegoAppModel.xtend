package applicationModels

import model.ocupante.Villano
import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors

@Observable
@Accessors
class FinDelJuegoAppModel {

    var Villano ocupanteDelLugar
    var Villano villanoDeLaOrdenEmitida
    var String nombreDeCaso

    new(Villano unOcupante, Villano villanoDeOrden, String unCaso){
        ocupanteDelLugar = unOcupante
        villanoDeLaOrdenEmitida = villanoDeOrden
        nombreDeCaso = unCaso
    }

    def esElVIllano(){
        ocupanteDelLugar.equals(villanoDeLaOrdenEmitida)
    }
}