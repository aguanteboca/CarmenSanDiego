package model.orden;

import model.excepciones.NoEstaElVillanoException;
import model.ocupante.Villano;
import model.orden.OrdenEmitida;
import model.orden.OrdenNula;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class OrdenTest {
  private OrdenEmitida ordenEmitida;
  
  private OrdenNula ordenNula;
  
  private Villano villanoMock;
  
  @Before
  public void setUp() {
    Villano _mock = Mockito.<Villano>mock(Villano.class);
    this.villanoMock = _mock;
    String _nombre = this.villanoMock.getNombre();
    OngoingStubbing<String> _when = Mockito.<String>when(_nombre);
    _when.thenReturn("Pepe");
    OrdenEmitida _ordenEmitida = new OrdenEmitida(this.villanoMock);
    this.ordenEmitida = _ordenEmitida;
    OrdenNula _ordenNula = new OrdenNula();
    this.ordenNula = _ordenNula;
  }
  
  @Test
  public void getVillanoTest() {
    Villano _villano = this.ordenEmitida.getVillano();
    Assert.assertEquals(_villano, this.villanoMock);
  }
  
  @Test(expected = NoEstaElVillanoException.class)
  public void obtenerVillanoTestSinVillano() {
    this.ordenNula.obtenerVillano();
  }
  
  @Test
  public void fueEmitidaTest() {
    Integer _fueEmitida = this.ordenEmitida.fueEmitida();
    Assert.assertEquals((_fueEmitida).intValue(), 1);
    Integer _fueEmitida_1 = this.ordenNula.fueEmitida();
    Assert.assertEquals((_fueEmitida_1).intValue(), 0);
  }
  
  @Test
  public void nombreTest() {
    Assert.assertEquals(this.ordenEmitida.nombre, "Pepe");
    Assert.assertEquals(this.ordenNula.nombre, "Nadie");
  }
}
