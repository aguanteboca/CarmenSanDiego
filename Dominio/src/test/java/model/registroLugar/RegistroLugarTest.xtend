package model.registroLugar

import model.lugar.Lugar
import model.ocupante.Ocupante
import org.junit.Before
import static org.mockito.Mockito.*
import org.junit.Test
import org.junit.Assert

class RegistroLugarTest {

    Lugar lugarMock
    Ocupante ocupanteMock
    RegistroLugar registro

    @Before
    def void setUp(){
        lugarMock = mock(Lugar)
        ocupanteMock = mock(Ocupante)

       registro = new RegistroLugar(lugarMock,ocupanteMock)
    }

    @Test
    def nombreLugarTest(){
        when(lugarMock.nombre).thenReturn("Real_Madrid")
        Assert.assertEquals(registro.nombreLugar,"Real_Madrid")
    }
}