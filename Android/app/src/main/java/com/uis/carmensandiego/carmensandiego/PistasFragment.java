package com.uis.carmensandiego.carmensandiego;

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
import com.uis.carmensandiego.carmensandiego.service.CarmenSanDiegoService;
import com.uis.carmensandiego.carmensandiego.service.Connection;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PistasFragment extends Fragment {

    TextView output;
    String detallePista;


    public PistasFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pistas, container, false);
        llenarPista(view);

        output = (TextView) view.findViewById(R.id.output);
        output.setText("vamos lp");
        final ListView lv = (ListView) view.findViewById(R.id.listLugares);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long arg3) {
                String pistaSeleccionada = (String) lv.getAdapter().getItem(position);
                mostrarPistaDe(pistaSeleccionada);

            }
        });

        return view;
    }

    public void llenarPista(View view) {
        List<String> nombreLugares = ((MainActivity) getActivity()).getCaso().getPais().getLugares();
        ListView lvLugares = (ListView) view.findViewById(R.id.listLugares);
        LugaresAdapter adapter = new LugaresAdapter(getActivity(), nombreLugares);
        lvLugares.setAdapter(adapter);
    }

    private void mostrarPistaDe(String pistaSeleccionada) {
        Caso caso = ((MainActivity) getActivity()).getCaso();
        CarmenSanDiegoService carmenSanDiegoService = new Connection().getService();
        carmenSanDiegoService.getPista(caso.getId(), pistaSeleccionada, new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                output.setText(s);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
