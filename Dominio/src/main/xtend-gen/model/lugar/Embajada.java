package model.lugar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import model.lugar.Lugar;
import model.ocupante.SeniasYHobbies;

@JsonTypeName("embajada")
@SuppressWarnings("all")
public class Embajada extends Lugar {
  @JsonCreator
  public Embajada(@JsonProperty("nombre") final String unNombre) {
    super(unNombre);
  }
  
  public List<String> pedirPistas(final SeniasYHobbies responsable, final List<String> paisActual) {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> pistas = new ArrayList<String>();
      int _size = paisActual.size();
      int _nextInt = this.rnd.nextInt(_size);
      String pPais1 = paisActual.get(_nextInt);
      pistas.add(("Pista de pais: " + pPais1));
      paisActual.remove(pPais1);
      int _size_1 = paisActual.size();
      int _nextInt_1 = this.rnd.nextInt(_size_1);
      String pPais2 = paisActual.get(_nextInt_1);
      pistas.add(("Pista de pais: " + pPais2));
      paisActual.remove(pPais2);
      _xblockexpression = pistas;
    }
    return _xblockexpression;
  }
}
