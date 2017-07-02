package model.baseCentralAcme

import model.caso.Caso
import model.creadores.CreadorJuego
import model.ocupante.Villano
import org.eclipse.xtend.lib.annotations.Accessors
import model.pais.Pais
import java.util.List

@Accessors
class BaseCentralAcme {

    var CreadorJuego creador

    new() {
        creador = new CreadorJuego()
    }

    new(List<Villano> villanos, List<Pais> mapamundi) {
        creador = new CreadorJuego(villanos,mapamundi)
    }

    def getVillanos(){ creador.villanos }
    def getMapamundi(){ creador.mapamundi }

    def registrarVillano(Villano nuevoVillano){
        creador.agregarVillano(nuevoVillano)
    }

    def registrarPais(Pais nuevoPais){
        creador.agregarPais(nuevoPais)
    }

    def Caso crearCaso(int id, String reporte, String obj){
        return creador.crearJuego(id,reporte,obj)
    }
}