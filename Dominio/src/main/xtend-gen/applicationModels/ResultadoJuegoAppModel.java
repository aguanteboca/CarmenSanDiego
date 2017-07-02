package applicationModels;

import com.google.common.base.Objects;
import model.caso.Caso;
import model.detective.Detective;
import model.lugar.Lugar;
import model.ocupante.Ocupante;
import model.ocupante.Villano;
import model.orden.Orden;
import model.registroLugar.RegistroLugar;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class ResultadoJuegoAppModel {
  private String pista;
  
  private String resultadoOrden;
  
  public ResultadoJuegoAppModel(final Caso caso, final RegistroLugar registro) {
    Lugar _lugar = registro.getLugar();
    String _detectiveVisitaLugar = caso.detectiveVisitaLugar(_lugar);
    this.pista = _detectiveVisitaLugar;
    Lugar _lugar_1 = registro.getLugar();
    Ocupante _obtenerOcupante = caso.obtenerOcupante(_lugar_1);
    String _objeto = caso.getObjeto();
    Detective _detective = caso.getDetective();
    Orden _ordenEmitida = _detective.getOrdenEmitida();
    this.esOrdenExitosaOFallida(_obtenerOcupante, _objeto, _ordenEmitida);
  }
  
  public String esOrdenExitosaOFallida(final Ocupante ocupante, final String objeto, final Orden unaOrden) {
    String _xifexpression = null;
    if ((((unaOrden.fueEmitida()).intValue() == 1) && (ocupante.esUnVillano()).booleanValue())) {
      String _xifexpression_1 = null;
      Villano _obtenerVillano = unaOrden.obtenerVillano();
      boolean _equals = Objects.equal(ocupante, _obtenerVillano);
      if (_equals) {
        Villano _obtenerVillano_1 = unaOrden.obtenerVillano();
        String _nombre = _obtenerVillano_1.getNombre();
        String _plus = ("En Hora Buena!!! Ha detenido a " + _nombre);
        String _plus_1 = (_plus + " y recuperado ");
        String _plus_2 = (_plus_1 + objeto);
        String _plus_3 = (_plus_2 + ". Felicitaciones!!!");
        _xifexpression_1 = this.resultadoOrden = _plus_3;
      } else {
        String _nombre_1 = ((Villano) ocupante).getNombre();
        String _plus_4 = ("Malas Noticias. Deberia tener Orden de Arresto Contra " + _nombre_1);
        String _plus_5 = (_plus_4 + ". Lamentablemente el crimen quedara impune.");
        _xifexpression_1 = this.resultadoOrden = _plus_5;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Pure
  public String getPista() {
    return this.pista;
  }
  
  public void setPista(final String pista) {
    this.pista = pista;
  }
  
  @Pure
  public String getResultadoOrden() {
    return this.resultadoOrden;
  }
  
  public void setResultadoOrden(final String resultadoOrden) {
    this.resultadoOrden = resultadoOrden;
  }
}
