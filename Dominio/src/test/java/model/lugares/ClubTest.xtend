package model.lugares

import java.util.ArrayList
import java.util.Random
import model.lugar.Club
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*
import model.ocupante.SeniasYHobbies
import java.util.Arrays

class ClubTest {

    Random rnd
    Club unClub
    ArrayList<String> paisActual
    SeniasYHobbies responsable

    @Before
    def void setUp() {
        paisActual = new ArrayList(Arrays.asList("Bandera Azul y Blanca","Moneda Peso"))
        responsable = new SeniasYHobbies(
                new ArrayList(Arrays.asList("Sobretodo amarillo","Usa guantes")),
                new ArrayList(Arrays.asList("Juega Golf","Estudia programacion"))
        )

        unClub = new Club("River Plate")
        rnd = mock(Random)
        unClub.setRnd(rnd)
    }

    @Test
    def void pistasDeBibliotecaSincHobbie() {
        when(rnd.nextInt(100)).thenReturn(75)
        var pistas = unClub.pedirPistas(responsable,paisActual)

        Assert.assertEquals(pistas.size,2)
    }

    @Test
    def void pistasDeBibliotecaConcHobbie() {
        when(rnd.nextInt(100)).thenReturn(25)
        var pistas = unClub.pedirPistas(responsable,paisActual)

        Assert.assertEquals(pistas.size,3)
    }
}


