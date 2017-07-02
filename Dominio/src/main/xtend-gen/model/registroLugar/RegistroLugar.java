package model.registroLugar;

import model.lugar.Lugar;
import model.ocupante.Ocupante;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RegistroLugar {
  private Lugar lugar;
  
  private Ocupante ocupante;
  
  public RegistroLugar(final Lugar unLugar, final Ocupante unOcupante) {
    this.lugar = unLugar;
    this.ocupante = unOcupante;
  }
  
  public String nombreLugar() {
    return this.lugar.getNombre();
  }
  
  @Pure
  public Lugar getLugar() {
    return this.lugar;
  }
  
  public void setLugar(final Lugar lugar) {
    this.lugar = lugar;
  }
  
  @Pure
  public Ocupante getOcupante() {
    return this.ocupante;
  }
  
  public void setOcupante(final Ocupante ocupante) {
    this.ocupante = ocupante;
  }
}
