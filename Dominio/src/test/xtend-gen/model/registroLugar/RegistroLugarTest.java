package model.registroLugar;

import model.lugar.Lugar;
import model.ocupante.Ocupante;
import model.registroLugar.RegistroLugar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class RegistroLugarTest {
  private Lugar lugarMock;
  
  private Ocupante ocupanteMock;
  
  private RegistroLugar registro;
  
  @Before
  public void setUp() {
    Lugar _mock = Mockito.<Lugar>mock(Lugar.class);
    this.lugarMock = _mock;
    Ocupante _mock_1 = Mockito.<Ocupante>mock(Ocupante.class);
    this.ocupanteMock = _mock_1;
    RegistroLugar _registroLugar = new RegistroLugar(this.lugarMock, this.ocupanteMock);
    this.registro = _registroLugar;
  }
  
  @Test
  public void nombreLugarTest() {
    String _nombre = this.lugarMock.getNombre();
    OngoingStubbing<String> _when = Mockito.<String>when(_nombre);
    _when.thenReturn("Real_Madrid");
    String _nombreLugar = this.registro.nombreLugar();
    Assert.assertEquals(_nombreLugar, "Real_Madrid");
  }
}
