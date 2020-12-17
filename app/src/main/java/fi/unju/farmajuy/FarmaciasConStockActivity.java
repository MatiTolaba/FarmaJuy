package fi.unju.farmajuy;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import fi.unju.farmajuy.adaptadores.AdaptadorFarmaciaConStock;
import fi.unju.farmajuy.entidades.Farmacia;
import fi.unju.farmajuy.utilidades.OrdenarDistancias;
import fi.unju.farmajuy.utilidades.UtilidadesMapa;

public class FarmaciasConStockActivity extends AppCompatActivity implements LocationListener {

    RecyclerView recyclerViewFarmacias;
    ArrayList<Farmacia> farmaciasConStock;
    ArrayList<Double> preciosProducto;

    public Criteria criterio;
    public String mejorProveedor;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle activityBundle = this.getIntent().getExtras();

        setContentView(R.layout.activity_farmacia);

        if (activityBundle != null){

            farmaciasConStock = (ArrayList<Farmacia>) activityBundle.getSerializable("listaFarmaciasConStock");
            preciosProducto = (ArrayList<Double>) activityBundle.getSerializable("preciosProducto");

            // Acquire a reference to the system Location Manager
            locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            criterio = new Criteria();
            mejorProveedor = String.valueOf(locationManager.getBestProvider(criterio, true)).toString();

            int permiso = ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION);

            //You can still do this if you like, you might get lucky:
            Location location = locationManager.getLastKnownLocation(mejorProveedor);
            if (location != null) {

                Collections.sort(farmaciasConStock, new OrdenarDistancias(location));

                locationManager.removeUpdates(this);
            }
            else{
                //This is what you need:
                //Register the listener with the Location Manager to receive location updates
                locationManager.requestLocationUpdates(mejorProveedor, 1000, 0, this);
            }

            recyclerViewFarmacias = (RecyclerView) findViewById(R.id.recyclerViewFarmaciasConStock);
            recyclerViewFarmacias.setLayoutManager( new LinearLayoutManager(this));

            AdaptadorFarmaciaConStock adaptadorFarmaciaConStock = new AdaptadorFarmaciaConStock(this, farmaciasConStock, preciosProducto);
            recyclerViewFarmacias.setAdapter(adaptadorFarmaciaConStock);
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //Called when a new location is found by the network location provider.

        //Hey, a non null location! Sweet!

        //remove location callback:
        locationManager.removeUpdates(this);

        Collections.sort(farmaciasConStock, new OrdenarDistancias(location));
    }
}
