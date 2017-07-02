package model.lugares

import java.util.ArrayList
import model.lugar.Embajada
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.Arrays
import model.ocupante.SeniasYHobbies

class EmbajadaTest {

    Embajada unaEmbajada
    ArrayList<String> paisActual
    SeniasYHobbies responsable

    @Before
    def void setUp() {
        paisActual = new ArrayList(Arrays.asList("Bandera Azul y Blanca","Moneda Peso"))
        responsable = new SeniasYHobbies(
                Arrays.asList("Sobretodo amarillo","Usa guantes"),
                Arrays.asList("Juega Golf","Estudia programacion")
        )

        unaEmbajada = new Embajada("Provincia")
    }

    @Test
    def void pistasDeEmbajada() {
        var pistas = unaEmbajada.pedirPistas(responsable,paisActual)

        Assert.assertEquals(pistas.size,2)
    }
}