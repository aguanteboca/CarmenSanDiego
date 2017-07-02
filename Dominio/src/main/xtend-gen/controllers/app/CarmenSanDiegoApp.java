package controllers.app;

import controllers.CarmenSanDiegoRestAPI;
import org.uqbar.xtrest.api.XTRest;

@SuppressWarnings("all")
public class CarmenSanDiegoApp {
  public static void main(final String[] args) {
    CarmenSanDiegoRestAPI _carmenSanDiegoRestAPI = new CarmenSanDiegoRestAPI();
    XTRest.startInstance(_carmenSanDiegoRestAPI, 9000);
  }
}
