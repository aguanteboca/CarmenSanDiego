package model.ocupante

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import model.orden.OrdenEmitida
import java.util.Arrays

import static org.mockito.Mockito.*

class InformanteTest {

    Informante informante
    OrdenEmitida ordenMock

    @Before
    def void setUp() {
        ordenMock = mock(OrdenEmitida)
        informante = new Informante(Arrays.asList("Le gusta las joyas","Mentia mucho"))
    }

    @Test
    def void actuar() {
        Assert.assertEquals(informante.actuar(ordenMock),"Le gusta las joyas, Mentia mucho")
    }

    @Test
    def void conoceVillanoTest() {
        Assert.assertTrue(informante.conoceVillano)
    }
}