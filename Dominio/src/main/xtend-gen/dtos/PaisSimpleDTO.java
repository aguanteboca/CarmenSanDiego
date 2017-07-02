package dtos;

import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class PaisSimpleDTO {
  private Integer id;
  
  private String nombre;
  
  public PaisSimpleDTO(final Pais unPais) {
    int _id = unPais.getId();
    this.id = Integer.valueOf(_id);
    String _nombre = unPais.getNombre();
    this.nombre = _nombre;
  }
  
  @Pure
  public Integer getId() {
    return this.id;
  }
  
  public void setId(final Integer id) {
    this.id = id;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
}
