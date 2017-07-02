package model.lugares

import java.util.ArrayList
import java.util.Random
import model.lugar.Biblioteca
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*
import model.ocupante.SeniasYHobbies
import java.util.Arrays

class BibliotecaTest {

    Random rnd
    Biblioteca unaBiblioteca
    ArrayList<String> paisActual
    SeniasYHobbies responsable

    @Before
    def void setUp() {
        paisActual = new ArrayList(Arrays.asList("Bandera Azul y Blanca","Moneda Peso"))
        responsable = new SeniasYHobbies(
                new ArrayList(Arrays.asList("Sobretodo amarillo","Usa guantes")),
                new ArrayList(Arrays.asList("Juega Golf","Estudia programacion"))
        )

        unaBiblioteca = new Biblioteca("Nacional")
        rnd = mock(Random)
        unaBiblioteca.setRnd(rnd)
    }

    @Test
    def void pistasDeBibliotecaSinHobbie() {
        when(rnd.nextInt(100)).thenReturn(75)
        var pistas = unaBiblioteca.pedirPistas(responsable,paisActual)

        Assert.assertEquals(pistas.size,2)
    }

    @Test
    def void pistasDeBibliotecaConHobbie() {
        when(rnd.nextInt(100)).thenReturn(25)
        var pistas = unaBiblioteca.pedirPistas(responsable,paisActual)

        Assert.assertEquals(pistas.size,3)
    }
}


