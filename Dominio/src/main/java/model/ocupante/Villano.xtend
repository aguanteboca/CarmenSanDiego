package model.ocupante

import applicationModels.SexosPosibles
import java.util.ArrayList
import java.util.Arrays
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import model.orden.Orden

@Observable
@Accessors
class Villano extends Ocupante{

    var String nombre
    var int id
    var SexosPosibles sexo
    var List<String> seniasParticulares
    var List<String> hobbies

    new(String unNombre, int unId, SexosPosibles genero, List<String> unasSenias, List<String> unosHobbies){
        nombre = unNombre
        id = unId
        sexo = genero
        seniasParticulares = unasSenias
        hobbies = unosHobbies
    }

    new() {
        seniasParticulares = new ArrayList<String>()
        hobbies = new ArrayList<String>()
    }

    override conoceVillano() {
        true
    }

    override esUnVillano() {
        true
    }

    override actuar(Orden orden){
        switch(orden.fueEmitida()){
            case 1: return "ALTO!!! Detengase: " + orden.nombre
            case 0: return "El villano ha escapado"
        }
    }

    def SeniasYHobbies pistas(){
        var List<String> cloneSenias = new ArrayList<String>
        var List<String> cloneHobbies = new ArrayList<String>

        for(c: seniasParticulares)
            cloneSenias.add(String.copyValueOf(c.toCharArray))

        for(c: hobbies)
            cloneHobbies.add(String.copyValueOf(c.toCharArray))

        new SeniasYHobbies(cloneSenias,cloneHobbies)
    }

    def sexos() {
        var SexosPosibles[] sexosP = SexosPosibles.values;
        return Arrays.asList(sexosP);
    }

    def agregarSenia(String senia) {
        seniasParticulares.add(senia)
    }

    def eliminarSenia(String senia) {
        seniasParticulares.remove(senia)
    }

    def eliminarHobbie(String hobbie) {
        hobbies.remove(hobbie)
    }

    def agregarHobbie (String hobbie){
        hobbies.add(hobbie)
    }
}