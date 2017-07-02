package applicationModels

import java.util.Arrays
import java.util.List
import model.ocupante.Villano
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import dummies.VillanosRepositorio
import org.uqbar.commons.model.UserException

@Accessors
@Observable
class ExpedientesAppModel {

    var List<Villano> villanos = VillanosRepositorio.getVillanos()
    var Villano villanoSeleccionado
    var List<String> sexosPosibles = Arrays.asList("sexosPosibles")

    def nuevoVillano(){
        val Villano nuevo = new Villano()
        agregarVillano(nuevo)
        return nuevo
    }
    
    def getVillanos() {
    	villanos
    }

    def agregarVillano(Villano villano) {
    	if(!villanos.stream().anyMatch(v | v.id == villano.id)) {
    		villanos.add(villano)
    	}
    	else {
    		throw new UserException("El villano ya existe");
    	}
    }
    
    def updateVillano(Villano villano) {
    	villanos.removeIf[ it.id == villano.id]
    	villanos.add(villano)
    }
    
    def deleteVillano(int id) {
    	villanos.removeIf[ it.id == id]
    }

    def buscarVillano(int id){
        villanos.findFirst[ it.id == Integer.valueOf(id) ]
    }
}