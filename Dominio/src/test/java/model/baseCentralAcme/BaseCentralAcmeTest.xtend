package model.baseCentralAcme

import model.ocupante.Villano
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import model.pais.Pais

import static org.mockito.Mockito.*
import model.creadores.CreadorJuego

class BaseCentralAcmeTest {

    Villano unVillanoMock
    Pais unPaisMock
    BaseCentralAcme acme

    @Before
    def void setUp() {
        unVillanoMock = mock(Villano)
        unPaisMock = mock(Pais)
        acme = new BaseCentralAcme
    }

    @Test
    def void registrarVillanoTest() {
        acme.registrarVillano(unVillanoMock)

        Assert.assertTrue(acme.villanos.contains(unVillanoMock))
    }

    @Test
    def void registrarPaisTest() {
        acme.registrarPais(unPaisMock)

        Assert.assertTrue(acme.mapamundi.contains(unPaisMock))
    }

    @Test
    def void crearCasoTest() {
        var creador = mock(CreadorJuego)
        acme.setCreador(creador)

        acme.crearCaso(1,"Los turros se robaron algo","Cadena de la Yeni")
        verify(creador).crearJuego(1,"Los turros se robaron algo","Cadena de la Yeni")
    }
}