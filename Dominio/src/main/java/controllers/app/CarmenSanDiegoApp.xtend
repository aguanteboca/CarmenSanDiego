package controllers.app

import org.uqbar.xtrest.api.XTRest
import controllers.CarmenSanDiegoRestAPI

class CarmenSanDiegoApp{

    def static void main(String[] args) {
        XTRest.startInstance(new CarmenSanDiegoRestAPI(), 9000)
    }
}