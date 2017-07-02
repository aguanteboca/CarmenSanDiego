package applicationModels

import model.detective.Detective
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class ResolverMisterioAppModel {

    Detective detective
    String nombreCaso

    new(Detective unDetective, String unCaso){
        nombreCaso = unCaso
        detective = unDetective
    }

    def nombreOrdenEmitida(){
        detective.ordenEmitida.nombre
    }
}