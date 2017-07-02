package applicationModels;

import model.ocupante.Villano;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class FinDelJuegoAppModel {
  private Villano ocupanteDelLugar;
  
  private Villano villanoDeLaOrdenEmitida;
  
  private String nombreDeCaso;
  
  public FinDelJuegoAppModel(final Villano unOcupante, final Villano villanoDeOrden, final String unCaso) {
    this.ocupanteDelLugar = unOcupante;
    this.villanoDeLaOrdenEmitida = villanoDeOrden;
    this.nombreDeCaso = unCaso;
  }
  
  public boolean esElVIllano() {
    return this.ocupanteDelLugar.equals(this.villanoDeLaOrdenEmitida);
  }
  
  @Pure
  public Villano getOcupanteDelLugar() {
    return this.ocupanteDelLugar;
  }
  
  public void setOcupanteDelLugar(final Villano ocupanteDelLugar) {
    this.ocupanteDelLugar = ocupanteDelLugar;
  }
  
  @Pure
  public Villano getVillanoDeLaOrdenEmitida() {
    return this.villanoDeLaOrdenEmitida;
  }
  
  public void setVillanoDeLaOrdenEmitida(final Villano villanoDeLaOrdenEmitida) {
    this.villanoDeLaOrdenEmitida = villanoDeLaOrdenEmitida;
  }
  
  @Pure
  public String getNombreDeCaso() {
    return this.nombreDeCaso;
  }
  
  public void setNombreDeCaso(final String nombreDeCaso) {
    this.nombreDeCaso = nombreDeCaso;
  }
}
