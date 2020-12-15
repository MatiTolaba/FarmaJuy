package fi.unju.farmajuy;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import fi.unju.farmajuy.adaptadores.AdaptadorFarmaciaConStock;
import fi.unju.farmajuy.entidades.Farmacia;
import fi.unju.farmajuy.utilidades.OrdenarDistancias;

public class FarmaciasConStockActivity extends AppCompatActivity {

    RecyclerView recyclerViewFarmacias;
    ArrayList<Farmacia> farmaciasConStock;

    ArrayList<Double> preciosProducto;

    Location miUbicacion;
    public Criteria criteria;
    public String bestProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle activityBundle = this.getIntent().getExtras();

        setContentView(R.layout.activity_farmacia);

        if (activityBundle != null){

            farmaciasConStock = (ArrayList<Farmacia>) activityBundle.getSerializable("listaFarmaciasConStock");
            preciosProducto = (ArrayList<Double>) activityBundle.getSerializable("preciosProducto");

            // Acquire a reference to the system Location Manager
            LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            criteria = new Criteria();
            bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true)).toString();

            // Define a listener that responds to location updates
            LocationListener locationListener = new LocationListener() {

                public void onLocationChanged(Location location) {
                    // Called when a new location is found by the network location provider.
                    int permiso = ContextCompat.checkSelfPermission( FarmaciasConStockActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);

                    //miUbicacion.set(location);
                    System.out.println(location.getLongitude());
//                    System.out.println(miUbicacion.getLongitude());

                    Collections.sort(farmaciasConStock, new OrdenarDistancias(location));

                    locationManager.removeUpdates(this);
                }
            };

            recyclerViewFarmacias = (RecyclerView) findViewById(R.id.recyclerViewFarmaciasConStock);
            recyclerViewFarmacias.setLayoutManager( new LinearLayoutManager(this));

            AdaptadorFarmaciaConStock adaptadorFarmaciaConStock = new AdaptadorFarmaciaConStock(this, farmaciasConStock, preciosProducto);
            recyclerViewFarmacias.setAdapter(adaptadorFarmaciaConStock);
        }

    }

//    public void onClick(View view){
//        switch (view.getId()){
//            case R.id.buttonMapaFarmacia:
//
//                Intent mapaIntent = new Intent(FarmaciasConStockActivity.this, MapaFarmaciaActivity.class);
//                Bundle productoActivityBundle = new Bundle();
//
//                productoActivityBundle.putSerializable("coordenadas", coordenadas);
//                productoActivityIntent.putExtras(productoActivityBundle);
//
//                startActivity(mapaIntent);
//
//            break;
//        }
//    }
}
