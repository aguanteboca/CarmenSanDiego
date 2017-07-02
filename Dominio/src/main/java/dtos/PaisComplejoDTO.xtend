package dtos

import java.util.List
import model.pais.Pais
import java.util.stream.Collectors
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PaisComplejoDTO {

    var Integer id
    var String nombre
    var List<String> lugares
    var List<PaisSimpleDTO> conexiones

    new(Pais unPais){
        id = unPais.id
        nombre = unPais.nombre
        lugares = unPais.lugaresDeInteres.stream.map(l | l.nombre).collect(Collectors.toList)
        conexiones = unPais.conexiones.stream.map(p | new PaisSimpleDTO(p)).collect(Collectors.toList)
    }
}