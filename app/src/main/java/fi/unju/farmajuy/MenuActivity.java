package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fi.unju.farmajuy.utilidades.UtilidadesConexion;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //pedimos ubicacion al usuario, directamente al iniciar la aplicacion
        obtenerLocalizacion();
    }

    //metodo permiso para acceder a la localizacion. Permisos para la app acceda a la ubicacion
    private void obtenerLocalizacion() {
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if(permiso == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    public void Sitios(View view){
        Intent intent = new Intent(getApplicationContext(), MapsSitiosActivity.class);
        startActivity(intent);
    }



    public void Ubicacion(View view){
        Intent intent = new Intent(getApplicationContext(), MapsMiUbicacionActivity.class);
        startActivity(intent);
    }

    public void Busqueda(View view){
        Intent intent = new Intent(getApplicationContext(), BuscarProductoActivity.class);
        startActivity(intent);
    }
}