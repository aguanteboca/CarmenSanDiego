package applicationModels

import dummies.PaisesRepositorio
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import model.pais.Pais
import org.apache.commons.lang.StringUtils
import org.uqbar.commons.model.UserException

@Accessors
@Observable
class MapamundiAppModel {

    var Pais paisSeleccionado
    var List<Pais> paises = PaisesRepositorio.getMapamundi

    new(List<Pais> unosPaises){
        paises = unosPaises
    }

    def quitarPaisSeleccionado(){
        return quitarPais(paisSeleccionado)

    }

    def quitarPais(Pais unPais){
        paises.remove(unPais)
    }

    def nuevoPais(){
        val Pais nuevo = new Pais()
        agregarPais(nuevo)
        return nuevo
    }

    def agregarPais(Pais unPais){
        paises.add(unPais)
    }

//////////////

    def getPais(int id) {
        paises.findFirst[ it.id == id ]
    }


    def setPais(Pais pais) {
        if (!pais.estaCompleto()) {
            throw new UserException("El pais debe estar completo");
        }
        eliminarPais(pais.id) // Elimina un eventual duplicado con mismo id
        paises.add(pais)
    }


    def searchPais(String substring) {
        if (StringUtils.isBlank(substring)) {
            this.paises
        } else {
            this.paises.filter[ it.nombre.toLowerCase.contains(substring.toLowerCase) ].toList
        }
    }

    def updatePais(Pais unPais) {
        paises.removeIf[ it.id == unPais.id]
        paises.add(unPais)
    }

    def eliminarPais(int unid){
        paises.removeIf[ it.id == unid ]
    }

}