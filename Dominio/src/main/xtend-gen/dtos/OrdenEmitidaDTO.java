package dtos;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class OrdenEmitidaDTO {
  private Integer villanoId;
  
  private Integer casoId;
  
  public OrdenEmitidaDTO(final Integer villanoId, final Integer casoId) {
    this.villanoId = villanoId;
    this.casoId = casoId;
  }
  
  public OrdenEmitidaDTO() {
  }
  
  @Pure
  public Integer getVillanoId() {
    return this.villanoId;
  }
  
  public void setVillanoId(final Integer villanoId) {
    this.villanoId = villanoId;
  }
  
  @Pure
  public Integer getCasoId() {
    return this.casoId;
  }
  
  public void setCasoId(final Integer casoId) {
    this.casoId = casoId;
  }
}
