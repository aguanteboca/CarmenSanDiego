package model.caso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import model.detective.Detective;
import model.lugar.Lugar;
import model.ocupante.Cuidador;
import model.ocupante.Informante;
import model.ocupante.Ocupante;
import model.ocupante.SeniasYHobbies;
import model.ocupante.Villano;
import model.orden.Orden;
import model.pais.Pais;
import model.registroLugar.RegistroLugar;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Caso {
  private int id;
  
  private String objeto;
  
  private Villano responsable;
  
  private String reporte;
  
  private List<Pais> planDeEscape;
  
  private Pais paisDelRobo;
  
  private Detective detective;
  
  private List<RegistroLugar> registrosDeLugares;
  
  @JsonIgnore
  private Random rnd;
  
  public Caso(final int id, final Villano unResponsable, final String unReporte, final String unObjeto, final List<Pais> unPlan, final Pais unPais, final Detective unDetective) {
    this.id = id;
    this.responsable = unResponsable;
    this.reporte = unReporte;
    this.objeto = unObjeto;
    this.planDeEscape = unPlan;
    this.paisDelRobo = unPais;
    this.detective = unDetective;
    ArrayList<RegistroLugar> _arrayList = new ArrayList<RegistroLugar>();
    this.registrosDeLugares = _arrayList;
    Random _random = new Random();
    this.rnd = _random;
  }
  
  public Caso(final int id) {
    this.id = id;
    ArrayList<RegistroLugar> _arrayList = new ArrayList<RegistroLugar>();
    this.registrosDeLugares = _arrayList;
    Random _random = new Random();
    this.rnd = _random;
  }
  
  public Caso setDetective(final Detective unDetective) {
    Caso _xblockexpression = null;
    {
      this.detective = unDetective;
      _xblockexpression = unDetective.setCaso(this);
    }
    return _xblockexpression;
  }
  
  public Ocupante obtenerOcupante(final Lugar unLugar) {
    final Function1<RegistroLugar, Boolean> _function = new Function1<RegistroLugar, Boolean>() {
      public Boolean apply(final RegistroLugar it) {
        Lugar _lugar = it.getLugar();
        return Boolean.valueOf(Objects.equal(_lugar, unLugar));
      }
    };
    RegistroLugar _findFirst = IterableExtensions.<RegistroLugar>findFirst(this.registrosDeLugares, _function);
    return _findFirst.getOcupante();
  }
  
  public RegistroLugar BuscarRegistroLugar(final String nombreLugarBuscado) {
    final Function1<RegistroLugar, Boolean> _function = new Function1<RegistroLugar, Boolean>() {
      public Boolean apply(final RegistroLugar it) {
        String _nombreLugar = it.nombreLugar();
        return Boolean.valueOf(Objects.equal(_nombreLugar, nombreLugarBuscado));
      }
    };
    return IterableExtensions.<RegistroLugar>findFirst(this.registrosDeLugares, _function);
  }
  
  public Pais buscarConexion(final int idPais) {
    Pais _lugarActual = this.detective.getLugarActual();
    return _lugarActual.buscarConexion(idPais);
  }
  
  public Orden detectiveEmiteOrdenContra(final Villano unVillano) {
    return this.detective.emitirOrden(unVillano);
  }
  
  public String detectiveVisitaLugar(final Lugar unLugar) {
    return this.detective.visitar(unLugar);
  }
  
  public void registrarPais(final Pais paisActual, final Pais paisAnterior, final Pais paisPosterior) {
    this.registrarInformantesALugares(paisActual, paisPosterior);
    this.registrarConexiones(paisActual, paisAnterior);
  }
  
  private void registrarInformantesALugares(final Pais paisActual, final Pais paisPosterior) {
    List<Lugar> _lugaresDeInteres = paisActual.getLugaresDeInteres();
    for (final Lugar lugar : _lugaresDeInteres) {
      Informante _crearInformante = this.crearInformante(paisPosterior, lugar);
      RegistroLugar _registroLugar = new RegistroLugar(lugar, _crearInformante);
      this.registrosDeLugares.add(_registroLugar);
    }
  }
  
  private Informante crearInformante(final Pais paisPosterior, final Lugar lugar) {
    SeniasYHobbies _pistas = this.responsable.pistas();
    List<String> _pistas_1 = paisPosterior.pistas();
    List<String> _pedirPistas = lugar.pedirPistas(_pistas, _pistas_1);
    return new Informante(_pedirPistas);
  }
  
  private void registrarConexiones(final Pais paisActual, final Pais paisAnterior) {
    List<Pais> _conexiones = paisActual.getConexiones();
    for (final Pais p : _conexiones) {
      if (((!Objects.equal(p, paisAnterior)) && ((!this.planDeEscape.contains(p)) && (!Objects.equal(p, paisActual))))) {
        this.registrarCuidadoresALugares(p);
      }
    }
  }
  
  private void registrarCuidadoresALugares(final Pais conexionActual) {
    List<Lugar> _lugaresDeInteres = conexionActual.getLugaresDeInteres();
    for (final Lugar lugar : _lugaresDeInteres) {
      Cuidador _cuidador = new Cuidador();
      RegistroLugar _registroLugar = new RegistroLugar(lugar, _cuidador);
      this.registrosDeLugares.add(_registroLugar);
    }
  }
  
  public void registrarUltimoPais() {
    final Pais ultimoPais = IterableExtensions.<Pais>last(this.planDeEscape);
    this.registrarOcupantesALugares(ultimoPais);
    List<Pais> _conexiones = ultimoPais.getConexiones();
    for (final Pais p : _conexiones) {
      if (((!this.planDeEscape.contains(p)) && (!Objects.equal(p, ultimoPais)))) {
        this.registrarCuidadoresALugares(p);
      }
    }
  }
  
  private void registrarOcupantesALugares(final Pais ultimoPais) {
    List<Lugar> _lugaresDeInteres = ultimoPais.getLugaresDeInteres();
    List<Lugar> _lugaresDeInteres_1 = ultimoPais.getLugaresDeInteres();
    int _size = _lugaresDeInteres_1.size();
    int _nextInt = this.rnd.nextInt(_size);
    Lugar lugarVillano = _lugaresDeInteres.get(_nextInt);
    RegistroLugar _registroLugar = new RegistroLugar(lugarVillano, this.responsable);
    this.registrosDeLugares.add(_registroLugar);
    List<Lugar> _lugaresDeInteres_2 = ultimoPais.getLugaresDeInteres();
    for (final Lugar lugar : _lugaresDeInteres_2) {
      boolean _notEquals = (!Objects.equal(lugar, lugarVillano));
      if (_notEquals) {
        List<String> pistaInf = Arrays.<String>asList("CUIDADO DETECTIVE!! ha estado a punto de caer en una trampa..");
        Informante _informante = new Informante(pistaInf);
        RegistroLugar _registroLugar_1 = new RegistroLugar(lugar, _informante);
        this.registrosDeLugares.add(_registroLugar_1);
      }
    }
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public String getObjeto() {
    return this.objeto;
  }
  
  public void setObjeto(final String objeto) {
    this.objeto = objeto;
  }
  
  @Pure
  public Villano getResponsable() {
    return this.responsable;
  }
  
  public void setResponsable(final Villano responsable) {
    this.responsable = responsable;
  }
  
  @Pure
  public String getReporte() {
    return this.reporte;
  }
  
  public void setReporte(final String reporte) {
    this.reporte = reporte;
  }
  
  @Pure
  public List<Pais> getPlanDeEscape() {
    return this.planDeEscape;
  }
  
  public void setPlanDeEscape(final List<Pais> planDeEscape) {
    this.planDeEscape = planDeEscape;
  }
  
  @Pure
  public Pais getPaisDelRobo() {
    return this.paisDelRobo;
  }
  
  public void setPaisDelRobo(final Pais paisDelRobo) {
    this.paisDelRobo = paisDelRobo;
  }
  
  @Pure
  public Detective getDetective() {
    return this.detective;
  }
  
  @Pure
  public List<RegistroLugar> getRegistrosDeLugares() {
    return this.registrosDeLugares;
  }
  
  public void setRegistrosDeLugares(final List<RegistroLugar> registrosDeLugares) {
    this.registrosDeLugares = registrosDeLugares;
  }
  
  @Pure
  public Random getRnd() {
    return this.rnd;
  }
  
  public void setRnd(final Random rnd) {
    this.rnd = rnd;
  }
}
