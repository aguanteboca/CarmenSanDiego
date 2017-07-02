package dummies

import model.caso.Caso
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class CasosRespositorio {

    val static SaltoDeLinea = System.getProperty("line.separator")
    val static String INTRO_A_DESCRIPCION = "Detective, tenemos un caso para usted!" + SaltoDeLinea + SaltoDeLinea
    val static String FINAL_DE_DESCRIPCION = "El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna," + SaltoDeLinea + " su mision como detective es desifrar el responsable de tal crimen y apresarlo."

    var static casos = new ArrayList<Caso>() => [
        add(BaseCentralRepositorio.crearCaso(1,
                    INTRO_A_DESCRIPCION + "A las 9 de la mañana en la ciudad del Cairo la comunidad científica fue conmovida" + SaltoDeLinea + " al darse cuenta del faltante de gran valor! El sarcófago del faraón" + SaltoDeLinea + " USERMAATRA-MERIAMON RAMSES-HEQAIUNU, el mejor conocido como Ramsés III. " + SaltoDeLinea + FINAL_DE_DESCRIPCION + SaltoDeLinea,
                    "la Tumba del Faraón")
        )
    ]

    def static cantidadDeCasos(){ return casos.size }

    def static getCasos(){ casos }
    
    def static buscarCaso(int id) {
    	casos.findFirst[ it.id == id]
    }
}