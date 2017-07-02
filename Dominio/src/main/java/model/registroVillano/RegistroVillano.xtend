package model.registroVillano

import java.util.HashSet
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import model.pais.Pais

@Accessors
class RegistroVillano {

    var Set<Pais> lugaresVisitados
    var Set<Pais> lugaresNoVisitados

    new(){
        lugaresVisitados = new HashSet<Pais>()
        lugaresNoVisitados = new HashSet<Pais>()
    }

    def agregarVisitado(Pais pais){
        lugaresVisitados.add(pais)
    }

    def agregarNoVisitado(Pais pais){
        lugaresNoVisitados.add(pais)
    }
}