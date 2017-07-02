package model.ocupante;

import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;

@Accessors
@SuppressWarnings("all")
public abstract class Ocupante {
  public abstract String actuar(final Orden orden);
  
  public abstract Boolean conoceVillano();
  
  public abstract Boolean esUnVillano();
}
