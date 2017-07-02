package dtos;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ViajarDTO {
  private Integer destinoId;
  
  private Integer casoId;
  
  public ViajarDTO() {
  }
  
  @Pure
  public Integer getDestinoId() {
    return this.destinoId;
  }
  
  public void setDestinoId(final Integer destinoId) {
    this.destinoId = destinoId;
  }
  
  @Pure
  public Integer getCasoId() {
    return this.casoId;
  }
  
  public void setCasoId(final Integer casoId) {
    this.casoId = casoId;
  }
}
