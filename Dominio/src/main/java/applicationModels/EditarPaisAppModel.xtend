package applicationModels

import model.pais.Pais
import model.lugar.Lugar
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import java.util.List
import dummies.PaisesRepositorio

@Observable
@Accessors
class EditarPaisAppModel {
	
    Pais paisSeleccionado
    String caracteristicaSeleccionada
    String caracteristicaParaAgregar
    Pais conexionSeleccionada
    Pais conexionParaAgregar
    List<Pais> listaDeConexiones = PaisesRepositorio.getMapamundi()
    List<Pais> listaDeConexionesOriginal = PaisesRepositorio.getMapamundi()
    Lugar lugarSeleccionado
    Lugar lugarParaAgregar 
    List<Lugar> listaDeLugares = PaisesRepositorio.getLugaresDePaises()

    new(Pais pais){
        paisSeleccionado = pais
    }

	//Caracteristicas
    def eliminarCaracteristica(String caracteristica) {
        paisSeleccionado.eliminarCaracteristica(caracteristica)
    }
    def agregarCaracteristica(String caracteristica){
        paisSeleccionado.agregarCaracteristica(caracteristica)
    }

	//Conexiones
    def eliminarConexion(Pais conexion) {
        paisSeleccionado.eliminarConexion(conexion)
    }
    def agregarConexion(Pais conexion){   		
        paisSeleccionado.agregarConexion(conexion)
    }
    
    //Lugares
    def eliminarLugar(Lugar lugar) {
        paisSeleccionado.eliminarLugar(lugar)
    }
    def agregarLugar(Lugar lugar){
        paisSeleccionado.agregarLugar(lugar)
    }
	
	
}