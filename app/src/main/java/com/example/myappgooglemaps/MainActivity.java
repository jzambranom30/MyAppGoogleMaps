package com.example.myappgooglemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myappgooglemaps.Adaptador.InfoWindowAdapter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener{
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        iniciarMapa();
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
    }

    private void iniciarMapa() {
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        LatLng coord = new LatLng(-1.010758,-79.4689636);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(coord, 17);
        map.moveCamera(cameraUpdate);
        map.getUiSettings().setZoomControlsEnabled(true);

        addMarker(new LatLng(-1.0098166769781363, -79.46938199480346),"Pizza Hut - Quevedo","Restaurante", R.mipmap.ic_launcher_restaurant);
        addMarker(new LatLng(-1.010294035991951, -79.47036904768063),"Asadero la Esquina del Shooping","Restaurante", R.mipmap.ic_launcher_restaurant);
        addMarker(new LatLng(-1.0133208042169646, -79.46935444082506),"LOKOS DE ASAR - Quevedo","Restaurante", R.mipmap.ic_launcher_restaurant);
        addMarker(new LatLng(-1.0106802140137283, -79.46842176397637),"Unidad Educativa Quevedo","Escuela", R.mipmap.ic_launcher_school);
        addMarker(new LatLng(-1.0110583466593017, -79.47042000953651),"Escuela de Educación Básica Francisco de Orellana","Escuela", R.mipmap.ic_launcher_school);
        map.setInfoWindowAdapter(new InfoWindowAdapter(this));
    }

    private void addMarker(LatLng position, String title, String snippet, int iconResId) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(position)
                .title(title)
                .snippet(snippet)
                .icon(BitmapDescriptorFactory.fromResource(iconResId));
        map.addMarker(markerOptions);
    }
}