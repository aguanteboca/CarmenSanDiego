package model.caso

import model.ocupante.Villano
import org.junit.Before
import model.pais.Pais

import static org.mockito.Mockito.*
import model.detective.Detective
import java.util.List
import java.util.ArrayList
import org.junit.Test
import org.junit.Assert
import model.lugar.Lugar
import java.util.Random
import model.ocupante.SeniasYHobbies

class CasoTest {

    Pais argentina
    Pais brasil
    Pais francia
    Pais conFrancia

    Lugar lugarArg
    Lugar lugarBrs
    Lugar lugarFrc1
    Lugar lugarFrc2
    Lugar lugarConFrc

    List<Lugar> lugaresArgentina
    List<Lugar> lugaresBrasil
    List<Lugar> lugaresFrancia
    List<Lugar> lugaresConexFrancia

    List<Pais> conexArgentina
    List<Pais> conexBrasil
    List<Pais> conexFrancia
    List<Pais> planDeEscape

    Detective detective
    Villano nico
    Caso caso
    Random rnd

    @Before
    def void setUp() {
        rnd = mock(Random)
        nico = mock(Villano)
        detective = mock(Detective)

        lugarArg = mock(Lugar)
        lugarBrs = mock(Lugar)
        lugarFrc1 = mock(Lugar)
        lugarFrc2 = mock(Lugar)
        lugarConFrc = mock(Lugar)

        argentina = mock(Pais)
        brasil = mock(Pais)
        francia = mock(Pais)
        conFrancia = mock(Pais)

        lugaresArgentina = new ArrayList => [ add(lugarArg) ]
        lugaresBrasil = new ArrayList => [ add(lugarBrs) ]
        lugaresFrancia = new ArrayList => [ add(lugarFrc1); add(lugarFrc2) ]
        lugaresConexFrancia = new ArrayList => [ add(lugarConFrc) ]

        conexArgentina = new ArrayList => [ add(brasil) ]
        conexBrasil = new ArrayList => [ add(francia) ]
        conexFrancia = new ArrayList => [ add(conFrancia) ]

        when(argentina.lugaresDeInteres).thenReturn(lugaresArgentina)
        when(argentina.conexiones).thenReturn(conexArgentina)
        when(brasil.lugaresDeInteres).thenReturn(lugaresArgentina)
        when(brasil.conexiones).thenReturn(conexBrasil)
        when(francia.lugaresDeInteres).thenReturn(lugaresFrancia)
        when(francia.conexiones).thenReturn(conexFrancia)
        when(conFrancia.lugaresDeInteres).thenReturn(lugaresConexFrancia)
        when(conFrancia.conexiones).thenReturn(new ArrayList)

        planDeEscape = new ArrayList => [ add(brasil); add(francia) ]

        caso = new Caso(1,nico,"Los turros se robaron algo","Cadena de la Yeni",planDeEscape,argentina,detective)
            caso.setRnd(rnd)
    }

    @Test
    def void registrarUltimoPaisTest() {
        when(rnd.nextInt(francia.lugaresDeInteres.size)).thenReturn(0)
        when(detective.visitar(lugarFrc2)).thenReturn("CUIDADO DETECTIVE!! ha estado a punto de caer en una trampa..")
        when(detective.visitar(lugarConFrc)).thenReturn("Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas")

        caso.registrarUltimoPais

        Assert.assertEquals(caso.registrosDeLugares.get(0).ocupante,nico)
        Assert.assertEquals(caso.detectiveVisitaLugar(lugarFrc2),"CUIDADO DETECTIVE!! ha estado a punto de caer en una trampa..")
        Assert.assertEquals(caso.detectiveVisitaLugar(lugarConFrc),"Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas")
    }

    @Test
    def void registrarPaisTest() {
        var pistasNico = mock(SeniasYHobbies)
        var pistasFrancia = mock(List)
        var expected = new ArrayList => [ add("Pelo Rojo"); add("Tenia un buen Sobretodo amarillo") ]

        when(lugarBrs.pedirPistas(pistasNico,pistasFrancia)).thenReturn(expected)
        when(detective.visitar(lugarBrs)).thenReturn("Pelo Rojo, Tenia un buen Sobretodo amarillo")

        caso.registrarPais(brasil,argentina,francia)
        Assert.assertEquals(caso.detectiveVisitaLugar(lugarBrs),"Pelo Rojo, Tenia un buen Sobretodo amarillo")
    }
}