package model.baseCentralAcme;

import java.util.List;
import model.baseCentralAcme.BaseCentralAcme;
import model.creadores.CreadorJuego;
import model.ocupante.Villano;
import model.pais.Pais;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class BaseCentralAcmeTest {
  private Villano unVillanoMock;
  
  private Pais unPaisMock;
  
  private BaseCentralAcme acme;
  
  @Before
  public void setUp() {
    Villano _mock = Mockito.<Villano>mock(Villano.class);
    this.unVillanoMock = _mock;
    Pais _mock_1 = Mockito.<Pais>mock(Pais.class);
    this.unPaisMock = _mock_1;
    BaseCentralAcme _baseCentralAcme = new BaseCentralAcme();
    this.acme = _baseCentralAcme;
  }
  
  @Test
  public void registrarVillanoTest() {
    this.acme.registrarVillano(this.unVillanoMock);
    List<Villano> _villanos = this.acme.getVillanos();
    boolean _contains = _villanos.contains(this.unVillanoMock);
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void registrarPaisTest() {
    this.acme.registrarPais(this.unPaisMock);
    List<Pais> _mapamundi = this.acme.getMapamundi();
    boolean _contains = _mapamundi.contains(this.unPaisMock);
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void crearCasoTest() {
    CreadorJuego creador = Mockito.<CreadorJuego>mock(CreadorJuego.class);
    this.acme.setCreador(creador);
    this.acme.crearCaso(1, "Los turros se robaron algo", "Cadena de la Yeni");
    CreadorJuego _verify = Mockito.<CreadorJuego>verify(creador);
    _verify.crearJuego(1, "Los turros se robaron algo", "Cadena de la Yeni");
  }
}
