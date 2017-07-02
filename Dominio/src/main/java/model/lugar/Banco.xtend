package model.lugar

import java.util.ArrayList
import model.ocupante.SeniasYHobbies
import java.util.List
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

@JsonTypeName("banco")
class Banco extends Lugar{

    @JsonCreator
    new(@JsonProperty("nombre") String unNombre){
        super(unNombre)
    }

    //Al pedir pista, borrarla de la lista, para no dar 2 veces la misma pista
    override pedirPistas(SeniasYHobbies responsable, List<String> paisActual) {
        var pistas = new ArrayList<String>()

        var String senia = responsable.senias.get(rnd.nextInt(responsable.senias.size()))
        var String pPais = paisActual.get(rnd.nextInt(paisActual.size()))

        pistas.add("Pista de villano: " + senia)
        pistas.add("Pista de pais: " + pPais)

        responsable.senias.remove(senia)
        paisActual.remove(pPais)

        pistas
    }
}