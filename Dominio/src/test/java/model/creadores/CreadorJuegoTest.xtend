package model.creadores

import model.ocupante.Villano
import org.junit.Before
import model.pais.Pais

import static org.mockito.Mockito.*
import org.junit.Test
import org.junit.Assert
import java.util.Random
import java.util.ArrayList
import model.caso.Caso

class CreadorJuegoTest {

    CreadorJuego creador
    Pais bolibia
    Pais argentina
    Pais brasil
    Villano cesar
    Villano lucho
    Random rnd

    @Before
    def void setUp() {
        rnd = mock(Random)

        cesar = mock(Villano)
        lucho = mock(Villano)

        bolibia = mock(Pais)
        argentina = mock(Pais)
        brasil = mock(Pais)

        creador = new CreadorJuego() => [
            agregarVillano(cesar)
            agregarVillano(lucho)

            agregarPais(argentina)
            agregarPais(bolibia)
            agregarPais(brasil)
            setRnd(rnd)
        ]
    }

    @Test
    def void randomVillanoTest() {
        var villano = creador.randomVillano
        Assert.assertTrue(villano.equals(cesar) || villano.equals(lucho))
    }

    @Test
    def void getLugarDelHechoTest() {
        var paises = creador.mapamundi
        when(rnd.nextInt(paises.size)).thenReturn(2)

        Assert.assertEquals(creador.getLugarDelHecho(paises),brasil)
    }

    @Test
    def void crearRutaEscapeTest() {
        var mapamundi = new ArrayList =>[ add(argentina); add(bolibia) ]

        when(brasil.findConexion(mapamundi)).thenReturn(argentina)
        when(argentina.containsAny(mapamundi)).thenReturn(true)
        when(argentina.findConexion(mapamundi)).thenReturn(bolibia)

        var rutaDeEscape = creador.crearRutaEscape(mapamundi,brasil)

        Assert.assertEquals(rutaDeEscape.get(0),argentina)
        Assert.assertEquals(rutaDeEscape.get(1),bolibia)
        Assert.assertEquals(rutaDeEscape.size,2)
    }

    @Test
    def void repartirPistasYocupantesTest() {
        var planDeEscape = new ArrayList =>[ add(argentina); add(bolibia) ]
        var caso = mock(Caso)
        when(caso.paisDelRobo).thenReturn(brasil)
        when(caso.planDeEscape).thenReturn(planDeEscape)

        creador.repartirPistasYocupantes(caso)
        verify(caso).registrarUltimoPais
        verify(caso).registrarPais(brasil,null,argentina)
        verify(caso).registrarPais(argentina,brasil,bolibia)
    }
}