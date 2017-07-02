package com.uis.carmensandiego.carmensandiego;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.uis.carmensandiego.carmensandiego.model.Caso;
import com.uis.carmensandiego.carmensandiego.model.OrdenEmitida;
import com.uis.carmensandiego.carmensandiego.model.Viajar;
import com.uis.carmensandiego.carmensandiego.model.Villano;
import com.uis.carmensandiego.carmensandiego.service.CarmenSanDiegoService;
import com.uis.carmensandiego.carmensandiego.service.Connection;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class OrdenArrestoFragment extends Fragment {

    private int idSeleccionado;
    private List<Villano> villanos;

    public OrdenArrestoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orden_arresto, container, false);

        //Listener para el boton onclick, sino explota
        Button button = (Button) view.findViewById(R.id.emitir_orden);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                emitirOrdenContra();
            }
        });

        obtenerVillanos(view);

        return view;
    }

    private void obtenerVillanos(final View view) {
        CarmenSanDiegoService carmenSanDiegoService = new Connection().getService();
        carmenSanDiegoService.getVillanos(new Callback<List<Villano>>() {
            @Override
            public void success(List<Villano> villanos, Response response) {
                llenarSpinnerVillanos(view, villanos);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    public void llenarSpinnerVillanos(View view, List<Villano> villanos) {
        this.villanos = villanos;
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_villanos);
        List<String> nombresVillanos = getNombresVillanos(villanos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, nombresVillanos);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public List<String> getNombresVillanos(List<Villano> villanos) {
        List<String> nombres = new ArrayList<>();
        for(Villano v : villanos) {
            nombres.add(v.getNombre());
        }
        return nombres;
    }

    private int getIdVillano(List<Villano> villanos, String nombreSeleccionado) {
        int id = 0;
        for(Villano v : villanos){
            if (v.getNombre() == nombreSeleccionado){
                id = v.getId();
            }
        }
        return id;
    }

    public void emitirOrdenContra() {

        Spinner spinner = (Spinner) getView().findViewById(R.id.spinner_villanos);
        final String nombreVillanoSeleccionado = spinner.getSelectedItem().toString();

        int idVillanoSeleccionado = getIdVillano(villanos, nombreVillanoSeleccionado);

        CarmenSanDiegoService carmenSanDiegoService = new Connection().getService();
        Caso caso = ((MainActivity) getActivity()).getCaso();
        OrdenEmitida ordenEmitidaBody = new OrdenEmitida(idVillanoSeleccionado, caso.getId());
        carmenSanDiegoService.emitirOrdenPara(ordenEmitidaBody, new Callback<Caso>() {
            @Override
            public void success(Caso caso, Response response) {
                procesarOrdenEmitida(caso, nombreVillanoSeleccionado);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    public void procesarOrdenEmitida(Caso caso, String nombreVillanoSeleccionado) {
        ((TextView) getActivity().findViewById(R.id.orden_arresto)).setText("Orden de arresto contra: " + nombreVillanoSeleccionado);
        Toast toastOrdenEmitida = Toast.makeText(getContext(), "Orden emitida correctamente contra: "+nombreVillanoSeleccionado, Toast.LENGTH_SHORT);
        toastOrdenEmitida.setGravity(Gravity.NO_GRAVITY, 0, 0);
        toastOrdenEmitida.show();
    }


}

