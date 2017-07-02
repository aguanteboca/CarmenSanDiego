package dtos

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class OrdenEmitidaDTO {

    var Integer villanoId
    var Integer casoId

    new(Integer villanoId, Integer casoId){
        this.villanoId = villanoId
        this.casoId = casoId
    }
    
    new(){}
}