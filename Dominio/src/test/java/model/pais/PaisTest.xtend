package model.pais

import java.util.Arrays
import model.lugar.Banco
import model.lugar.Biblioteca
import model.lugar.Club
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*
import org.junit.Assert
import java.util.List
import java.util.ArrayList

class PaisTest {

    Pais argentina
    Pais brasil; Pais uruguay; Pais paraguay                                //Conexiones
    Banco bancoGalicia; Biblioteca bibliotecaNacional; Club riverPlate      //lugaresDeInteres

    @Before
    def void setUp() {
        brasil = mock(Pais) ; uruguay = mock(Pais) ; paraguay = mock(Pais)
        bancoGalicia = mock(Banco) ; bibliotecaNacional = mock(Biblioteca) ; riverPlate = mock(Club)

        argentina = new Pais(1,"Nombre",
        Arrays.asList("Moneda Peso","Bandera Celeste y Blanca","Hablan español"),
        Arrays.asList(brasil,uruguay,paraguay),
        Arrays.asList(bancoGalicia,bibliotecaNacional,riverPlate))
    }

    @Test
    def void containsAnyTest() {
        var List<Pais> mapamundi = new ArrayList<Pais>()
        Assert.assertFalse(argentina.containsAny(mapamundi))

        mapamundi.add(brasil)
        Assert.assertTrue(argentina.containsAny(mapamundi))
    }

    @Test
    def void findConexionTest() {
        when(brasil.cantDeConexiones).thenReturn(1)
        when(uruguay.cantDeConexiones).thenReturn(2)

        var List<Pais> mapamundi = new ArrayList<Pais>()
        Assert.assertEquals(argentina.findConexion(mapamundi),null)

        mapamundi.add(brasil)
        mapamundi.add(uruguay)
        Assert.assertEquals(argentina.findConexion(mapamundi),uruguay)
    }

    @Test
    def void pistasTest() {
        Assert.assertEquals(argentina.pistas().size,3)
    }

    @Test
    def void buscarConexionTest() {
        when(brasil.getId).thenReturn(1)
        when(uruguay.getId).thenReturn(2)
        when(paraguay.getId).thenReturn(3)

        Assert.assertEquals(argentina.buscarConexion(2),uruguay)
    }

    @Test
    def void buscarLugarTest() {
        when(bancoGalicia.nombre).thenReturn("Banco Galicia")
        when(bibliotecaNacional.nombre).thenReturn("Biblioteca Nacional")
        when(riverPlate.nombre).thenReturn("River Plate")

        Assert.assertEquals(argentina.buscarLugar("River Plate"),riverPlate)
    }
}