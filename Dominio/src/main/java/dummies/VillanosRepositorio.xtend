package dummies

import applicationModels.SexosPosibles
import java.util.ArrayList
import java.util.Arrays
import java.util.List
import model.ocupante.Villano

class VillanosRepositorio {

    var static List<String> seniasParticulares
    var static List<String> hobbies

    var static villanos = new ArrayList() => [

        var carmenSanDiego = new Villano("Carmen SanDiego", 1,SexosPosibles.Femenino,
        seniasParticulares = new ArrayList<String>(Arrays.asList("Pelirroja","Sobretodo rojo","Guantes amarillos","Admiracion por las joyas","Conocimiento en vinos")),
        hobbies = new ArrayList<String>(Arrays.asList("Le gusta andar en moto","Tiene una coleccion de joyas")))
        add(carmenSanDiego)

        var ihorIhorovich = new Villano("Ihor Ihorovich", 2, SexosPosibles.Masculino,
        seniasParticulares = new ArrayList<String>(Arrays.asList("Pelo rubio","Maneja una limusina","Tatuaje en su brazo derecho", "Habla ucraniano","Admiracion por las joyas")),
        hobbies = new ArrayList<String>(Arrays.asList("Le jugar al croquet","Le gusta cocinar")))
        add(ihorIhorovich)

        var alCapone = new Villano("Al Capone", 3, SexosPosibles.Masculino,
        seniasParticulares = new ArrayList<String>(Arrays.asList("Pelo rubio","Usa un traje", "Habla italiano","Usa guantes","Maneja una limosina")),
        hobbies = new ArrayList<String>(Arrays.asList("Se ocupa en la mafia con los muchachos","Antecedentes en robo de bancos")))
        add(alCapone)
    ]

    def static List<Villano> getVillanos() {
        return villanos
    }
}