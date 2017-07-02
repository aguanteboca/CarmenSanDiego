package model.ocupante;

import applicationModels.SexosPosibles;
import java.util.Arrays;
import java.util.List;
import model.ocupante.SeniasYHobbies;
import model.ocupante.Villano;
import model.orden.OrdenEmitida;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class VillanoTest {
  private Villano villano;
  
  private OrdenEmitida ordenMock;
  
  @Before
  public void setUp() {
    OrdenEmitida _mock = Mockito.<OrdenEmitida>mock(OrdenEmitida.class);
    this.ordenMock = _mock;
    String _nombre = this.ordenMock.getNombre();
    OngoingStubbing<String> _when = Mockito.<String>when(_nombre);
    _when.thenReturn("Carmen San Diego");
    List<String> _asList = Arrays.<String>asList("Pelo Rubio", "Capa Roja");
    List<String> _asList_1 = Arrays.<String>asList("Coleciona gemas", "Estudia geologia", "Anda en moto");
    Villano _villano = new Villano("Carmen San Diego", 1, SexosPosibles.Masculino, _asList, _asList_1);
    this.villano = _villano;
  }
  
  @Test
  public void actuar() {
    Integer _fueEmitida = this.ordenMock.fueEmitida();
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(_fueEmitida);
    _when.thenReturn(Integer.valueOf(1));
    String expected = this.villano.actuar(this.ordenMock);
    Assert.assertEquals(expected, "ALTO!!! Detengase: Carmen San Diego");
    Integer _fueEmitida_1 = this.ordenMock.fueEmitida();
    OngoingStubbing<Integer> _when_1 = Mockito.<Integer>when(_fueEmitida_1);
    _when_1.thenReturn(Integer.valueOf(0));
    String _actuar = this.villano.actuar(this.ordenMock);
    expected = _actuar;
    Assert.assertEquals(expected, "El villano ha escapado");
  }
  
  @Test
  public void conoceVillanoTest() {
    Boolean _conoceVillano = this.villano.conoceVillano();
    Assert.assertTrue((_conoceVillano).booleanValue());
  }
  
  @Test
  public void pistasTest() {
    SeniasYHobbies seniasYhobbies = this.villano.pistas();
    List<String> _senias = seniasYhobbies.getSenias();
    boolean _contains = _senias.contains("Pelo Rubio");
    Assert.assertTrue(_contains);
    List<String> _senias_1 = seniasYhobbies.getSenias();
    boolean _contains_1 = _senias_1.contains("Capa Roja");
    Assert.assertTrue(_contains_1);
    List<String> _hobbies = seniasYhobbies.getHobbies();
    boolean _contains_2 = _hobbies.contains("Coleciona gemas");
    Assert.assertTrue(_contains_2);
    List<String> _hobbies_1 = seniasYhobbies.getHobbies();
    boolean _contains_3 = _hobbies_1.contains("Estudia geologia");
    Assert.assertTrue(_contains_3);
    List<String> _hobbies_2 = seniasYhobbies.getHobbies();
    boolean _contains_4 = _hobbies_2.contains("Anda en moto");
    Assert.assertTrue(_contains_4);
  }
}
