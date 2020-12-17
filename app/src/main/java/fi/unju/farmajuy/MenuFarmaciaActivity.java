package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuFarmaciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_farmacia);

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void Ubicacion(View view){
        Intent intent = new Intent(getApplicationContext(), MapsMiUbicacionActivity.class);
        startActivity(intent);
    }

    public void CargarProducto(View view){
        Intent intent = new Intent(getApplicationContext(), activity_cargar_producto.class);
        startActivity(intent);
    }
}