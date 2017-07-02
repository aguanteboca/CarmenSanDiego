package model.pais;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.lugar.Lugar;
import org.apache.commons.lang.StringUtils;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Pais {
  private int id;
  
  private String nombre;
  
  private List<String> caracteristicas;
  
  private List<Pais> conexiones;
  
  private List<Lugar> lugaresDeInteres;
  
  public Pais() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.caracteristicas = _arrayList;
    ArrayList<Pais> _arrayList_1 = new ArrayList<Pais>();
    this.conexiones = _arrayList_1;
    ArrayList<Lugar> _arrayList_2 = new ArrayList<Lugar>();
    this.lugaresDeInteres = _arrayList_2;
  }
  
  public Pais(final int unid, final String unNombre) {
    this.id = unid;
    this.nombre = unNombre;
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.caracteristicas = _arrayList;
    ArrayList<Pais> _arrayList_1 = new ArrayList<Pais>();
    this.conexiones = _arrayList_1;
    ArrayList<Lugar> _arrayList_2 = new ArrayList<Lugar>();
    this.lugaresDeInteres = _arrayList_2;
  }
  
  public Pais(final int unid, final String unNombre, final List<String> unasCaracteristicas, final List<Pais> unasConexiones, final List<Lugar> unosLugares) {
    this.id = unid;
    this.nombre = unNombre;
    this.caracteristicas = unasCaracteristicas;
    this.conexiones = unasConexiones;
    this.lugaresDeInteres = unosLugares;
  }
  
  public boolean containsAny(final List<Pais> mapamundi) {
    boolean _xblockexpression = false;
    {
      boolean found = false;
      for (final Pais pais : this.conexiones) {
        found = (found || mapamundi.contains(pais));
      }
      _xblockexpression = found;
    }
    return _xblockexpression;
  }
  
  public Pais findConexion(final List<Pais> mapamundi) {
    Pais _xblockexpression = null;
    {
      Pais found = null;
      Stream<Pais> _stream = this.conexiones.stream();
      final Predicate<Pais> _function = new Predicate<Pais>() {
        public boolean test(final Pais p) {
          return mapamundi.contains(p);
        }
      };
      Stream<Pais> _filter = _stream.filter(_function);
      Collector<Pais, ?, List<Pais>> _list = Collectors.<Pais>toList();
      List<Pais> encontrados = _filter.collect(_list);
      int _size = encontrados.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        Pais _get = encontrados.get(0);
        found = _get;
        for (final Pais pais : encontrados) {
          int _cantDeConexiones = pais.cantDeConexiones();
          int _cantDeConexiones_1 = found.cantDeConexiones();
          boolean _greaterThan_1 = (_cantDeConexiones > _cantDeConexiones_1);
          if (_greaterThan_1) {
            found = pais;
          }
        }
      }
      _xblockexpression = found;
    }
    return _xblockexpression;
  }
  
  public List<String> pistas() {
    List<String> _xblockexpression = null;
    {
      List<String> cloneCaracterist = new ArrayList<String>();
      for (final String c : this.caracteristicas) {
        char[] _charArray = c.toCharArray();
        String _copyValueOf = String.copyValueOf(_charArray);
        cloneCaracterist.add(_copyValueOf);
      }
      _xblockexpression = cloneCaracterist;
    }
    return _xblockexpression;
  }
  
  public Pais buscarConexion(final int idPais) {
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais it) {
        int _id = it.getId();
        return Boolean.valueOf((_id == idPais));
      }
    };
    return IterableExtensions.<Pais>findFirst(this.conexiones, _function);
  }
  
  public Lugar buscarLugar(final String nombreLugar) {
    final Function1<Lugar, Boolean> _function = new Function1<Lugar, Boolean>() {
      public Boolean apply(final Lugar it) {
        String _nombre = it.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, nombreLugar));
      }
    };
    return IterableExtensions.<Lugar>findFirst(this.lugaresDeInteres, _function);
  }
  
  public int cantDeConexiones() {
    return this.conexiones.size();
  }
  
  public boolean eliminarCaracteristica(final String caracteristica) {
    return this.caracteristicas.remove(caracteristica);
  }
  
  public boolean agregarCaracteristica(final String caracteristica) {
    return this.caracteristicas.add(caracteristica);
  }
  
  public boolean eliminarConexion(final Pais conexion) {
    return this.conexiones.remove(conexion);
  }
  
  public boolean agregarConexion(final Pais conexion) {
    return this.conexiones.add(conexion);
  }
  
  public boolean eliminarLugar(final Lugar lugar) {
    return this.lugaresDeInteres.remove(lugar);
  }
  
  public boolean agregarLugar(final Lugar lugar) {
    return this.lugaresDeInteres.add(lugar);
  }
  
  public boolean estaCompleto() {
    return StringUtils.isNotBlank(this.nombre);
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
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
  public List<String> getCaracteristicas() {
    return this.caracteristicas;
  }
  
  public void setCaracteristicas(final List<String> caracteristicas) {
    this.caracteristicas = caracteristicas;
  }
  
  @Pure
  public List<Pais> getConexiones() {
    return this.conexiones;
  }
  
  public void setConexiones(final List<Pais> conexiones) {
    this.conexiones = conexiones;
  }
  
  @Pure
  public List<Lugar> getLugaresDeInteres() {
    return this.lugaresDeInteres;
  }
  
  public void setLugaresDeInteres(final List<Lugar> lugaresDeInteres) {
    this.lugaresDeInteres = lugaresDeInteres;
  }
}
