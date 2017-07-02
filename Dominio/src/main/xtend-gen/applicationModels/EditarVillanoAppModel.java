package applicationModels;

import model.ocupante.Villano;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class EditarVillanoAppModel {
  private Villano villanoSeleccionado;
  
  private String seniaSeleccionada;
  
  private String seniaParaAgregar;
  
  private String hobbieSeleccionado;
  
  private String hobbieParaAgregar;
  
  public EditarVillanoAppModel(final Villano villano) {
    this.villanoSeleccionado = villano;
  }
  
  public boolean agregarSenia(final String senia) {
    return this.villanoSeleccionado.agregarSenia(senia);
  }
  
  public boolean eliminarSenia(final String senia) {
    return this.villanoSeleccionado.eliminarSenia(senia);
  }
  
  public boolean agregarHobbie(final String hobbie) {
    return this.villanoSeleccionado.agregarHobbie(hobbie);
  }
  
  public boolean eliminarHobbie(final String hobbie) {
    return this.villanoSeleccionado.eliminarHobbie(hobbie);
  }
  
  @Pure
  public Villano getVillanoSeleccionado() {
    return this.villanoSeleccionado;
  }
  
  public void setVillanoSeleccionado(final Villano villanoSeleccionado) {
    this.villanoSeleccionado = villanoSeleccionado;
  }
  
  @Pure
  public String getSeniaSeleccionada() {
    return this.seniaSeleccionada;
  }
  
  public void setSeniaSeleccionada(final String seniaSeleccionada) {
    this.seniaSeleccionada = seniaSeleccionada;
  }
  
  @Pure
  public String getSeniaParaAgregar() {
    return this.seniaParaAgregar;
  }
  
  public void setSeniaParaAgregar(final String seniaParaAgregar) {
    this.seniaParaAgregar = seniaParaAgregar;
  }
  
  @Pure
  public String getHobbieSeleccionado() {
    return this.hobbieSeleccionado;
  }
  
  public void setHobbieSeleccionado(final String hobbieSeleccionado) {
    this.hobbieSeleccionado = hobbieSeleccionado;
  }
  
  @Pure
  public String getHobbieParaAgregar() {
    return this.hobbieParaAgregar;
  }
  
  public void setHobbieParaAgregar(final String hobbieParaAgregar) {
    this.hobbieParaAgregar = hobbieParaAgregar;
  }
}
