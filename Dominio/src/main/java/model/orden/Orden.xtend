package model.orden

import model.ocupante.Villano
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
abstract class Orden {

    protected var String nombre

    new(){}

    def Integer fueEmitida()

    def Villano obtenerVillano()
}