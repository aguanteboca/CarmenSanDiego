package com.uis.carmensandiego.carmensandiego.service;

import com.uis.carmensandiego.carmensandiego.bodies.EmitirOrdenBody;
import com.uis.carmensandiego.carmensandiego.bodies.ViajarBody;
import com.uis.carmensandiego.carmensandiego.model.Caso;
import com.uis.carmensandiego.carmensandiego.model.OrdenEmitida;
import com.uis.carmensandiego.carmensandiego.model.Pista;
import com.uis.carmensandiego.carmensandiego.model.Viajar;
import com.uis.carmensandiego.carmensandiego.model.Villano;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface CarmenSanDiegoService {
    @POST("/iniciarJuego")
    void iniciarJuego(Callback<Caso> callback);

    @GET("/villanos")
    void getVillanos(Callback<List<Villano>> callback);

    @GET("/pistasDelLugar/{casoId}/{nombreLugar}")
    void getPista(@Path("casoId") int idCaso, @Query("nombreLugar") String lugar, Callback<String> callback);

    @POST("/emitirOrden")
    void emitirOrdenPara(@Body OrdenEmitida ordenEmitida, Callback<Caso> callback);

    @POST("/viajar")
    void viajar(@Body Viajar viajar, Callback<Caso> callback);
}
