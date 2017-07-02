package dtos

import model.pais.Pais
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PaisSimpleDTO {

    var Integer id
    var String nombre

    new(Pais unPais){
        id = unPais.id
        nombre = unPais.nombre
    }
}