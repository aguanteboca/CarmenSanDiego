package model.caso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.caso.Caso;
import model.detective.Detective;
import model.lugar.Lugar;
import model.ocupante.Ocupante;
import model.ocupante.SeniasYHobbies;
import model.ocupante.Villano;
import model.pais.Pais;
import model.registroLugar.RegistroLugar;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class CasoTest {
  private Pais argentina;
  
  private Pais brasil;
  
  private Pais francia;
  
  private Pais conFrancia;
  
  private Lugar lugarArg;
  
  private Lugar lugarBrs;
  
  private Lugar lugarFrc1;
  
  private Lugar lugarFrc2;
  
  private Lugar lugarConFrc;
  
  private List<Lugar> lugaresArgentina;
  
  private List<Lugar> lugaresBrasil;
  
  private List<Lugar> lugaresFrancia;
  
  private List<Lugar> lugaresConexFrancia;
  
  private List<Pais> conexArgentina;
  
  private List<Pais> conexBrasil;
  
  private List<Pais> conexFrancia;
  
  private List<Pais> planDeEscape;
  
  private Detective detective;
  
  private Villano nico;
  
  private Caso caso;
  
  private Random rnd;
  
  @Before
  public void setUp() {
    Random _mock = Mockito.<Random>mock(Random.class);
    this.rnd = _mock;
    Villano _mock_1 = Mockito.<Villano>mock(Villano.class);
    this.nico = _mock_1;
    Detective _mock_2 = Mockito.<Detective>mock(Detective.class);
    this.detective = _mock_2;
    Lugar _mock_3 = Mockito.<Lugar>mock(Lugar.class);
    this.lugarArg = _mock_3;
    Lugar _mock_4 = Mockito.<Lugar>mock(Lugar.class);
    this.lugarBrs = _mock_4;
    Lugar _mock_5 = Mockito.<Lugar>mock(Lugar.class);
    this.lugarFrc1 = _mock_5;
    Lugar _mock_6 = Mockito.<Lugar>mock(Lugar.class);
    this.lugarFrc2 = _mock_6;
    Lugar _mock_7 = Mockito.<Lugar>mock(Lugar.class);
    this.lugarConFrc = _mock_7;
    Pais _mock_8 = Mockito.<Pais>mock(Pais.class);
    this.argentina = _mock_8;
    Pais _mock_9 = Mockito.<Pais>mock(Pais.class);
    this.brasil = _mock_9;
    Pais _mock_10 = Mockito.<Pais>mock(Pais.class);
    this.francia = _mock_10;
    Pais _mock_11 = Mockito.<Pais>mock(Pais.class);
    this.conFrancia = _mock_11;
    ArrayList<Lugar> _arrayList = new ArrayList<Lugar>();
    final Procedure1<ArrayList<Lugar>> _function = new Procedure1<ArrayList<Lugar>>() {
      public void apply(final ArrayList<Lugar> it) {
        it.add(CasoTest.this.lugarArg);
      }
    };
    ArrayList<Lugar> _doubleArrow = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_arrayList, _function);
    this.lugaresArgentina = _doubleArrow;
    ArrayList<Lugar> _arrayList_1 = new ArrayList<Lugar>();
    final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
      public void apply(final ArrayList<Lugar> it) {
        it.add(CasoTest.this.lugarBrs);
      }
    };
    ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_arrayList_1, _function_1);
    this.lugaresBrasil = _doubleArrow_1;
    ArrayList<Lugar> _arrayList_2 = new ArrayList<Lugar>();
    final Procedure1<ArrayList<Lugar>> _function_2 = new Procedure1<ArrayList<Lugar>>() {
      public void apply(final ArrayList<Lugar> it) {
        it.add(CasoTest.this.lugarFrc1);
        it.add(CasoTest.this.lugarFrc2);
      }
    };
    ArrayList<Lugar> _doubleArrow_2 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_arrayList_2, _function_2);
    this.lugaresFrancia = _doubleArrow_2;
    ArrayList<Lugar> _arrayList_3 = new ArrayList<Lugar>();
    final Procedure1<ArrayList<Lugar>> _function_3 = new Procedure1<ArrayList<Lugar>>() {
      public void apply(final ArrayList<Lugar> it) {
        it.add(CasoTest.this.lugarConFrc);
      }
    };
    ArrayList<Lugar> _doubleArrow_3 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_arrayList_3, _function_3);
    this.lugaresConexFrancia = _doubleArrow_3;
    ArrayList<Pais> _arrayList_4 = new ArrayList<Pais>();
    final Procedure1<ArrayList<Pais>> _function_4 = new Procedure1<ArrayList<Pais>>() {
      public void apply(final ArrayList<Pais> it) {
        it.add(CasoTest.this.brasil);
      }
    };
    ArrayList<Pais> _doubleArrow_4 = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(_arrayList_4, _function_4);
    this.conexArgentina = _doubleArrow_4;
    ArrayList<Pais> _arrayList_5 = new ArrayList<Pais>();
    final Procedure1<ArrayList<Pais>> _function_5 = new Procedure1<ArrayList<Pais>>() {
      public void apply(final ArrayList<Pais> it) {
        it.add(CasoTest.this.francia);
      }
    };
    ArrayList<Pais> _doubleArrow_5 = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(_arrayList_5, _function_5);
    this.conexBrasil = _doubleArrow_5;
    ArrayList<Pais> _arrayList_6 = new ArrayList<Pais>();
    final Procedure1<ArrayList<Pais>> _function_6 = new Procedure1<ArrayList<Pais>>() {
      public void apply(final ArrayList<Pais> it) {
        it.add(CasoTest.this.conFrancia);
      }
    };
    ArrayList<Pais> _doubleArrow_6 = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(_arrayList_6, _function_6);
    this.conexFrancia = _doubleArrow_6;
    List<Lugar> _lugaresDeInteres = this.argentina.getLugaresDeInteres();
    OngoingStubbing<List<Lugar>> _when = Mockito.<List<Lugar>>when(_lugaresDeInteres);
    _when.thenReturn(this.lugaresArgentina);
    List<Pais> _conexiones = this.argentina.getConexiones();
    OngoingStubbing<List<Pais>> _when_1 = Mockito.<List<Pais>>when(_conexiones);
    _when_1.thenReturn(this.conexArgentina);
    List<Lugar> _lugaresDeInteres_1 = this.brasil.getLugaresDeInteres();
    OngoingStubbing<List<Lugar>> _when_2 = Mockito.<List<Lugar>>when(_lugaresDeInteres_1);
    _when_2.thenReturn(this.lugaresArgentina);
    List<Pais> _conexiones_1 = this.brasil.getConexiones();
    OngoingStubbing<List<Pais>> _when_3 = Mockito.<List<Pais>>when(_conexiones_1);
    _when_3.thenReturn(this.conexBrasil);
    List<Lugar> _lugaresDeInteres_2 = this.francia.getLugaresDeInteres();
    OngoingStubbing<List<Lugar>> _when_4 = Mockito.<List<Lugar>>when(_lugaresDeInteres_2);
    _when_4.thenReturn(this.lugaresFrancia);
    List<Pais> _conexiones_2 = this.francia.getConexiones();
    OngoingStubbing<List<Pais>> _when_5 = Mockito.<List<Pais>>when(_conexiones_2);
    _when_5.thenReturn(this.conexFrancia);
    List<Lugar> _lugaresDeInteres_3 = this.conFrancia.getLugaresDeInteres();
    OngoingStubbing<List<Lugar>> _when_6 = Mockito.<List<Lugar>>when(_lugaresDeInteres_3);
    _when_6.thenReturn(this.lugaresConexFrancia);
    List<Pais> _conexiones_3 = this.conFrancia.getConexiones();
    OngoingStubbing<List<Pais>> _when_7 = Mockito.<List<Pais>>when(_conexiones_3);
    ArrayList<Pais> _arrayList_7 = new ArrayList<Pais>();
    _when_7.thenReturn(_arrayList_7);
    ArrayList<Pais> _arrayList_8 = new ArrayList<Pais>();
    final Procedure1<ArrayList<Pais>> _function_7 = new Procedure1<ArrayList<Pais>>() {
      public void apply(final ArrayList<Pais> it) {
        it.add(CasoTest.this.brasil);
        it.add(CasoTest.this.francia);
      }
    };
    ArrayList<Pais> _doubleArrow_7 = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(_arrayList_8, _function_7);
    this.planDeEscape = _doubleArrow_7;
    Caso _caso = new Caso(1, this.nico, "Los turros se robaron algo", "Cadena de la Yeni", this.planDeEscape, this.argentina, this.detective);
    this.caso = _caso;
    this.caso.setRnd(this.rnd);
  }
  
  @Test
  public void registrarUltimoPaisTest() {
    List<Lugar> _lugaresDeInteres = this.francia.getLugaresDeInteres();
    int _size = _lugaresDeInteres.size();
    int _nextInt = this.rnd.nextInt(_size);
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(Integer.valueOf(_nextInt));
    _when.thenReturn(Integer.valueOf(0));
    String _visitar = this.detective.visitar(this.lugarFrc2);
    OngoingStubbing<String> _when_1 = Mockito.<String>when(_visitar);
    _when_1.thenReturn("CUIDADO DETECTIVE!! ha estado a punto de caer en una trampa..");
    String _visitar_1 = this.detective.visitar(this.lugarConFrc);
    OngoingStubbing<String> _when_2 = Mockito.<String>when(_visitar_1);
    _when_2.thenReturn("Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas");
    this.caso.registrarUltimoPais();
    List<RegistroLugar> _registrosDeLugares = this.caso.getRegistrosDeLugares();
    RegistroLugar _get = _registrosDeLugares.get(0);
    Ocupante _ocupante = _get.getOcupante();
    Assert.assertEquals(_ocupante, this.nico);
    String _detectiveVisitaLugar = this.caso.detectiveVisitaLugar(this.lugarFrc2);
    Assert.assertEquals(_detectiveVisitaLugar, "CUIDADO DETECTIVE!! ha estado a punto de caer en una trampa..");
    String _detectiveVisitaLugar_1 = this.caso.detectiveVisitaLugar(this.lugarConFrc);
    Assert.assertEquals(_detectiveVisitaLugar_1, "Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas");
  }
  
  @Test
  public void registrarPaisTest() {
    SeniasYHobbies pistasNico = Mockito.<SeniasYHobbies>mock(SeniasYHobbies.class);
    List pistasFrancia = Mockito.<List>mock(List.class);
    ArrayList<String> _arrayList = new ArrayList<String>();
    final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
      public void apply(final ArrayList<String> it) {
        it.add("Pelo Rojo");
        it.add("Tenia un buen Sobretodo amarillo");
      }
    };
    ArrayList<String> expected = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_arrayList, _function);
    List<String> _pedirPistas = this.lugarBrs.pedirPistas(pistasNico, pistasFrancia);
    OngoingStubbing<List<String>> _when = Mockito.<List<String>>when(_pedirPistas);
    _when.thenReturn(expected);
    String _visitar = this.detective.visitar(this.lugarBrs);
    OngoingStubbing<String> _when_1 = Mockito.<String>when(_visitar);
    _when_1.thenReturn("Pelo Rojo, Tenia un buen Sobretodo amarillo");
    this.caso.registrarPais(this.brasil, this.argentina, this.francia);
    String _detectiveVisitaLugar = this.caso.detectiveVisitaLugar(this.lugarBrs);
    Assert.assertEquals(_detectiveVisitaLugar, "Pelo Rojo, Tenia un buen Sobretodo amarillo");
  }
}
