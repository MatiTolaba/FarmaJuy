package fi.unju.farmajuy.utilidades;

import android.location.Location;

import java.util.Comparator;

import fi.unju.farmajuy.entidades.Farmacia;

public class OrdenarDistancias implements Comparator<Farmacia> {

    Location miUbicacionActual;

    public OrdenarDistancias(Location miUbicacion){
        miUbicacionActual = miUbicacion;
    }
    @Override
    public int compare(final Farmacia farmacia1, final Farmacia farmacia2) {
        double lat1 = farmacia1.getLatitud();
        double lon1 = farmacia1.getLongitud();
        double lat2 = farmacia2.getLatitud();
        double lon2 = farmacia2.getLongitud();

        double distanceToPlace1 = distance(miUbicacionActual.getLatitude(), miUbicacionActual.getLongitude(), lat1, lon1);
        double distanceToPlace2 = distance(miUbicacionActual.getLatitude(), miUbicacionActual.getLongitude(), lat2, lon2);
        return (int) (distanceToPlace1 - distanceToPlace2);
    }

    public double distance(double fromLat, double fromLon, double toLat, double toLon) {
        double radius = 6378137;   // approximate Earth radius, *in meters*
        double deltaLat = toLat - fromLat;
        double deltaLon = toLon - fromLon;
        double angle = 2 * Math.asin( Math.sqrt(
                Math.pow(Math.sin(deltaLat/2), 2) +
                        Math.cos(fromLat) * Math.cos(toLat) *
                                Math.pow(Math.sin(deltaLon/2), 2) ) );
        return radius * angle;
    }
}
