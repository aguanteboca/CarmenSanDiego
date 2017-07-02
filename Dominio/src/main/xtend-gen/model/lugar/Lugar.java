package model.lugar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;
import java.util.Random;
import model.lugar.Banco;
import model.lugar.Biblioteca;
import model.lugar.Club;
import model.lugar.Embajada;
import model.ocupante.Ocupante;
import model.ocupante.SeniasYHobbies;
import model.orden.Orden;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = Banco.class, name = "banco"), @JsonSubTypes.Type(value = Club.class, name = "club"), @JsonSubTypes.Type(value = Embajada.class, name = "embajada"), @JsonSubTypes.Type(value = Biblioteca.class, name = "biblioteca") })
@SuppressWarnings("all")
public abstract class Lugar {
  protected String nombre;
  
  @JsonIgnore
  protected Random rnd;
  
  public Lugar(final String unNombre) {
    this.nombre = unNombre;
    Random _random = new Random();
    this.rnd = _random;
  }
  
  public String mostrarPistas(final Orden orden, final Ocupante ocupante) {
    return ocupante.actuar(orden);
  }
  
  public abstract List<String> pedirPistas(final SeniasYHobbies responsable, final List<String> paisActual);
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public Random getRnd() {
    return this.rnd;
  }
  
  public void setRnd(final Random rnd) {
    this.rnd = rnd;
  }
}
