package dummies;

import dummies.LugaresRepositorio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.lugar.Lugar;
import model.pais.Pais;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.UserException;

@SuppressWarnings("all")
public class PaisesRepositorio {
  private static List<String> caracteristicas;
  
  private static List<Pais> conexiones;
  
  private static List<Lugar> lugares;
  
  private static ArrayList<Pais> mapamundi = ObjectExtensions.<ArrayList<Pais>>operator_doubleArrow(new ArrayList<Pais>(), new Procedure1<ArrayList<Pais>>() {
    public void apply(final ArrayList<Pais> it) {
      List<String> _asList = Arrays.<String>asList("Habitantes hablan portuges", "Bandera verde amarilla y azul", "Pentacampeones del mundo", "Quinto pais mas grande del mundo", "Tiene mas de 200m de habitantes");
      ArrayList<String> _arrayList = new ArrayList<String>(_asList);
      List<String> _caracteristicas = PaisesRepositorio.caracteristicas = _arrayList;
      List<Pais> _asList_1 = Arrays.<Pais>asList();
      ArrayList<Pais> _arrayList_1 = new ArrayList<Pais>(_asList_1);
      List<Pais> _conexiones = PaisesRepositorio.conexiones = _arrayList_1;
      Lugar _lugar = LugaresRepositorio.getLugar(0);
      Lugar _lugar_1 = LugaresRepositorio.getLugar(1);
      Lugar _lugar_2 = LugaresRepositorio.getLugar(2);
      List<Lugar> _asList_2 = Arrays.<Lugar>asList(_lugar, _lugar_1, _lugar_2);
      ArrayList<Lugar> _arrayList_2 = new ArrayList<Lugar>(_asList_2);
      List<Lugar> _lugares = PaisesRepositorio.lugares = _arrayList_2;
      Pais brasil = new Pais(1, "Brasil", _caracteristicas, _conexiones, _lugares);
      List<String> _asList_3 = Arrays.<String>asList("Habitantes hablan español", "Bandera celeste y blanca", "Habitantes toman mate", "Tierra del tango", "Tierra de los mejores jugadores de la historia");
      ArrayList<String> _arrayList_3 = new ArrayList<String>(_asList_3);
      List<String> _caracteristicas_1 = PaisesRepositorio.caracteristicas = _arrayList_3;
      List<Pais> _asList_4 = Arrays.<Pais>asList(brasil);
      ArrayList<Pais> _arrayList_4 = new ArrayList<Pais>(_asList_4);
      List<Pais> _conexiones_1 = PaisesRepositorio.conexiones = _arrayList_4;
      Lugar _lugar_3 = LugaresRepositorio.getLugar(3);
      Lugar _lugar_4 = LugaresRepositorio.getLugar(4);
      Lugar _lugar_5 = LugaresRepositorio.getLugar(5);
      List<Lugar> _asList_5 = Arrays.<Lugar>asList(_lugar_3, _lugar_4, _lugar_5);
      ArrayList<Lugar> _arrayList_5 = new ArrayList<Lugar>(_asList_5);
      List<Lugar> _lugares_1 = PaisesRepositorio.lugares = _arrayList_5;
      Pais argentina = new Pais(2, "Argentina", _caracteristicas_1, _conexiones_1, _lugares_1);
      List<String> _asList_6 = Arrays.<String>asList("Habitantes hablan italiano", "Bandera blanca roja y verde", "Toman vino", "Miembro de la Union Europea", "Con una ciudad santa para la Iglesia católica");
      ArrayList<String> _arrayList_6 = new ArrayList<String>(_asList_6);
      List<String> _caracteristicas_2 = PaisesRepositorio.caracteristicas = _arrayList_6;
      List<Pais> _asList_7 = Arrays.<Pais>asList(argentina, brasil);
      ArrayList<Pais> _arrayList_7 = new ArrayList<Pais>(_asList_7);
      List<Pais> _conexiones_2 = PaisesRepositorio.conexiones = _arrayList_7;
      Lugar _lugar_6 = LugaresRepositorio.getLugar(6);
      Lugar _lugar_7 = LugaresRepositorio.getLugar(7);
      Lugar _lugar_8 = LugaresRepositorio.getLugar(8);
      List<Lugar> _asList_8 = Arrays.<Lugar>asList(_lugar_6, _lugar_7, _lugar_8);
      ArrayList<Lugar> _arrayList_8 = new ArrayList<Lugar>(_asList_8);
      List<Lugar> _lugares_2 = PaisesRepositorio.lugares = _arrayList_8;
      Pais italia = new Pais(3, "Italia", _caracteristicas_2, _conexiones_2, _lugares_2);
      List<String> _asList_9 = Arrays.<String>asList("Habitantes hablan arabe", "Bandera roja blanca y negra", "Habitantes construllen piramides", "La mayor parte de su superficie la integra el desierto del Sahara", "Fue cuna de la antigua civilización egipcia");
      ArrayList<String> _arrayList_9 = new ArrayList<String>(_asList_9);
      List<String> _caracteristicas_3 = PaisesRepositorio.caracteristicas = _arrayList_9;
      List<Pais> _asList_10 = Arrays.<Pais>asList(brasil, italia, argentina);
      ArrayList<Pais> _arrayList_10 = new ArrayList<Pais>(_asList_10);
      List<Pais> _conexiones_3 = PaisesRepositorio.conexiones = _arrayList_10;
      Lugar _lugar_9 = LugaresRepositorio.getLugar(9);
      Lugar _lugar_10 = LugaresRepositorio.getLugar(10);
      Lugar _lugar_11 = LugaresRepositorio.getLugar(11);
      List<Lugar> _asList_11 = Arrays.<Lugar>asList(_lugar_9, _lugar_10, _lugar_11);
      ArrayList<Lugar> _arrayList_11 = new ArrayList<Lugar>(_asList_11);
      List<Lugar> _lugares_3 = PaisesRepositorio.lugares = _arrayList_11;
      Pais egipto = new Pais(4, "Egipto", _caracteristicas_3, _conexiones_3, _lugares_3);
      List<String> _asList_12 = Arrays.<String>asList("Habitantes hablan japones", "Bandera roja y blanca", "Habitantes comen arroz", "Conocido como la Tierra del Sol Naciente", "Es un archipiélago de 6852 islas");
      ArrayList<String> _arrayList_12 = new ArrayList<String>(_asList_12);
      List<String> _caracteristicas_4 = PaisesRepositorio.caracteristicas = _arrayList_12;
      List<Pais> _asList_13 = Arrays.<Pais>asList(egipto, argentina, italia);
      ArrayList<Pais> _arrayList_13 = new ArrayList<Pais>(_asList_13);
      List<Pais> _conexiones_4 = PaisesRepositorio.conexiones = _arrayList_13;
      Lugar _lugar_12 = LugaresRepositorio.getLugar(12);
      Lugar _lugar_13 = LugaresRepositorio.getLugar(13);
      Lugar _lugar_14 = LugaresRepositorio.getLugar(14);
      List<Lugar> _asList_14 = Arrays.<Lugar>asList(_lugar_12, _lugar_13, _lugar_14);
      ArrayList<Lugar> _arrayList_14 = new ArrayList<Lugar>(_asList_14);
      List<Lugar> _lugares_4 = PaisesRepositorio.lugares = _arrayList_14;
      Pais japon = new Pais(5, "Japon", _caracteristicas_4, _conexiones_4, _lugares_4);
      List<String> _asList_15 = Arrays.<String>asList("Habitantes hablan ruso", "Bandera roja blanca y azul", "Habitantes sufren bajas temperaturas", "Pais mas grande del mundo", "Es el pais que limita con mayor número de países");
      ArrayList<String> _arrayList_15 = new ArrayList<String>(_asList_15);
      List<String> _caracteristicas_5 = PaisesRepositorio.caracteristicas = _arrayList_15;
      List<Pais> _asList_16 = Arrays.<Pais>asList(egipto, japon, italia, argentina);
      ArrayList<Pais> _arrayList_16 = new ArrayList<Pais>(_asList_16);
      List<Pais> _conexiones_5 = PaisesRepositorio.conexiones = _arrayList_16;
      Lugar _lugar_15 = LugaresRepositorio.getLugar(15);
      Lugar _lugar_16 = LugaresRepositorio.getLugar(16);
      Lugar _lugar_17 = LugaresRepositorio.getLugar(17);
      List<Lugar> _asList_17 = Arrays.<Lugar>asList(_lugar_15, _lugar_16, _lugar_17);
      ArrayList<Lugar> _arrayList_17 = new ArrayList<Lugar>(_asList_17);
      List<Lugar> _lugares_5 = PaisesRepositorio.lugares = _arrayList_17;
      Pais rusia = new Pais(6, "Rusia", _caracteristicas_5, _conexiones_5, _lugares_5);
      List<String> _asList_18 = Arrays.<String>asList("Habitantes hablan español", "Bandera amarrillo y rojo", "Tienen a los mejores jugadores del mundo", "Miembro de la Union Europea", "Es un país transcontinental");
      ArrayList<String> _arrayList_18 = new ArrayList<String>(_asList_18);
      List<String> _caracteristicas_6 = PaisesRepositorio.caracteristicas = _arrayList_18;
      List<Pais> _asList_19 = Arrays.<Pais>asList(egipto, japon, italia, argentina);
      ArrayList<Pais> _arrayList_19 = new ArrayList<Pais>(_asList_19);
      List<Pais> _conexiones_6 = PaisesRepositorio.conexiones = _arrayList_19;
      Lugar _lugar_18 = LugaresRepositorio.getLugar(18);
      Lugar _lugar_19 = LugaresRepositorio.getLugar(19);
      Lugar _lugar_20 = LugaresRepositorio.getLugar(20);
      List<Lugar> _asList_20 = Arrays.<Lugar>asList(_lugar_18, _lugar_19, _lugar_20);
      ArrayList<Lugar> _arrayList_20 = new ArrayList<Lugar>(_asList_20);
      List<Lugar> _lugares_6 = PaisesRepositorio.lugares = _arrayList_20;
      Pais españa = new Pais(7, "España", _caracteristicas_6, _conexiones_6, _lugares_6);
      List<String> _asList_21 = Arrays.<String>asList("Habitantes hablan español", "Bandera roja blanca y azul", "El pais es un Archipielago", "La Habana es su capital y ciudad más poblada", "Está ubicado en el extremo noroeste de las Antillas");
      ArrayList<String> _arrayList_21 = new ArrayList<String>(_asList_21);
      List<String> _caracteristicas_7 = PaisesRepositorio.caracteristicas = _arrayList_21;
      List<Pais> _asList_22 = Arrays.<Pais>asList(rusia, egipto, japon, italia);
      ArrayList<Pais> _arrayList_22 = new ArrayList<Pais>(_asList_22);
      List<Pais> _conexiones_7 = PaisesRepositorio.conexiones = _arrayList_22;
      Lugar _lugar_21 = LugaresRepositorio.getLugar(21);
      Lugar _lugar_22 = LugaresRepositorio.getLugar(22);
      Lugar _lugar_23 = LugaresRepositorio.getLugar(23);
      List<Lugar> _asList_23 = Arrays.<Lugar>asList(_lugar_21, _lugar_22, _lugar_23);
      ArrayList<Lugar> _arrayList_23 = new ArrayList<Lugar>(_asList_23);
      List<Lugar> _lugares_7 = PaisesRepositorio.lugares = _arrayList_23;
      Pais cuba = new Pais(8, "Cuba", _caracteristicas_7, _conexiones_7, _lugares_7);
      List<String> _asList_24 = Arrays.<String>asList("Habitantes hablan frances", "Bandera roja blanca y azul", "La torre eiffel es simbolo de su nacion", "Miembro de la Unión Europea", "Se ubica en Europa Occidental");
      ArrayList<String> _arrayList_24 = new ArrayList<String>(_asList_24);
      List<String> _caracteristicas_8 = PaisesRepositorio.caracteristicas = _arrayList_24;
      List<Pais> _asList_25 = Arrays.<Pais>asList(cuba, rusia, egipto);
      ArrayList<Pais> _arrayList_25 = new ArrayList<Pais>(_asList_25);
      List<Pais> _conexiones_8 = PaisesRepositorio.conexiones = _arrayList_25;
      Lugar _lugar_24 = LugaresRepositorio.getLugar(24);
      Lugar _lugar_25 = LugaresRepositorio.getLugar(25);
      Lugar _lugar_26 = LugaresRepositorio.getLugar(26);
      List<Lugar> _asList_26 = Arrays.<Lugar>asList(_lugar_24, _lugar_25, _lugar_26);
      ArrayList<Lugar> _arrayList_26 = new ArrayList<Lugar>(_asList_26);
      List<Lugar> _lugares_8 = PaisesRepositorio.lugares = _arrayList_26;
      Pais francia = new Pais(9, "Francia", _caracteristicas_8, _conexiones_8, _lugares_8);
      List<String> _asList_27 = Arrays.<String>asList("Habitantes hablan español", "Bandera celeste", "En 1950 sus futbolistas dieron un Maracanazo", "Conocida como como Banda Oriental", "Tiene un clima templado");
      ArrayList<String> _arrayList_27 = new ArrayList<String>(_asList_27);
      List<String> _caracteristicas_9 = PaisesRepositorio.caracteristicas = _arrayList_27;
      List<Pais> _asList_28 = Arrays.<Pais>asList(argentina, francia, españa);
      ArrayList<Pais> _arrayList_28 = new ArrayList<Pais>(_asList_28);
      List<Pais> _conexiones_9 = PaisesRepositorio.conexiones = _arrayList_28;
      Lugar _lugar_27 = LugaresRepositorio.getLugar(27);
      Lugar _lugar_28 = LugaresRepositorio.getLugar(28);
      Lugar _lugar_29 = LugaresRepositorio.getLugar(29);
      List<Lugar> _asList_29 = Arrays.<Lugar>asList(_lugar_27, _lugar_28, _lugar_29);
      ArrayList<Lugar> _arrayList_29 = new ArrayList<Lugar>(_asList_29);
      List<Lugar> _lugares_9 = PaisesRepositorio.lugares = _arrayList_29;
      Pais uruguay = new Pais(10, "Uruguay", _caracteristicas_9, _conexiones_9, _lugares_9);
      it.add(brasil);
      it.add(argentina);
      it.add(italia);
      it.add(egipto);
      it.add(japon);
      it.add(rusia);
      it.add(españa);
      it.add(cuba);
      it.add(francia);
      it.add(uruguay);
    }
  });
  
  public static List<Pais> getMapamundi() {
    return PaisesRepositorio.mapamundi;
  }
  
  public static List<Lugar> getLugaresDePaises() {
    return LugaresRepositorio.getLugares();
  }
  
  public static boolean agregarPais(final Pais paisNuevo) {
    boolean _xblockexpression = false;
    {
      boolean _estaCompleto = paisNuevo.estaCompleto();
      boolean _not = (!_estaCompleto);
      if (_not) {
        throw new UserException("El pais debe estar completo");
      }
      _xblockexpression = PaisesRepositorio.mapamundi.add(paisNuevo);
    }
    return _xblockexpression;
  }
}
