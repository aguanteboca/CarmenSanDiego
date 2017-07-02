package model.detective;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.caso.Caso;
import model.detective.Detective;
import model.lugar.Biblioteca;
import model.ocupante.Ocupante;
import model.ocupante.Villano;
import model.orden.Orden;
import model.pais.Pais;
import model.registroVillano.RegistroVillano;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class DetectiveTest {
  private Villano villanoMock;
  
  private Detective sherlockHolmes;
  
  private Pais argentina;
  
  private Pais unPaisMock;
  
  private RegistroVillano registro;
  
  private Caso caso;
  
  @Before
  public void setUp() {
    RegistroVillano _mock = Mockito.<RegistroVillano>mock(RegistroVillano.class);
    this.registro = _mock;
    Villano _mock_1 = Mockito.<Villano>mock(Villano.class);
    this.villanoMock = _mock_1;
    Pais _mock_2 = Mockito.<Pais>mock(Pais.class);
    this.unPaisMock = _mock_2;
    Caso _mock_3 = Mockito.<Caso>mock(Caso.class);
    this.caso = _mock_3;
    Pais _mock_4 = Mockito.<Pais>mock(Pais.class);
    this.argentina = _mock_4;
    String _nombre = this.argentina.getNombre();
    OngoingStubbing<String> _when = Mockito.<String>when(_nombre);
    _when.thenReturn("Argentina");
    Detective _detective = new Detective(this.unPaisMock);
    this.sherlockHolmes = _detective;
    this.sherlockHolmes.setRegistroVillano(this.registro);
    this.sherlockHolmes.setCaso(this.caso);
  }
  
  @Test
  public void detectiveEstaEnArgentina() {
    this.sherlockHolmes.viajar(this.argentina);
    Pais _lugarActual = this.sherlockHolmes.getLugarActual();
    String _nombre = _lugarActual.getNombre();
    Assert.assertEquals("Argentina", _nombre);
  }
  
  @Test
  public void visitarUnLugar() {
    Biblioteca biblioteca = Mockito.<Biblioteca>mock(Biblioteca.class);
    Orden _ordenEmitida = this.sherlockHolmes.getOrdenEmitida();
    String _mostrarPistas = biblioteca.mostrarPistas(_ordenEmitida, this.villanoMock);
    OngoingStubbing<String> _when = Mockito.<String>when(_mostrarPistas);
    _when.thenReturn("Bandera Blanca y Celeste");
    Ocupante _obtenerOcupante = this.caso.obtenerOcupante(biblioteca);
    OngoingStubbing<Ocupante> _when_1 = Mockito.<Ocupante>when(_obtenerOcupante);
    _when_1.thenReturn(this.villanoMock);
    Boolean _conoceVillano = this.villanoMock.conoceVillano();
    OngoingStubbing<Boolean> _when_2 = Mockito.<Boolean>when(_conoceVillano);
    _when_2.thenReturn(Boolean.valueOf(true));
    String expected = "Bandera Blanca y Celeste";
    String _visitar = this.sherlockHolmes.visitar(biblioteca);
    Assert.assertEquals(_visitar, expected);
    RegistroVillano _verify = Mockito.<RegistroVillano>verify(this.registro);
    _verify.agregarVisitado(this.unPaisMock);
    Boolean _conoceVillano_1 = this.villanoMock.conoceVillano();
    OngoingStubbing<Boolean> _when_3 = Mockito.<Boolean>when(_conoceVillano_1);
    _when_3.thenReturn(Boolean.valueOf(false));
    this.sherlockHolmes.visitar(biblioteca);
    RegistroVillano _verify_1 = Mockito.<RegistroVillano>verify(this.registro);
    _verify_1.agregarVisitado(this.unPaisMock);
  }
  
  @Test
  public void emitirOrden() {
    this.sherlockHolmes.emitirOrden(this.villanoMock);
    Orden _ordenEmitida = this.sherlockHolmes.getOrdenEmitida();
    Villano _obtenerVillano = _ordenEmitida.obtenerVillano();
    Assert.assertEquals(_obtenerVillano, this.villanoMock);
  }
  
  @Test
  public void recorridoCriminalTest() {
    HashSet<Pais> _hashSet = new HashSet<Pais>();
    final Procedure1<HashSet<Pais>> _function = new Procedure1<HashSet<Pais>>() {
      public void apply(final HashSet<Pais> it) {
        Pais _mock = Mockito.<Pais>mock(Pais.class);
        it.add(_mock);
        Pais _mock_1 = Mockito.<Pais>mock(Pais.class);
        it.add(_mock_1);
      }
    };
    HashSet<Pais> visitados = ObjectExtensions.<HashSet<Pais>>operator_doubleArrow(_hashSet, _function);
    Set<Pais> _lugaresVisitados = this.registro.getLugaresVisitados();
    OngoingStubbing<Set<Pais>> _when = Mockito.<Set<Pais>>when(_lugaresVisitados);
    _when.thenReturn(visitados);
    List<String> _recorridoCriminal = this.sherlockHolmes.recorridoCriminal();
    int _size = _recorridoCriminal.size();
    Assert.assertEquals(_size, 2);
  }
  
  @Test
  public void destinosFallidosTest() {
    HashSet<Pais> _hashSet = new HashSet<Pais>();
    final Procedure1<HashSet<Pais>> _function = new Procedure1<HashSet<Pais>>() {
      public void apply(final HashSet<Pais> it) {
        Pais _mock = Mockito.<Pais>mock(Pais.class);
        it.add(_mock);
        Pais _mock_1 = Mockito.<Pais>mock(Pais.class);
        it.add(_mock_1);
        Pais _mock_2 = Mockito.<Pais>mock(Pais.class);
        it.add(_mock_2);
      }
    };
    HashSet<Pais> noVisitados = ObjectExtensions.<HashSet<Pais>>operator_doubleArrow(_hashSet, _function);
    Set<Pais> _lugaresNoVisitados = this.registro.getLugaresNoVisitados();
    OngoingStubbing<Set<Pais>> _when = Mockito.<Set<Pais>>when(_lugaresNoVisitados);
    _when.thenReturn(noVisitados);
    List<String> _destinosFallidos = this.sherlockHolmes.destinosFallidos();
    int _size = _destinosFallidos.size();
    Assert.assertEquals(_size, 3);
  }
}
