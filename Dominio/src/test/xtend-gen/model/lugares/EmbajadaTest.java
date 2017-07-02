package model.lugares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.lugar.Embajada;
import model.ocupante.SeniasYHobbies;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class EmbajadaTest {
  private Embajada unaEmbajada;
  
  private ArrayList<String> paisActual;
  
  private SeniasYHobbies responsable;
  
  @Before
  public void setUp() {
    List<String> _asList = Arrays.<String>asList("Bandera Azul y Blanca", "Moneda Peso");
    ArrayList<String> _arrayList = new ArrayList<String>(_asList);
    this.paisActual = _arrayList;
    List<String> _asList_1 = Arrays.<String>asList("Sobretodo amarillo", "Usa guantes");
    List<String> _asList_2 = Arrays.<String>asList("Juega Golf", "Estudia programacion");
    SeniasYHobbies _seniasYHobbies = new SeniasYHobbies(_asList_1, _asList_2);
    this.responsable = _seniasYHobbies;
    Embajada _embajada = new Embajada("Provincia");
    this.unaEmbajada = _embajada;
  }
  
  @Test
  public void pistasDeEmbajada() {
    List<String> pistas = this.unaEmbajada.pedirPistas(this.responsable, this.paisActual);
    int _size = pistas.size();
    Assert.assertEquals(_size, 2);
  }
}
