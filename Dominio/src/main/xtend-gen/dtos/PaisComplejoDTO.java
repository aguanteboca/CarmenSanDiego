package dtos;

import dtos.PaisSimpleDTO;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.lugar.Lugar;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class PaisComplejoDTO {
  private Integer id;
  
  private String nombre;
  
  private List<String> lugares;
  
  private List<PaisSimpleDTO> conexiones;
  
  public PaisComplejoDTO(final Pais unPais) {
    int _id = unPais.getId();
    this.id = Integer.valueOf(_id);
    String _nombre = unPais.getNombre();
    this.nombre = _nombre;
    List<Lugar> _lugaresDeInteres = unPais.getLugaresDeInteres();
    Stream<Lugar> _stream = _lugaresDeInteres.stream();
    final Function<Lugar, String> _function = new Function<Lugar, String>() {
      public String apply(final Lugar l) {
        return l.getNombre();
      }
    };
    Stream<String> _map = _stream.<String>map(_function);
    Collector<String, ?, List<String>> _list = Collectors.<String>toList();
    List<String> _collect = _map.collect(_list);
    this.lugares = _collect;
    List<Pais> _conexiones = unPais.getConexiones();
    Stream<Pais> _stream_1 = _conexiones.stream();
    final Function<Pais, PaisSimpleDTO> _function_1 = new Function<Pais, PaisSimpleDTO>() {
      public PaisSimpleDTO apply(final Pais p) {
        return new PaisSimpleDTO(p);
      }
    };
    Stream<PaisSimpleDTO> _map_1 = _stream_1.<PaisSimpleDTO>map(_function_1);
    Collector<PaisSimpleDTO, ?, List<PaisSimpleDTO>> _list_1 = Collectors.<PaisSimpleDTO>toList();
    List<PaisSimpleDTO> _collect_1 = _map_1.collect(_list_1);
    this.conexiones = _collect_1;
  }
  
  @Pure
  public Integer getId() {
    return this.id;
  }
  
  public void setId(final Integer id) {
    this.id = id;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public List<String> getLugares() {
    return this.lugares;
  }
  
  public void setLugares(final List<String> lugares) {
    this.lugares = lugares;
  }
  
  @Pure
  public List<PaisSimpleDTO> getConexiones() {
    return this.conexiones;
  }
  
  public void setConexiones(final List<PaisSimpleDTO> conexiones) {
    this.conexiones = conexiones;
  }
}
