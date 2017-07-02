package model.lugares

import model.lugar.Club
import model.lugar.Lugar
import model.ocupante.*
import model.orden.Orden
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*

class LugarTest {
    Lugar riverPlate
    Orden orden

    @Before
    def void setUp() {
        orden = mock(Orden)

        riverPlate = new Club("River Plate")
    }

    @Test
    def void mostrarPistasInformante() {
        var informante = mock(Informante)
        when(informante.actuar(orden)).thenReturn("Tiene pelo Rojo, Juega bien al Futbol")


        var pistasEsperadas = "Tiene pelo Rojo, Juega bien al Futbol"

        Assert.assertEquals(riverPlate.mostrarPistas(orden,informante),pistasEsperadas)
    }

    @Test
    def void mostrarPistasCuidador() {
        var cuidador = new Cuidador()
        var pistasEsperadas = "Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas"

        Assert.assertEquals(riverPlate.mostrarPistas(orden,cuidador),pistasEsperadas)
    }

    @Test
    def void mostrarPistasVillanoQueEscapo() {
        var pistasEsperadas = "El villano ha escapado"
        var villano = mock(Villano)
        when(villano.actuar(orden)).thenReturn("El villano ha escapado")

        Assert.assertEquals(riverPlate.mostrarPistas(orden,villano),pistasEsperadas)
    }

    @Test
    def void mostrarPistasVillanoCorrecto() {
        var pistasEsperadas = "ALTO!!! Detengase: Carmen San Diego"
        var villano = mock(Villano)
        when(villano.actuar(orden)).thenReturn("ALTO!!! Detengase: Carmen San Diego")

        Assert.assertEquals(riverPlate.mostrarPistas(orden,villano),pistasEsperadas)
    }

    @Test
    def void mostrarPistasVillanoEquivocado() {
        var pistasEsperadas = "El villano ha escapado"
        var villano = mock(Villano)
        when(villano.actuar(orden)).thenReturn("El villano ha escapado")

        Assert.assertEquals(riverPlate.mostrarPistas(orden,villano),pistasEsperadas)
    }
}