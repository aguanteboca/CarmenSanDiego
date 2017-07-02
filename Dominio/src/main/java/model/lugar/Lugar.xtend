package model.lugar

import java.util.List
import java.util.Random
import model.ocupante.Ocupante
import model.orden.Orden
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import com.fasterxml.jackson.annotation.JsonIgnore
import model.ocupante.SeniasYHobbies
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonSubTypes

@Observable
@Accessors
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
@JsonSubTypes.Type(value=Banco, name="banco"),
@JsonSubTypes.Type(value=Club, name="club"),
@JsonSubTypes.Type(value=Embajada, name="embajada"),
@JsonSubTypes.Type(value=Biblioteca, name="biblioteca")
)
abstract class Lugar{

    protected var String nombre
    @JsonIgnore
    protected var Random rnd

    new(String unNombre){
        nombre = unNombre
        rnd = new Random()
    }

    def String mostrarPistas(Orden orden, Ocupante ocupante){
        return ocupante.actuar(orden)
    }

    def List<String> pedirPistas(SeniasYHobbies responsable, List<String> paisActual)
}