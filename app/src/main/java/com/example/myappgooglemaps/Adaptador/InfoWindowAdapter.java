package com.example.myappgooglemaps.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myappgooglemaps.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View view;

    public InfoWindowAdapter(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.vista_datos_lugar, null);
    }
    @Override
    public View getInfoWindow(Marker marker) {
        TextView nombre = view.findViewById(R.id.nombreLugar);
        TextView direccion = view.findViewById(R.id.direccionLugar);
        nombre.setText(marker.getTitle());
        direccion.setText(marker.getSnippet());
        return view;
    }
    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
