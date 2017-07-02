package dummies;

import dummies.PaisesRepositorio;
import dummies.VillanosRepositorio;
import java.util.List;
import model.baseCentralAcme.BaseCentralAcme;
import model.caso.Caso;
import model.ocupante.Villano;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Accessors
@SuppressWarnings("all")
public class BaseCentralRepositorio {
  private static BaseCentralAcme acme = new BaseCentralAcme(VillanosRepositorio.getVillanos(), PaisesRepositorio.getMapamundi());
  
  public static List<Villano> getVillanos() {
    return BaseCentralRepositorio.acme.getVillanos();
  }
  
  public static List<Pais> getMapamundi() {
    return BaseCentralRepositorio.acme.getMapamundi();
  }
  
  public static Caso crearCaso(final int id, final String reporte, final String obj) {
    return BaseCentralRepositorio.acme.crearCaso(id, reporte, obj);
  }
  
  public static Villano buscarVillano(final int idVillano) {
    List<Villano> _villanos = BaseCentralRepositorio.acme.getVillanos();
    final Function1<Villano, Boolean> _function = new Function1<Villano, Boolean>() {
      public Boolean apply(final Villano it) {
        int _id = it.getId();
        return Boolean.valueOf((_id == idVillano));
      }
    };
    return IterableExtensions.<Villano>findFirst(_villanos, _function);
  }
  
  public static List<String> sexosPosibles() {
    return null;
  }
}
