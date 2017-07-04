package controllers;

import applicationModels.ExpedientesAppModel;
import applicationModels.MapamundiAppModel;
import applicationModels.ResultadoJuegoAppModel;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.google.common.base.Objects;
import dtos.CasoDTO;
import dtos.OrdenEmitidaDTO;
import dtos.PaisSimpleDTO;
import dtos.ViajarDTO;
import dtos.VillanoDTO;
import dummies.BaseCentralRepositorio;
import dummies.CasosRespositorio;
import dummies.PaisesRepositorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.caso.Caso;
import model.detective.Detective;
import model.ocupante.Villano;
import model.pais.Pais;
import model.registroLugar.RegistroLugar;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.commons.model.UserException;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;

@Controller
@SuppressWarnings("all")
public class CarmenSanDiegoRestAPI extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private final List<Pais> paises = BaseCentralRepositorio.getMapamundi();
  
  private final MapamundiAppModel mapamundi = new MapamundiAppModel(this.paises);
  
  private final ExpedientesAppModel expedientesModel = new ExpedientesAppModel();
  
  private String getErrorJson(final String message) {
    return (("{ \"Error\": \"" + message) + "\" }");
  }
  
  private String getAceptJson(final String message) {
    return (("{ \"Bien\": \"" + message) + "\" }");
  }
  
  @Get("/villanos")
  public Result getVillanos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      System.out.println("Get villanos");
      response.setContentType(ContentType.APPLICATION_JSON);
      List<Villano> _villanos = this.expedientesModel.getVillanos();
      Stream<Villano> _stream = _villanos.stream();
      final Function<Villano, VillanoDTO> _function = new Function<Villano, VillanoDTO>() {
        public VillanoDTO apply(final Villano v) {
          return new VillanoDTO(v);
        }
      };
      Stream<VillanoDTO> _map = _stream.<VillanoDTO>map(_function);
      Collector<VillanoDTO, ?, List<VillanoDTO>> _list = Collectors.<VillanoDTO>toList();
      List<VillanoDTO> villanosSimple = _map.collect(_list);
      String _json = this._jSONUtils.toJson(villanosSimple);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/villanosCompletos")
  public Result getVillanosCompletos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      List<Villano> _villanos = this.expedientesModel.getVillanos();
      String _json = this._jSONUtils.toJson(_villanos);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/villanos/:id")
  public Result getVillano(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Result _xtrycatchfinallyexpression = null;
      try {
        Integer _valueOf = Integer.valueOf(id);
        Villano _buscarVillano = this.expedientesModel.buscarVillano((_valueOf).intValue());
        String _json = this._jSONUtils.toJson(_buscarVillano);
        _xtrycatchfinallyexpression = ResultFactory.ok(_json);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _errorJson = this.getErrorJson("El id debe ser un numero entero");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/crearVillano")
  public Result createVillano(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          final Villano villano = this._jSONUtils.<Villano>fromJson(body, Villano.class);
          Result _xtrycatchfinallyexpression_1 = null;
          try {
            Result _xblockexpression_2 = null;
            {
              this.expedientesModel.agregarVillano(villano);
              String _aceptJson = this.getAceptJson("Se agrego el nuevo villano");
              _xblockexpression_2 = ResultFactory.ok(_aceptJson);
            }
            _xtrycatchfinallyexpression_1 = _xblockexpression_2;
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              String _errorJson = this.getErrorJson("Introduzca un Villano bien formado");
              _xtrycatchfinallyexpression_1 = ResultFactory.badRequest(_errorJson);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          _xblockexpression_1 = _xtrycatchfinallyexpression_1;
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _errorJson = this.getErrorJson("El body debe ser un villano");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/updateVillano")
  public Result upVillano(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          final Villano villano = this._jSONUtils.<Villano>fromJson(body, Villano.class);
          this.expedientesModel.updateVillano(villano);
          String _aceptJson = this.getAceptJson("Se ha modificado el villano");
          _xblockexpression_1 = ResultFactory.ok(_aceptJson);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _errorJson = this.getErrorJson("El body debe ser un villano");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/deleteVillano/:id")
  public Result deleteVillano(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          Integer _valueOf = Integer.valueOf(id);
          this.expedientesModel.deleteVillano((_valueOf).intValue());
          _xblockexpression_1 = ResultFactory.ok();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _errorJson = this.getErrorJson("El id debe ser un numero");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/viajar")
  public Result viajar(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      ViajarDTO req = this._jSONUtils.<ViajarDTO>fromJson(body, ViajarDTO.class);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          Integer _casoId = req.getCasoId();
          Integer _valueOf = Integer.valueOf((_casoId).intValue());
          Caso caso = CasosRespositorio.buscarCaso((_valueOf).intValue());
          Integer _destinoId = req.getDestinoId();
          Integer _valueOf_1 = Integer.valueOf((_destinoId).intValue());
          Pais paisAViajar = caso.buscarConexion((_valueOf_1).intValue());
          Detective _detective = caso.getDetective();
          Pais paisAnterior = _detective.getLugarActual();
          Detective _detective_1 = caso.getDetective();
          _detective_1.viajar(paisAViajar);
          CasoDTO casoDto = new CasoDTO(caso);
          PaisSimpleDTO _paisSimpleDTO = new PaisSimpleDTO(paisAnterior);
          casoDto.setPaisAnterior(_paisSimpleDTO);
          CasoDTO _casoDTO = new CasoDTO(caso);
          String _json = this._jSONUtils.toJson(_casoDTO);
          _xblockexpression_1 = ResultFactory.ok(_json);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          final UserException e = (UserException)_t;
          String _errorJson = this.getErrorJson("El body debe contener un destinoId y un casoId");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/pistaDelLugar/:casoId/:nombreLugar")
  public Result pistaDelLugar(final String casoId, final String nombreLugar, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          Integer _valueOf = Integer.valueOf(casoId);
          final Caso caso = CasosRespositorio.buscarCaso((_valueOf).intValue());
          String _valueOf_1 = String.valueOf(nombreLugar);
          final RegistroLugar registro = caso.BuscarRegistroLugar(_valueOf_1);
          ResultadoJuegoAppModel _resultadoJuegoAppModel = new ResultadoJuegoAppModel(caso, registro);
          String _json = this._jSONUtils.toJson(_resultadoJuegoAppModel);
          _xblockexpression_1 = ResultFactory.ok(_json);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          final UserException e = (UserException)_t;
          String _errorJson = this.getErrorJson("El nombre del lugar no es valido o el id del caso es incorrecto");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/paises")
  public Result getPaises(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      List<Pais> _paises = this.mapamundi.getPaises();
      Stream<Pais> _stream = _paises.stream();
      final Function<Pais, PaisSimpleDTO> _function = new Function<Pais, PaisSimpleDTO>() {
        public PaisSimpleDTO apply(final Pais p) {
          return new PaisSimpleDTO(p);
        }
      };
      Stream<PaisSimpleDTO> _map = _stream.<PaisSimpleDTO>map(_function);
      Collector<PaisSimpleDTO, ?, List<PaisSimpleDTO>> _list = Collectors.<PaisSimpleDTO>toList();
      List<PaisSimpleDTO> paisesSimples = _map.collect(_list);
      String _json = this._jSONUtils.toJson(paisesSimples);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/paisesCompletos")
  public Result getPaisesCompletos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(this.paises);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/paises/:id")
  public Result getPaisById(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          Integer _valueOf = Integer.valueOf(id);
          Pais pais = this.mapamundi.getPais((_valueOf).intValue());
          Result _xifexpression = null;
          boolean _equals = Objects.equal(pais, null);
          if (_equals) {
            String _errorJson = this.getErrorJson("No existe pais con ese id");
            _xifexpression = ResultFactory.notFound(_errorJson);
          } else {
            String _json = this._jSONUtils.toJson(pais);
            _xifexpression = ResultFactory.ok(_json);
          }
          _xblockexpression_1 = _xifexpression;
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof NumberFormatException) {
          final NumberFormatException ex = (NumberFormatException)_t;
          String _errorJson = this.getErrorJson("El id debe ser un numero entero");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/crearPais")
  public Result createPais(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      System.out.println("Crear pais");
      System.out.println(body);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          final Pais pais = this._jSONUtils.<Pais>fromJson(body, Pais.class);
          Result _xtrycatchfinallyexpression_1 = null;
          try {
            Result _xblockexpression_2 = null;
            {
              PaisesRepositorio.agregarPais(pais);
              String _json = this._jSONUtils.toJson("Pais creado exitosamente");
              _xblockexpression_2 = ResultFactory.ok(_json);
            }
            _xtrycatchfinallyexpression_1 = _xblockexpression_2;
          } catch (final Throwable _t) {
            if (_t instanceof UserException) {
              final UserException exception = (UserException)_t;
              Result _xblockexpression_3 = null;
              {
                System.out.println(exception);
                String _message = exception.getMessage();
                String _errorJson = this.getErrorJson(_message);
                _xblockexpression_3 = ResultFactory.badRequest(_errorJson);
              }
              _xtrycatchfinallyexpression_1 = _xblockexpression_3;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          _xblockexpression_1 = _xtrycatchfinallyexpression_1;
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof UnrecognizedPropertyException) {
          final UnrecognizedPropertyException exception = (UnrecognizedPropertyException)_t;
          Result _xblockexpression_2 = null;
          {
            System.out.println(exception);
            String _errorJson = this.getErrorJson("El body debe ser un Pais");
            _xblockexpression_2 = ResultFactory.badRequest(_errorJson);
          }
          _xtrycatchfinallyexpression = _xblockexpression_2;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/updatePais")
  public Result upPais(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Pais pais = this._jSONUtils.<Pais>fromJson(body, Pais.class);
        this.mapamundi.updatePais(pais);
        String _json = this._jSONUtils.toJson("Pais actualizado correctamente");
        _xblockexpression = ResultFactory.ok(_json);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = ResultFactory.badRequest("El body debe ser un pais");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/deletePais/:id")
  public Result deletePais(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          Integer _valueOf = Integer.valueOf(id);
          this.mapamundi.eliminarPais((_valueOf).intValue());
          _xblockexpression_1 = ResultFactory.ok();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof NumberFormatException) {
          final NumberFormatException ex = (NumberFormatException)_t;
          String _errorJson = this.getErrorJson("El id debe ser un numero entero");
          _xtrycatchfinallyexpression = ResultFactory.badRequest(_errorJson);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/iniciarJuego")
  public Result iniciarJuego(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      System.out.println("Iniciar juego");
      response.setContentType(ContentType.APPLICATION_JSON);
      ArrayList<Caso> casos = CasosRespositorio.getCasos();
      Random _random = new Random();
      int _size = casos.size();
      int _nextInt = _random.nextInt(_size);
      Caso _get = casos.get(_nextInt);
      CasoDTO caso = new CasoDTO(_get);
      String _json = this._jSONUtils.toJson(caso);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Post("/emitirOrden")
  public Result emitirOrden(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      System.out.println("Emitir orden");
      final OrdenEmitidaDTO req = this._jSONUtils.<OrdenEmitidaDTO>fromJson(body, OrdenEmitidaDTO.class);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          Integer _casoId = req.getCasoId();
          Integer _valueOf = Integer.valueOf((_casoId).intValue());
          final Caso caso = CasosRespositorio.buscarCaso((_valueOf).intValue());
          Integer _villanoId = req.getVillanoId();
          Integer _valueOf_1 = Integer.valueOf((_villanoId).intValue());
          final Villano villano = BaseCentralRepositorio.buscarVillano((_valueOf_1).intValue());
          caso.detectiveEmiteOrdenContra(villano);
          CasoDTO _casoDTO = new CasoDTO(caso);
          String _json = this._jSONUtils.toJson(_casoDTO);
          _xblockexpression_1 = ResultFactory.ok(_json);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          final UserException exception = (UserException)_t;
          _xtrycatchfinallyexpression = ResultFactory.badRequest("Se deben pasar por parametros un villano y un caso");
        } else if (_t instanceof NumberFormatException) {
          final NumberFormatException ex = (NumberFormatException)_t;
          _xtrycatchfinallyexpression = ResultFactory.badRequest("Los IDs deben ser numeros enteros");
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/villanos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = getVillanos(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/villanosCompletos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = getVillanosCompletos(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/villanos/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = getVillano(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/deleteVillano/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = deleteVillano(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/pistaDelLugar/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String casoId = matcher.group(1);
    		String nombreLugar = matcher.group(2);
    		
    		
    	    Result result = pistaDelLugar(casoId, nombreLugar, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/paises").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = getPaises(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/paisesCompletos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = getPaisesCompletos(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/paises/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = getPaisById(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/deletePais/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = deletePais(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/crearVillano").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = createVillano(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/updateVillano").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = upVillano(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/viajar").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = viajar(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/crearPais").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = createPais(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/updatePais").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = upPais(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/iniciarJuego").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = iniciarJuego(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/emitirOrden").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = emitirOrden(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    this.pageNotFound(baseRequest, request, response);
  }
  
  public void pageNotFound(final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    response.getWriter().write(
    	"<html><head><title>XtRest - Page Not Found!</title></head>" 
    	+ "<body>"
    	+ "	<h1>Page Not Found !</h1>"
    	+ "	Supported resources:"
    	+ "	<table>"
    	+ "		<thead><tr><th>Verb</th><th>URL</th><th>Parameters</th></tr></thead>"
    	+ "		<tbody>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/villanos</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/villanosCompletos</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/villanos/:id</td>"
    	+ "				<td>id</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/deleteVillano/:id</td>"
    	+ "				<td>id</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/pistaDelLugar/:casoId/:nombreLugar</td>"
    	+ "				<td>casoId, nombreLugar</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/paises</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/paisesCompletos</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/paises/:id</td>"
    	+ "				<td>id</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/deletePais/:id</td>"
    	+ "				<td>id</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/crearVillano</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/updateVillano</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/viajar</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/crearPais</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/updatePais</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/iniciarJuego</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/emitirOrden</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
