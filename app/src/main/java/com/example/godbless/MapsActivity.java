package com.example.godbless;

import static android.content.ContentValues.TAG;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.godbless.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    String lati;
    String longi;

    double x;
    double y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.viewLocation);
        mapFragment.getMapAsync(this);

        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            lati = extras.getString("latitude");
            longi = extras.getString("longitude");
            x = Double.parseDouble(lati);
            y = Double.parseDouble(longi);
            Log.d(TAG,"lati = " + lati);
            Log.d(TAG,"longi = " + longi);
        }

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

        // Add a marker in Sydney and move the camera
        LatLng g1 = new LatLng(x, y);
        mMap.setMinZoomPreference(10.0f);
        mMap.setMaxZoomPreference(100.0f);
        mMap.addMarker(new MarkerOptions().position(g1).title("Garbage 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.amogusmarker)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(g1));


    }
}