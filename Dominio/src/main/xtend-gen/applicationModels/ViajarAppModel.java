package applicationModels;

import model.detective.Detective;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class ViajarAppModel {
  private Detective detective;
  
  private Pais paisSeleccionado;
  
  private String nombreCaso;
  
  public ViajarAppModel(final Detective unDetective, final String unCaso) {
    this.detective = unDetective;
    this.nombreCaso = unCaso;
  }
  
  public Pais viajar() {
    return this.detective.viajar(this.paisSeleccionado);
  }
  
  @Pure
  public Detective getDetective() {
    return this.detective;
  }
  
  public void setDetective(final Detective detective) {
    this.detective = detective;
  }
  
  @Pure
  public Pais getPaisSeleccionado() {
    return this.paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this.paisSeleccionado = paisSeleccionado;
  }
  
  @Pure
  public String getNombreCaso() {
    return this.nombreCaso;
  }
  
  public void setNombreCaso(final String nombreCaso) {
    this.nombreCaso = nombreCaso;
  }
}
