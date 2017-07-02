package dtos;

import dtos.PaisComplejoDTO;
import dtos.PaisSimpleDTO;
import java.util.List;
import model.caso.Caso;
import model.detective.Detective;
import model.orden.Orden;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class CasoDTO {
  private Integer id;
  
  private String ordenContra;
  
  private PaisComplejoDTO pais;
  
  private PaisSimpleDTO paisAnterior;
  
  private List<String> paisesVisitados;
  
  private List<String> paisesFallidos;
  
  public CasoDTO(final Caso unCaso) {
    int _id = unCaso.getId();
    this.id = Integer.valueOf(_id);
    Detective _detective = unCaso.getDetective();
    Orden _ordenEmitida = _detective.getOrdenEmitida();
    String _nombre = _ordenEmitida.getNombre();
    this.ordenContra = _nombre;
    Detective _detective_1 = unCaso.getDetective();
    Pais _lugarActual = _detective_1.getLugarActual();
    PaisComplejoDTO _paisComplejoDTO = new PaisComplejoDTO(_lugarActual);
    this.pais = _paisComplejoDTO;
    Detective _detective_2 = unCaso.getDetective();
    List<String> _recorridoCriminal = _detective_2.recorridoCriminal();
    this.paisesVisitados = _recorridoCriminal;
    Detective _detective_3 = unCaso.getDetective();
    List<String> _destinosFallidos = _detective_3.destinosFallidos();
    this.paisesFallidos = _destinosFallidos;
    this.paisAnterior = null;
  }
  
  @Pure
  public Integer getId() {
    return this.id;
  }
  
  public void setId(final Integer id) {
    this.id = id;
  }
  
  @Pure
  public String getOrdenContra() {
    return this.ordenContra;
  }
  
  public void setOrdenContra(final String ordenContra) {
    this.ordenContra = ordenContra;
  }
  
  @Pure
  public PaisComplejoDTO getPais() {
    return this.pais;
  }
  
  public void setPais(final PaisComplejoDTO pais) {
    this.pais = pais;
  }
  
  @Pure
  public PaisSimpleDTO getPaisAnterior() {
    return this.paisAnterior;
  }
  
  public void setPaisAnterior(final PaisSimpleDTO paisAnterior) {
    this.paisAnterior = paisAnterior;
  }
  
  @Pure
  public List<String> getPaisesVisitados() {
    return this.paisesVisitados;
  }
  
  public void setPaisesVisitados(final List<String> paisesVisitados) {
    this.paisesVisitados = paisesVisitados;
  }
  
  @Pure
  public List<String> getPaisesFallidos() {
    return this.paisesFallidos;
  }
  
  public void setPaisesFallidos(final List<String> paisesFallidos) {
    this.paisesFallidos = paisesFallidos;
  }
}
