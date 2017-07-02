package applicationModels;

import model.detective.Detective;
import model.excepciones.NoEstaElVillanoException;
import model.lugar.Lugar;
import model.ocupante.Villano;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class VisitarAppModel {
  private String info;
  
  private Lugar lugar;
  
  private String nombreCaso;
  
  private Detective detective;
  
  public VisitarAppModel(final String unaInfo, final Lugar unLugar, final String unNombreCaso, final Detective unDetective) {
    this.info = unaInfo;
    this.lugar = unLugar;
    this.nombreCaso = unNombreCaso;
    this.detective = unDetective;
  }
  
  public Object estaElVillano() {
    return null;
  }
  
  public String nombreDelLugar() {
    return this.lugar.getNombre();
  }
  
  public Villano villanoDelLugar() {
    return null;
  }
  
  public Villano villanoDeOrden() {
    Villano _xtrycatchfinallyexpression = null;
    try {
      Orden _ordenEmitida = this.detective.getOrdenEmitida();
      _xtrycatchfinallyexpression = _ordenEmitida.obtenerVillano();
    } catch (final Throwable _t) {
      if (_t instanceof NoEstaElVillanoException) {
        final NoEstaElVillanoException nv = (NoEstaElVillanoException)_t;
        _xtrycatchfinallyexpression = new Villano();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Pure
  public String getInfo() {
    return this.info;
  }
  
  public void setInfo(final String info) {
    this.info = info;
  }
  
  @Pure
  public Lugar getLugar() {
    return this.lugar;
  }
  
  public void setLugar(final Lugar lugar) {
    this.lugar = lugar;
  }
  
  @Pure
  public String getNombreCaso() {
    return this.nombreCaso;
  }
  
  public void setNombreCaso(final String nombreCaso) {
    this.nombreCaso = nombreCaso;
  }
  
  @Pure
  public Detective getDetective() {
    return this.detective;
  }
  
  public void setDetective(final Detective detective) {
    this.detective = detective;
  }
}
