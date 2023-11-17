package br.com.tiagors09.eletroshop.activities;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback {
    SupportMapFragment supportMapFragment;
    private GoogleMap mMap;

    private Marker currentMarker;

    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Adicionando um marcador inicial no centro do mapa e movendo a câmera
        LatLng latLngInitial = new LatLng(0, 0);
        currentMarker = mMap.addMarker(new MarkerOptions().position(latLngInitial).title("Center").snippet(latLngInitial.toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngInitial));

        // configurando evento de click curto no mapa
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                removeCurrentMarker(); // remove marcador atual
                String address = getAddressFromLatLng(latLng); // chamada ao método getAddressFromLatLng passando latLng
                currentMarker = mMap.addMarker(new MarkerOptions().position(latLng).title(address).snippet(latLng.toString())); // adiciona novo marcador com título referente ao nome do local
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng)); // atualiza a câmera
            }
        });
    }

    // remove marcador atual
    private void removeCurrentMarker() {
        if(currentMarker != null) {
            currentMarker.remove();
        }
    }

    // função que recebe LatLng e informa nome do local
    private String getAddressFromLatLng(LatLng location) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String address = "";

        try {
            List<Address> addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1);

            if (addresses != null && addresses.size() > 0) {
                address = addresses.get(0).getAddressLine(0);
            } else {
                address = "localização não disponível";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show();
    }
}