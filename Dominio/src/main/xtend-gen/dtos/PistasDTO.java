package dtos;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class PistasDTO {
  private String pista;
  
  public PistasDTO(final String pistas) {
    this.pista = pistas;
  }
  
  @Pure
  public String getPista() {
    return this.pista;
  }
  
  public void setPista(final String pista) {
    this.pista = pista;
  }
}
