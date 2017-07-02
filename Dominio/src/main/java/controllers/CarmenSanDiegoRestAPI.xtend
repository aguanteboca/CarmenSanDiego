package controllers

import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.json.JSONUtils
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.commons.model.UserException
import model.caso.Caso
import model.ocupante.Villano
import dummies.CasosRespositorio
import dummies.BaseCentralRepositorio
import dtos.OrdenEmitidaDTO
import dtos.CasoDTO
import java.util.List
import model.pais.Pais
import org.uqbar.xtrest.api.annotation.Get
import applicationModels.MapamundiAppModel
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import org.uqbar.xtrest.api.annotation.Delete
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.api.annotation.Body
import dtos.PaisSimpleDTO
import java.util.stream.Collectors
import model.registroLugar.RegistroLugar
import dtos.VillanoDTO
import applicationModels.ExpedientesAppModel
import dtos.ViajarDTO
import dtos.PistasDTO
import java.util.Random
import dummies.PaisesRepositorio
import applicationModels.ResultadoJuegoAppModel

@Controller
class CarmenSanDiegoRestAPI {
    extension JSONUtils = new JSONUtils

    val List<Pais> paises = BaseCentralRepositorio.getMapamundi()
    val MapamundiAppModel mapamundi = new MapamundiAppModel(paises)
    val expedientesModel = new ExpedientesAppModel()

    private def getErrorJson(String message) {
        '{ "Error": "' + message + '" }'
    }

    private def getAceptJson(String message) {
        '{ "Bien": "' + message + '" }'
    }

    //***************************VILLANOS*****************************

    @Get("/villanos")
    def getVillanos() {
    	System.out.println("Get villanos");
        response.contentType = ContentType.APPLICATION_JSON

        var List<VillanoDTO> villanosSimple = expedientesModel.villanos.stream.map(v | new VillanoDTO(v)).collect(Collectors.toList)
        ok(villanosSimple.toJson)
    }

    @Get("/villanosCompletos")
    def getVillanosCompletos() {
        response.contentType = ContentType.APPLICATION_JSON

        ok(expedientesModel.villanos.toJson)
    }

    @Get("/villanos/:id")
    def getVillano() {
        response.contentType = ContentType.APPLICATION_JSON
        try {
            ok(expedientesModel.buscarVillano(Integer.valueOf(id)).toJson)
        }
        catch(Exception e) {
            badRequest(getErrorJson("El id debe ser un numero entero"))
        }
    }

    @Post("/crearVillano")
    def createVillano(@Body String body) {
        response.contentType = ContentType.APPLICATION_JSON
        try {
            val Villano villano = body.fromJson(Villano)
            try {
                expedientesModel.agregarVillano(villano)
                ok(getAceptJson("Se agrego el nuevo villano"))
            }
            catch(Exception e) {
                badRequest(getErrorJson("Introduzca un Villano bien formado"))
            }
        }
        catch(Exception e) {
            badRequest(getErrorJson("El body debe ser un villano"))
        }
    }

    @Post("/updateVillano")
    def upVillano(@Body String body) {
        response.contentType = ContentType.APPLICATION_JSON
        try {
            val Villano villano = body.fromJson(Villano)
            expedientesModel.updateVillano(villano)
            ok(getAceptJson("Se ha modificado el villano"))
        }
        catch(Exception e) {
            badRequest(getErrorJson("El body debe ser un villano"))
        }
    }

    @Get("/deleteVillano/:id")
    def deleteVillano() {
        response.contentType = ContentType.APPLICATION_JSON
        try {
            expedientesModel.deleteVillano(Integer.valueOf(id))
            ok()
        }
        catch(Exception e){
            badRequest(getErrorJson("El id debe ser un numero"))
        }
    }

    //***************************VIAJAR********************************

    @Post("/viajar")
    def viajar(@Body String body) {
        response.contentType = ContentType.APPLICATION_JSON
        var req = body.fromJson(ViajarDTO)

        try {
            var Caso caso = CasosRespositorio.buscarCaso(Integer.valueOf(req.casoId))
            var Pais paisAViajar = caso.buscarConexion(Integer.valueOf(req.destinoId))

            var paisAnterior = caso.detective.lugarActual
            caso.detective.viajar(paisAViajar)

            var casoDto = new CasoDTO(caso)
            casoDto.setPaisAnterior(new PaisSimpleDTO(paisAnterior))

            ok(new CasoDTO(caso).toJson)
        }
        catch(UserException e) {
            badRequest(getErrorJson("El body debe contener un destinoId y un casoId"))
        }
    }

