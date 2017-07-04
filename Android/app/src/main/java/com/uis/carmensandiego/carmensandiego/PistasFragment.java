package com.uis.carmensandiego.carmensandiego;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.uis.carmensandiego.carmensandiego.adapter.LugaresAdapter;
import com.uis.carmensandiego.carmensandiego.model.Caso;
import com.uis.carmensandiego.carmensandiego.model.ResultadoJuego;
import com.uis.carmensandiego.carmensandiego.service.CarmenSanDiegoService;
import com.uis.carmensandiego.carmensandiego.service.Connection;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PistasFragment extends Fragment {

    TextView detallePista;


    public PistasFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pistas, container, false);
        llenarPista(view);

        detallePista = (TextView) view.findViewById(R.id.detallePista);
        final ListView lv = (ListView) view.findViewById(R.id.listLugares);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
                String pistaSeleccionada = (String) lv.getAdapter().getItem(position);
                mostrarPistaDe(pistaSeleccionada);
            }
        });

        return view;
    }

    public void llenarPista(View view) {
        List<String> nombreLugares = new ArrayList<>();
        nombreLugares.addAll(((MainActivity) getActivity()).getCaso().getPais().getLugares());
        ListView lvLugares = (ListView) view.findViewById(R.id.listLugares);
        LugaresAdapter adapter = new LugaresAdapter(getActivity(), nombreLugares);
        lvLugares.setAdapter(adapter);
    }

    private void mostrarPistaDe(String pistaSeleccionada) {
        Caso caso = ((MainActivity) getActivity()).getCaso();
        CarmenSanDiegoService carmenSanDiegoService = new Connection().getService();
        carmenSanDiegoService.getPista(caso.getId(), pistaSeleccionada, new Callback<ResultadoJuego>() {
            @Override
            public void success(ResultadoJuego s, Response response) {
                verificarSiEsFinDelJuego(s);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void verificarSiEsFinDelJuego(ResultadoJuego s) {
        if(s.getResultadoOrden() == null){
            detallePista.setText(s.getPista());
            detallePista.setTextColor(0xff424242);
        }else {
            if(s.getResultadoOrden().startsWith("Malas")) {
                detallePista.setText(s.getResultadoOrden());
                detallePista.setTextColor(0xffff0000);
            }else {
                detallePista.setText(s.getResultadoOrden());
                detallePista.setTextColor(0xff00ff00);
            }

        }
    }
}
