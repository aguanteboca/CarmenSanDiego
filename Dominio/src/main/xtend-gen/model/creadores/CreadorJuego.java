package model.creadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import model.caso.Caso;
import model.detective.Detective;
import model.ocupante.Villano;
import model.pais.Pais;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class CreadorJuego {
  private List<Villano> villanos;
  
  private List<Pais> mapamundi;
  
  private Random rnd;
  
  public CreadorJuego() {
    ArrayList<Villano> _arrayList = new ArrayList<Villano>();
    this.villanos = _arrayList;
    ArrayList<Pais> _arrayList_1 = new ArrayList<Pais>();
    this.mapamundi = _arrayList_1;
    Random _random = new Random();
    this.rnd = _random;
  }
  
  public CreadorJuego(final List<Villano> villanos, final List<Pais> mapamundi) {
    this.villanos = villanos;
    this.mapamundi = mapamundi;
    Random _random = new Random();
    this.rnd = _random;
  }
  
  public boolean agregarVillano(final Villano nuevoVillano) {
    return this.villanos.add(nuevoVillano);
  }
  
  public boolean agregarPais(final Pais nuevoPais) {
    return this.mapamundi.add(nuevoPais);
  }
  
  public Caso crearJuego(final int id, final String reporte, final String obj) {
    Caso _xblockexpression = null;
    {
      ArrayList<Pais> _arrayList = new ArrayList<Pais>();
      final Procedure1<ArrayList<Pais>> _function = new Procedure1<ArrayList<Pais>>() {
        public void apply(final ArrayList<Pais> it) {
          it.addAll(CreadorJuego.this.mapamundi);
        }
      };
      ArrayList<Pais> paises = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(_arrayList, _function);
      Pais lugarDelHecho = this.getLugarDelHecho(paises);
      Detective detective = new Detective(lugarDelHecho);
      List<Pais> rutaEscape = this.crearRutaEscape(paises, lugarDelHecho);
      Caso newCase = new Caso(id);
      Villano _randomVillano = this.randomVillano();
      newCase.setResponsable(_randomVillano);
      newCase.setReporte(reporte);
      newCase.setObjeto(obj);
      newCase.setPaisDelRobo(lugarDelHecho);
      newCase.setPlanDeEscape(rutaEscape);
      newCase.setDetective(detective);
      this.repartirPistasYocupantes(newCase);
      _xblockexpression = newCase;
    }
    return _xblockexpression;
  }
  
  public void repartirPistasYocupantes(final Caso newCase) {
    Pais paisAnterior = null;
    int iteracion = 0;
    Pais _paisDelRobo = newCase.getPaisDelRobo();
    List<Pais> _planDeEscape = newCase.getPlanDeEscape();
    Pais _get = _planDeEscape.get(0);
    newCase.registrarPais(_paisDelRobo, paisAnterior, _get);
    Pais _paisDelRobo_1 = newCase.getPaisDelRobo();
    paisAnterior = _paisDelRobo_1;
    List<Pais> _planDeEscape_1 = newCase.getPlanDeEscape();
    List<Pais> _planDeEscape_2 = newCase.getPlanDeEscape();
    int _size = _planDeEscape_2.size();
    int _minus = (_size - 1);
    List<Pais> _subList = _planDeEscape_1.subList(iteracion, _minus);
    for (final Pais pais : _subList) {
      {
        List<Pais> _planDeEscape_3 = newCase.getPlanDeEscape();
        Pais _get_1 = _planDeEscape_3.get((iteracion + 1));
        newCase.registrarPais(pais, paisAnterior, _get_1);
        List<Pais> _planDeEscape_4 = newCase.getPlanDeEscape();
        Pais _get_2 = _planDeEscape_4.get(iteracion);
        paisAnterior = _get_2;
        iteracion++;
      }
    }
    newCase.registrarUltimoPais();
  }
  
  public List<Pais> crearRutaEscape(final List<Pais> mapamundi, final Pais lugarDelHecho) {
    ArrayList<Pais> _xblockexpression = null;
    {
      ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
      Pais nuevoDestino = lugarDelHecho.findConexion(mapamundi);
      rutaDeEscape.add(nuevoDestino);
      mapamundi.remove(nuevoDestino);
      int cantPaises = 0;
      while ((((!mapamundi.isEmpty()) && (cantPaises < 8)) && IterableExtensions.<Pais>last(rutaDeEscape).containsAny(mapamundi))) {
        {
          Pais _last = IterableExtensions.<Pais>last(rutaDeEscape);
          Pais _findConexion = _last.findConexion(mapamundi);
          nuevoDestino = _findConexion;
          rutaDeEscape.add(nuevoDestino);
          mapamundi.remove(nuevoDestino);
          cantPaises++;
        }
      }
      _xblockexpression = rutaDeEscape;
    }
    return _xblockexpression;
  }
  
  public Pais getLugarDelHecho(final List<Pais> paises) {
    Pais _xblockexpression = null;
    {
      int _size = paises.size();
      int _nextInt = this.rnd.nextInt(_size);
      Pais lugarDelHecho = paises.get(_nextInt);
      paises.remove(lugarDelHecho);
      _xblockexpression = lugarDelHecho;
    }
    return _xblockexpression;
  }
  
  public Villano randomVillano() {
    ArrayList<Villano> _arrayList = new ArrayList<Villano>();
    final Procedure1<ArrayList<Villano>> _function = new Procedure1<ArrayList<Villano>>() {
      public void apply(final ArrayList<Villano> it) {
        it.addAll(CreadorJuego.this.villanos);
      }
    };
    ArrayList<Villano> newList = ObjectExtensions.<ArrayList<Villano>>operator_doubleArrow(_arrayList, _function);
    Collections.shuffle(newList);
    return newList.get(0);
  }
  
  @Pure
  public List<Villano> getVillanos() {
    return this.villanos;
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this.villanos = villanos;
  }
  
  @Pure
  public List<Pais> getMapamundi() {
    return this.mapamundi;
  }
  
  public void setMapamundi(final List<Pais> mapamundi) {
    this.mapamundi = mapamundi;
  }
  
  @Pure
  public Random getRnd() {
    return this.rnd;
  }
  
  public void setRnd(final Random rnd) {
    this.rnd = rnd;
  }
}
