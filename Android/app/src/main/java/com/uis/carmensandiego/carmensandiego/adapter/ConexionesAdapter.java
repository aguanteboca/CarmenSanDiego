package com.uis.carmensandiego.carmensandiego.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.uis.carmensandiego.carmensandiego.R;

import java.util.List;

public class ConexionesAdapter extends ArrayAdapter<String> {

    private List<String> conexiones;

    public ConexionesAdapter(Context context, List<String> conexiones) {
        super(context, R.layout.fragment_viajar, conexiones);
        this.conexiones = conexiones;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.row_viajar, null);

        TextView textConexiones = (TextView) item.findViewById(R.id.conexion);
        textConexiones.setText(conexiones.get(position));

        return item;
    }
}
