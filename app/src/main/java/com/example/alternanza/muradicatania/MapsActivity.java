package com.example.alternanza.muradicatania;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

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
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if (bd !=null)  //Apro la mappa nel punto specificato
        {
            Double latd = (Double) bd.get("lat");
            Double longd = (Double) bd.get("long");
            String nome = bd.getString("nome");

            // Aggiunge un marker nella mappa
            LatLng monumento = new LatLng(latd, longd);
            mMap.addMarker(new MarkerOptions().position(monumento).title(nome));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(monumento),2000,null);
            mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
        }
        else //Apro la mappa con tutti i punti.
        {

            String[] latd= getResources().getStringArray(R.array.Latitude);
            String[] logd= getResources().getStringArray(R.array.Longitude);
            String[] nome= getResources().getStringArray(R.array.name);

            for(int i=0; i<nome.length; i++)
            {
                if( !latd[i].equals("") || !latd[i].equals("") )
                {
                    LatLng point= new LatLng(Double.parseDouble(latd[i]), Double.parseDouble(logd[i]) );
                    mMap.addMarker(new MarkerOptions().position(point).title(nome[i]));
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(point),2000,null);
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
                }
            }

        }

    }
}
