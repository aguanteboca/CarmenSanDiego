package model.detective

import java.util.stream.Collectors
import model.lugar.Lugar
import model.orden.Orden
import model.orden.OrdenNula
import org.eclipse.xtend.lib.annotations.Accessors
import model.pais.Pais
import model.registroVillano.RegistroVillano
import org.uqbar.commons.utils.Observable
import model.orden.OrdenEmitida
import model.ocupante.Villano
import model.caso.Caso

@Observable
@Accessors
class Detective{

    Orden ordenEmitida
    Pais lugarActual
    RegistroVillano registroVillano
    Caso caso

    new(Pais lugarDeLosHechos){
        lugarActual = lugarDeLosHechos
        ordenEmitida = new OrdenNula()
        registroVillano = new RegistroVillano()
    }

    def viajar(Pais unPais){
        lugarActual = unPais
    }

    def setCaso(Caso unCaso){
        this.caso = unCaso
    }

    def String visitar(Lugar unLugar){
        var ocupante = caso.obtenerOcupante(unLugar)

        var msj = unLugar.mostrarPistas(ordenEmitida,ocupante)
        if(ocupante.conoceVillano)
            registroVillano.agregarVisitado(lugarActual)
        else
            registroVillano.agregarNoVisitado(lugarActual)

        msj
    }

    def emitirOrden(Villano villano) {
        ordenEmitida = new OrdenEmitida(villano)
    }

    def recorridoCriminal(){
        registroVillano.lugaresVisitados.stream.map(p | p.nombre).collect(Collectors.toList())
    }

    def destinosFallidos(){
        registroVillano.lugaresNoVisitados.stream.map(p | p.nombre).collect(Collectors.toList())
    }
}