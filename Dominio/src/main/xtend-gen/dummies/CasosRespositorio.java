package dummies;

import dummies.BaseCentralRepositorio;
import java.util.ArrayList;
import model.caso.Caso;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Accessors
@SuppressWarnings("all")
public class CasosRespositorio {
  private final static String SaltoDeLinea = System.getProperty("line.separator");
  
  private final static String INTRO_A_DESCRIPCION = (("Detective, tenemos un caso para usted!" + CasosRespositorio.SaltoDeLinea) + CasosRespositorio.SaltoDeLinea);
  
  private final static String FINAL_DE_DESCRIPCION = (("El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna," + CasosRespositorio.SaltoDeLinea) + " su mision como detective es desifrar el responsable de tal crimen y apresarlo.");
  
  private static ArrayList<Caso> casos = ObjectExtensions.<ArrayList<Caso>>operator_doubleArrow(new ArrayList<Caso>(), new Procedure1<ArrayList<Caso>>() {
    public void apply(final ArrayList<Caso> it) {
      Caso _crearCaso = BaseCentralRepositorio.crearCaso(1, 
        ((((((((CasosRespositorio.INTRO_A_DESCRIPCION + "A las 9 de la mañana en la ciudad del Cairo la comunidad científica fue conmovida") + CasosRespositorio.SaltoDeLinea) + " al darse cuenta del faltante de gran valor! El sarcófago del faraón") + CasosRespositorio.SaltoDeLinea) + " USERMAATRA-MERIAMON RAMSES-HEQAIUNU, el mejor conocido como Ramsés III. ") + CasosRespositorio.SaltoDeLinea) + CasosRespositorio.FINAL_DE_DESCRIPCION) + CasosRespositorio.SaltoDeLinea), 
        "la Tumba del Faraón");
      it.add(_crearCaso);
    }
  });
  
  public static int cantidadDeCasos() {
    return CasosRespositorio.casos.size();
  }
  
  public static ArrayList<Caso> getCasos() {
    return CasosRespositorio.casos;
  }
  
  public static Caso buscarCaso(final int id) {
    final Function1<Caso, Boolean> _function = new Function1<Caso, Boolean>() {
      public Boolean apply(final Caso it) {
        int _id = it.getId();
        return Boolean.valueOf((_id == id));
      }
    };
    return IterableExtensions.<Caso>findFirst(CasosRespositorio.casos, _function);
  }
}
