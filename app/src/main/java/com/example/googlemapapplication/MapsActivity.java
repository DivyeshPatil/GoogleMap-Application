package com.example.googlemapapplication;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

// Add a marker in WinjitNashik, WinjitPune, WinjitMumbai & WinjitBangalore and move the camera
        LatLng WinjitNashik = new LatLng(19.9988228,73.7511518);
        LatLng WinjitPune = new LatLng(18.5435724,73.9071026);
        LatLng WinjitMumbai = new LatLng(19.1176387,72.8713418);
        LatLng WinjitBangalore = new LatLng(12.9467138,77.6467346);

        mMap.addMarker(new MarkerOptions().position(WinjitNashik).title("Winjit Technologies, Nashik"));
        mMap.addMarker(new MarkerOptions().position(WinjitPune).title("Winjit Technologies, Pune"));
        mMap.addMarker(new MarkerOptions().position(WinjitMumbai).title("Winjit Technologies, Mumbai"));
        mMap.addMarker(new MarkerOptions().position(WinjitBangalore).title("Winjit Technologies, Bangalore"));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Winjit));

//use animateCamera instead of moveCamera
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(WinjitNashik, 15f));

//Add CustomInfoWindowAdapter
     //   mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity.this));

// Adding Polyline
        mMap.addPolyline(new PolylineOptions()
                .add(WinjitNashik)
                .add(WinjitPune)
                .add(WinjitMumbai)
                .add(WinjitBangalore)
                .width(8f)
                .color(Color.RED)
        );

//Adding Circle to WinjitNashik
        mMap.addCircle(new CircleOptions()
                .center(WinjitNashik)
                .radius(500.0)
                .strokeWidth(3f)
                .strokeColor(Color.BLUE)
                .fillColor(Color.argb(70,150,50,50))

        );

 //Adding Circle WinjitPune
        mMap.addCircle(new CircleOptions()
                .center(WinjitPune)
                .radius(500.0)
                .strokeWidth(3f)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(70,150,50,50))

        );

//Adding Circle WinjitMumbai
        mMap.addCircle(new CircleOptions()
                .center(WinjitMumbai)
                .radius(500.0)
                .strokeWidth(3f)
                .strokeColor(Color.WHITE)
                .fillColor(Color.argb(70,150,50,50))

        );

//Adding Circle WinjitBangalore
        mMap.addCircle(new CircleOptions()
                .center(WinjitBangalore)
                .radius(500.0)
                .strokeWidth(3f)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.argb(70,150,50,50))

        );

//Set Rotate Gestures Enabled
        mMap.getUiSettings().setRotateGesturesEnabled(true);

    }
}
