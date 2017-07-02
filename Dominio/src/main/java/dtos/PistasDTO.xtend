package dtos

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PistasDTO {

    var String pista

    new(String pistas){
        pista = pistas
    }
}