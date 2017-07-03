package com.uis.carmensandiego.carmensandiego;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.uis.carmensandiego.carmensandiego.adapter.ConexionesAdapter;
import com.uis.carmensandiego.carmensandiego.model.Caso;
import com.uis.carmensandiego.carmensandiego.model.Pais;
import com.uis.carmensandiego.carmensandiego.model.Viajar;
import com.uis.carmensandiego.carmensandiego.service.CarmenSanDiegoService;
import com.uis.carmensandiego.carmensandiego.service.Connection;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ViajarFragment extends Fragment {

    private List<Pais> conexiones;
    private Caso caso;

    public ViajarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viajar, container, false);
        llenarConexiones(view);

        final ListView lv = (ListView) view.findViewById(R.id.listConexiones);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String conexionSeleccionada = (String) (lv.getAdapter().getItem(position));
                viajar(conexionSeleccionada);
            }
        });



        return view;
    }

    public void llenarConexiones(View view){
        Caso caso = ((MainActivity) getActivity()).getCaso();
        ListView lvConexiones = (ListView) view.findViewById(R.id.listConexiones);
        List<String> conexionesNombre = this.getNombreConexiones(caso.getPais().getConexiones());
        ConexionesAdapter adapter = new ConexionesAdapter(getActivity(),conexionesNombre);
        lvConexiones.setAdapter(adapter);
    }


    public List<String> getNombreConexiones(List<Pais> pais){
        List<String> nombreConexiones = new ArrayList<>();
        for(Pais p : pais){
            nombreConexiones.add(p.getNombre());
        }
        return nombreConexiones;
    }

    private int getIdPais(List<Pais> conexiones, String paisSeleccionado) {
        int id = 0;
        for(Pais pais : conexiones){
            if (pais.getNombre() == paisSeleccionado){
                id = pais.getId();
            }
        }
        return id;
    }

    private void viajar(String paisDestino) {
        Caso caso = ((MainActivity) getActivity()).getCaso();
        CarmenSanDiegoService carmenSanDiegoService = new Connection().getService();
        Integer idPais = getIdPais(caso.getPais().getConexiones(),paisDestino);

        carmenSanDiegoService.viajar((new Viajar(idPais,caso.getId())), new Callback<Caso>(){
            @Override
            public void success(Caso caso, Response response) {
                ((MainActivity) getActivity()).setCaso(caso);
                llenarConexiones(getView());
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}

