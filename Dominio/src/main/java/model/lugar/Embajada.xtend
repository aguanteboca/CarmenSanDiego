package model.lugar

import java.util.ArrayList
import java.util.List
import model.ocupante.SeniasYHobbies
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

@JsonTypeName("embajada")
class Embajada extends Lugar{

    @JsonCreator
    new(@JsonProperty("nombre") String unNombre){
        super(unNombre)
    }

    //Al pedir pista, borrarla de la lista, para no dar 2 veces la misma pista
    override pedirPistas(SeniasYHobbies responsable, List<String> paisActual) {
        var pistas = new ArrayList<String>()

        var String pPais1 = paisActual.get(rnd.nextInt(paisActual.size()))
        pistas.add("Pista de pais: " + pPais1)
        paisActual.remove(pPais1)

        var String pPais2 = paisActual.get(rnd.nextInt(paisActual.size()))
        pistas.add("Pista de pais: " + pPais2)
        paisActual.remove(pPais2)

        pistas
    }
}