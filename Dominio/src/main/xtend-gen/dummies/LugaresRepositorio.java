package dummies;

import java.util.ArrayList;
import java.util.List;
import model.lugar.Banco;
import model.lugar.Biblioteca;
import model.lugar.Club;
import model.lugar.Embajada;
import model.lugar.Lugar;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class LugaresRepositorio {
  private final static ArrayList<Lugar> lugares = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(new ArrayList<Lugar>(), new Procedure1<ArrayList<Lugar>>() {
    public void apply(final ArrayList<Lugar> it) {
      Banco bbva = new Banco("BBVA_Frances");
      Club palmeiras = new Club("Palmeiras");
      Biblioteca biblioteca = new Biblioteca("Biblioteca_Nacional");
      Club aaaj = new Club("Argentinos_Juniors");
      Banco provincia = new Banco("Banco_Provincia");
      Biblioteca bibliotecaArg = new Biblioteca("Biblioteca_La_Posada");
      Embajada embajadaMexico = new Embajada("Embajada_Mexico");
      Biblioteca bibliotecaItalia = new Biblioteca("Biblioteca_La_Tana");
      Club juventus = new Club("Juventus_FC");
      Biblioteca bibliotecaEgipto = new Biblioteca("Biblioteca_de_Alejandria");
      Embajada embajadaEeuu = new Embajada("Embajada_EEUU");
      Club abuDabi = new Club("Abu_Dabi_FC");
      Banco bbva2 = new Banco("BBVA_Frances_2");
      Embajada embajadaRusia = new Embajada("Embajada_Rusia");
      Club sanfrece = new Club("Sanfrece_Hiroshima_FC");
      Biblioteca bibliotecaRusia = new Biblioteca("Biblioteca_Rusia");
      Embajada embajadaArg = new Embajada("Embajada_Argentina");
      Banco bancoRusia = new Banco("Banco_Rusia");
      Banco bbva3 = new Banco("BBVA_Frances_3");
      Biblioteca bibliotecaEsp = new Biblioteca("Biblioteca_de_Gallegos");
      Club barcelona = new Club("Barcelona_FC");
      Banco banco = new Banco("Banco_Nacional");
      Embajada embajadaBrasil = new Embajada("Embajada_Brasil");
      Biblioteca bibliotecaCuba = new Biblioteca("Biblioteca_Jose_Marti");
      Biblioteca poodle = new Biblioteca("Biblioteca_Le_Poodles");
      Embajada embajadaAustralia = new Embajada("Embajada_Australia");
      Banco bbv4 = new Banco("BBVA_Frances_4");
      Biblioteca bibliotecaUruguay = new Biblioteca("Biblioteca_Lucho_Suarez");
      Embajada embajadaJapon = new Embajada("Embajada_Japon");
      Banco rio = new Banco("Rio");
      it.add(bbva);
      it.add(palmeiras);
      it.add(biblioteca);
      it.add(aaaj);
      it.add(provincia);
      it.add(bibliotecaArg);
      it.add(embajadaMexico);
      it.add(bibliotecaItalia);
      it.add(juventus);
      it.add(bibliotecaEgipto);
      it.add(embajadaEeuu);
      it.add(abuDabi);
      it.add(bbva2);
      it.add(embajadaRusia);
      it.add(sanfrece);
      it.add(bibliotecaRusia);
      it.add(embajadaArg);
      it.add(bancoRusia);
      it.add(bbva3);
      it.add(bibliotecaEsp);
      it.add(barcelona);
      it.add(banco);
      it.add(embajadaBrasil);
      it.add(bibliotecaCuba);
      it.add(poodle);
      it.add(embajadaAustralia);
      it.add(bbv4);
      it.add(bibliotecaUruguay);
      it.add(embajadaJapon);
      it.add(rio);
    }
  });
  
  public static List<Lugar> getLugares() {
    return LugaresRepositorio.lugares;
  }
  
  public static Lugar getLugar(final int pos) {
    return LugaresRepositorio.lugares.get(pos);
  }
}
