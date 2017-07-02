package model.lugar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import model.lugar.Lugar;
import model.ocupante.SeniasYHobbies;

@JsonTypeName("biblioteca")
@SuppressWarnings("all")
public class Biblioteca extends Lugar {
  @JsonCreator
  public Biblioteca(@JsonProperty("nombre") final String unNombre) {
    super(unNombre);
  }
  
  public List<String> pedirPistas(final SeniasYHobbies responsable, final List<String> paisActual) {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> pistas = new ArrayList<String>();
      List<String> _senias = responsable.getSenias();
      List<String> _senias_1 = responsable.getSenias();
      int _size = _senias_1.size();
      int _nextInt = this.rnd.nextInt(_size);
      String senia = _senias.get(_nextInt);
      int _size_1 = paisActual.size();
      int _nextInt_1 = this.rnd.nextInt(_size_1);
      String pPais = paisActual.get(_nextInt_1);
      pistas.add(("Pista de villano: " + senia));
      pistas.add(("Pista de pais: " + pPais));
      List<String> _senias_2 = responsable.getSenias();
      _senias_2.remove(senia);
      paisActual.remove(pPais);
      int _nextInt_2 = this.rnd.nextInt(100);
      boolean _lessEqualsThan = (_nextInt_2 <= 50);
      if (_lessEqualsThan) {
        List<String> _hobbies = responsable.getHobbies();
        List<String> _hobbies_1 = responsable.getHobbies();
        int _size_2 = _hobbies_1.size();
        int _nextInt_3 = this.rnd.nextInt(_size_2);
        String hobbie = _hobbies.get(_nextInt_3);
        pistas.add(("Pista de villano: " + hobbie));
        List<String> _hobbies_2 = responsable.getHobbies();
        _hobbies_2.remove(hobbie);
      }
      _xblockexpression = pistas;
    }
    return _xblockexpression;
  }
}
