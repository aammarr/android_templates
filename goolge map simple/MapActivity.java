package com.example.ammarahmed.naqsha;


import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<LatLng> arrayPoints = new ArrayList<LatLng>();
    ;
    PolylineOptions polylineOptions;

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
        
        // Add a marker in Home and move the camera
        LatLng home = new LatLng(24.908323,67.069846);
        LatLng osama_home = new LatLng(24.910824, 67.085615);
        LatLng saad_home = new LatLng(24.906283, 67.077049);

        mMap.getMyLocation();

        mMap.addMarker(new MarkerOptions().position(home).title("Marker @ myHome"));
        mMap.addMarker(new MarkerOptions().position(osama_home).title("Marker @ osamaHome"));
        mMap.addMarker(new MarkerOptions().position(saad_home).title("Marker @ saadHome"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        mMap.setMinZoomPreference(15);
        mMap.setMaxZoomPreference(20);

        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(home);
        circleOptions.radius(75);
        circleOptions.strokeColor(Color.BLUE);

        // Fill color of the circle
        // 0x represents, this is an hexadecimal code
        // 55 represents percentage of transparency. For 100% transparency, specify 00.
        // For 0% transparency ( ie, opaque ) , specify ff
        // The remaining 6 characters(00ff00) specify the fill color
        circleOptions.fillColor(0x5500ff00);
        circleOptions.strokeWidth(2);
        googleMap.addCircle(circleOptions);

        polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.GREEN);

        polylineOptions.width(5); arrayPoints.add(home);
        polylineOptions.width(5); arrayPoints.add(saad_home);
        polylineOptions.width(5); arrayPoints.add(osama_home);

        polylineOptions.addAll(arrayPoints);
        googleMap.addPolyline(polylineOptions);


    }
}