    //************************PISTAS DEL LUGAR***************************

    @Get("/pistaDelLugar/:casoId/:nombreLugar")
    def pistaDelLugar(){
        response.contentType = ContentType.APPLICATION_JSON

        try {
            val Caso caso = CasosRespositorio.buscarCaso(Integer.valueOf(casoId))
            val RegistroLugar registro = caso.BuscarRegistroLugar(String.valueOf(nombreLugar))

            ok(new ResultadoJuegoAppModel(caso,registro).toJson)
        }
        catch(UserException e) {
            badRequest(getErrorJson("El nombre del lugar no es valido o el id del caso es incorrecto"))
        }
    }

    //***************************PAISES*********************************

    @Get("/paises")
    def getPaises() {
        response.contentType = ContentType.APPLICATION_JSON
        var List<PaisSimpleDTO> paisesSimples = mapamundi.paises.stream.map(p | new PaisSimpleDTO(p)).collect(Collectors.toList)
        ok(paisesSimples.toJson)
    }

    @Get("/paisesCompletos")
    def getPaisesCompletos() {
        response.contentType = ContentType.APPLICATION_JSON
        ok(paises.toJson)
    }

    @Get("/paises/:id")
    def getPaisById() {
        response.contentType = ContentType.APPLICATION_JSON
        
        try {
            var pais = this.mapamundi.getPais(Integer.valueOf(id))
            if(pais == null) {
                notFound(getErrorJson("No existe pais con ese id"))
            }
            else {
            	ok(pais.toJson)
            }
        }
        catch(NumberFormatException ex) {
            badRequest(getErrorJson("El id debe ser un numero entero"))
        }
    }

    @Post("/crearPais")
    def createPais(@Body String body) {
        response.contentType = ContentType.APPLICATION_JSON
        System.out.println("Crear pais");
    	System.out.println(body);
        try {
            val Pais pais = body.fromJson(Pais)
            try {
                PaisesRepositorio.agregarPais(pais)
                ok("Pais creado exitosamente".toJson)
            }
            catch (UserException exception) {
            	System.out.println(exception)
                badRequest(getErrorJson(exception.message))
            }
        }
        catch (UnrecognizedPropertyException exception) {
        	System.out.println(exception)
            badRequest(getErrorJson("El body debe ser un Pais"))
        }
    }

    @Post("/updatePais")
    def upPais(@Body String body) {
        try {
            val Pais pais = body.fromJson(Pais)
            mapamundi.updatePais(pais)
            ok("Pais actualizado correctamente".toJson)
        }
        catch(Exception e) {
            badRequest("El body debe ser un pais")
        }
    }

    @Get("/deletePais/:id")
    def deletePais() {
        response.contentType = ContentType.APPLICATION_JSON
        try {
            this.mapamundi.eliminarPais(Integer.valueOf(id))
            ok()
        }
        catch (NumberFormatException ex) {
            badRequest(getErrorJson("El id debe ser un numero entero"))
        }
    }

    //***************************INICIAR JUEGO*****************************

    @Post("/iniciarJuego")
    def iniciarJuego() {
    	System.out.println("Iniciar juego");
    	response.contentType = ContentType.APPLICATION_JSON
        var casos = CasosRespositorio.casos
        var CasoDTO caso = new CasoDTO(casos.get(new Random().nextInt(casos.size)))
        ok(caso.toJson)
    }

    //***************************EMITIR ORDEN******************************

    @Post("/emitirOrden")
    def emitirOrden(@Body String body) {
        
        System.out.println("Emitir orden");
        val req = body.fromJson(OrdenEmitidaDTO)

        try {
            val Caso caso = CasosRespositorio.buscarCaso(Integer.valueOf(req.casoId))
            val Villano villano = BaseCentralRepositorio.buscarVillano(Integer.valueOf(req.villanoId))

            caso.detectiveEmiteOrdenContra(villano)
            ok(new CasoDTO(caso).toJson)
        }
        catch (UserException exception) {
            badRequest("Se deben pasar por parametros un villano y un caso")
        }
        catch(NumberFormatException ex) {
            badRequest("Los IDs deben ser numeros enteros")
        }
    }
}
