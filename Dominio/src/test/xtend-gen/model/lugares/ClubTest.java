package model.lugares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import model.lugar.Club;
import model.ocupante.SeniasYHobbies;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class ClubTest {
  private Random rnd;
  
  private Club unClub;
  
  private ArrayList<String> paisActual;
  
  private SeniasYHobbies responsable;
  
  @Before
  public void setUp() {
    List<String> _asList = Arrays.<String>asList("Bandera Azul y Blanca", "Moneda Peso");
    ArrayList<String> _arrayList = new ArrayList<String>(_asList);
    this.paisActual = _arrayList;
    List<String> _asList_1 = Arrays.<String>asList("Sobretodo amarillo", "Usa guantes");
    ArrayList<String> _arrayList_1 = new ArrayList<String>(_asList_1);
    List<String> _asList_2 = Arrays.<String>asList("Juega Golf", "Estudia programacion");
    ArrayList<String> _arrayList_2 = new ArrayList<String>(_asList_2);
    SeniasYHobbies _seniasYHobbies = new SeniasYHobbies(_arrayList_1, _arrayList_2);
    this.responsable = _seniasYHobbies;
    Club _club = new Club("River Plate");
    this.unClub = _club;
    Random _mock = Mockito.<Random>mock(Random.class);
    this.rnd = _mock;
    this.unClub.setRnd(this.rnd);
  }
  
  @Test
  public void pistasDeBibliotecaSincHobbie() {
    int _nextInt = this.rnd.nextInt(100);
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(Integer.valueOf(_nextInt));
    _when.thenReturn(Integer.valueOf(75));
    List<String> pistas = this.unClub.pedirPistas(this.responsable, this.paisActual);
    int _size = pistas.size();
    Assert.assertEquals(_size, 2);
  }
  
  @Test
  public void pistasDeBibliotecaConcHobbie() {
    int _nextInt = this.rnd.nextInt(100);
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(Integer.valueOf(_nextInt));
    _when.thenReturn(Integer.valueOf(25));
    List<String> pistas = this.unClub.pedirPistas(this.responsable, this.paisActual);
    int _size = pistas.size();
    Assert.assertEquals(_size, 3);
  }
}
