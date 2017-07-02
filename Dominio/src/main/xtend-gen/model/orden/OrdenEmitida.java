package model.orden;

import model.ocupante.Villano;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class OrdenEmitida extends Orden {
  private Villano villano;
  
  public OrdenEmitida(final Villano unVillano) {
    String _nombre = unVillano.getNombre();
    this.nombre = _nombre;
    this.villano = unVillano;
  }
  
  public Integer fueEmitida() {
    return Integer.valueOf(1);
  }
  
  public Villano obtenerVillano() {
    return this.villano;
  }
  
  @Pure
  public Villano getVillano() {
    return this.villano;
  }
  
  public void setVillano(final Villano villano) {
    this.villano = villano;
  }
}
