package applicationModels;

import dummies.PaisesRepositorio;
import java.util.List;
import model.lugar.Lugar;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class EditarPaisAppModel {
  private Pais paisSeleccionado;
  
  private String caracteristicaSeleccionada;
  
  private String caracteristicaParaAgregar;
  
  private Pais conexionSeleccionada;
  
  private Pais conexionParaAgregar;
  
  private List<Pais> listaDeConexiones = PaisesRepositorio.getMapamundi();
  
  private List<Pais> listaDeConexionesOriginal = PaisesRepositorio.getMapamundi();
  
  private Lugar lugarSeleccionado;
  
  private Lugar lugarParaAgregar;
  
  private List<Lugar> listaDeLugares = PaisesRepositorio.getLugaresDePaises();
  
  public EditarPaisAppModel(final Pais pais) {
    this.paisSeleccionado = pais;
  }
  
  public boolean eliminarCaracteristica(final String caracteristica) {
    return this.paisSeleccionado.eliminarCaracteristica(caracteristica);
  }
  
  public boolean agregarCaracteristica(final String caracteristica) {
    return this.paisSeleccionado.agregarCaracteristica(caracteristica);
  }
  
  public boolean eliminarConexion(final Pais conexion) {
    return this.paisSeleccionado.eliminarConexion(conexion);
  }
  
  public boolean agregarConexion(final Pais conexion) {
    return this.paisSeleccionado.agregarConexion(conexion);
  }
  
  public boolean eliminarLugar(final Lugar lugar) {
    return this.paisSeleccionado.eliminarLugar(lugar);
  }
  
  public boolean agregarLugar(final Lugar lugar) {
    return this.paisSeleccionado.agregarLugar(lugar);
  }
  
  @Pure
  public Pais getPaisSeleccionado() {
    return this.paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this.paisSeleccionado = paisSeleccionado;
  }
  
  @Pure
  public String getCaracteristicaSeleccionada() {
    return this.caracteristicaSeleccionada;
  }
  
  public void setCaracteristicaSeleccionada(final String caracteristicaSeleccionada) {
    this.caracteristicaSeleccionada = caracteristicaSeleccionada;
  }
  
  @Pure
  public String getCaracteristicaParaAgregar() {
    return this.caracteristicaParaAgregar;
  }
  
  public void setCaracteristicaParaAgregar(final String caracteristicaParaAgregar) {
    this.caracteristicaParaAgregar = caracteristicaParaAgregar;
  }
  
  @Pure
  public Pais getConexionSeleccionada() {
    return this.conexionSeleccionada;
  }
  
  public void setConexionSeleccionada(final Pais conexionSeleccionada) {
    this.conexionSeleccionada = conexionSeleccionada;
  }
  
  @Pure
  public Pais getConexionParaAgregar() {
    return this.conexionParaAgregar;
  }
  
  public void setConexionParaAgregar(final Pais conexionParaAgregar) {
    this.conexionParaAgregar = conexionParaAgregar;
  }
  
  @Pure
  public List<Pais> getListaDeConexiones() {
    return this.listaDeConexiones;
  }
  
  public void setListaDeConexiones(final List<Pais> listaDeConexiones) {
    this.listaDeConexiones = listaDeConexiones;
  }
  
  @Pure
  public List<Pais> getListaDeConexionesOriginal() {
    return this.listaDeConexionesOriginal;
  }
  
  public void setListaDeConexionesOriginal(final List<Pais> listaDeConexionesOriginal) {
    this.listaDeConexionesOriginal = listaDeConexionesOriginal;
  }
  
  @Pure
  public Lugar getLugarSeleccionado() {
    return this.lugarSeleccionado;
  }
  
  public void setLugarSeleccionado(final Lugar lugarSeleccionado) {
    this.lugarSeleccionado = lugarSeleccionado;
  }
  
  @Pure
  public Lugar getLugarParaAgregar() {
    return this.lugarParaAgregar;
  }
  
  public void setLugarParaAgregar(final Lugar lugarParaAgregar) {
    this.lugarParaAgregar = lugarParaAgregar;
  }
  
  @Pure
  public List<Lugar> getListaDeLugares() {
    return this.listaDeLugares;
  }
  
  public void setListaDeLugares(final List<Lugar> listaDeLugares) {
    this.listaDeLugares = listaDeLugares;
  }
}
