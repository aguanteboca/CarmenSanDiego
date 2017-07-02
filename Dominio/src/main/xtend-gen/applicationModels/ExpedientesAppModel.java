package applicationModels;

import dummies.VillanosRepositorio;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import model.ocupante.Villano;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class ExpedientesAppModel {
  private List<Villano> villanos = VillanosRepositorio.getVillanos();
  
  private Villano villanoSeleccionado;
  
  private List<String> sexosPosibles = Arrays.<String>asList("sexosPosibles");
  
  public Villano nuevoVillano() {
    final Villano nuevo = new Villano();
    this.agregarVillano(nuevo);
    return nuevo;
  }
  
  public List<Villano> getVillanos() {
    return this.villanos;
  }
  
  public boolean agregarVillano(final Villano villano) {
    boolean _xifexpression = false;
    Stream<Villano> _stream = this.villanos.stream();
    final Predicate<Villano> _function = new Predicate<Villano>() {
      public boolean test(final Villano v) {
        int _id = v.getId();
        int _id_1 = villano.getId();
        return (_id == _id_1);
      }
    };
    boolean _anyMatch = _stream.anyMatch(_function);
    boolean _not = (!_anyMatch);
    if (_not) {
      _xifexpression = this.villanos.add(villano);
    } else {
      throw new UserException("El villano ya existe");
    }
    return _xifexpression;
  }
  
  public boolean updateVillano(final Villano villano) {
    boolean _xblockexpression = false;
    {
      final Predicate<Villano> _function = new Predicate<Villano>() {
        public boolean test(final Villano it) {
          int _id = it.getId();
          int _id_1 = villano.getId();
          return (_id == _id_1);
        }
      };
      this.villanos.removeIf(_function);
      _xblockexpression = this.villanos.add(villano);
    }
    return _xblockexpression;
  }
  
  public boolean deleteVillano(final int id) {
    final Predicate<Villano> _function = new Predicate<Villano>() {
      public boolean test(final Villano it) {
        int _id = it.getId();
        return (_id == id);
      }
    };
    return this.villanos.removeIf(_function);
  }
  
  public Villano buscarVillano(final int id) {
    final Function1<Villano, Boolean> _function = new Function1<Villano, Boolean>() {
      public Boolean apply(final Villano it) {
        int _id = it.getId();
        Integer _valueOf = Integer.valueOf(id);
        return Boolean.valueOf((_id == (_valueOf).intValue()));
      }
    };
    return IterableExtensions.<Villano>findFirst(this.villanos, _function);
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this.villanos = villanos;
  }
  
  @Pure
  public Villano getVillanoSeleccionado() {
    return this.villanoSeleccionado;
  }
  
  public void setVillanoSeleccionado(final Villano villanoSeleccionado) {
    this.villanoSeleccionado = villanoSeleccionado;
  }
  
  @Pure
  public List<String> getSexosPosibles() {
    return this.sexosPosibles;
  }
  
  public void setSexosPosibles(final List<String> sexosPosibles) {
    this.sexosPosibles = sexosPosibles;
  }
}
