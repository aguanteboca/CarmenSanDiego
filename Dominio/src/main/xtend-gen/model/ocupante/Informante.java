package model.ocupante;

import java.util.List;
import model.ocupante.Ocupante;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Informante extends Ocupante {
  private List<String> pistas;
  
  public Informante(final List<String> pistas) {
    this.pistas = pistas;
  }
  
  public Boolean conoceVillano() {
    return Boolean.valueOf(true);
  }
  
  public String actuar(final Orden orden) {
    return String.join(", ", this.pistas);
  }
  
  public Boolean esUnVillano() {
    return Boolean.valueOf(false);
  }
  
  @Pure
  public List<String> getPistas() {
    return this.pistas;
  }
  
  public void setPistas(final List<String> pistas) {
    this.pistas = pistas;
  }
}
