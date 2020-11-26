package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }


    public void Sitios(View view){
        Intent intent = new Intent(getApplicationContext(), activity_maps_sitios.class);
        startActivity(intent);
    }

    //public void TiposMapas(View view){
    //    Intent intent = new Intent(getApplicationContext(), MapsActivity2_Tipos.class);
    //    startActivity(intent);
    //}

    public void Ubicacion(View view){
        Intent intent = new Intent(getApplicationContext(), activity_maps_mi_ubicacion.class);
        startActivity(intent);
    }
}