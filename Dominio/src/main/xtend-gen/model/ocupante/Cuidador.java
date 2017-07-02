package model.ocupante;

import model.ocupante.Ocupante;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Cuidador extends Ocupante {
  private String pista;
  
  public Cuidador() {
    this.pista = "Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas";
  }
  
  public Boolean conoceVillano() {
    return Boolean.valueOf(false);
  }
  
  public String actuar(final Orden orden) {
    return this.pista;
  }
  
  public Boolean esUnVillano() {
    return Boolean.valueOf(false);
  }
  
  @Pure
  public String getPista() {
    return this.pista;
  }
  
  public void setPista(final String pista) {
    this.pista = pista;
  }
}
