package dtos;

import model.ocupante.Villano;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class VillanoDTO {
  private String nombre;
  
  private int id;
  
  public VillanoDTO(final Villano unVillano) {
    String _nombre = unVillano.getNombre();
    this.nombre = _nombre;
    int _id = unVillano.getId();
    this.id = _id;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
}
