package model.detective;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.caso.Caso;
import model.lugar.Lugar;
import model.ocupante.Ocupante;
import model.ocupante.Villano;
import model.orden.Orden;
import model.orden.OrdenEmitida;
import model.orden.OrdenNula;
import model.pais.Pais;
import model.registroVillano.RegistroVillano;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class Detective {
  private Orden ordenEmitida;
  
  private Pais lugarActual;
  
  private RegistroVillano registroVillano;
  
  private Caso caso;
  
  public Detective(final Pais lugarDeLosHechos) {
    this.lugarActual = lugarDeLosHechos;
    OrdenNula _ordenNula = new OrdenNula();
    this.ordenEmitida = _ordenNula;
    RegistroVillano _registroVillano = new RegistroVillano();
    this.registroVillano = _registroVillano;
  }
  
  public Pais viajar(final Pais unPais) {
    return this.lugarActual = unPais;
  }
  
  public Caso setCaso(final Caso unCaso) {
    return this.caso = unCaso;
  }
  
  public String visitar(final Lugar unLugar) {
    String _xblockexpression = null;
    {
      Ocupante ocupante = this.caso.obtenerOcupante(unLugar);
      String msj = unLugar.mostrarPistas(this.ordenEmitida, ocupante);
      Boolean _conoceVillano = ocupante.conoceVillano();
      if ((_conoceVillano).booleanValue()) {
        this.registroVillano.agregarVisitado(this.lugarActual);
      } else {
        this.registroVillano.agregarNoVisitado(this.lugarActual);
      }
      _xblockexpression = msj;
    }
    return _xblockexpression;
  }
  
  public Orden emitirOrden(final Villano villano) {
    OrdenEmitida _ordenEmitida = new OrdenEmitida(villano);
    return this.ordenEmitida = _ordenEmitida;
  }
  
  public List<String> recorridoCriminal() {
    Set<Pais> _lugaresVisitados = this.registroVillano.getLugaresVisitados();
    Stream<Pais> _stream = _lugaresVisitados.stream();
    final Function<Pais, String> _function = new Function<Pais, String>() {
      public String apply(final Pais p) {
        return p.getNombre();
      }
    };
    Stream<String> _map = _stream.<String>map(_function);
    Collector<String, ?, List<String>> _list = Collectors.<String>toList();
    return _map.collect(_list);
  }
  
  public List<String> destinosFallidos() {
    Set<Pais> _lugaresNoVisitados = this.registroVillano.getLugaresNoVisitados();
    Stream<Pais> _stream = _lugaresNoVisitados.stream();
    final Function<Pais, String> _function = new Function<Pais, String>() {
      public String apply(final Pais p) {
        return p.getNombre();
      }
    };
    Stream<String> _map = _stream.<String>map(_function);
    Collector<String, ?, List<String>> _list = Collectors.<String>toList();
    return _map.collect(_list);
  }
  
  @Pure
  public Orden getOrdenEmitida() {
    return this.ordenEmitida;
  }
  
  public void setOrdenEmitida(final Orden ordenEmitida) {
    this.ordenEmitida = ordenEmitida;
  }
  
  @Pure
  public Pais getLugarActual() {
    return this.lugarActual;
  }
  
  public void setLugarActual(final Pais lugarActual) {
    this.lugarActual = lugarActual;
  }
  
  @Pure
  public RegistroVillano getRegistroVillano() {
    return this.registroVillano;
  }
  
  public void setRegistroVillano(final RegistroVillano registroVillano) {
    this.registroVillano = registroVillano;
  }
  
  @Pure
  public Caso getCaso() {
    return this.caso;
  }
}
