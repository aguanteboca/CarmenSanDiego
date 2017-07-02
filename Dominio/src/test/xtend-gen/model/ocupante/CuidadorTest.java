package model.ocupante;

import model.ocupante.Cuidador;
import model.orden.OrdenEmitida;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class CuidadorTest {
  private Cuidador cuidador;
  
  private OrdenEmitida ordenMock;
  
  @Before
  public void setUp() {
    OrdenEmitida _mock = Mockito.<OrdenEmitida>mock(OrdenEmitida.class);
    this.ordenMock = _mock;
    Cuidador _cuidador = new Cuidador();
    this.cuidador = _cuidador;
  }
  
  @Test
  public void actuar() {
    String _actuar = this.cuidador.actuar(this.ordenMock);
    Assert.assertEquals(_actuar, 
      "Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas");
  }
  
  @Test
  public void conoceVillanoTest() {
    Boolean _conoceVillano = this.cuidador.conoceVillano();
    Assert.assertFalse((_conoceVillano).booleanValue());
  }
}
