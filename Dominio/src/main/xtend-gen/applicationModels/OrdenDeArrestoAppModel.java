package applicationModels;

import dummies.VillanosRepositorio;
import java.util.List;
import model.detective.Detective;
import model.ocupante.Villano;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class OrdenDeArrestoAppModel {
  private Detective detective;
  
  private String nombreCaso;
  
  private List<Villano> villanos = VillanosRepositorio.getVillanos();
  
  private Villano villanoSeleccionado;
  
  public OrdenDeArrestoAppModel(final Detective unDetective, final String unCaso) {
    this.nombreCaso = unCaso;
    this.detective = unDetective;
  }
  
  public Orden setOrden() {
    return this.detective.emitirOrden(this.villanoSeleccionado);
  }
  
  @Pure
  public Detective getDetective() {
    return this.detective;
  }
  
  public void setDetective(final Detective detective) {
    this.detective = detective;
  }
  
  @Pure
  public String getNombreCaso() {
    return this.nombreCaso;
  }
  
  public void setNombreCaso(final String nombreCaso) {
    this.nombreCaso = nombreCaso;
  }
  
  @Pure
  public List<Villano> getVillanos() {
    return this.villanos;
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this.villanos = villanos;
  }
  
  @Pure
  public Villano getVillanoSeleccionado() {
    return this.villanoSeleccionado;
  }
  
  public void setVillanoSeleccionado(final Villano villanoSeleccionado) {
    this.villanoSeleccionado = villanoSeleccionado;
  }
}
