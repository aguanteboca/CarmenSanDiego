package dummies

import model.baseCentralAcme.BaseCentralAcme
import model.caso.Caso
import java.util.List
import model.ocupante.Villano
import model.pais.Pais
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class BaseCentralRepositorio {

    var static acme = new BaseCentralAcme(VillanosRepositorio.getVillanos,PaisesRepositorio.getMapamundi)

    def static List<Villano> getVillanos() {
        return acme.getVillanos
    }

    def static List<Pais> getMapamundi() {
        return acme.getMapamundi
    }

    def static Caso crearCaso(int id, String reporte, String obj){
        acme.crearCaso(id, reporte,obj)
    }

    def static buscarVillano(int idVillano){
        acme.getVillanos.findFirst[ it.id == idVillano]
    }

    def static List<String> sexosPosibles(){
        // return
    }
}