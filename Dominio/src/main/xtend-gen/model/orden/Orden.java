package model.orden;

import model.ocupante.Villano;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public abstract class Orden {
  protected String nombre;
  
  public Orden() {
  }
  
  public abstract Integer fueEmitida();
  
  public abstract Villano obtenerVillano();
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
}
