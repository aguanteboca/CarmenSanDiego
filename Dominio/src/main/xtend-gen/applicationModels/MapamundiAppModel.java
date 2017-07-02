package applicationModels;

import dummies.PaisesRepositorio;
import java.util.List;
import java.util.function.Predicate;
import model.pais.Pais;
import org.apache.commons.lang.StringUtils;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class MapamundiAppModel {
  private Pais paisSeleccionado;
  
  private List<Pais> paises = PaisesRepositorio.getMapamundi();
  
  public MapamundiAppModel(final List<Pais> unosPaises) {
    this.paises = unosPaises;
  }
  
  public boolean quitarPaisSeleccionado() {
    return this.quitarPais(this.paisSeleccionado);
  }
  
  public boolean quitarPais(final Pais unPais) {
    return this.paises.remove(unPais);
  }
  
  public Pais nuevoPais() {
    final Pais nuevo = new Pais();
    this.agregarPais(nuevo);
    return nuevo;
  }
  
  public boolean agregarPais(final Pais unPais) {
    return this.paises.add(unPais);
  }
  
  public Pais getPais(final int id) {
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais it) {
        int _id = it.getId();
        return Boolean.valueOf((_id == id));
      }
    };
    return IterableExtensions.<Pais>findFirst(this.paises, _function);
  }
  
  public boolean setPais(final Pais pais) {
    boolean _xblockexpression = false;
    {
      boolean _estaCompleto = pais.estaCompleto();
      boolean _not = (!_estaCompleto);
      if (_not) {
        throw new UserException("El pais debe estar completo");
      }
      int _id = pais.getId();
      this.eliminarPais(_id);
      _xblockexpression = this.paises.add(pais);
    }
    return _xblockexpression;
  }
  
  public List<Pais> searchPais(final String substring) {
    List<Pais> _xifexpression = null;
    boolean _isBlank = StringUtils.isBlank(substring);
    if (_isBlank) {
      _xifexpression = this.paises;
    } else {
      final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
        public Boolean apply(final Pais it) {
          String _nombre = it.getNombre();
          String _lowerCase = _nombre.toLowerCase();
          String _lowerCase_1 = substring.toLowerCase();
          return Boolean.valueOf(_lowerCase.contains(_lowerCase_1));
        }
      };
      Iterable<Pais> _filter = IterableExtensions.<Pais>filter(this.paises, _function);
      _xifexpression = IterableExtensions.<Pais>toList(_filter);
    }
    return _xifexpression;
  }
  
  public boolean updatePais(final Pais unPais) {
    boolean _xblockexpression = false;
    {
      final Predicate<Pais> _function = new Predicate<Pais>() {
        public boolean test(final Pais it) {
          int _id = it.getId();
          int _id_1 = unPais.getId();
          return (_id == _id_1);
        }
      };
      this.paises.removeIf(_function);
      _xblockexpression = this.paises.add(unPais);
    }
    return _xblockexpression;
  }
  
  public boolean eliminarPais(final int unid) {
    final Predicate<Pais> _function = new Predicate<Pais>() {
      public boolean test(final Pais it) {
        int _id = it.getId();
        return (_id == unid);
      }
    };
    return this.paises.removeIf(_function);
  }
  
  @Pure
  public Pais getPaisSeleccionado() {
    return this.paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this.paisSeleccionado = paisSeleccionado;
  }
  
  @Pure
  public List<Pais> getPaises() {
    return this.paises;
  }
  
  public void setPaises(final List<Pais> paises) {
    this.paises = paises;
  }
}
