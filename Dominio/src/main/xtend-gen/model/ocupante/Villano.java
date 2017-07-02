package model.ocupante;

import applicationModels.SexosPosibles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.ocupante.Ocupante;
import model.ocupante.SeniasYHobbies;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class Villano extends Ocupante {
  private String nombre;
  
  private int id;
  
  private SexosPosibles sexo;
  
  private List<String> seniasParticulares;
  
  private List<String> hobbies;
  
  public Villano(final String unNombre, final int unId, final SexosPosibles genero, final List<String> unasSenias, final List<String> unosHobbies) {
    this.nombre = unNombre;
    this.id = unId;
    this.sexo = genero;
    this.seniasParticulares = unasSenias;
    this.hobbies = unosHobbies;
  }
  
  public Villano() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.seniasParticulares = _arrayList;
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.hobbies = _arrayList_1;
  }
  
  public Boolean conoceVillano() {
    return Boolean.valueOf(true);
  }
  
  public Boolean esUnVillano() {
    return Boolean.valueOf(true);
  }
  
  public String actuar(final Orden orden) {
    Integer _fueEmitida = orden.fueEmitida();
    if (_fueEmitida != null) {
      switch (_fueEmitida) {
        case 1:
          String _nombre = orden.getNombre();
          return ("ALTO!!! Detengase: " + _nombre);
        case 0:
          return "El villano ha escapado";
      }
    }
    return null;
  }
  
  public SeniasYHobbies pistas() {
    SeniasYHobbies _xblockexpression = null;
    {
      List<String> cloneSenias = new ArrayList<String>();
      List<String> cloneHobbies = new ArrayList<String>();
      for (final String c : this.seniasParticulares) {
        char[] _charArray = c.toCharArray();
        String _copyValueOf = String.copyValueOf(_charArray);
        cloneSenias.add(_copyValueOf);
      }
      for (final String c_1 : this.hobbies) {
        char[] _charArray_1 = c_1.toCharArray();
        String _copyValueOf_1 = String.copyValueOf(_charArray_1);
        cloneHobbies.add(_copyValueOf_1);
      }
      _xblockexpression = new SeniasYHobbies(cloneSenias, cloneHobbies);
    }
    return _xblockexpression;
  }
  
  public List<SexosPosibles> sexos() {
    SexosPosibles[] sexosP = SexosPosibles.values();
    return Arrays.<SexosPosibles>asList(sexosP);
  }
  
  public boolean agregarSenia(final String senia) {
    return this.seniasParticulares.add(senia);
  }
  
  public boolean eliminarSenia(final String senia) {
    return this.seniasParticulares.remove(senia);
  }
  
  public boolean eliminarHobbie(final String hobbie) {
    return this.hobbies.remove(hobbie);
  }
  
  public boolean agregarHobbie(final String hobbie) {
    return this.hobbies.add(hobbie);
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public SexosPosibles getSexo() {
    return this.sexo;
  }
  
  public void setSexo(final SexosPosibles sexo) {
    this.sexo = sexo;
  }
  
  @Pure
  public List<String> getSeniasParticulares() {
    return this.seniasParticulares;
  }
  
  public void setSeniasParticulares(final List<String> seniasParticulares) {
    this.seniasParticulares = seniasParticulares;
  }
  
  @Pure
  public List<String> getHobbies() {
    return this.hobbies;
  }
  
  public void setHobbies(final List<String> hobbies) {
    this.hobbies = hobbies;
  }
}
