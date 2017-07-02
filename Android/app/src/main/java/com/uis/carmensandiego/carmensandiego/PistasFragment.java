package com.uis.carmensandiego.carmensandiego;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.uis.carmensandiego.carmensandiego.adapter.LugaresAdapter;
import com.uis.carmensandiego.carmensandiego.model.Caso;

import java.util.List;

public class PistasFragment extends Fragment {


    public PistasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pistas, container, false);
        llenarPista(view);
        final ListView lv = (ListView) view.findViewById(R.id.listLugares);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pistaSeleccionada = (String) (lv.getItemAtPosition(position));
                mostrasPista(pistaSeleccionada);
            }
        });

        return view;
    }

    public void llenarPista(View view) {
        List<String> nombreLugares  = ((MainActivity) getActivity()).getCaso().getPais().getLugares();
        ListView lvLugares = (ListView) view.findViewById(R.id.listLugares);
        LugaresAdapter adapter = new LugaresAdapter(getActivity(), nombreLugares);
        lvLugares.setAdapter(adapter);
    }

    public void mostrasPista(final String pistaSeleccionada) {
        Caso caso = ((MainActivity) getActivity()).getCaso();
        int idPaisSeleccionado = getIdPista(caso.getPais().getLugares(), pistaSeleccionada);

        CarmenSanDiegoService carmenSanDiegoService = new Connection().getService();
        Viajar viajarRequest = new Viajar(caso.getId(), idPaisSeleccionado);
        carmenSanDiegoService.viajar(viajarRequest, new Callback<Caso>() {
            @Override
            public void success(Caso caso, Response response) {
                Toast toastOrdenEmitida = Toast.makeText(getContext(), "Conexion: "+ nombrePaisSeleccionado, Toast.LENGTH_SHORT);
                toastOrdenEmitida.setGravity(Gravity.NO_GRAVITY, 0, 0);
                toastOrdenEmitida.show();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getMessage());
                error.printStackTrace();
            }
        });

    }

    private int getIdPista(List<String> pistas, String pistaSeleccionada) {
        int id = 0;
        for(String pista : pistas){
            if (pista == pistaSeleccionada){
                id = pista;
            }
        }
        return id;
    }


}

















/*
    public void mostrarPistas(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    Button button = (Button) getView().findViewById(R.id.lugar);
    String nombreLugar = button.getText().toString();

    /*int idVillanoSeleccionado = getIdVillano(villanos, nombreVillanoSeleccionado);

    Toast toastOrdenEmitida = Toast.makeText(getContext(), "Orden emitida exitosamente contra: "+ nombreVillanoSeleccionado, Toast.LENGTH_SHORT);
        toastOrdenEmitida.setGravity(Gravity.CENTER, 0, 0);

        toastOrdenEmitida.show();*/

