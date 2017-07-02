package model.ocupante

import applicationModels.SexosPosibles
import java.util.Arrays
import org.junit.Before
import org.junit.Test
import model.orden.OrdenEmitida
import org.junit.Assert

import static org.mockito.Mockito.*

class VillanoTest {

    Villano villano
    OrdenEmitida ordenMock

    @Before
    def void setUp() {
        ordenMock = mock(OrdenEmitida)
        when(ordenMock.nombre).thenReturn("Carmen San Diego")

        villano = new Villano("Carmen San Diego", 1,SexosPosibles.Masculino,
        Arrays.asList("Pelo Rubio","Capa Roja"),
        Arrays.asList("Coleciona gemas","Estudia geologia","Anda en moto"))
    }

    @Test
    def void actuar() {
        when(ordenMock.fueEmitida).thenReturn(1)
        var expected = villano.actuar(ordenMock)
        Assert.assertEquals(expected,"ALTO!!! Detengase: Carmen San Diego")

        when(ordenMock.fueEmitida).thenReturn(0)
        expected = villano.actuar(ordenMock)
        Assert.assertEquals(expected,"El villano ha escapado")
    }

    @Test
    def void conoceVillanoTest() {
        Assert.assertTrue(villano.conoceVillano)
    }

    @Test
    def void pistasTest() {
        var seniasYhobbies = villano.pistas

        Assert.assertTrue(seniasYhobbies.senias.contains("Pelo Rubio"))
        Assert.assertTrue(seniasYhobbies.senias.contains("Capa Roja"))

        Assert.assertTrue(seniasYhobbies.hobbies.contains("Coleciona gemas"))
        Assert.assertTrue(seniasYhobbies.hobbies.contains("Estudia geologia"))
        Assert.assertTrue(seniasYhobbies.hobbies.contains("Anda en moto"))
    }
}