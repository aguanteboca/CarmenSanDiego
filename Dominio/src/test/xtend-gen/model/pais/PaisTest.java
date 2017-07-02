package model.pais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.lugar.Banco;
import model.lugar.Biblioteca;
import model.lugar.Club;
import model.lugar.Lugar;
import model.pais.Pais;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class PaisTest {
  private Pais argentina;
  
  private Pais brasil;
  
  private Pais uruguay;
  
  private Pais paraguay;
  
  private Banco bancoGalicia;
  
  private Biblioteca bibliotecaNacional;
  
  private Club riverPlate;
  
  @Before
  public void setUp() {
    Pais _mock = Mockito.<Pais>mock(Pais.class);
    this.brasil = _mock;
    Pais _mock_1 = Mockito.<Pais>mock(Pais.class);
    this.uruguay = _mock_1;
    Pais _mock_2 = Mockito.<Pais>mock(Pais.class);
    this.paraguay = _mock_2;
    Banco _mock_3 = Mockito.<Banco>mock(Banco.class);
    this.bancoGalicia = _mock_3;
    Biblioteca _mock_4 = Mockito.<Biblioteca>mock(Biblioteca.class);
    this.bibliotecaNacional = _mock_4;
    Club _mock_5 = Mockito.<Club>mock(Club.class);
    this.riverPlate = _mock_5;
    List<String> _asList = Arrays.<String>asList("Moneda Peso", "Bandera Celeste y Blanca", "Hablan español");
    List<Pais> _asList_1 = Arrays.<Pais>asList(this.brasil, this.uruguay, this.paraguay);
    List<Lugar> _asList_2 = Arrays.<Lugar>asList(this.bancoGalicia, this.bibliotecaNacional, this.riverPlate);
    Pais _pais = new Pais(1, "Nombre", _asList, _asList_1, _asList_2);
    this.argentina = _pais;
  }
  
  @Test
  public void containsAnyTest() {
    List<Pais> mapamundi = new ArrayList<Pais>();
    boolean _containsAny = this.argentina.containsAny(mapamundi);
    Assert.assertFalse(_containsAny);
    mapamundi.add(this.brasil);
    boolean _containsAny_1 = this.argentina.containsAny(mapamundi);
    Assert.assertTrue(_containsAny_1);
  }
  
  @Test
  public void findConexionTest() {
    int _cantDeConexiones = this.brasil.cantDeConexiones();
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(Integer.valueOf(_cantDeConexiones));
    _when.thenReturn(Integer.valueOf(1));
    int _cantDeConexiones_1 = this.uruguay.cantDeConexiones();
    OngoingStubbing<Integer> _when_1 = Mockito.<Integer>when(Integer.valueOf(_cantDeConexiones_1));
    _when_1.thenReturn(Integer.valueOf(2));
    List<Pais> mapamundi = new ArrayList<Pais>();
    Pais _findConexion = this.argentina.findConexion(mapamundi);
    Assert.assertEquals(_findConexion, null);
    mapamundi.add(this.brasil);
    mapamundi.add(this.uruguay);
    Pais _findConexion_1 = this.argentina.findConexion(mapamundi);
    Assert.assertEquals(_findConexion_1, this.uruguay);
  }
  
  @Test
  public void pistasTest() {
    List<String> _pistas = this.argentina.pistas();
    int _size = _pistas.size();
    Assert.assertEquals(_size, 3);
  }
  
  @Test
  public void buscarConexionTest() {
    int _id = this.brasil.getId();
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(Integer.valueOf(_id));
    _when.thenReturn(Integer.valueOf(1));
    int _id_1 = this.uruguay.getId();
    OngoingStubbing<Integer> _when_1 = Mockito.<Integer>when(Integer.valueOf(_id_1));
    _when_1.thenReturn(Integer.valueOf(2));
    int _id_2 = this.paraguay.getId();
    OngoingStubbing<Integer> _when_2 = Mockito.<Integer>when(Integer.valueOf(_id_2));
    _when_2.thenReturn(Integer.valueOf(3));
    Pais _buscarConexion = this.argentina.buscarConexion(2);
    Assert.assertEquals(_buscarConexion, this.uruguay);
  }
  
  @Test
  public void buscarLugarTest() {
    String _nombre = this.bancoGalicia.getNombre();
    OngoingStubbing<String> _when = Mockito.<String>when(_nombre);
    _when.thenReturn("Banco Galicia");
    String _nombre_1 = this.bibliotecaNacional.getNombre();
    OngoingStubbing<String> _when_1 = Mockito.<String>when(_nombre_1);
    _when_1.thenReturn("Biblioteca Nacional");
    String _nombre_2 = this.riverPlate.getNombre();
    OngoingStubbing<String> _when_2 = Mockito.<String>when(_nombre_2);
    _when_2.thenReturn("River Plate");
    Lugar _buscarLugar = this.argentina.buscarLugar("River Plate");
    Assert.assertEquals(_buscarLugar, this.riverPlate);
  }
}
