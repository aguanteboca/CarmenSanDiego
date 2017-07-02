package model.baseCentralAcme;

import java.util.List;
import model.caso.Caso;
import model.creadores.CreadorJuego;
import model.ocupante.Villano;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class BaseCentralAcme {
  private CreadorJuego creador;
  
  public BaseCentralAcme() {
    CreadorJuego _creadorJuego = new CreadorJuego();
    this.creador = _creadorJuego;
  }
  
  public BaseCentralAcme(final List<Villano> villanos, final List<Pais> mapamundi) {
    CreadorJuego _creadorJuego = new CreadorJuego(villanos, mapamundi);
    this.creador = _creadorJuego;
  }
  
  public List<Villano> getVillanos() {
    return this.creador.getVillanos();
  }
  
  public List<Pais> getMapamundi() {
    return this.creador.getMapamundi();
  }
  
  public boolean registrarVillano(final Villano nuevoVillano) {
    return this.creador.agregarVillano(nuevoVillano);
  }
  
  public boolean registrarPais(final Pais nuevoPais) {
    return this.creador.agregarPais(nuevoPais);
  }
  
  public Caso crearCaso(final int id, final String reporte, final String obj) {
    return this.creador.crearJuego(id, reporte, obj);
  }
  
  @Pure
  public CreadorJuego getCreador() {
    return this.creador;
  }
  
  public void setCreador(final CreadorJuego creador) {
    this.creador = creador;
  }
}
