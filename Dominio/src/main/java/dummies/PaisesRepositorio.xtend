package dummies

import java.util.ArrayList
import java.util.Arrays
import java.util.List
import model.lugar.*
import model.pais.Pais

import static dummies.LugaresRepositorio.*
import org.uqbar.commons.model.UserException

class PaisesRepositorio {

    static List<String> caracteristicas
    static List<Pais> conexiones
    static List<Lugar> lugares

    var static mapamundi = new ArrayList() => [
        var brasil = new Pais(1,"Brasil",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan portuges", "Bandera verde amarilla y azul","Pentacampeones del mundo","Quinto pais mas grande del mundo","Tiene mas de 200m de habitantes")),
        conexiones = new ArrayList<Pais>(Arrays.asList()),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(0),getLugar(1),getLugar(2))))

        var argentina = new Pais(2,"Argentina",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan español", "Bandera celeste y blanca","Habitantes toman mate","Tierra del tango","Tierra de los mejores jugadores de la historia")),
        conexiones = new ArrayList<Pais>(Arrays.asList(brasil)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(3),getLugar(4),getLugar(5))))

        var italia = new Pais(3,"Italia",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan italiano", "Bandera blanca roja y verde","Toman vino","Miembro de la Union Europea","Con una ciudad santa para la Iglesia católica")),
        conexiones = new ArrayList<Pais>(Arrays.asList(argentina, brasil)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(6),getLugar(7),getLugar(8))))

        var egipto = new Pais(4,"Egipto",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan arabe", "Bandera roja blanca y negra","Habitantes construllen piramides","La mayor parte de su superficie la integra el desierto del Sahara","Fue cuna de la antigua civilización egipcia")),
        conexiones = new ArrayList<Pais>(Arrays.asList(brasil,italia,argentina)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(9),getLugar(10),getLugar(11))))

        var japon = new Pais(5,"Japon",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan japones", "Bandera roja y blanca","Habitantes comen arroz","Conocido como la Tierra del Sol Naciente","Es un archipiélago de 6852 islas")),
        conexiones = new ArrayList<Pais>(Arrays.asList(egipto, argentina,italia)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(12),getLugar(13),getLugar(14))))

        var rusia = new Pais(6,"Rusia",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan ruso", "Bandera roja blanca y azul","Habitantes sufren bajas temperaturas","Pais mas grande del mundo","Es el pais que limita con mayor número de países")),
        conexiones = new ArrayList<Pais>(Arrays.asList(egipto, japon, italia, argentina)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(15),getLugar(16),getLugar(17))))

        var españa = new Pais(7,"España",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan español", "Bandera amarrillo y rojo","Tienen a los mejores jugadores del mundo","Miembro de la Union Europea","Es un país transcontinental")),
        conexiones = new ArrayList<Pais>(Arrays.asList(egipto, japon, italia, argentina)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(18),getLugar(19),getLugar(20))))

        var cuba = new Pais(8,"Cuba",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan español", "Bandera roja blanca y azul","El pais es un Archipielago","La Habana es su capital y ciudad más poblada","Está ubicado en el extremo noroeste de las Antillas")),
        conexiones = new ArrayList<Pais>(Arrays.asList(rusia,egipto, japon, italia)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(21),getLugar(22),getLugar(23))))

        var francia = new Pais(9,"Francia",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan frances", "Bandera roja blanca y azul","La torre eiffel es simbolo de su nacion","Miembro de la Unión Europea","Se ubica en Europa Occidental")),
        conexiones = new ArrayList<Pais>(Arrays.asList(cuba,rusia, egipto)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(24),getLugar(25),getLugar(26))))

        var uruguay = new Pais(10,"Uruguay",
        caracteristicas = new ArrayList<String>(Arrays.asList("Habitantes hablan español", "Bandera celeste","En 1950 sus futbolistas dieron un Maracanazo","Conocida como como Banda Oriental","Tiene un clima templado")),
        conexiones = new ArrayList<Pais>(Arrays.asList(argentina,francia,españa)),
        lugares = new ArrayList<Lugar>(Arrays.asList(getLugar(27),getLugar(28),getLugar(29))))

        add(brasil)
        add(argentina)
        add(italia)
        add(egipto)
        add(japon)
        add(rusia)
        add(españa)
        add(cuba)
        add(francia)
        add(uruguay)

    ]

    def static List<Pais> getMapamundi() {
        return mapamundi
    }

    def static List<Lugar> getLugaresDePaises() {
        return getLugares
    }
    
    def static agregarPais(Pais paisNuevo) {
        if (!paisNuevo.estaCompleto()) {
            throw new UserException("El pais debe estar completo");
        }
        mapamundi.add(paisNuevo)
    }
    
}