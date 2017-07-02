package dtos

import org.eclipse.xtend.lib.annotations.Accessors
import model.ocupante.Villano

@Accessors
class VillanoDTO {
	var String nombre
	var int id
	
	new(Villano unVillano){
		this.nombre = unVillano.nombre
		this.id = unVillano.id
	}
}