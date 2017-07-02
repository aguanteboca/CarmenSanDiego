package model.ocupante

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class SeniasYHobbies {

    var List<String> senias
    var List<String> hobbies

    new(List<String> senias, List<String> hobbies){
        this.senias = senias
        this.hobbies = hobbies
    }
}