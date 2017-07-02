package applicationModels;

import model.detective.Detective;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class ResolverMisterioAppModel {
  private Detective detective;
  
  private String nombreCaso;
  
  public ResolverMisterioAppModel(final Detective unDetective, final String unCaso) {
    this.nombreCaso = unCaso;
    this.detective = unDetective;
  }
  
  public String nombreOrdenEmitida() {
    Orden _ordenEmitida = this.detective.getOrdenEmitida();
    return _ordenEmitida.getNombre();
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
}
