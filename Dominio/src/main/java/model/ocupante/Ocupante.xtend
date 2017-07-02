package model.ocupante

import org.eclipse.xtend.lib.annotations.Accessors
import model.orden.Orden

@Accessors
abstract class Ocupante{

    def String actuar(Orden orden)
    def Boolean conoceVillano()
    def Boolean esUnVillano()
}