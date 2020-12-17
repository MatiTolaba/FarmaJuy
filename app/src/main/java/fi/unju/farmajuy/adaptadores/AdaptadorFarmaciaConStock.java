package fi.unju.farmajuy.adaptadores;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fi.unju.farmajuy.DetalleFarmaciaActivity;
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

    public class ViewHolderFarmaciaConStock extends RecyclerView.ViewHolder implements View.OnClickListener, LocationListener {

        ImageView imagenFarmacia;
        TextView nombreFarmacia, precioProducto, distanciaFarmacia;

        Button botonDetalleFarmacia, botonMapaFarmacia;

        //TEST
        public double latitud;
        public double longitud;
        public LocationManager locationManager;
        public Criteria criterio;
        public String mejorProveedor;

        public ViewHolderFarmaciaConStock(@NonNull View itemView) {
            super(itemView);

            imagenFarmacia = itemView.findViewById(R.id.imageViewFarmacia);
            nombreFarmacia = itemView.findViewById(R.id.textViewNombreFarmacia);
            precioProducto = itemView.findViewById(R.id.textViewPrice);
            distanciaFarmacia = itemView.findViewById(R.id.textViewDistancia);

            botonDetalleFarmacia = itemView.findViewById(R.id.buttonDetalleFarmacia);
            botonMapaFarmacia = itemView.findViewById(R.id.buttonMapaFarmacia);

            itemView.setOnClickListener(this);

            botonDetalleFarmacia.setOnClickListener(this);
            botonMapaFarmacia.setOnClickListener(this);
        }

        JsonObjectRequest jsonObjectRequest;
        RequestQueue request;

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.buttonMapaFarmacia:
//                    Intent mapaFarmaciasIntent = new Intent(miContexto, MapaFarmaciaActivity.class);
//                    Bundle mapaFarmaciasBundle = new Bundle();
//
//                    obtenerUbicacion();
//
//                    mapaFarmaciasIntent.putExtras(mapaFarmaciasBundle);
//                    mapaFarmaciasIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    miContexto.startActivity(mapaFarmaciasIntent);
                    break;

                case R.id.buttonDetalleFarmacia:
                    Intent detalleFarmaciaIntent = new Intent(miContexto, DetalleFarmaciaActivity.class);
                    detalleFarmaciaIntent.putExtra("claveFarmacia", listaFarmaciasConStock.get(getAdapterPosition()));
                    detalleFarmaciaIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    miContexto.startActivity(detalleFarmaciaIntent);
                    break;
            }
        }

        private void obtenerUbicacion(){


            locationManager = (LocationManager)  miContexto.getSystemService(Context.LOCATION_SERVICE);
            criterio = new Criteria();
            mejorProveedor = String.valueOf(locationManager.getBestProvider(criterio, true)).toString();

            int permiso = ContextCompat.checkSelfPermission( miContexto, Manifest.permission.ACCESS_FINE_LOCATION);

            //You can still do this if you like, you might get lucky:
            Location location = locationManager.getLastKnownLocation(mejorProveedor);
            if (location != null) {
                Log.e("TAG", "GPS is on");
                latitud = location.getLatitude();
                longitud = location.getLongitude();
                Toast.makeText( miContexto , "latitude:" + latitud + " longitude:" + longitud, Toast.LENGTH_SHORT).show();
                // Called when a new location is found by the network location provider.

                UtilidadesMapa.coordenadas.setLatitudInicial(location.getLatitude());
                UtilidadesMapa.coordenadas.setLongitudInicial(location.getLongitude());
                UtilidadesMapa.coordenadas.setLatitudFinal(listaFarmaciasConStock.get(getAdapterPosition()).getLatitud());
                UtilidadesMapa.coordenadas.setLongitudFinal(listaFarmaciasConStock.get(getAdapterPosition()).getLongitud());

                webServiceObtenerRuta(Double.toString(location.getLatitude()), Double.toString(location.getLongitude()),
                            listaFarmaciasConStock.get(getAdapterPosition()).getLatitud().toString(),listaFarmaciasConStock.get(getAdapterPosition()).getLongitud().toString());

                locationManager.removeUpdates(this);
            }
            else{
                //This is what you need:
                //Register the listener with the Location Manager to receive location updates
                locationManager.requestLocationUpdates(mejorProveedor, 1000, 0, this);
            }
        }

        private void webServiceObtenerRuta(String latitudInicial, String longitudInicial, String latitudFinal, String longitudFinal) {

            String url="https://maps.googleapis.com/maps/api/directions/json?origin="+latitudInicial+","+longitudInicial
                    +"&destination="+latitudFinal+","+longitudFinal;

            System.out.println(url);

            jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //Este método PARSEA el JSONObject que retorna del API de Rutas de Google devolviendo
                    //una lista del lista de HashMap Strings con el listado de Coordenadas de Lat y Long,
                    //con la cual se podrá dibujar pollinas que describan la ruta entre 2 puntos.
                    JSONArray jRoutes = null;
                    JSONArray jLegs = null;
                    JSONArray jSteps = null;

                    try {

                        jRoutes = response.getJSONArray("routes");

                        /** Traversing all routes */
                        for(int i=0;i<jRoutes.length();i++){
                            jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");
                            List<HashMap<String, String>> path = new ArrayList<HashMap<String, String>>();

                            /** Traversing all legs */
                            for(int j=0;j<jLegs.length();j++){
                                jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps");

                                /** Traversing all steps */
                                for(int k=0;k<jSteps.length();k++){
                                    String polyline = "";
                                    polyline = (String)((JSONObject)((JSONObject)jSteps.get(k)).get("polyline")).get("points");
                                    List<LatLng> list = decodePoly(polyline);

                                    /** Traversing all points */
                                    for(int l=0;l<list.size();l++){
                                        HashMap<String, String> hm = new HashMap<String, String>();
                                        hm.put("lat", Double.toString(((LatLng)list.get(l)).latitude) );
                                        hm.put("lng", Double.toString(((LatLng)list.get(l)).longitude) );
                                        path.add(hm);
                                    }
                                }
                                UtilidadesMapa.routes.add(path);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText( miContexto, "No se puede conectar "+error.toString(), Toast.LENGTH_LONG).show();
                    System.out.println();
                    Log.d("ERROR: ", error.toString());
                }
            }
            );

            request.add(jsonObjectRequest);
        }

        private List<LatLng> decodePoly(String encoded) {

            List<LatLng> poly = new ArrayList<LatLng>();
            int index = 0, len = encoded.length();
            int lat = 0, lng = 0;

            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                LatLng p = new LatLng((((double) lat / 1E5)),
                        (((double) lng / 1E5)));
                poly.add(p);
            }

            return poly;
        }

        @Override
        public void onLocationChanged(@NonNull Location location) {
            //Called when a new location is found by the network location provider.

            //Hey, a non null location! Sweet!

            //remove location callback:
            locationManager.removeUpdates(this);

            UtilidadesMapa.coordenadas.setLatitudInicial(location.getLatitude());
            UtilidadesMapa.coordenadas.setLongitudInicial(location.getLongitude());
            UtilidadesMapa.coordenadas.setLatitudFinal(listaFarmaciasConStock.get(getAdapterPosition()).getLatitud());
            UtilidadesMapa.coordenadas.setLongitudFinal(listaFarmaciasConStock.get(getAdapterPosition()).getLongitud());

            webServiceObtenerRuta(Double.toString(location.getLatitude()), Double.toString(location.getLongitude()),
                    listaFarmaciasConStock.get(getAdapterPosition()).getLatitud().toString(),listaFarmaciasConStock.get(getAdapterPosition()).getLongitud().toString());

            //locationManager.removeUpdates(this);
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