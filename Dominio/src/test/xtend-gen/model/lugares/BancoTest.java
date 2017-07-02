package model.lugares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.lugar.Banco;
import model.ocupante.SeniasYHobbies;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class BancoTest {
  private Banco unBanco;
  
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
    Banco _banco = new Banco("Provincia");
    this.unBanco = _banco;
  }
  
  @Test
  public void pistasDeBanco() {
    List<String> pistas = this.unBanco.pedirPistas(this.responsable, this.paisActual);
    int _size = pistas.size();
    Assert.assertEquals(_size, 2);
  }
}
