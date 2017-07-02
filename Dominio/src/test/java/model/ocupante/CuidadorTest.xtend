package model.ocupante

import org.junit.Before
import org.junit.Test
import model.orden.OrdenEmitida
import org.junit.Assert

import static org.mockito.Mockito.*

class CuidadorTest {

    Cuidador cuidador
    OrdenEmitida ordenMock

    @Before
    def void setUp() {
        ordenMock = mock(OrdenEmitida)
        cuidador = new Cuidador()
    }

    @Test
    def void actuar() {
        Assert.assertEquals(cuidador.actuar(ordenMock),
        "Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas")
    }

    @Test
    def void conoceVillanoTest() {
        Assert.assertFalse(cuidador.conoceVillano)
    }
}