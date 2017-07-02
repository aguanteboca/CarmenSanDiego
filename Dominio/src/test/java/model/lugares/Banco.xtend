package model.lugares

import java.util.ArrayList
import model.lugar.Banco
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.util.Arrays
import model.ocupante.SeniasYHobbies

class BancoTest {

    Banco unBanco
    ArrayList<String> paisActual
    SeniasYHobbies responsable

    @Before
    def void setUp() {
        paisActual = new ArrayList(Arrays.asList("Bandera Azul y Blanca","Moneda Peso"))
        responsable = new SeniasYHobbies(
                new ArrayList(Arrays.asList("Sobretodo amarillo","Usa guantes")),
                new ArrayList(Arrays.asList("Juega Golf","Estudia programacion"))
        )

        unBanco = new Banco("Provincia")
    }

    @Test
    def void pistasDeBanco() {
        var pistas = unBanco.pedirPistas(responsable,paisActual)
        Assert.assertEquals(pistas.size,2)
    }
}