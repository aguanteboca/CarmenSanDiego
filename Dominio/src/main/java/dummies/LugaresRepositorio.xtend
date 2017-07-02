package dummies

import java.util.ArrayList
import model.lugar.*
import java.util.List

class LugaresRepositorio {

    val static lugares = new ArrayList() => [
        var bbva                = new Banco("BBVA_Frances")
        var palmeiras           = new Club("Palmeiras")
        var biblioteca          = new Biblioteca("Biblioteca_Nacional")

        var aaaj                = new Club("Argentinos_Juniors")
        var provincia           = new Banco("Banco_Provincia")
        var bibliotecaArg       = new Biblioteca("Biblioteca_La_Posada")

        var embajadaMexico      = new Embajada("Embajada_Mexico")
        var bibliotecaItalia    = new Biblioteca("Biblioteca_La_Tana")
        var juventus            = new Club("Juventus_FC")

        var bibliotecaEgipto    = new Biblioteca("Biblioteca_de_Alejandria")
        var embajadaEeuu        = new Embajada("Embajada_EEUU")
        var abuDabi             = new Club("Abu_Dabi_FC")

        var bbva2               = new Banco("BBVA_Frances_2")
        var embajadaRusia       = new Embajada("Embajada_Rusia")
        var sanfrece            = new Club("Sanfrece_Hiroshima_FC")

        var bibliotecaRusia     = new Biblioteca("Biblioteca_Rusia")
        var embajadaArg         = new Embajada("Embajada_Argentina")
        var bancoRusia          = new Banco("Banco_Rusia")

        var bbva3               = new Banco("BBVA_Frances_3")
        var bibliotecaEsp       = new Biblioteca("Biblioteca_de_Gallegos")
        var barcelona           = new Club("Barcelona_FC")

        var banco               = new Banco("Banco_Nacional")
        var embajadaBrasil      = new Embajada("Embajada_Brasil")
        var bibliotecaCuba      = new Biblioteca("Biblioteca_Jose_Marti")

        var poodle              = new Biblioteca("Biblioteca_Le_Poodles")
        var embajadaAustralia   = new Embajada("Embajada_Australia")
        var bbv4                = new Banco("BBVA_Frances_4")

        var bibliotecaUruguay   = new Biblioteca("Biblioteca_Lucho_Suarez")
        var embajadaJapon       = new Embajada("Embajada_Japon")
        var rio                 = new Banco("Rio")

        add(bbva); add(palmeiras); add(biblioteca)
        add(aaaj); add(provincia); add(bibliotecaArg)
        add(embajadaMexico); add(bibliotecaItalia); add(juventus)
        add(bibliotecaEgipto); add(embajadaEeuu); add(abuDabi)
        add(bbva2); add(embajadaRusia); add(sanfrece)
        add(bibliotecaRusia); add(embajadaArg); add(bancoRusia)
        add(bbva3); add(bibliotecaEsp); add(barcelona)
        add(banco); add(embajadaBrasil); add(bibliotecaCuba)
        add(poodle); add(embajadaAustralia); add(bbv4)
        add(bibliotecaUruguay); add(embajadaJapon); add(rio)
    ]

    def static List<Lugar> getLugares() {
        return lugares
    }

    def static Lugar getLugar(int pos) {
        return lugares.get(pos)
    }
}