package fi.unju.farmajuy;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsSitiosActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_sitios);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFarmacia);
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

        // Add a marker in Sydney and move the camera
        LatLng siufi = new LatLng(-24.18440588, -65.30781977);
        mMap.addMarker(new MarkerOptions().position(siufi).title("Farmacia Siufi").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(siufi,12));

        LatLng del_pueblo = new LatLng(-24.1841364, -65.30602907);
        mMap.addMarker(new MarkerOptions().position(del_pueblo).title("Farmacia Del Pueblo").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(del_pueblo,12));

        LatLng el_inca = new LatLng(-24.18447993, -65.30961692);
        mMap.addMarker(new MarkerOptions().position(el_inca).title("Farmacia El Inca").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(el_inca,12));

        LatLng san_cayetano = new LatLng(-24.18562992, -65.30692506);
        mMap.addMarker(new MarkerOptions().position(san_cayetano).title("Farmacia San Cayetano").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(san_cayetano,12));

        LatLng farmacity = new LatLng(-24.18373121, -65.30434799);
        mMap.addMarker(new MarkerOptions().position(farmacity).title("Farmacia Farmacity").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(farmacity,12));

        LatLng san_martin = new LatLng(-24.18631893, -65.29671335);
        mMap.addMarker(new MarkerOptions().position(san_martin).title("Farmacia San Martin").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(san_martin,12));

        LatLng farmar = new LatLng(-24.18532065, -65.30406582);
        mMap.addMarker(new MarkerOptions().position(farmar).title("Farmacia Farmar").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(farmar,12));

        LatLng san_javier = new LatLng(-24.18536958, -65.30156922);
        mMap.addMarker(new MarkerOptions().position(san_javier).title("Farmacia San Javier").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(san_javier,12));

        LatLng terminal = new LatLng(-24.19023173, -65.30273867);
        mMap.addMarker(new MarkerOptions().position(terminal).title("Farmacia Terminal").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terminal,12));

        LatLng hipolito = new LatLng(-24.19023858, -65.29778945);
        mMap.addMarker(new MarkerOptions().position(hipolito).title("Farmacia Hipolito Yrigoyen").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hipolito,12));

        LatLng balut = new LatLng(-24.20017173, -65.28535473);
        mMap.addMarker(new MarkerOptions().position(balut).title("Farmacia Balut").snippet("Entre calle: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_maletin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(balut, 12));
    }
}