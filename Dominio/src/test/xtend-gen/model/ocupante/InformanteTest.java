package model.ocupante;

import java.util.Arrays;
import java.util.List;
import model.ocupante.Informante;
import model.orden.OrdenEmitida;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class InformanteTest {
  private Informante informante;
  
  private OrdenEmitida ordenMock;
  
  @Before
  public void setUp() {
    OrdenEmitida _mock = Mockito.<OrdenEmitida>mock(OrdenEmitida.class);
    this.ordenMock = _mock;
    List<String> _asList = Arrays.<String>asList("Le gusta las joyas", "Mentia mucho");
    Informante _informante = new Informante(_asList);
    this.informante = _informante;
  }
  
  @Test
  public void actuar() {
    String _actuar = this.informante.actuar(this.ordenMock);
    Assert.assertEquals(_actuar, "Le gusta las joyas, Mentia mucho");
  }
  
  @Test
  public void conoceVillanoTest() {
    Boolean _conoceVillano = this.informante.conoceVillano();
    Assert.assertTrue((_conoceVillano).booleanValue());
  }
}
