package model.detective

import model.lugar.Biblioteca
import model.pais.Pais
import model.ocupante.Villano
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*
import model.caso.Caso
import model.registroVillano.RegistroVillano
import java.util.HashSet

class DetectiveTest {

    Villano villanoMock
    Detective sherlockHolmes
    Pais argentina
    Pais unPaisMock
    RegistroVillano registro
    Caso caso

    @Before
    def void setUp() {
        registro = mock(RegistroVillano)
        villanoMock = mock(Villano)
        unPaisMock = mock(Pais)
        caso = mock(Caso)

        argentina = mock(Pais)
        when(argentina.nombre).thenReturn("Argentina")

        sherlockHolmes = new Detective(unPaisMock)
            sherlockHolmes.setRegistroVillano(registro)
            sherlockHolmes.setCaso(caso)
    }

    @Test
    def void detectiveEstaEnArgentina() {
        sherlockHolmes.viajar(argentina)
        Assert.assertEquals("Argentina", sherlockHolmes.lugarActual.nombre)
    }

    @Test
    def void visitarUnLugar() {
        var biblioteca = mock(Biblioteca)
        when(biblioteca.mostrarPistas(sherlockHolmes.ordenEmitida,villanoMock))
            .thenReturn("Bandera Blanca y Celeste")

        when(caso.obtenerOcupante(biblioteca)).thenReturn(villanoMock)

        when(villanoMock.conoceVillano).thenReturn(true)

        var expected = "Bandera Blanca y Celeste"
        Assert.assertEquals(sherlockHolmes.visitar(biblioteca),expected)
        verify(registro).agregarVisitado(unPaisMock)

        when(villanoMock.conoceVillano).thenReturn(false)

        sherlockHolmes.visitar(biblioteca)
        verify(registro).agregarVisitado(unPaisMock)
    }

    @Test
    def void emitirOrden() {
        sherlockHolmes.emitirOrden(villanoMock)
        Assert.assertEquals(sherlockHolmes.ordenEmitida.obtenerVillano,villanoMock)
    }

    @Test
    def void recorridoCriminalTest() {
        var visitados = new HashSet => [ add(mock(Pais)); add(mock(Pais)) ]
        when(registro.lugaresVisitados).thenReturn(visitados)

        Assert.assertEquals(sherlockHolmes.recorridoCriminal.size,2)
    }

    @Test
    def void destinosFallidosTest() {
        var noVisitados = new HashSet => [ add(mock(Pais)); add(mock(Pais)); add(mock(Pais)); ]
        when(registro.lugaresNoVisitados).thenReturn(noVisitados)

        Assert.assertEquals(sherlockHolmes.destinosFallidos.size,3)
    }
}