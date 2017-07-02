package model.caso

import java.util.List
import model.ocupante.Villano
import org.eclipse.xtend.lib.annotations.Accessors
import model.pais.Pais
import model.lugar.Lugar
import model.detective.Detective
import model.registroLugar.RegistroLugar
import model.ocupante.*
import java.util.Random
import java.util.Arrays
import java.util.ArrayList
import com.fasterxml.jackson.annotation.JsonIgnore

@Accessors
class Caso {

	var int id
    var String objeto
    var Villano responsable
    var String reporte
    var List<Pais> planDeEscape
    var Pais paisDelRobo
    var Detective detective
    var List<RegistroLugar> registrosDeLugares
    @JsonIgnore
    var Random rnd

    new(int id, Villano unResponsable, String unReporte, String unObjeto, List<Pais> unPlan, Pais unPais, Detective unDetective){
        this.id = id
        responsable = unResponsable
        reporte = unReporte
        objeto = unObjeto
        planDeEscape = unPlan
        paisDelRobo = unPais
        detective = unDetective
        registrosDeLugares = new ArrayList<RegistroLugar>()
        rnd = new Random
    }

    new(int id){
        this.id = id
        registrosDeLugares = new ArrayList<RegistroLugar>()
        rnd = new Random
    }

    def setDetective(Detective unDetective){
        detective = unDetective
        unDetective.setCaso(this)
    }

    def obtenerOcupante(Lugar unLugar){
        registrosDeLugares.findFirst[ it.lugar == unLugar].ocupante
    }

    def BuscarRegistroLugar(String nombreLugarBuscado){
        this.registrosDeLugares.findFirst[ it.nombreLugar == nombreLugarBuscado ]
    }
    
    def Pais buscarConexion(int idPais) {
    	this.detective.lugarActual.buscarConexion(idPais)
    }

    def detectiveEmiteOrdenContra(Villano unVillano){
        detective.emitirOrden(unVillano)
    }

    def detectiveVisitaLugar(Lugar unLugar){
        detective.visitar(unLugar)
    }

    /////////////////////////////////////////////////////////////////////////

    def registrarPais(Pais paisActual, Pais paisAnterior, Pais paisPosterior){
        registrarInformantesALugares(paisActual,paisPosterior)
        registrarConexiones(paisActual,paisAnterior)
    }

    private def registrarInformantesALugares(Pais paisActual, Pais paisPosterior){
        for(Lugar lugar: paisActual.lugaresDeInteres)
            registrosDeLugares.add(new RegistroLugar(lugar,crearInformante(paisPosterior,lugar)))
    }

    private def crearInformante(Pais paisPosterior,Lugar lugar){
        new Informante(lugar.pedirPistas(responsable.pistas,paisPosterior.pistas))
    }

    private def registrarConexiones(Pais paisActual, Pais paisAnterior){

        for(Pais p: paisActual.conexiones){
            if(p != paisAnterior && (!planDeEscape.contains(p) && p != paisActual))
            { registrarCuidadoresALugares(p) }
        }
    }

    private def registrarCuidadoresALugares(Pais conexionActual){
        for(Lugar lugar: conexionActual.lugaresDeInteres)
            registrosDeLugares.add(new RegistroLugar(lugar,new Cuidador()))
    }

    /////////////////////////////////////////////////////////////////////////

    def registrarUltimoPais(){
        val ultimoPais = planDeEscape.last
        registrarOcupantesALugares(ultimoPais)

        for(Pais p: ultimoPais.conexiones){
            if(!planDeEscape.contains(p) && p != ultimoPais)
            { registrarCuidadoresALugares(p) }
        }
    }

    private def registrarOcupantesALugares(Pais ultimoPais){
        var lugarVillano = ultimoPais.lugaresDeInteres.get(rnd.nextInt(ultimoPais.lugaresDeInteres.size))
        registrosDeLugares.add(new RegistroLugar(lugarVillano,responsable))

        for(Lugar lugar: ultimoPais.lugaresDeInteres) {
            if(lugar != lugarVillano) {
                var List<String> pistaInf = Arrays.asList("CUIDADO DETECTIVE!! ha estado a punto de caer en una trampa..")
                registrosDeLugares.add(new RegistroLugar(lugar, new Informante(pistaInf)))
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////
}