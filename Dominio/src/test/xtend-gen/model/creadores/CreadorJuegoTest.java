package model.creadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.caso.Caso;
import model.creadores.CreadorJuego;
import model.ocupante.Villano;
import model.pais.Pais;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class CreadorJuegoTest {
  private CreadorJuego creador;
  
  private Pais bolibia;
  
  private Pais argentina;
  
  private Pais brasil;
  
  private Villano cesar;
  
  private Villano lucho;
  
  private Random rnd;
  
  @Before
  public void setUp() {
    Random _mock = Mockito.<Random>mock(Random.class);
    this.rnd = _mock;
    Villano _mock_1 = Mockito.<Villano>mock(Villano.class);
    this.cesar = _mock_1;
    Villano _mock_2 = Mockito.<Villano>mock(Villano.class);
    this.lucho = _mock_2;
    Pais _mock_3 = Mockito.<Pais>mock(Pais.class);
    this.bolibia = _mock_3;
    Pais _mock_4 = Mockito.<Pais>mock(Pais.class);
    this.argentina = _mock_4;
    Pais _mock_5 = Mockito.<Pais>mock(Pais.class);
    this.brasil = _mock_5;
    CreadorJuego _creadorJuego = new CreadorJuego();
    final Procedure1<CreadorJuego> _function = new Procedure1<CreadorJuego>() {
      public void apply(final CreadorJuego it) {
        it.agregarVillano(CreadorJuegoTest.this.cesar);
        it.agregarVillano(CreadorJuegoTest.this.lucho);
        it.agregarPais(CreadorJuegoTest.this.argentina);
        it.agregarPais(CreadorJuegoTest.this.bolibia);
        it.agregarPais(CreadorJuegoTest.this.brasil);
        it.setRnd(CreadorJuegoTest.this.rnd);
      }
    };
    CreadorJuego _doubleArrow = ObjectExtensions.<CreadorJuego>operator_doubleArrow(_creadorJuego, _function);
    this.creador = _doubleArrow;
  }
  
  @Test
  public void randomVillanoTest() {
    Villano villano = this.creador.randomVillano();
    Assert.assertTrue((villano.equals(this.cesar) || villano.equals(this.lucho)));
  }
  
  @Test
  public void getLugarDelHechoTest() {
    List<Pais> paises = this.creador.getMapamundi();
    int _size = paises.size();
    int _nextInt = this.rnd.nextInt(_size);
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(Integer.valueOf(_nextInt));
    _when.thenReturn(Integer.valueOf(2));
    Pais _lugarDelHecho = this.creador.getLugarDelHecho(paises);
    Assert.assertEquals(_lugarDelHecho, this.brasil);
  }
  
  @Test
  public void crearRutaEscapeTest() {
    ArrayList<Pais> _arrayList = new ArrayList<Pais>();
    final Procedure1<ArrayList<Pais>> _function = new Procedure1<ArrayList<Pais>>() {
      public void apply(final ArrayList<Pais> it) {
        it.add(CreadorJuegoTest.this.argentina);
        it.add(CreadorJuegoTest.this.bolibia);
      }
    };
    ArrayList<Pais> mapamundi = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(_arrayList, _function);
    Pais _findConexion = this.brasil.findConexion(mapamundi);
    OngoingStubbing<Pais> _when = Mockito.<Pais>when(_findConexion);
    _when.thenReturn(this.argentina);
    boolean _containsAny = this.argentina.containsAny(mapamundi);
    OngoingStubbing<Boolean> _when_1 = Mockito.<Boolean>when(Boolean.valueOf(_containsAny));
    _when_1.thenReturn(Boolean.valueOf(true));
    Pais _findConexion_1 = this.argentina.findConexion(mapamundi);
    OngoingStubbing<Pais> _when_2 = Mockito.<Pais>when(_findConexion_1);
    _when_2.thenReturn(this.bolibia);
    List<Pais> rutaDeEscape = this.creador.crearRutaEscape(mapamundi, this.brasil);
    Pais _get = rutaDeEscape.get(0);
    Assert.assertEquals(_get, this.argentina);
    Pais _get_1 = rutaDeEscape.get(1);
    Assert.assertEquals(_get_1, this.bolibia);
    int _size = rutaDeEscape.size();
    Assert.assertEquals(_size, 2);
  }
  
  @Test
  public void repartirPistasYocupantesTest() {
    ArrayList<Pais> _arrayList = new ArrayList<Pais>();
    final Procedure1<ArrayList<Pais>> _function = new Procedure1<ArrayList<Pais>>() {
      public void apply(final ArrayList<Pais> it) {
        it.add(CreadorJuegoTest.this.argentina);
        it.add(CreadorJuegoTest.this.bolibia);
      }
    };
    ArrayList<Pais> planDeEscape = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(_arrayList, _function);
    Caso caso = Mockito.<Caso>mock(Caso.class);
    Pais _paisDelRobo = caso.getPaisDelRobo();
    OngoingStubbing<Pais> _when = Mockito.<Pais>when(_paisDelRobo);
    _when.thenReturn(this.brasil);
    List<Pais> _planDeEscape = caso.getPlanDeEscape();
    OngoingStubbing<List<Pais>> _when_1 = Mockito.<List<Pais>>when(_planDeEscape);
    _when_1.thenReturn(planDeEscape);
    this.creador.repartirPistasYocupantes(caso);
    Caso _verify = Mockito.<Caso>verify(caso);
    _verify.registrarUltimoPais();
    Caso _verify_1 = Mockito.<Caso>verify(caso);
    _verify_1.registrarPais(this.brasil, null, this.argentina);
    Caso _verify_2 = Mockito.<Caso>verify(caso);
    _verify_2.registrarPais(this.argentina, this.brasil, this.bolibia);
  }
}
