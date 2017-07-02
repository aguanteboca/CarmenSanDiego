package dtos

import model.caso.Caso
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class CasoDTO {

    var Integer id
    var String ordenContra
    var PaisComplejoDTO pais
    var PaisSimpleDTO paisAnterior
    var List<String> paisesVisitados
    var List<String> paisesFallidos

    new(Caso unCaso){
        id = unCaso.id
        ordenContra = unCaso.detective.ordenEmitida.nombre
        pais = new PaisComplejoDTO(unCaso.detective.lugarActual)
        paisesVisitados = unCaso.detective.recorridoCriminal
        paisesFallidos = unCaso.detective.destinosFallidos
        paisAnterior = null
    }
}