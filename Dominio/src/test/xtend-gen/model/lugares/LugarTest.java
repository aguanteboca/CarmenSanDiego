package model.lugares;

import model.lugar.Club;
import model.lugar.Lugar;
import model.ocupante.Cuidador;
import model.ocupante.Informante;
import model.ocupante.Villano;
import model.orden.Orden;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class LugarTest {
  private Lugar riverPlate;
  
  private Orden orden;
  
  @Before
  public void setUp() {
    Orden _mock = Mockito.<Orden>mock(Orden.class);
    this.orden = _mock;
    Club _club = new Club("River Plate");
    this.riverPlate = _club;
  }
  
  @Test
  public void mostrarPistasInformante() {
    Informante informante = Mockito.<Informante>mock(Informante.class);
    String _actuar = informante.actuar(this.orden);
    OngoingStubbing<String> _when = Mockito.<String>when(_actuar);
    _when.thenReturn("Tiene pelo Rojo, Juega bien al Futbol");
    String pistasEsperadas = "Tiene pelo Rojo, Juega bien al Futbol";
    String _mostrarPistas = this.riverPlate.mostrarPistas(this.orden, informante);
    Assert.assertEquals(_mostrarPistas, pistasEsperadas);
  }
  
  @Test
  public void mostrarPistasCuidador() {
    Cuidador cuidador = new Cuidador();
    String pistasEsperadas = "Lo siento creo que se ha equivocado de Ciudad. No hay nadie con esas caracteristicas";
    String _mostrarPistas = this.riverPlate.mostrarPistas(this.orden, cuidador);
    Assert.assertEquals(_mostrarPistas, pistasEsperadas);
  }
  
  @Test
  public void mostrarPistasVillanoQueEscapo() {
    String pistasEsperadas = "El villano ha escapado";
    Villano villano = Mockito.<Villano>mock(Villano.class);
    String _actuar = villano.actuar(this.orden);
    OngoingStubbing<String> _when = Mockito.<String>when(_actuar);
    _when.thenReturn("El villano ha escapado");
    String _mostrarPistas = this.riverPlate.mostrarPistas(this.orden, villano);
    Assert.assertEquals(_mostrarPistas, pistasEsperadas);
  }
  
  @Test
  public void mostrarPistasVillanoCorrecto() {
    String pistasEsperadas = "ALTO!!! Detengase: Carmen San Diego";
    Villano villano = Mockito.<Villano>mock(Villano.class);
    String _actuar = villano.actuar(this.orden);
    OngoingStubbing<String> _when = Mockito.<String>when(_actuar);
    _when.thenReturn("ALTO!!! Detengase: Carmen San Diego");
    String _mostrarPistas = this.riverPlate.mostrarPistas(this.orden, villano);
    Assert.assertEquals(_mostrarPistas, pistasEsperadas);
  }
  
  @Test
  public void mostrarPistasVillanoEquivocado() {
    String pistasEsperadas = "El villano ha escapado";
    Villano villano = Mockito.<Villano>mock(Villano.class);
    String _actuar = villano.actuar(this.orden);
    OngoingStubbing<String> _when = Mockito.<String>when(_actuar);
    _when.thenReturn("El villano ha escapado");
    String _mostrarPistas = this.riverPlate.mostrarPistas(this.orden, villano);
    Assert.assertEquals(_mostrarPistas, pistasEsperadas);
  }
}
