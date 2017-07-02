package model.orden;

import model.excepciones.NoEstaElVillanoException;
import model.ocupante.Villano;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;

@Accessors
@SuppressWarnings("all")
public class OrdenNula extends Orden {
  public OrdenNula() {
    this.nombre = "Nadie";
  }
  
  public Integer fueEmitida() {
    return Integer.valueOf(0);
  }
  
  public Villano obtenerVillano() {
    throw new NoEstaElVillanoException();
  }
}
