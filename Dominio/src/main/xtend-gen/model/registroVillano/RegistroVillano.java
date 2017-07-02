package model.registroVillano;

import java.util.HashSet;
import java.util.Set;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RegistroVillano {
  private Set<Pais> lugaresVisitados;
  
  private Set<Pais> lugaresNoVisitados;
  
  public RegistroVillano() {
    HashSet<Pais> _hashSet = new HashSet<Pais>();
    this.lugaresVisitados = _hashSet;
    HashSet<Pais> _hashSet_1 = new HashSet<Pais>();
    this.lugaresNoVisitados = _hashSet_1;
  }
  
  public boolean agregarVisitado(final Pais pais) {
    return this.lugaresVisitados.add(pais);
  }
  
  public boolean agregarNoVisitado(final Pais pais) {
    return this.lugaresNoVisitados.add(pais);
  }
  
  @Pure
  public Set<Pais> getLugaresVisitados() {
    return this.lugaresVisitados;
  }
  
  public void setLugaresVisitados(final Set<Pais> lugaresVisitados) {
    this.lugaresVisitados = lugaresVisitados;
  }
  
  @Pure
  public Set<Pais> getLugaresNoVisitados() {
    return this.lugaresNoVisitados;
  }
  
  public void setLugaresNoVisitados(final Set<Pais> lugaresNoVisitados) {
    this.lugaresNoVisitados = lugaresNoVisitados;
  }
}
