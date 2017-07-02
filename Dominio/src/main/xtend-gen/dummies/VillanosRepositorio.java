package dummies;

import applicationModels.SexosPosibles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.ocupante.Villano;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class VillanosRepositorio {
  private static List<String> seniasParticulares;
  
  private static List<String> hobbies;
  
  private static ArrayList<Villano> villanos = ObjectExtensions.<ArrayList<Villano>>operator_doubleArrow(new ArrayList<Villano>(), new Procedure1<ArrayList<Villano>>() {
    public void apply(final ArrayList<Villano> it) {
      List<String> _asList = Arrays.<String>asList("Pelirroja", "Sobretodo rojo", "Guantes amarillos", "Admiracion por las joyas", "Conocimiento en vinos");
      ArrayList<String> _arrayList = new ArrayList<String>(_asList);
      List<String> _seniasParticulares = VillanosRepositorio.seniasParticulares = _arrayList;
      List<String> _asList_1 = Arrays.<String>asList("Le gusta andar en moto", "Tiene una coleccion de joyas");
      ArrayList<String> _arrayList_1 = new ArrayList<String>(_asList_1);
      List<String> _hobbies = VillanosRepositorio.hobbies = _arrayList_1;
      Villano carmenSanDiego = new Villano("Carmen SanDiego", 1, SexosPosibles.Femenino, _seniasParticulares, _hobbies);
      it.add(carmenSanDiego);
      List<String> _asList_2 = Arrays.<String>asList("Pelo rubio", "Maneja una limusina", "Tatuaje en su brazo derecho", "Habla ucraniano", "Admiracion por las joyas");
      ArrayList<String> _arrayList_2 = new ArrayList<String>(_asList_2);
      List<String> _seniasParticulares_1 = VillanosRepositorio.seniasParticulares = _arrayList_2;
      List<String> _asList_3 = Arrays.<String>asList("Le jugar al croquet", "Le gusta cocinar");
      ArrayList<String> _arrayList_3 = new ArrayList<String>(_asList_3);
      List<String> _hobbies_1 = VillanosRepositorio.hobbies = _arrayList_3;
      Villano ihorIhorovich = new Villano("Ihor Ihorovich", 2, SexosPosibles.Masculino, _seniasParticulares_1, _hobbies_1);
      it.add(ihorIhorovich);
      List<String> _asList_4 = Arrays.<String>asList("Pelo rubio", "Usa un traje", "Habla italiano", "Usa guantes", "Maneja una limosina");
      ArrayList<String> _arrayList_4 = new ArrayList<String>(_asList_4);
      List<String> _seniasParticulares_2 = VillanosRepositorio.seniasParticulares = _arrayList_4;
      List<String> _asList_5 = Arrays.<String>asList("Se ocupa en la mafia con los muchachos", "Antecedentes en robo de bancos");
      ArrayList<String> _arrayList_5 = new ArrayList<String>(_asList_5);
      List<String> _hobbies_2 = VillanosRepositorio.hobbies = _arrayList_5;
      Villano alCapone = new Villano("Al Capone", 3, SexosPosibles.Masculino, _seniasParticulares_2, _hobbies_2);
      it.add(alCapone);
    }
  });
  
  public static List<Villano> getVillanos() {
    return VillanosRepositorio.villanos;
  }
}
