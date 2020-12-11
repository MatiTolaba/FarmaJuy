package fi.unju.farmajuy.adaptadores;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fi.unju.farmajuy.BuscarProductoActivity;
import fi.unju.farmajuy.DetalleFarmaciaActivity;
import fi.unju.farmajuy.DetalleProductoActivity;
import fi.unju.farmajuy.MapaFarmaciaActivity;
import fi.unju.farmajuy.ProductoActivity;
import fi.unju.farmajuy.R;

import fi.unju.farmajuy.entidades.Farmacia;
import fi.unju.farmajuy.utilidades.UtilidadesMapa;

public class AdaptadorFarmaciaConStock extends RecyclerView.Adapter<AdaptadorFarmaciaConStock.ViewHolderFarmaciaConStock>{

    Context miContexto;
    ArrayList<Farmacia> listaFarmaciasConStock;
    ArrayList<Double> preciosProducto;

    Location miUbicacion;

    public AdaptadorFarmaciaConStock(Context miContexto, ArrayList<Farmacia> listaFarmaciasConStock, ArrayList<Double> preciosProducto) {
        this.miContexto = miContexto;
        this.listaFarmaciasConStock = listaFarmaciasConStock;
        this.preciosProducto = preciosProducto;
    }

    @NonNull
    @Override
    public ViewHolderFarmaciaConStock onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmacia, parent,false);
        return new ViewHolderFarmaciaConStock(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFarmaciaConStock holder, int position) {

        Farmacia farmacia = listaFarmaciasConStock.get(position);
        Glide.with(miContexto)
                .load(farmacia.getFoto())
                .centerCrop()
                .into(holder.imagenFarmacia);

        holder.nombreFarmacia.setText(farmacia.getNombre());

        Double precioProducto = preciosProducto.get(position);

        holder.precioProducto.setText("$ "+precioProducto.toString());

        //Calculo de distancia de la ubicacion actual hacia una farmacia

        buscarLocation(farmacia, holder);
    }

    public void buscarLocation(Farmacia farmacia, @NonNull ViewHolderFarmaciaConStock holder){
        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) miContexto.getSystemService(Context.LOCATION_SERVICE);

        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {

            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                float results[] = new float[10];
                Location.distanceBetween(location.getLatitude(), location.getLongitude(), farmacia.getLatitud(), farmacia.getLongitud(), results);
                if (results[0] >= 1000){
                    Double resultadoKilometros = Double.valueOf(results[0] / 1000);
                    holder.distanciaFarmacia.setText(String.format("%.1f", resultadoKilometros)+" km.");
                } else {
                    Double resultadoKilometros = Double.valueOf(results[0]);
                    holder.distanciaFarmacia.setText(String.format("%.1f", resultadoKilometros)+" m.");
                }
                locationManager.removeUpdates(this);
            }

//            public void onStatusChanged(String provider, int status, Bundle extras) {}
//
//            public void onProviderEnabled(String provider) {}
//
//            public void onProviderDisabled(String provider) {}
        };

        int permiso = ContextCompat.checkSelfPermission( miContexto, Manifest.permission.ACCESS_FINE_LOCATION);
        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }

    @Override
    public int getItemCount() {
        return listaFarmaciasConStock.size();
    }

    public class ViewHolderFarmaciaConStock extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imagenFarmacia;
        TextView nombreFarmacia, precioProducto, distanciaFarmacia;

        Button botonDetalleFarmacia;

        public ViewHolderFarmaciaConStock(@NonNull View itemView) {
            super(itemView);

            imagenFarmacia = itemView.findViewById(R.id.imageViewFarmacia);
            nombreFarmacia = itemView.findViewById(R.id.textViewNombreFarmacia);
            precioProducto = itemView.findViewById(R.id.textViewPrice);
            distanciaFarmacia = itemView.findViewById(R.id.textViewDistancia);

            botonDetalleFarmacia = itemView.findViewById(R.id.buttonDetalleFarmacia);

            itemView.setOnClickListener(this);

            botonDetalleFarmacia.setOnClickListener(this);
        }

        JsonObjectRequest jsonObjectRequest;
        RequestQueue request;

        @Override
        public void onClick(View view) {
            switch (view.getId()){
//                case R.id.buttonMapaFarmacia:
//
//                    Intent mapaFarmaciasIntent = new Intent(miContexto, MapaFarmaciaActivity.class);
//                    Bundle mapaFarmaciasBundle = new Bundle();
//
//
//                    // Acquire a reference to the system Location Manager
//                    LocationManager locationManager = (LocationManager) miContexto.getSystemService(Context.LOCATION_SERVICE);
//
//                    // Define a listener that responds to location updates
//                    LocationListener locationListener = new LocationListener() {
//
//                        public void onLocationChanged(Location location) {
//                            // Called when a new location is found by the network location provider.
//
//                            UtilidadesMapa.coordenadas.setLatitudInicial(location.getLatitude());
//                            UtilidadesMapa.coordenadas.setLongitudInicial(location.getLongitude());
//                            UtilidadesMapa.coordenadas.setLatitudFinal(listaFarmaciasConStock.get(getAdapterPosition()).getLatitud());
//                            UtilidadesMapa.coordenadas.setLongitudFinal(listaFarmaciasConStock.get(getAdapterPosition()).getLongitud());
//
//                            webServiceObtenerRuta(location.getLatitude().toString(),location.getLongitude().toString(),
//                                    listaFarmaciasConStock.get(getAdapterPosition()).getLatitud().toString(),listaFarmaciasConStock.get(getAdapterPosition()).getLongitud().toString());
//
//
//
//
//
//
//
//                            locationManager.removeUpdates(this);
//                        }
//                    };
//
//                    int permiso = ContextCompat.checkSelfPermission( miContexto, Manifest.permission.ACCESS_FINE_LOCATION);
//                    // Register the listener with the Location Manager to receive location updates
//                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
//
//
//
//                    //mapaFarmaciasBundle.putSerializable("listaProductos", listaProductos);
//                    mapaFarmaciasIntent.putExtras(mapaFarmaciasBundle);
//                    mapaFarmaciasIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    miContexto.startActivity(mapaFarmaciasIntent);
//                  break;
                case R.id.buttonDetalleFarmacia:
                    Intent intent = new Intent(miContexto, DetalleFarmaciaActivity.class);
                    intent.putExtra("claveFarmacia", listaFarmaciasConStock.get(getAdapterPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    miContexto.startActivity(intent);
                    break;
            }
        }
    }
}






//         NO DAR BOLA A ESTO
//                  Location ubicacionDestino = null;
//
//                ubicacionDestino.set(miUbicacion);
//
//                ubicacionDestino.setLatitude(farmacia.getLatitud());
//                ubicacionDestino.setLongitude(farmacia.getLongitud());
//
//                double distancia = miUbicacion.distanceTo(ubicacionDestino);