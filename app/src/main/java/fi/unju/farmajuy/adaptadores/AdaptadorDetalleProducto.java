package fi.unju.farmajuy.adaptadores;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fi.unju.farmajuy.R;

import fi.unju.farmajuy.entidades.Farmacia;
import fi.unju.farmajuy.entidades.Producto;

public class AdaptadorDetalleProducto extends RecyclerView.Adapter<AdaptadorDetalleProducto.ViewHolderDetalleProducto>{

    Context miContexto;
    ArrayList<Farmacia> listaFarmaciasConStock;
    ArrayList<Double> preciosProducto;

    Location miUbicacion;

    public AdaptadorDetalleProducto(Context miContexto, ArrayList<Farmacia> listaFarmaciasConStock, ArrayList<Double> preciosProducto) {
        this.miContexto = miContexto;
        this.listaFarmaciasConStock = listaFarmaciasConStock;
        this.preciosProducto = preciosProducto;
    }

    @NonNull
    @Override
    public AdaptadorDetalleProducto.ViewHolderDetalleProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmacia, parent,false);
        return new AdaptadorDetalleProducto.ViewHolderDetalleProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDetalleProducto.ViewHolderDetalleProducto holder, int position) {

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

        //System.out.println(miUbicacion.getLongitude());
    }

    public void buscarLocation(Farmacia farmacia, @NonNull AdaptadorDetalleProducto.ViewHolderDetalleProducto holder){
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
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };

        int permiso = ContextCompat.checkSelfPermission( miContexto, Manifest.permission.ACCESS_FINE_LOCATION);
        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }

    @Override
    public int getItemCount() {
        return listaFarmaciasConStock.size();
    }

    public class ViewHolderDetalleProducto extends RecyclerView.ViewHolder {

        ImageView imagenFarmacia;
        TextView nombreFarmacia, precioProducto, distanciaFarmacia;

        public ViewHolderDetalleProducto(@NonNull View itemView) {
            super(itemView);

            imagenFarmacia = itemView.findViewById(R.id.imageViewFarmacia);
            nombreFarmacia = itemView.findViewById(R.id.textViewNombreFarmacia);
            precioProducto = itemView.findViewById(R.id.textViewPrice);
            distanciaFarmacia = itemView.findViewById(R.id.textViewDistancia);
        }
    }
}

//                  Location ubicacionDestino = null;
//
//                ubicacionDestino.set(miUbicacion);
//
//                ubicacionDestino.setLatitude(farmacia.getLatitud());
//                ubicacionDestino.setLongitude(farmacia.getLongitud());
//
//                double distancia = miUbicacion.distanceTo(ubicacionDestino);